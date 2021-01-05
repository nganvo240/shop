package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.bill;
import beans.bill_infor;
import beans.product;
import beans.productFromCart;


public class DBcart {
	public static bill insertBill(Connection conn, bill sv) throws SQLException {
        String sql = "INSERT INTO bill(customer_id, date, totalMoney, status) VALUES(?,GETDATE(),?,0)";//insert student values (?,?,?)
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        //pstm.setInt(1,sv.getId());// Integer.valueOf(sv.getId())
        pstm.setInt(1, sv.getCustomer());
        pstm.setInt(2, sv.getTotalMoney());
        
        pstm.executeUpdate();
        System.out.println("theem bill");
        return sv;             
    }
	
	public static bill_infor insertBill_infor (Connection conn, bill_infor sv) throws SQLException {
        String sql = "INSERT INTO bill_infor (bill_id, product_id, quantity) VALUES(?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, sv.getBill_id());
        pstm.setInt(2, sv.getProduct_id());
        pstm.setInt(3, sv.getQuantity());
        
        pstm.executeUpdate();
        System.out.println("theem bill_inf");
        return sv;             
    }
	
	public static int maxID(Connection conn, String username) throws SQLException {
        String sql = "select max(b.id) from bill b,  customer c, Accuser a where b.customer_id=c.id and c.username=a.username and a.username='"+username+"'";
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	
	public static int IDcustomer(Connection conn, String username) throws SQLException {
        String sql = "select id from customer c, Accuser a where c.username=a.username and c.username='"+username+"'";        
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	
	public static List<productFromCart> listProductFromCart(Connection conn, String username)
			throws SQLException, ClassNotFoundException
	{
		String sql="select img, p.id as id, p.name as name, quantity, price\r\n"
				+ "from bill_infor bf, product p, bill b, customer c, Accuser a\r\n"
				+ "where bf.product_id=p.id and bf.bill_id=b.id and c.id=b.customer_id and a.username=a.username\r\n"
				+ "and a.username='"+username+"'";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<productFromCart> list = new ArrayList<productFromCart>();
		while (rs.next()) 
		{
			String img = rs.getString("img");
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int quantity = rs.getInt("quantity");
			int price = rs.getInt("price");
			productFromCart sv = new productFromCart();
			sv.setImg(img);
			sv.setId(id);
			sv.setName(name);
			sv.setQuantity(quantity);
			sv.setPrice(price);
			list.add(sv);
		}
		
		return list;
		
	}
}
