package utils;
//insert, delete, update su dung executeUpdate
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.slide;
import beans.user;


public class DBUtils {
	public static List<slide> listSlide(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from slide";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<slide> list = new ArrayList<slide>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String img = rs.getString("img");
			String title =  rs.getString("title");
			String description = rs.getString("description");
			
			slide s = new slide();
			s.setId(id);
			s.setImg(img);
			s.setTitle(title);
			s.setDescription(description);
			
			list.add(s);
		}
		System.out.println("get list slide from DB");
		return list;
		
	}
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
