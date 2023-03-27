package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AirlineBookingPortal.Utils.FlightUtil;
import com.AirlineBookingPortal.Utils.PassengetUtil;
import com.AirlineBookingPortal.model.Flight;

@WebServlet("/MakePayment")
public class MakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		String flightdate = request.getParameter("flightdate");
		String[] names = request.getParameterValues("names");
		String[] ages = request.getParameterValues("ages");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateformat.parse(flightdate);
			Flight flight = FlightUtil.getFlight(flightId);
			synchronized (names) {
				for (int i = 0; i < names.length; i++) {
					PassengetUtil.addPassenger(names[i], Integer.parseInt(ages[i]), flight,date);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HttpSession httpSession = request.getSession(false);
		httpSession.invalidate();
		response.sendRedirect("paymentGateway.jsp");
	}

}
