package com.studentcrm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentcrm.Model.DBService;
import com.studentcrm.Model.DBServiceImpl;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		try {
			session.setMaxInactiveInterval(30);
			if(session.getAttribute("email") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
			rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			try {
				session.setMaxInactiveInterval(30);
				if(session.getAttribute("email") != null) {
					
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				
				DBService service = new DBServiceImpl();
				int nora = service.register(name,email,mobile);
				
				if(nora>0) {
					request.setAttribute("message", "<p style='text-align:center; color:green;'>"+nora +" new row Added Successfully<p>");
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
					rd.forward(request, response);
					}
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
				
			
	}

}
