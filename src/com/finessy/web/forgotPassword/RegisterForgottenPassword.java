package com.finessy.web.forgotPassword;

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
 * Servlet implementation class RegisterForgottenPassword
 */
@WebServlet("/registerForgottenPassword")
public class RegisterForgottenPassword extends HttpServlet {
	boolean isupdated;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPassword = BCrypt.hashpw(request.getParameter("newPassword"), BCrypt.gensalt());
		Integer studentId = (Integer)request.getSession(false).getAttribute("userid");
		UserDAO dao = new UserDAO();
		try {
			isupdated = dao.updatePassword(studentId, newPassword);
			if(isupdated) {
				response.sendRedirect("forgotpasswordsuccess.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		
	}

}
