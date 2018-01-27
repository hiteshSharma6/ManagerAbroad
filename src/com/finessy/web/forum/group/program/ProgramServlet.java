package com.finessy.web.forum.group.program;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/program")
public class ProgramServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		int programId = Integer.parseInt(request.getParameter("programId"));
		
		ProgramDTO programDTO = ProgramCtrl.getProgramDetail(programId);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(programDTO);
		json = "\"program\": "+ json;

		response.setContentType("application/json");
		response.getWriter().println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
