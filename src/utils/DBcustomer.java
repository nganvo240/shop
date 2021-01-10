package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.customer;

public class DBcustomer {
	public static customer displayCustomer(Connection conn, String Inusername)
			throws SQLException
	{
		String sql = "select * from customer where username='"+Inusername+"'";
		PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String name = rs.getString("name");			
			String tel = rs.getString("tel");
			String address =  rs.getString("address");
			String username = rs.getString("username");
			customer sv = new customer (name,  address,  tel,  username);
            return sv;
        }
        return null;
		
	}
	public static void updateCustomer(Connection conn, String name, String addr, String tel, String username) throws SQLException {
        String sql = "execute SP_updateCustomer N'"+ name +"', N'"+ addr +"', '"+ tel +"', '"+ username+"'";
        System.out.println(sql);
        conn.createStatement().executeUpdate(sql);
    }

}
