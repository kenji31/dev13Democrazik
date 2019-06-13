package fr.democrazik.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Artiste;



public interface ArtisteRepository extends JpaRepository<Artiste, Long>{

}
