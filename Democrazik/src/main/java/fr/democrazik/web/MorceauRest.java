package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.MorceauRepository;

import fr.democrazik.entities.Morceau;


@RestController
@CrossOrigin("*")
public class MorceauRest {
	@Autowired
	private MorceauRepository morceauRepo;
	
	//Afficher tout
	@RequestMapping(value="/morceaux",method=RequestMethod.GET)
	public List<Morceau> getMorceaux(){
		return morceauRepo.findAll();
	}
	
	//Ajouter dans BD
			@RequestMapping(value="/morceau",method=RequestMethod.POST)
			public Morceau save(@RequestBody Morceau m){
				return morceauRepo.save(m);
				
			}
	
	
	
	
	
}
