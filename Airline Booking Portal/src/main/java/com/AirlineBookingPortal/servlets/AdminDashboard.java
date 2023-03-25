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

@WebServlet("/dashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher = null;
		if (session != null) {
			String email = (String) session.getAttribute("email");
			Admin admin = AdminUtil.getAdmin(email);
			request.setAttribute("admin", admin);
			dispatcher = request.getRequestDispatcher("dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<p>Invalid Credentials</p>");
			dispatcher = request.getRequestDispatcher("admin_login.html");			
			dispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
