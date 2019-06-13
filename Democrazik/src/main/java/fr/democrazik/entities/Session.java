package fr.democrazik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Session {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String code;
	
	public Session() {
	}

	public Session(String nom, String code) {
		super();
		this.nom = nom;
		this.code = code;
	}
	
	public Session(Long id, String nom, String code) {
		super();
		this.id=id;
		this.nom = nom;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
