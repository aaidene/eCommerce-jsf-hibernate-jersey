package fr.greta.ecommerce.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

	private static HibernateConnector instance;
	private SessionFactory sessionFactory;
	private Session session;
	
	private HibernateConnector() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	}
	
	public static HibernateConnector getInstance() {
		if (instance == null) {
			instance = new HibernateConnector();
		}
		return instance;
	}
	
	public Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
}
