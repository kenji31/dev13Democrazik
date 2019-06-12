package fr.democrazik.dao;




import org.springframework.data.jpa.repository.JpaRepository;


import fr.democrazik.entities.Vote;



	public interface VoteRepository extends JpaRepository<Vote, Long> {

	}