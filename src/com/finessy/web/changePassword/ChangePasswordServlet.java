package com.finessy.web.changePassword;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.finessy.web.user.UserDAO;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		String oldPassword = BCrypt.hashpw(request.getParameter("oldPassword"), BCrypt.gensalt());
		String newPassword =  BCrypt.hashpw(request.getParameter("newPassword"), BCrypt.gensalt());
		String message = null;
		UserDAO dao = new UserDAO();
		boolean updatePassword;
		
		try {
			if(dao.getOldPassword(studentId).equals(oldPassword)) {
				
				 updatePassword = dao.updatePassword(studentId, newPassword);
				 response.sendRedirect("changepasswordsuccess.html");
				 response.setHeader("Cache-control", "no-cache, no-store");
					response.setHeader("Pragma", "no-cache");
					response.setHeader("Expires", "-1");
			}
			else {
				message = "incorrect Current password";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println(message);
		
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		
	}

}
