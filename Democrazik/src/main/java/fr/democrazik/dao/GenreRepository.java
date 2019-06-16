package fr.democrazik.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	public List<Genre> findGenreByLibelle(String nom);
	
	@Query("selesct genre.id from genre left join morceau on genre.id = morceau.genre_id where genre_id IS NULL", 
	       native = true)
	public List<Long> idOfUselessGenres();
}
