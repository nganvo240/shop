package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.branch;
import beans.type;


public class DBcategory {
	public static List<type> listType(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from type";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<type> list = new ArrayList<type>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String link =  rs.getString("link");
			
			type s = new type();
			s.setId(id);
			s.setName(name);
			s.setLink(link);
			
			list.add(s);
		}
		System.out.println("get list type from DB");
		return list;
		
	}
	
	public static List<branch> listBranch(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from branch";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<branch> list = new ArrayList<branch>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			branch s = new branch();
			s.setId(id);
			s.setName(name);
			
			list.add(s);
		}
		return list;
		
	}

}
