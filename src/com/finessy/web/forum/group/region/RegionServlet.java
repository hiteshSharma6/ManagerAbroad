package com.finessy.web.forum.group.region;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/region")
public class RegionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		int regionId = Integer.parseInt(request.getParameter("regionId"));
		
		RegionDTO regionDTO = RegionCtrl.getRegionDetail(regionId);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(regionDTO);
		json = "\"region\": "+ json;

		response.setContentType("application/json");
		response.getWriter().println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
