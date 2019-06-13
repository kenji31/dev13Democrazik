package fr.democrazik.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Utilisateur {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
    @Column(nullable = false)
	private String prenom;
     
	@Column(nullable = false)
	private String mdp;
	
	@Column(nullable = false, unique = true)
	private String mail;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Session session;
	
	
	
	public Utilisateur() {	
	}
	
	public Utilisateur(String nom, String prenom, String mdp, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.mail = mail;
	}
	
	public Utilisateur(String nom, String prenom, String mdp, String mail, Session session) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.mail = mail;
		this.session = session;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	

}
