package fr.greta.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User:findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User:findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")	
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom", nullable = false, length = 32)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 32)
	private String prenom;
	
	@Column(name = "email", nullable = false, length = 32, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 32)
	private String password;

	@Column(name = "telephone", nullable = true, length = 14)
	private String telephone;
	
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + ", dateNaissance=" + dateNaissance + "]";
	}

}
