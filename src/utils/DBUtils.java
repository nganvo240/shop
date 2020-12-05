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
			
			slide s = new slide();
			s.setId(id);
			s.setImg(img);
			
			list.add(s);
		}
		System.out.println("in coi");
		return list;
		
	}
}
