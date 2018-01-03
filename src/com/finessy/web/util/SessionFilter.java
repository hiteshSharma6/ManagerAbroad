package com.finessy.web.util;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/dashboard/*")
public class SessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Cookie[] cookies = null;
		
		cookies = ((HttpServletRequest) request).getCookies();
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
	            System.out.println("Name : " + cookie.getName( ) + ",  ");
	            System.out.println("Value: " + cookie.getValue( ) + " <br/>");
	         }
		}
		
        String requestURI = ((HttpServletRequest) request).getRequestURI();
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		System.out.println("Filter");
		if(session == null) {
			String url = ((HttpServletRequest) request).getRequestURI();
			String start = "finessy/";
			int url2 = url.indexOf(start) + start.length();
			System.out.println(url2);
			System.out.println(url.substring(url2));
			String cp = ((HttpServletRequest)request).getContextPath();
			System.out.println(cp);
//		    String encodedUrl = ((HttpServletResponse) response).encodeURL(cp + "/login.html");
//		    System.out.println(encodedUrl);
//			request.getRequestDispatcher("login").forward(request, response);
			((HttpServletResponse)response).sendRedirect("/finessy/login.html");
			System.out.println("in");
			return;
		}
		else {
			System.out.println("out");
			chain.doFilter(request, response);
		}
		
	}

}
