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
		private UtilisateurRepository UtilisateurRepo;
		
		@RequestMapping(value="/personnes",method=RequestMethod.GET)
		public List<Utilisateur> getPersonnes(){
			return UtilisateurRepo.findAll();
			
		}
		@RequestMapping(value="/personnes/{id}",method=RequestMethod.GET)
		public Utilisateur getPersonnes(@PathVariable long id){
			return UtilisateurRepo.findOne(id);
			
		}
		
		@RequestMapping(value="/personne",method=RequestMethod.POST)
		public Utilisateur save(@RequestBody Utilisateur p){
			return UtilisateurRepo.save(p);
			
		}

		@RequestMapping(value="/personnes/{id}",method=RequestMethod.DELETE)
		public boolean supp(@PathVariable long id){
			UtilisateurRepo.delete(id);
			return true;
		}
		
		@RequestMapping(value="/personnes/{id}",method=RequestMethod.PUT)
		public Personne modif(@PathVariable long id,@RequestBody Personne p){
			p.setId(id);
			return personneRepo.save(p);
		}
	}


}
