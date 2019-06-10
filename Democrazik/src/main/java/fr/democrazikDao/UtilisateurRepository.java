package fr.democrazikDao;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Utilisateur;

public class UtilisateurRepository {

	
	
	

	public interface PersonneRepository extends JpaRepository<Utilisateur, Long> {

	}

}
