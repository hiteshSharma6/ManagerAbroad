package com.finessy.web.forgotPassword;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finessy.web.user.UserDAO;

/**
 * Servlet implementation class VerifyUserServlet
 */
@WebServlet("/verifyUser")
public class VerifyUserServlet extends HttpServlet {
	String message = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(request.getParameter("userid"));
		String emailHash = request.getParameter("hash");
		UserDAO dao = new UserDAO();
		
		try {
			if(dao.verifyEmailHash(studentId, emailHash)) {
				request.getSession().setAttribute("userid", studentId);
				request.getRequestDispatcher("registerforgottenpassword.html").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
