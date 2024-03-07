package fr.greta.ecommerce.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.greta.ecommerce.entity.User;
import fr.greta.ecommerce.metier.UserMetier;
import fr.greta.ecommerce.utils.Dates;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean {

	@ManagedProperty(name = "nom", value = "")
	private String nom;
	private String prenom;
	private String email;
	private String passwordConfirmation;
	private String password;
	private String telephone;
	private String dateNaissance;
	
	private String messageError;
	private String messageSuccess;


	public UserBean() {
		messageError = messageSuccess = "";
	}

	public String addUser() {
		messageError = messageSuccess = "";
		
		if ( !password.equals(passwordConfirmation)) {
			
			messageError = "Les deux mot mot de passe doivent se correcpondre  ";
			return "";
			
		}
		
		

		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setDateNaissance(Dates.convertStringToDate(dateNaissance));
		
		UserMetier userMetier = new UserMetier();
		try {
			userMetier.addUser(user);
			messageSuccess = "L'utilisateur a bien été crée.";
			nom = prenom = email = password = telephone = dateNaissance = "";
		} catch (Exception e) {
			messageError = "Erreur lors de la création de l'utilisateur\n"
					+ "+ ERROR : " + e.getMessage();
		}
		return "";
		
	}
	
	public List<User> getUsers() {
		messageError = messageSuccess = "";
		UserMetier userMetier = new UserMetier();
		List<User> users = new ArrayList<>();
		try {
			users = userMetier.getUsers();
		} catch (Exception e) {
			messageError = "Erreur lors de la récupération de la liste des utilisateurs\n"
			+ "+ ERROR : " + e.getMessage();
		}
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

	
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}
	
	

}
