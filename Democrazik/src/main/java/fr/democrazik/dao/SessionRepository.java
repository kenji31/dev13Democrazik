package fr.democrazik.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	public List<Session> findSessionByNom(String nom);
	
//	@Modifying
//	  @Transactional
//	  @Query("delete from Session s where s.id = ?1")
//	  public void deleteSessionById(Long id);

}
