package fr.democrazik.dao;




import org.springframework.data.jpa.repository.JpaRepository;


import fr.democrazik.entities.Utilisateur;



//@ComponentScan(basePackages ={"fr.democrazik"})
	public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	}

