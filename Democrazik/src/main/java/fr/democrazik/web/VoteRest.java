package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.democrazik.dao.VoteRepository;
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
		
//		//Suppression vote (fonction de Utilisateur et morceau)
//		@RequestMapping(value="/deleteVote", method=RequestMethod.POST)
//		public boolean deleteVote(@RequestBody Vote vote) {
//			List<Vote> votes = voteRepo.findAll();
//			Vote voteDelete = new Vote();
//			for (Vote vote2 : votes) {
//				if(vote.getUtilisateur().getId()==vote2.getUtilisateur().getId() &&(vote.getMorceau().getId()==vote2.getMorceau().getId())){
//					voteDelete = vote2;
//					voteRepo.delete(vote2);
//				}
//			}
//			return true;
//		}
		
		
}
