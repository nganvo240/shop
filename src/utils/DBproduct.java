package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.product;

public class DBproduct {
	public static List<product> listRandomProduct(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select top 9 * from product order by newid()";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String status = rs.getString("status");
			String detail =  rs.getString("detail");
			int price_new = rs.getInt("price_new");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			int branch_id = rs.getInt("branch_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setStatus(status);
			s.setDetail(detail);
			s.setPrice_new(price_new);
			s.setImg(img);
			s.setType_id(type_id);
			s.setBranch_id(branch_id);
			
			list.add(s);
		}
		System.out.println("get list product from DB");
		return list;	
	}

	public static List<product> listProduct(Connection conn)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from product";
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String status = rs.getString("status");
			String detail =  rs.getString("detail");
			int price_new = rs.getInt("price_new");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			int branch_id = rs.getInt("branch_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setStatus(status);
			s.setDetail(detail);
			s.setPrice_new(price_new);
			s.setImg(img);
			s.setType_id(type_id);
			s.setBranch_id(branch_id);
			
			list.add(s);
		}	
		return list;
		
	}
	
}
