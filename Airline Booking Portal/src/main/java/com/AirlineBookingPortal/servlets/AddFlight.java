package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirlineBookingPortal.Utils.FlightUtil;
import com.AirlineBookingPortal.Utils.PlaceUtil;
import com.AirlineBookingPortal.model.Place;

@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddFlight() {
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
		String flight_name = request.getParameter("flightName");
		int numOfPassenger = Integer.parseInt(request.getParameter("noOfPassengers"));
		int source_id = Integer.parseInt(request.getParameter("source"));
		int destination_id = Integer.parseInt(request.getParameter("destination"));
				
		Place source = PlaceUtil.getPlace(source_id);
		Place destionation = PlaceUtil.getPlace(destination_id);
		FlightUtil.addFlight(flight_name, numOfPassenger, source, destionation);
		response.sendRedirect("dashboard");
	}

}
