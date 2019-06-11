package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.democrazik.dao.MorceauRepository;

import fr.democrazik.entities.Morceau;


public class MorceauRest {
	@Autowired
	private MorceauRepository morceauRepo;
	
	//Afficher tout
	@RequestMapping(value="/morceaux",method=RequestMethod.GET)
	public List<Morceau> getMorceaux(){
		return morceauRepo.findAll();
	}
	
	
	
	
	
}
