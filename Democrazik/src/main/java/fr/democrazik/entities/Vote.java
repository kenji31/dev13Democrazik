package fr.democrazik.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints= @UniqueConstraint(columnNames={"utilisateur", "morceau"}) )


@Entity
public class Vote {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Morceau morceau;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Morceau getMorceau() {
		return morceau;
	}

	public void setMorceau(Morceau morceau) {
		this.morceau = morceau;
	}
	
	
	
}
