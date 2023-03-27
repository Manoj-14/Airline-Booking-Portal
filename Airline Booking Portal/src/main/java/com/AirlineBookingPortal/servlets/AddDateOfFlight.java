package com.AirlineBookingPortal.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirlineBookingPortal.Utils.AllotedFlightUtil;
import com.AirlineBookingPortal.Utils.FlightUtil;
import com.AirlineBookingPortal.model.Flight;

@WebServlet("/AddDateOfFlight")
public class AddDateOfFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>URL Not Found</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flightId = Integer.parseInt(request.getParameter("flight"));
		String flightDate = request.getParameter("flightDate");
		Flight flight = FlightUtil.getFlight(flightId);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = dateformat.parse(flightDate);
			AllotedFlightUtil.addDateToFlight(flight, date);
			System.out.println(date);
			response.sendRedirect("dashboard");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
