package fr.democrazik.dao;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.democrazik.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	public List<Genre> findGenreByLibelle(String nom);
	
	@Query(value = "select genre.id from genre left join morceau on genre.id = morceau.genre_id where genre_id IS NULL", 
	       nativeQuery = true)
	public List<BigInteger> idOfUselessGenres();
}
