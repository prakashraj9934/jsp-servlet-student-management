package com.studentcrm.Model;

import java.sql.ResultSet;

public interface DBService {
	
	public boolean verifyLogin(String email, String password);

	public int register(String name, String email, String mobile);

	public ResultSet getStudents();

	public void connectDB();

	public void deleteRecord(String email);

	public void updateRecord(String name, String email, String mobile, String oldemail);

}
