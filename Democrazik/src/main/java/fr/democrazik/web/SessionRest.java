package fr.democrazik.web;

import java.util.List;

import javax.persistence.PreRemove;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.ArtisteRepository;
import fr.democrazik.dao.GenreRepository;
import fr.democrazik.dao.MorceauRepository;
import fr.democrazik.dao.SessionRepository;
import fr.democrazik.dao.UtilisateurRepository;
import fr.democrazik.dao.VoteRepository;
import fr.democrazik.entities.Morceau;
import fr.democrazik.entities.Session;
import fr.democrazik.entities.Utilisateur;
import fr.democrazik.entities.Vote;

@RestController
@CrossOrigin("*")
public class SessionRest {

	@Autowired
	private SessionRepository sessionRepo;
	@Autowired
	private VoteRepository voteRepo;
	@Autowired
	private MorceauRepository morceauRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private ArtisteRepository artisteRepo;
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	// Afficher tout
	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public List<Session> getSessions() {
		return sessionRepo.findAll();
	}

	// Ajouter dans BD
	@RequestMapping(value = "/session", method = RequestMethod.POST)
	public Session save(@RequestBody Session s) {
		return sessionRepo.save(s);
	}

	// Connexion session
	@RequestMapping(value = "/sessionconnexion/{id}", method = RequestMethod.POST)
	public Session connexionSession(@PathVariable Long id, @RequestBody Session session) {
		List<Session> sessions = sessionRepo.findAll();
		Session sessionConnect = new Session();
		for (Session session2 : sessions) {
			if (session.getNom().equals(session2.getNom()) && (session.getCode().equals(session2.getCode()))) {
				sessionConnect = session2;
				Utilisateur utilisateur = utilisateurRepo.findOne(id);
				utilisateur.setSession(sessionConnect);
				utilisateurRepo.save(utilisateur);
			}
		}
		return sessionConnect;
	}

	// Rechercher en fonction nom
	@RequestMapping(value = "/session/{nom}", method = RequestMethod.GET)
	public List<Session> findSessionbyNom(@PathVariable String nom) {
		return sessionRepo.findSessionByNom(nom);
	}

	// Supprimer en fonction ID --> OK

	@RequestMapping(value = "/sessions/{id}", method = RequestMethod.DELETE)
	public boolean supp(@PathVariable Long id) {
		
		
		List<Vote> votes = voteRepo.findAll();

		for (Vote voteListe : votes) {
			
			if (voteListe.getMorceau().getSession().getId() == id) { //suppression d'abord des votes de la session (sinon pb dépendance) Possibilité p-ê d'utiliser suppression en cascade mais n'a pas marché
				voteRepo.delete(voteListe.getId());
			}
		
		}
		List<Morceau> morceaux = morceauRepo.findAll(); //suppression des morceaux de la session

		for (Morceau morceauListe : morceaux) {
			if (morceauListe.getSession().getId() == id) {
				morceauRepo.delete(morceauListe.getId());
			}
		}
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll(); //set Session des Utilisateurs à 'null' pour ne pas les supprimer (sinon besoin de se réinscrire pour se connecter) 
		for (Utilisateur utilisateurListe : utilisateurs) {
			if (utilisateurListe.getSession()!=null) {
				if (utilisateurListe.getSession().getId() == id) {
					utilisateurListe.setSession(null);
				}
			}
		}
		
		List<Long> idUselessArtists = artistRepo.idOfUselessArtists();
		for (Long id : idUselessArtists) {
			artisteRepo.delete(id);
		}
		List<Long> idUselessGenres = genreRepo.idOfUselessGenres();
		for (Long id : idUselessGenres) {
			genreRepo.delete(id);
		}
		
		sessionRepo.delete(id);
		return true;

	}
	
	@RequestMapping(value = "/session/{id}", method = RequestMethod.DELETE)
	public boolean supp(@PathVariable Long id) {
		sessionRepo.delete(id);
		return true;
	}
}

