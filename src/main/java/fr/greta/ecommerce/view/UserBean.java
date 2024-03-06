package fr.greta.ecommerce.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.greta.ecommerce.entity.User;
import fr.greta.ecommerce.utils.Dates;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean {

	@ManagedProperty(name = "nom", value = "")
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telephone;
	private String dateNaissance;
	
	private String message;

	private static List<User> users;
	
	public UserBean() {
		users = new ArrayList<>();
		message = "";
	}

	public String addUser() {
		message = "";
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setDateNaissance(Dates.convertStringToDate(dateNaissance));
		
		users.add(user);
		
		nom = prenom = email = password = telephone = dateNaissance = "";
		message = "L'utilisateur a bien été crée.";
		
		return "login";
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
