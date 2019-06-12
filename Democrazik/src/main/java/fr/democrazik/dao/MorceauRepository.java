package fr.democrazik.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Morceau;
import fr.democrazik.entities.Session;

public interface MorceauRepository extends JpaRepository<Morceau, Long> {
	

	@Query("select morceau, compte from Morceau morceau, "
			+ "(select vote, count(vote) as compte from Vote vote groub by vote.idTitre) table"
			+ "where morceau.idTitre = table.vote.idTitre ORDER BY table.compte")
	List<Object[]> values();
	

}
