package fr.democrazik.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;



import fr.democrazik.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	public List<Session> findSessionByNom(String nom);

}
