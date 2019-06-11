package fr.democrazik;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.democrazik.dao.UtilisateurRepository;
import fr.democrazik.entities.Utilisateur;

@SpringBootApplication

public class DemocrazikApplication implements CommandLineRunner{
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemocrazikApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		utilisateurRepo.save(new Utilisateur ("Test", "Test","test","Test@test.fr" )); 
		
		
		//findAll renvoie liste de tous les utilsateurs de la bd dans personneRepo		
		utilisateurRepo.findAll().forEach(u -> {
			System.out.println(u.getNom() + " " + u.getPrenom());
		});
	}
}
