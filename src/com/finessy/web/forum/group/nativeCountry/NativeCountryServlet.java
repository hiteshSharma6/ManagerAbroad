package com.finessy.web.forum.group.nativeCountry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/nativeCountry")
public class NativeCountryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		int nativeCountryId = Integer.parseInt(request.getParameter("nativeCountryId"));
		
		NativeCountryDTO nativeCountryDTO = NativeCountryCtrl.getNativeCountryDetail(nativeCountryId);
		
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nativeCountryDTO);
		json = "\"nativeCountry\": "+ json;

		response.setContentType("application/json");
		response.getWriter().println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
