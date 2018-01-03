package com.finessy.web.notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String previousDate = null;
		HashMap<Integer,ArrayList<String>> eachGroupQuestionMap = new HashMap<Integer,ArrayList<String>>();
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		NotificationDAO dao = new NotificationDAO();
		try {
			 previousDate = dao.getPreviousDate(studentId);
			 eachGroupQuestionMap = dao.eachGroupQuestion(studentId, previousDate);
			 
			 ObjectMapper mapper = new ObjectMapper();
			 String json;
			 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(eachGroupQuestionMap);
			 
			dao.updateLastLogin(studentId);
				response.setContentType("application/json");
				response.getWriter().println(json);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
