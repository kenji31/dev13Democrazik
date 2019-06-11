package fr.democrazik.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import fr.democrazik.entities.Session;


	public interface SessionRepository extends JpaRepository<Session, Long> {
		
public List <Session> findSessionByNom(String nom);

@Transactional
@Modifying
void deleteSessionByNom(String nom);

	}

