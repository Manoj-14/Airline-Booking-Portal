package com.AirlineBookingPortal.servlets;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Place source =PlaceUtil.getPlace(3);
		Place destionation =PlaceUtil.getPlace(2);
		FlightUtil.addFlight("Mysore Express", 150, source, destionation);
	}

}
