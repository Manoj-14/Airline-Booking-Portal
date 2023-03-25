package com.AirlineBookingPortal.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.AirlineBookingPortal.Utils.FlightUtil;
import com.AirlineBookingPortal.Utils.HibernateUtil;
import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.OpenFlights;

@WebServlet("/AddDateOfFlight")
public class AddDateOfFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Flight flight = FlightUtil.getFlight(1);
		OpenFlights of= new OpenFlights(flight, new Date(14082023));
		
		session.save(of);
		session.getTransaction().commit();
		session.close();
	}

}
