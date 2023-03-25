package com.AirlineBookingPortal.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
		@SuppressWarnings("deprecation")
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder(registry).build();
		return metadata.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
