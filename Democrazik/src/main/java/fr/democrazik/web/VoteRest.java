package fr.democrazik.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.democrazik.dao.VoteRepository;
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
		
		
}
