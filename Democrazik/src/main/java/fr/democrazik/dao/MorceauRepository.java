package fr.democrazik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Morceau;

public interface MorceauRepository extends JpaRepository<Morceau, Long> {

}
