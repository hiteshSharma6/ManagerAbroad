package com.finessy.web.forgotPassword;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.finessy.web.mailapp.SendMail;
import com.finessy.web.user.UserDAO;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	ResourceBundle rb = ResourceBundle.getBundle("config");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String)request.getParameter("email");
		String emailHash = null;
		int studentId;
		UserDAO dao = new UserDAO();
		try {
			if(dao.doExist(email)) {
				if(dao.isActive(email).equals("active")) {
					 emailHash = BCrypt.hashpw(email, BCrypt.gensalt());
					 studentId = dao.findStudentId(email);
					 
					 String link = rb.getString("forgotPasswordLink")+"?userid="+studentId+"&hash="+emailHash;
					 StringBuilder bodyText = new StringBuilder();
						bodyText.append("<div>")
						        .append("  Dear User<br/><br/>")
						        .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser for password reset<br/>")
						        .append("  <a href=\""+link+"\">"+link+"</a>")
						        .append("  <br/><br/>")
						        .append("  Thanks,<br/>")
						        .append("  Abroad Manager Team")
						        .append("</div>");
						
						String bodyMessage = bodyText.toString();
						
						SendMail.send(email,bodyMessage);

				}
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
		doGet(request,response);
		}

}
