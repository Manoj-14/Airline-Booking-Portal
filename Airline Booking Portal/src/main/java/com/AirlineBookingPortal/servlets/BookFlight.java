package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AirlineBookingPortal.Utils.AllotedFlightUtil;
import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.OpenFlights;

@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightDate = request.getParameter("flightDate");
		int sourceId = Integer.parseInt(request.getParameter("source"));
		int destinationId = Integer.parseInt(request.getParameter("destination"));
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = dateformat.parse(flightDate);
			List<Flight> flights = AllotedFlightUtil.getFlights(date, sourceId, destinationId);
			request.setAttribute("flights", flights);
			request.setAttribute("NoOfFlights", flights.size());
			request.setAttribute("date", date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("bookFlight.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
