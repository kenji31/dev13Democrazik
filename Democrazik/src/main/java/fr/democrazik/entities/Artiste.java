//hazmatique

package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artiste {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
	@ManyToOne
	private Session session;
	
	
	
	
		public Artiste(Long id, String nom, Session session) {
		super();
		this.id = id;
		this.nom = nom;
		this.session = session;
	}



		public Artiste(String nom, Session session) {
		super();
		this.nom = nom;
		this.session = session;
	}
		
		

	public Artiste() {
			super();
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
