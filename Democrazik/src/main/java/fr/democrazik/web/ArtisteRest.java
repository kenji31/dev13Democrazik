package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.democrazik.dao.ArtisteRepository;

import fr.democrazik.entities.Artiste;


public class ArtisteRest {

	@Autowired
	private ArtisteRepository artisteRepo;
	
	//Afficher tout
	@RequestMapping(value="/artistes",method=RequestMethod.GET)
	public List<Artiste> getArtistes(){
		return artisteRepo.findAll();
	}
	
	//Ajouter dans BD
			@RequestMapping(value="/artiste",method=RequestMethod.POST)
			public Artiste save(@RequestBody Artiste a){
				return artisteRepo.save(a);
				
			}
	
}
