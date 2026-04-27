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


@WebServlet("/delete")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteRegistrationController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email") != null) {
		String email = request.getParameter("email");
		DBService service = new DBServiceImpl();
		service.connectDB();
		service.deleteRecord(email);
		
		ResultSet result = service.getStudents();
		request.setAttribute("result", result);
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/view/viewStudents.jsp");
		rs.forward(request, response);}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
