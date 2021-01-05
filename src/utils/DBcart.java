package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.bill;
import beans.bill_infor;


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
        pstm.setInt(1, sv.getProduct_id());
        pstm.setInt(2, 1);
        
        pstm.executeUpdate();
        System.out.println("theem bill_inf");
        return sv;             
    }
	
	public static int maxID(Connection conn) throws SQLException {
        String sql = "select max(id) from bill";
        Statement stmt = conn.createStatement();    
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
        return rs.getInt(1);             
    }
	
}
