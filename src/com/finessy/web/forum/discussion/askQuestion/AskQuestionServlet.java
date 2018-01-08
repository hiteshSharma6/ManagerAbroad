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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{"
        + "\"group\": {"
        + "\"groupId\": 2,"
        + "\"universityId\": 0,"
        + "\"regionId\": 1,"
        + "\"nativeCountryId\": 0,"
        + "\"degreeId\": 0,"
        + "\"programId\": 1"
        + "},"
        + "\"questionId\": 0,"
        + "\"description\": \"How you doing at hostel?\","
        + "\"postBy\": 1,"
        + "\"postOn\": \" \","
        + "\"tags\": \"hostel\""
		+ "}";
		
		System.out.println(json);
		
		AskQuestionDTO askQuestionDTO;
		
		askQuestionDTO = mapper.readValue(json, new TypeReference<AskQuestionDTO>() {});
		
		askQuestionDTO = AskQuestionCtrl.addQuestion(askQuestionDTO);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(askQuestionDTO);
		
		response.setContentType("application/json");
		response.getWriter().println(json);
	}

}
