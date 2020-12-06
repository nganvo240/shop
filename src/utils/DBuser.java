package utils;
//insert, delete, update su dung executeUpdate
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import beans.user;


public class DBuser {
	
	//xử lý user
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
}
