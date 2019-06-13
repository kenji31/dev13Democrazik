package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.ArtisteRepository;

import fr.democrazik.entities.Artiste;

@RestController
@CrossOrigin("*")
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
