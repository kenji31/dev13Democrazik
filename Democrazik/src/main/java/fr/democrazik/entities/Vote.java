package fr.democrazik.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(uniqueConstraints= @UniqueConstraint(columnNames={"utilisateur_id", "morceau_id"}) )


@Entity
public class Vote {

	@Id @GeneratedValue
	private Long id;
	

	@ManyToOne
	
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	
	@ManyToOne
	@JoinColumn(name = "morceau_id")

	private Morceau morceau;
	
	
	
	

	public Vote(Utilisateur utilisateur, Morceau morceau) {
		super();
		this.utilisateur = utilisateur;
		this.morceau = morceau;
	}
	
	
	

	public Vote() {
		super();
	}




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
