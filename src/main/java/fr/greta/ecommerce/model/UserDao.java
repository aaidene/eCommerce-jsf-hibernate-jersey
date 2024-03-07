package fr.greta.ecommerce.model;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.greta.ecommerce.entity.User;

public class UserDao {

	public User getUserById(Integer id) throws Exception {

		Session session = HibernateConnector.getInstance().getSession();
		try {
			Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.id = :ident", User.class);
			query.setParameter("ident", id);
			return query.uniqueResult();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void addUser(User user) throws Exception {

		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();

		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public List<User> getUsers() throws Exception {

		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();

			// façon 1 : Requête en SQL pur
			// Query<User> query = session.createNativeQuery("SELECT * FROM user",
			// User.class);

			// façon 2 : Requête prédéfinie
			// Query<User> query = session.createNamedQuery("User:findAll", User.class);

			// façon 3 : Requête JPQL
			Query<User> query = session.createQuery("SELECT u FROM User u", User.class);

			return query.list();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}
}
