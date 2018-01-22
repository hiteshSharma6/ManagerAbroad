package com.finessy.web.forum.discussion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.finessy.web.forum.GroupDTO;

@WebServlet("/forum/discussion")
public class DiscussionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{"
        + "\"groupId\": 2,"
        + "\"universityId\": 0,"
        + "\"regionId\": 1,"
        + "\"nativeCountryId\": 0,"
        + "\"degreeId\": 0,"
        + "\"programId\": 1"
		+ "}";
		
		System.out.println(json);
		
		GroupDTO groupDTO;
		
		groupDTO = mapper.readValue(json, new TypeReference<DiscussionDTO>() {});
		
		DiscussionDTO discussionDTO = DiscussionCtrl.getDiscussionPage(groupDTO);
		
		if(discussionDTO == null) {
			//Return to unknown error page.
		}
		else if(discussionDTO.getQuestions() == null) {
			//Show no such group exists.
			response.setContentType("application/text");
			response.getWriter().println("Sorry, no such group exists. Be the first to <a href='#'>ask question</a> and start this group.");
		}
		else {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(discussionDTO);
			
			response.setContentType("application/json");
			response.getWriter().println(json);
		}
	}

}
