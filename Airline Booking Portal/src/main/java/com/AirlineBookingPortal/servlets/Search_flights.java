package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirlineBookingPortal.Utils.PlaceUtil;
import com.AirlineBookingPortal.model.Place;

@WebServlet("/Searchflights")
public class Search_flights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Place> places = PlaceUtil.getPlace();
		request.setAttribute("places", places);
		request.getRequestDispatcher("search_flight.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
