package com.springstudy.ch01.strong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.springstudy.ch01.domain.Product;

public class ProductDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/spring?useSSL=false&useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String pass = "12345678";
	
	public ArrayList<Product> getProductList() {
		
		String selectSql = "SELECT * FROM product";		
		ArrayList<Product> pList = new ArrayList<Product>();
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString("code"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
				pList.add(p);
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) { }
		}				
		
		return pList;
	}
}
