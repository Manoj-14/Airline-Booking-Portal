package com.AirlineBookingPortal.Utils;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.AirlineBookingPortal.model.Admin;
import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.Passenger;

public class PassengetUtil {

	public static void addPassenger(String name, int age, Flight flight,Date date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Passenger passenger = new Passenger(name, age, flight,date);

		session.save(passenger);
		session.getTransaction().commit();
		session.close();
	}

	public static List<Passenger> getPassengers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Passenger> passengers = session.createQuery("from Passenger").getResultList();
		session.close();
		return passengers;
	}
}
