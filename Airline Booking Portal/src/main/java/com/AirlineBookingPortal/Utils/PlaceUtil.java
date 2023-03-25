package com.AirlineBookingPortal.Utils;

import java.util.List;

import org.hibernate.Session;

import com.AirlineBookingPortal.model.Place;

public class PlaceUtil {
	public static void addplace(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Place place = new Place(name);

		session.save(place);
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<Place> getPlace() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Place" ;
		List<Place> places= session.createQuery(hql).getResultList();
		session.close();
		return places;
	}
	
	public static Place getPlace(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Place place = null;
		place = session.get(Place.class, id);
		return place;
	}
}
