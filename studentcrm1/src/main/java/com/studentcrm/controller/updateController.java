package com.studentcrm.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentcrm.Model.DBService;
import com.studentcrm.Model.DBServiceImpl;



@WebServlet("/update")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public updateController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email") != null) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);
			
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/view/update.jsp");
			rs.forward(request, response);}
			else {
				RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				rs.forward(request, response);}
			
		} catch (Exception e) {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);}
		}
		
		
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String oldemail = request.getParameter("oldemail");
		
		DBService service = new DBServiceImpl();
		service.connectDB();
		service.updateRecord(name,email,mobile,oldemail);
		
		ResultSet result = service.getStudents();
		
		
		request.setAttribute("result", result);
		request.setAttribute("massage", "updated Successfully 😊");
		RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/view/viewStudents.jsp");
		rd.forward(request, response);
		
				
			
	}

}
