package fr.democrazik.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Collection;
import fr.democrazik.entities.Morceau;


public interface MorceauRepository extends JpaRepository<Morceau, Long> {
	
	@Query("select v, count(v) as compte from Vote v group by v.morceau.id order by compte desc")
	public List<Object[]> orderMorceauByVote();	
	
}
 