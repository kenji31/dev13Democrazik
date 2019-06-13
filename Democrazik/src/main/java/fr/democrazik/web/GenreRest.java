package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.GenreRepository;

import fr.democrazik.entities.Genre;

@RestController
@CrossOrigin("*")
public class GenreRest {

	@Autowired
	private GenreRepository genreRepo;
	
	//Afficher tout
	@RequestMapping(value="/genres",method=RequestMethod.GET)
	public List<Genre> getGenres(){
		return genreRepo.findAll();
	}
	
	//Ajouter dans BD
			@RequestMapping(value="/genre",method=RequestMethod.POST)
			public Genre save(@RequestBody Genre g){
				return genreRepo.save(g);
				
			}
	
}
