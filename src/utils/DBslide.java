package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.slide;

public class DBslide {
	/*public static List<slide> listSlide(Connection conn)
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
		return list;
		
	}*/
	public static List<slide> listSlide(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select id,img,name,detail from product";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<slide> list = new ArrayList<slide>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String img = rs.getString("img");
			String title =  rs.getString("name");
			String description = rs.getString("detail");
			
			slide s = new slide();
			s.setId(id);
			s.setImg(img);
			s.setTitle(title);
			s.setDescription(description);
			
			list.add(s);
		}
		return list;
		
	}
}
	

