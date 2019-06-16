package fr.democrazik.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Morceau;


public interface MorceauRepository extends JpaRepository<Morceau, Long> {
	
	@Query("select v, count(v) as compte from Vote v group by v.morceau.id order by compte desc")
	public List<Object[]> orderMorceauByVote();
	
	@Query(value ="select chemin from Morceau where id_session=?1 ORDER BY RAND() LIMIT 1", native=true) // id_session ou session_id ?
	public String getRandomCheminMorceauOfSession(Long id);
	
}
 
