package com.finessy.web.forum.group.university;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/university")
public class UniversityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		int universityId = Integer.parseInt(request.getParameter("universityId"));;
		
		UniversityDTO universityDTO = UniversityCtrl.getUniversityDetail(universityId);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(universityDTO);
		json = "\"university\": "+ json;
		
		response.setContentType("application/json");
		response.getWriter().println(json);
		System.out.println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
