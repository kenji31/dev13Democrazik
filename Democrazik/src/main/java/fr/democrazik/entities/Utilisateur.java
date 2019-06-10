package fr.democrazik.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@Column(nullable = false)
	@Column(unique = true)
	private String mail;
	
	@ManyToOne
	private Session session;
	
	@ManyToMany(targetEntity=Morceau.class)
	private Set morceauSet;

}
