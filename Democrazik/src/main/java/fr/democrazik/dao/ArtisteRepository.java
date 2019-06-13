package fr.democrazik.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Artiste;
import fr.democrazik.entities.Session;



public interface ArtisteRepository extends JpaRepository<Artiste, Long>{

	public Artiste findArtisteByNom(String nom);
}
