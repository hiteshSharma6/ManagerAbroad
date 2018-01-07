package com.finessy.web.forum.discussion.askQuestion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@WebServlet("/forum/discussion/ask")
public class AskQuestionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = request.getParameter("dto_obj");
		
		System.out.println(json);
		
		AskQuestionDTO askQuestionDTO;
		
		askQuestionDTO = mapper.readValue(json, new TypeReference<AskQuestionDTO>() {});
		
		askQuestionDTO = AskQuestionCtrl.addQuestion(askQuestionDTO);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(askQuestionDTO);
		
		response.setContentType("application/json");
		response.getWriter().println(json);
	}

}
