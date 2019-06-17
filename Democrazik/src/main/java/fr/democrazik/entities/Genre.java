package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Genre {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable=false)
	private String libelle;
	

	public Genre(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
		
	}





	public Genre(String libelle) {
		super();
		this.libelle = libelle;
		
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


	
	

}
