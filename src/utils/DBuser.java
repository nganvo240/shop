package utils;
//insert, delete, update su dung executeUpdate
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.branch;
import beans.user;


public class DBuser {
	
	public static user insertUser(Connection conn, user u) throws SQLException {
        String sql = "INSERT INTO accuser(username, password, email, role) " + "VALUES(?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        System.out.println("add user");
        
        pstm.setString(1, u.getUsername());
        pstm.setString(2, u.getPassword());
        pstm.setString(3, u.getEmail());
        pstm.setInt(4, u.getRole());
        
        pstm.executeUpdate();
        
        return u;             
    }
	public static int testLogin(Connection conn, String username, String pass) throws SQLException {
        String sql = "select COUNT(*) from Accuser where username= '" + username + "'" + " and password= '"+ pass + "'";
        PreparedStatement pstm =conn.prepareStatement(sql);		
		ResultSet rs = pstm.executeQuery();
		rs.next();
	     // Giá trị của ID (Vị trí 1 theo thiết kế của bảng)
		System.out.println(rs.getInt(1));
	    return rs.getInt(1);            
    } 
	
}
