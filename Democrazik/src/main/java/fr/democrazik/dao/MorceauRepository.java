package fr.democrazik.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Morceau;


public interface MorceauRepository extends JpaRepository<Morceau, Long> {
	
	@Query("select v, count(v) as compte from Vote v group by v.morceau.id order by compte desc")
	public List<Object[]> orderMorceauByVote();
	
//	@Query("select v.morceau, v.morceau.session.id count(v) as compte from Vote v group by v.morceau.id order by compte desc")
//	public List<Object[]> getPopulaire();
	
//	@Query(value ="select m from Morceau m where session_id=?1 ORDER BY RAND() LIMIT 1", 
//			native=true) // id_session ou session_id ?
//	public List<Morceau> getRandomMorceauOfSession(Long id);
	
}
 
