package com.finessy.web.forum.group.degree;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/degree")
public class DegreeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		int degreeId = Integer.parseInt(request.getParameter("degreeId"));
		
		DegreeDTO degreeDTO = DegreeCtrl.getDegreeDetail(degreeId);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(degreeDTO);
		json = "\"degree\": "+ json;

		response.setContentType("application/json");
		response.getWriter().println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
