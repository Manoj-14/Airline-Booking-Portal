package com.AirlineBookingPortal.Utils;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.AirlineBookingPortal.model.Flight;
import com.AirlineBookingPortal.model.OpenFlights;

public class AllotedFlightUtil {

	public static void addDateToFlight(Flight flight, Date date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		OpenFlights of = new OpenFlights(flight, date);

		session.save(of);
		session.getTransaction().commit();
		session.close();
	}

	public static List<OpenFlights> getAllocations() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<OpenFlights> openFlights = session.createQuery("from OpenFlights").getResultList();
		session.close();
		return openFlights;
	}

	public static List<Flight> getFlights(Date date,Integer sourceId,Integer destinationId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select f from Flight f join OpenFlights o on f.flight_id = o.flight.flight_id where o.date = :date and f.source.id=:sourceId and f.destination.id=:destinationId";
		Query query = session.createQuery(hql);
		query.setParameter("date", date);
		query.setParameter("sourceId", sourceId);
		query.setParameter("destinationId", destinationId);
		List<Flight> of = query.getResultList();
		session.close();
		return of;
	}
}
