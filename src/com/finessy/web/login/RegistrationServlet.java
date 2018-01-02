package com.finessy.web.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finessy.web.user.UserDAO;
import com.finessy.web.user.UserDTO;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	boolean isregistered;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		UserDTO dto = new UserDTO(firstName, lastName, email, password);
		
		try {
			 isregistered = dao.register(dto);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(isregistered);
	}

}
