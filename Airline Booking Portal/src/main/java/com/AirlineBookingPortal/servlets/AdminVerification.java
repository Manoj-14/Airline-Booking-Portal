package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AirlineBookingPortal.Utils.AdminUtil;
import com.AirlineBookingPortal.model.Admin;

@WebServlet("/AdminVerification")
public class AdminVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminVerification() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>URL Not Found</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin admin = AdminUtil.getAdmin(email, password);
		RequestDispatcher dispatcher = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (admin == null) {
			dispatcher = request.getRequestDispatcher("admin_login.html");
			out.println("<p>Invalid Credentials</p>");
			dispatcher.include(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("email", admin.getUsername());
			response.sendRedirect("dashboard");
		}
	}

}
