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
import java.util.List;

import com.AirlineBookingPortal.Utils.AdminUtil;
import com.AirlineBookingPortal.Utils.AllotedFlightUtil;
import com.AirlineBookingPortal.Utils.FlightUtil;
import com.AirlineBookingPortal.Utils.PassengetUtil;
import com.AirlineBookingPortal.Utils.PlaceUtil;
import com.AirlineBookingPortal.model.Admin;
import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.OpenFlights;
import com.AirlineBookingPortal.model.Passenger;
import com.AirlineBookingPortal.model.Place;

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
			List<Place> places = PlaceUtil.getPlace();
			List<Flight> flights = FlightUtil.getFlight();
			List<OpenFlights> ofs = AllotedFlightUtil.getAllocations();
			List<Passenger> passengers = PassengetUtil.getPassengers();
			for(Passenger pas:passengers) {
				System.out.println(pas.getDate());
			}
			request.setAttribute("passengers", passengers);
			request.setAttribute("places", places);
			request.setAttribute("admin", admin);		
			request.setAttribute("flights", flights);
			request.setAttribute("ofs", ofs);
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>URL Not Found</h2>");
	}

}
