package fr.democrazik.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Vote;



	public interface VoteRepository extends JpaRepository<Vote, Long> {

		@Query("select v from Vote v where v.morceau.id=?1")
		public List<Vote> getVotesOfMorceau(Long id);
	}