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
import fr.democrazik.entities.Vote;


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
				for (Morceau morceaux : allMorceaux) {
					if ((morceaux.getSession().getId()==id)) {
						morceauFind=morceaux;
						morceauxById.add(morceauFind);
					}
				}
				return morceauxById;
			}
			
			@RequestMapping(value="/morceau-ordre/{id}",method=RequestMethod.GET)
			public List<Object[]> orderMorceauBySession(@PathVariable Long id){
				
				List<Object[]> liste2 = morceauRepo.orderMorceauByVote();
				List<Object[]> liste= new ArrayList<Object[]>();
				for (Object[] c : liste2) {
						if(((Vote) c[0]).getMorceau().getSession().getId()==id) {
						liste.add(c);
						}
				}
								
				return liste;
			}
			
			@RequestMapping(value="/morceau-ordre",method=RequestMethod.GET)
			public List<Object[]> orderMorceauBySession(){			
				return morceauRepo.orderMorceauByVote();
			}
	
			@RequestMapping(value="/morceau-ordre2",method=RequestMethod.GET)
			public List<Object[]> orderMorceauBySession2(){
				
				List<Object[]> liste2 = morceauRepo.orderMorceauByVote();
				List<Object[]> liste= new ArrayList<Object[]>();
				for (Object[] c : liste2) {
					liste.add(c);
				}
								
				return liste;
			}
			
			@RequestMapping(value="/morceau-ordre-vote",method=RequestMethod.GET)
			public List<Vote> orderMorceauBySession3(){
				
				List<Object[]> liste2 = morceauRepo.orderMorceauByVote();
				List<Vote> liste= new ArrayList<Vote>();
				for (Object[] c : liste2) {
					liste.add((Vote)c[0]);
				}
								
				return liste;
			}
	
}
