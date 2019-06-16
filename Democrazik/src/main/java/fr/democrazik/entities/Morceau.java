package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Morceau {

	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String titre;
	
	@ManyToOne

	private Session session;
	@ManyToOne

	private Genre genre;
	@ManyToOne

	private Artiste artiste;
	
	private String chemin;

	
	public Morceau() {
		super();
	}
	
	public Morceau(String titre, Session session, Genre genre, Artiste artiste) {
		super();
		this.titre = titre;
		this.session = session;
		this.genre = genre;
		this.artiste = artiste;
	}
	
	public Morceau(String titre, Session session, Genre genre, Artiste artiste, String chemin) {
		super();
		this.titre = titre;
		this.session = session;
		this.genre = genre;
		this.artiste = artiste;
		this.chemin = chemin;
	}
	

	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Artiste getArtiste() {
		return artiste;
	}
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	
	
}
