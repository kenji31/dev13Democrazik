package fr.democrazik.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Morceau {

	@Id @GeneratedValue
	private Long id;
	
	private String titre;
	
	@ManyToOne
	private Session session;
	@ManyToOne
	private Genre genre;
	@ManyToOne
	private Artiste artiste;
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
