package com.finessy.web.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.finessy.web.user.UserDAO;
import com.finessy.web.user.UserDTO;
import com.finessy.web.util.AuthenticateUser;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
//		String pass = BCrypt.hashpw(request.getParameter("password"),BCrypt.gensalt());
		UserDAO dao = new UserDAO();
		boolean exist = false;
		
		boolean valid = AuthenticateUser.valid(email, pass);
		if(valid) {
			
			try {
				exist = dao.doExist(email, pass);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(exist) {
				try {
					UserDTO dto = dao.getUserDetails(email, pass);
					HttpSession session = request.getSession(true);
					session.setAttribute("studentId", dto.getStudentId());
					session.setAttribute("firstName", dto.getFirstName());
					session.setAttribute("lastName", dto.getLastName());					
					response.sendRedirect("welcome.html");
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return;
			}
			else {
				response.sendRedirect("login.html");
			}
			
		}
		else {
			response.sendRedirect("login.html");
		}
		
	}

}
