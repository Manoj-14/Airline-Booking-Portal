package com.AirlineBookingPortal.Utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.AirlineBookingPortal.model.Admin;

public class AdminUtil {
	
	
	public static void addAdmin(String username, String name, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Admin admin = new Admin(username, name, password);

		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Admin getAdmin(String email,String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Admin where email = :email and password = :password";
		Query query = session.createQuery(hql,Admin.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<Admin> admins = query.getResultList();
		if(admins.size()<1) {
			return null;
		}
		Admin admin = admins.get(0);
		return admin;
	}
	
	public static Admin getAdmin(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Admin where email = :email";
		Query query = session.createQuery(hql,Admin.class);
		query.setParameter("email", email);
		List<Admin> admins = query.getResultList();
		if(admins.size()<1) {
			return null;
		}
		Admin admin = admins.get(0);
		return admin;
	}
	
}
