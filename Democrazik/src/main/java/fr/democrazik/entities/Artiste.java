//hazmatique

package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Artiste {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable=false)
	private String nom;

	
		public Artiste(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
	}

		public Artiste(String nom) {
		super();
		this.nom = nom;
		
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


	
}
