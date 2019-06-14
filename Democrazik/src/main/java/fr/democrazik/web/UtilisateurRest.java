package fr.democrazik.web;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.UtilisateurRepository;
import fr.democrazik.entities.Utilisateur;


	@RestController
	@CrossOrigin("*")


	public class UtilisateurRest {
		@Autowired
		private UtilisateurRepository utilisateurRepo;
		
		
		//Afficher tout
		@RequestMapping(value="/users",method=RequestMethod.GET)
		public List<Utilisateur> getPersonnes(){
			return utilisateurRepo.findAll();
		}
		
		
		//Chercher en fonction de l'ID
		@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
		public Utilisateur getPersonne(@PathVariable Long id){
			return utilisateurRepo.findOne(id);
		}
	
		
		//Ajouter dans BD
		@RequestMapping(value="/user",method=RequestMethod.POST)
		public Utilisateur save(@RequestBody Utilisateur p){
			return utilisateurRepo.save(p);
			
		}

		//Supprimer
		@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
		public boolean supp(@PathVariable Long id){
			utilisateurRepo.delete(id);
			return true;
		}
		
		//Mettre à jour
		@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
		public Utilisateur modif(@PathVariable Long id,@RequestBody Utilisateur p){
			p.setId(id);
			return utilisateurRepo.save(p);
		}
		
		//Connexion utilisateur (utiliser dépendance Spring Security pour plus de sécurité) --> OK
		@RequestMapping(value="/userconnexion", method=RequestMethod.POST)
		public Utilisateur connexionUtilisateur(@RequestBody Utilisateur utilisateur) {
			List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
			Utilisateur userConnect = new Utilisateur();
			for (Utilisateur utilisateur2 : utilisateurs) {
				if(utilisateur.getMail().equals(utilisateur2.getMail())&&(utilisateur.getMdp().equals(utilisateur2.getMdp()))){
					userConnect = utilisateur2;
				}
			}
			return userConnect;
		}
		
		//Deconnexion utilisateur --> OK
		@RequestMapping(value="/userdeconnexion/{id}", method=RequestMethod.POST)
		public Utilisateur deconnexionUtilisateur(@PathVariable Long id) {
			Utilisateur utilisateur = utilisateurRepo.findOne(id);
			utilisateur.setSession(null);
			utilisateurRepo.save(utilisateur);
			return utilisateur;
				}
			
		
		
	}



