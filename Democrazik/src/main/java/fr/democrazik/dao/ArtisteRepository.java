package fr.democrazik.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Artiste;
import fr.democrazik.entities.Session;



public interface ArtisteRepository extends JpaRepository<Artiste, Long>{

	public List<Artiste> findArtisteByNom(String nom);
	
//	@Query("selesct artiste.id from artiste left join morceau on artiste.id = morceau.artiste_id where artiste_id IS NULL", 
//	       native = true)
//	public List<Long> idOfUselessArtists();
}
