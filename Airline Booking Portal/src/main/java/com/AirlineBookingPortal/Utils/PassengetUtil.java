package com.AirlineBookingPortal.Utils;

import org.hibernate.Session;

import com.AirlineBookingPortal.model.Admin;
import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.Passenger;

public class PassengetUtil {

	public static void addPassenger(String name,int age,Flight flight) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Passenger passenger = new Passenger(name,age,flight);

		session.save(passenger);
		session.getTransaction().commit();
		session.close();
	}
}
