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
import beans.productFromCart;


public class DBcart {
	public static bill insertBill(Connection conn, bill sv) throws SQLException {
        String sql = "INSERT INTO bill(customer_id, date, totalMoney, status) VALUES(?,GETDATE(),?,0)";//insert student values (?,?,?)
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        //pstm.setInt(1,sv.getId());// Integer.valueOf(sv.getId())
        pstm.setInt(1, sv.getCustomer_id());
        pstm.setInt(2, sv.getTotalMoney());
        
        pstm.executeUpdate();
        return sv;             
    }
	
	public static bill_infor insertBill_infor (Connection conn, bill_infor sv) throws SQLException {
        String sql = "INSERT INTO bill_infor (bill_id, product_id, size_product, quantity) VALUES(?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, sv.getBill_id());
        pstm.setInt(2, sv.getProduct_id());
        pstm.setInt(3, sv.getSize_product());
        pstm.setInt(4, sv.getQuantity());
        
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
		String sql="select img, p.id as id, p.name as name, quantity, price, bf.size_product as size_product, price*quantity as totalPrice\r\n"
				+ "from bill_infor bf, product p, bill b, customer c, Accuser a\r\n"
				+ "where bf.product_id=p.id and bf.bill_id=b.id and c.id=b.customer_id and c.username=a.username\r\n"
				+ "and a.username='"+username+"' and b.status=0";
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
			int totalPrice = rs.getInt("totalPrice");
			int size_product = rs.getInt("size_product");
			
			productFromCart sv = new productFromCart();
			sv.setImg(img);
			sv.setId(id);
			sv.setName(name);
			sv.setQuantity(quantity);
			sv.setPrice(price);
			sv.setSize_product(size_product);
			sv.setTotalPrice(totalPrice);
			list.add(sv);
		}
		
		return list;
	}
	
	public static int IDBIll_AlreadyExist(Connection conn, String username) throws SQLException {
        String sql = "select b.id\r\n"
        		+ "from bill b, accuser a, customer c\r\n"
        		+ "where b.customer_id=c.id and c.username=a.username and a.username='"+username+"' and status=0";        
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	
	public static int NumberProInCart(Connection conn, int id_bill) throws SQLException {
        String sql = "select COUNT(*) from bill_infor bf where bill_id="+id_bill;        
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	public static int TotalMoney(Connection conn, String username) throws SQLException {
        String sql = "select sum(price*quantity) as sum\r\n"
        		+ "from bill_infor bf, product p, bill b, customer c, Accuser a\r\n"
        		+ "where bf.product_id=p.id and bf.bill_id=b.id and c.id=b.customer_id and c.username=a.username\r\n"
        		+ "	and a.username='"+username+"' and b.status=0" ;
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	//thêm giá trị cột giá và trạng thái 1 cho bill
	public static void updateBill(Connection conn, int totalMoney, String username) throws SQLException {
        String sql = "update bill set status=1 , totalMoney="+totalMoney+" from customer c, Accuser a\r\n"
        		+ "where bill.customer_id=c.id and c.id=bill.customer_id and c.username=a.username\r\n"
        		+ " and a.username='"+username+"'";

        conn.createStatement().executeUpdate(sql);
        System.out.println("updateBill");       
    }

	public static void delProFromCart(Connection conn, int id_bill, int NumRow) throws SQLException {
        String sql = "delete from bill_infor \n"
        		+ "where product_id in (SELECT product_id from\n"
        		+ "(select product_id, ROW_NUMBER() over (ORDER BY product_id ) as rw\n"
        		+ "from bill_infor \n"
        		+ "where bill_id="+id_bill+") res WHERE res.rw = "+NumRow+")";
        
        conn.createStatement().executeUpdate(sql);        

    }
	public static int getBillID_ByUrname(Connection conn, String username) throws SQLException {
        String sql = "select b.id\n"
        		+ "from bill b, bill_infor bf, customer c, Accuser a\n"
        		+ "where b.id=bf.bill_id and b.customer_id=c.id and c.username=a.username and b.status=0 and \n"
        		+ "a.username='"+username+"'" ;
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	public static void updateProInCart(Connection conn, int quantity, int bill_id, int numRow) throws SQLException {
        String sql = "execute SP_updateQuantity "+ quantity +", "+ bill_id +", "+ numRow;
        System.out.println(sql);
        conn.createStatement().executeUpdate(sql);
    }
	//hiển thị số lượng sp trên header
	public static int NumProduct(Connection conn, String username) throws SQLException {
        String sql = "select COUNT(*)\n"
        		+ "from bill_infor bf, bill b, customer c, Accuser a\n"
        		+ "where bf.bill_id=b.id and b.customer_id=c.id and c.username=a.username \n"
        		+ "	and a.username='"+username+"'" + " and b.status=0" ;
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	
}
