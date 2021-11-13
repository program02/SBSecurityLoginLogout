package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDao {
	Connection con;
	PreparedStatement pstmt;
	public List<User> allUsers() {
		List<User> pList = new ArrayList<>();
		User p;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbsecurity", "root", "idb@123456");
			 pstmt = con.prepareStatement("select * from user");
			ResultSet rs = pstmt.executeQuery();
			//for date type 
			//Take sql.Date in pojo then no need to convert
			//Otherwise convert to sql.Date
			// java.util.Date d = new java.util.Date();
			//java.sql.Date sd = new java.sql.Date(d.getTime());
			
			while (rs.next()) {
				//System.out.println(rs.getInt(1));
				p=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				pList.add(p);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList;
	}
	
	
	public User userById(int id) {
		//List<Product> pList = new ArrayList<>();
		User u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbsecurity", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from user where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt(1));
				u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				//stList.add(s);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public User userByName(String name) {
		//List<Product> pList = new ArrayList<>();
		User u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbsecurity", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from user where username=?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt(1));
				u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				//stList.add(s);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	
}
