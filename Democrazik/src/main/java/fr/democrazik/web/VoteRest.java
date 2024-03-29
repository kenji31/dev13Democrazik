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


import fr.democrazik.dao.VoteRepository;
import fr.democrazik.entities.Morceau;
import fr.democrazik.entities.Utilisateur;
import fr.democrazik.entities.Vote;

@RestController
@CrossOrigin("*")

public class VoteRest {
	@Autowired
	private VoteRepository voteRepo;
	
	//Afficher tout
		@RequestMapping(value="/votes",method=RequestMethod.GET)
		public List<Vote> getVotes(){
			return voteRepo.findAll();
		}
		
		//Ajouter dans BD
		@RequestMapping(value="/vote",method=RequestMethod.POST)
		public Vote save(@RequestBody Vote v){
			return voteRepo.save(v);
		}
		
		//Supprimer (en fonction id)
		@RequestMapping(value="/votes/{id}",method=RequestMethod.DELETE)
		public boolean supp(@PathVariable Long id){
			voteRepo.delete(id);
			return true;
		}
		
		//Suppression vote (fonction de Utilisateur et morceau) --> pas testé
		@RequestMapping(value="/deleteVote/{id1}/{id2}", method=RequestMethod.DELETE)
		public boolean deleteVote(@PathVariable Long id1, Long id2) {
			Vote voteSupp= new Vote();
			List<Vote> votes = voteRepo.findAll();
			for (Vote vote : votes) {
				if(vote.getUtilisateur().getId()==id1 && vote.getMorceau().getId()==id2){
					voteSupp=vote;
					voteRepo.delete(voteSupp.getId());
					return true;
				} else {
					
					return false;
				}
			}
			return true;
		}
		
		
		//Rechercher en fonction Utilisateur --> OK
		@RequestMapping(value="/vote/utilisateur/{id}",method=RequestMethod.GET)
		public List<Vote> getVotebyUser(@PathVariable Long id){
			List <Vote> voteByUtilisateur = new ArrayList<Vote>();
			List <Vote>  allVotes = voteRepo.findAll();
			Vote voteFind = new Vote();
			for (Vote votes : allVotes) {
				if ((votes.getUtilisateur().getId()==id)) {
					voteFind=votes;
					voteByUtilisateur.add(voteFind);
				}
			}
			return voteByUtilisateur;
		}
		
		// faire une methode qui supprime les votes d'un morceau qui vient d'etre joué
		@RequestMapping(value="/vote/morceau/{id}",method=RequestMethod.GET)
		public boolean deleteVotesOfMorceau(@PathVariable Long id){
			List<Vote> votes = voteRepo.getVotesOfMorceau(id);
			for (Vote vote : votes) {
				voteRepo.delete(vote.getId());
			}
			return true;
		}
}
