package fr.democrazik.web;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.entities.Utilisateur;
import fr.democrazikDao.UtilisateurRepository;


public class UtilisateursRest {
	
	
	


	@RestController
	@CrossOrigin("*")


	public class PersonneRest {
		@Autowired
		private UtilisateurRepository utilisateurRepos;
		
		@RequestMapping(value="/users",method=RequestMethod.GET)
		public List<Utilisateur> getPersonnes(){
			return utilisateurRepos.findAll();
		}
		
		@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
		public Utilisateur getPersonne(@PathVariable Long id){
			return utilisateurRepos.findOne(id);
		}
		
		@RequestMapping(value="/user",method=RequestMethod.POST)
		public Utilisateur save(@RequestBody Utilisateur p){
			return utilisateurRepos.save(p);
			
		}

		@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
		public boolean supp(@PathVariable Long id){
			utilisateurRepos.delete(id);
			return true;
		}
		
		@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
		public Utilisateur modif(@PathVariable Long id,@RequestBody Utilisateur p){
			p.setId(id);
			return utilisateurRepos.save(p);
		}
	}


}
