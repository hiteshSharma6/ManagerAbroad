package com.finessy.web.forum.question;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class RelatedQuestionsServlet
 */
@WebServlet("/relatedQuestions")
public class RelatedQuestionsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		RelatedQuestionsDAO dao = new RelatedQuestionsDAO();
		ArrayList<RelatedQuestionsDTO> quesList = new ArrayList<RelatedQuestionsDTO>();
		
		try {
			quesList = dao.findRelatedQuestions(questionId);
			ObjectMapper mapper = new ObjectMapper();
			 String json;
			 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(quesList);
			 
			 response.setContentType("application/json");
			 response.getWriter().println(json);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
