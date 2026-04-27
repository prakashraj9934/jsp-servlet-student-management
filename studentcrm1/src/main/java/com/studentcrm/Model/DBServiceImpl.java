package com.studentcrm.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBServiceImpl implements DBService {
	private Statement stmnt;
	private Connection con;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcrm","root","root");
			stmnt = con.createStatement();}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcrm","root","root");
					PreparedStatement ps = con.prepareStatement("select * from login where email=? and password=?"); ){
				
				ps.setString(1, email);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				return rs.next();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int register(String name, String email, String mobile) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcrm","root","root");
					PreparedStatement ps =con.prepareStatement("insert into srecord(name, email, mobile) values(?, ?, ?);")){
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, mobile);
					
					return ps.executeUpdate();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

	@Override
	public ResultSet getStudents() {
		try {
			 ResultSet result = stmnt.executeQuery("select * from srecord;");
			 return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void deleteRecord(String email) {
		try {
		stmnt.executeUpdate("delete from srecord where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRecord(String name, String email, String mobile, String oldemail) {
		try {
			stmnt.executeUpdate("update srecord set name='"+name+"', email='"+email+"',mobile='"+mobile+"' where email='"+oldemail+"';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
