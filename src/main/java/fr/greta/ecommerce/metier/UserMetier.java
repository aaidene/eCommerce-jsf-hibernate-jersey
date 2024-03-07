package fr.greta.ecommerce.metier;

import java.util.List;

import fr.greta.ecommerce.entity.User;
import fr.greta.ecommerce.model.UserDao;

public class UserMetier {

	public void addUser(User user) throws Exception {
		user.setNom(user.getNom().trim().toUpperCase());
		user.setPrenom(user.getPrenom().trim().substring(0, 1).toUpperCase()
							.concat(user.getPrenom().trim().substring(1).toLowerCase()));
		
		// on peut plutard ici crypter le mot de passe
		
		UserDao userDao = new UserDao();
		userDao.addUser(user);
	}
	
	public List<User> getUsers() throws Exception {
		
		UserDao userDao = new UserDao();
		return userDao.getUsers();
	}

	public User getUserByEmail(String email) throws Exception {
	    UserDao userDao = new UserDao();
	    return userDao.getUserByEmail(email);
	}
}
