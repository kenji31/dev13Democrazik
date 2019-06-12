package fr.democrazik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.democrazik.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
