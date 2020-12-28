package utils;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.product;
import beans.product_detail;

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
			String detail =  rs.getString("detail");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setDetail(detail);
			s.setImg(img);
			s.setType_id(type_id);
			
			list.add(s);
		}
		return list;	
	}

	public static List<product> listProduct(Connection conn, String x)
			throws SQLException, ClassNotFoundException
	{
		String sql = "select * from product " + CommandSQL_Price(x);
		sql = sql.replace("{and}", "");
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String detail =  rs.getString("detail");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");

			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setDetail(detail);
			s.setImg(img);
			s.setType_id(type_id);
			
			list.add(s);
		}	
		return list;
		
	}
	public static List<product> listProduct_Nam(Connection conn, String x)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from product where type_id=1 "+ CommandSQL_Price(x);;
		PreparedStatement pstm =conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String detail =  rs.getString("detail");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setDetail(detail);
			s.setImg(img);
			s.setType_id(type_id);
			
			list.add(s);
		}	
		return list;
		
	}
	public static String  CommandSQL_Price(String x) {
		String result = "";
		if (x.equals("1M")) {
			result="and price > 1000000";
		}
		else if (x.equals("500K-1M")) {
			result="and price between 500000 and 1000000 ";
		}
		else if (x.equals("500K")) {
			result="and price < 500000";
		}
		
		return result;
	}
	public static List<product> listProduct_Nu(Connection conn, String x)
			throws SQLException, ClassNotFoundException{
		String sql="select * from product where type_id=2 "+ CommandSQL_Price(x);
		PreparedStatement pstm =conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String detail =  rs.getString("detail");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setDetail(detail);
			s.setImg(img);
			s.setType_id(type_id);
			
			list.add(s);
		}	
		return list;
		
	}
	public static product findProduct(Connection conn, int idIn) throws SQLException, ClassNotFoundException {
        String sql = "select p.id,p.name,price,detail,img, t.name as type_name from product p, Type t where p.type_id=t.id and p.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");           
            String detail = rs.getString("detail");
            String img = rs.getString("img");
            String t_name = rs.getString("type_name");
            
            product p = new product(id,  name,  price,  detail,  img,  t_name);
            return p;
        }
        
        return null;
    }
	public static List<product_detail> sizeOfProduct(Connection conn, int  idPro)throws SQLException, ClassNotFoundException{
		String sql = "select size,quantity from product_detail where id_product=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idPro);
        ResultSet rs = pstm.executeQuery();
        List<product_detail> list = new ArrayList<product_detail>();
		while (rs.next()) 
		{
			int size = rs.getInt("size");
			int quantity = rs.getInt("quantity");
			
			product_detail p = new product_detail();
			p.setSize(size);
			p.setQuantity(quantity);
			
			list.add(p);
		}	
		return list;
    }
	public static List<product> listProduct_search(Connection conn, String key)
			throws SQLException, ClassNotFoundException
	{
		String sql="select * from product where name like N'%" +key+"%'";
		PreparedStatement pstm =conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");			
			int price = rs.getInt("price");
			String detail =  rs.getString("detail");
			String img = rs.getString("img");
			int type_id = rs.getInt("type_id");
			
			product s = new product();
			s.setId(id);
			s.setName(name);
			s.setPrice(price);
			s.setDetail(detail);
			s.setImg(img);
			s.setType_id(type_id);
			
			list.add(s);
		}	
		return list;
		
	}
	
}
