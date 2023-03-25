package com.AirlineBookingPortal.Utils;

import org.hibernate.Session;

import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.Place;

public class FlightUtil {
	public static void addFlight(String flightname, int numofpassengers, Place source, Place destination) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Flight flight = new Flight(flightname, numofpassengers, source, destination);

		session.save(flight);
		session.getTransaction().commit();
		session.close();
	}

	public static Flight getFlight(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Flight flight = null;
		flight = session.get(Flight.class, id);
		return flight;
	}
}
