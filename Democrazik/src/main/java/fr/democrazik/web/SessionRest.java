package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.SessionRepository;

import fr.democrazik.entities.Session;




@RestController
@CrossOrigin("*")
public class SessionRest {

	@Autowired
	private SessionRepository sessionRepo;
	
	//Afficher tout
			@RequestMapping(value="/sessions",method=RequestMethod.GET)
			public List<Session> getSessions(){
				return sessionRepo.findAll();
			}
	
			//Ajouter dans BD
			@RequestMapping(value="/session",method=RequestMethod.POST)
			public Session save(@RequestBody Session s){
				return sessionRepo.save(s);
							}
			
			
			//Connexion session 
			@RequestMapping(value="/sessionconnexion", method=RequestMethod.POST)
			public Session connexionSession(@RequestBody Session session) {
				List<Session> sessions = sessionRepo.findAll();
				Session sessionConnect = new Session();
				for (Session session2 : sessions) {
					if(session.getNom().equals(session2.getNom())&&(session.getCode().equals(session2.getCode()))){
						sessionConnect = session2;
					}
				}
				return sessionConnect;
			}
			
			//Rechercher en fonction nom
			@RequestMapping(value="/session/{nom}",method=RequestMethod.GET)
			public List<Session> findSessionbyNom(@PathVariable String nom){
				return sessionRepo.findSessionByNom(nom);
			}
			
			//Supprimer en fonction
			@RequestMapping(value="/sessions/{id}",method=RequestMethod.DELETE)
			public boolean supp(@PathVariable Long id){
				sessionRepo.delete(id);
				return true;
			}
		

}
