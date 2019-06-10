package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Genre {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable=false)
	private String libelle;
	
	@ManyToOne
	private Session session;
	
	
	
	

	public Genre(Long id, String libelle, Session session) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.session = session;
	}





	public Genre(String libelle, Session session) {
		super();
		this.libelle = libelle;
		this.session = session;
	}
	
	
	
	

	public Genre() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}
