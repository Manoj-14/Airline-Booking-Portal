package com.AirlineBookingPortal.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/AddPlace" ,"/AddFlight","","/AddDateOfFlight","/dashboard"})
public class SessionVerification extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public SessionVerification() {
		super();
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		RequestDispatcher dispatcher ;
		PrintWriter out = response.getWriter();
		if (session == null) {
			dispatcher = request.getRequestDispatcher("admin_login.html");
			out.println("<p>Please login again</p>");
			dispatcher.include(request, response);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Initialization");
	}

}
