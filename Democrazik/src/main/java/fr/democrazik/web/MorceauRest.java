package fr.democrazik.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.MorceauRepository;

import fr.democrazik.entities.Morceau;
import fr.democrazik.entities.Session;


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
	
			//Rechercher en fonction session --> OK
			@RequestMapping(value="/morceau/session/{id}",method=RequestMethod.GET)
			public List<Morceau> getMorceaubySession(@PathVariable Long id){
				List <Morceau> morceauxById = new ArrayList<Morceau>();
				List <Morceau>  allMorceaux = morceauRepo.findAll();
				Morceau morceauFind = new Morceau();
				for (Morceau morceaux : allMorceaux) { //comparaison chaque éléments de la liste allMorceaux
					if ((morceaux.getSession().getId()==id)) {
						morceauFind=morceaux;
						morceauxById.add(morceauFind);
					}
				}
				return morceauxById;
			}
	
	
	
}
