package fr.democrazik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.democrazikDao.UtilisateurRepository;

@SpringBootApplication
public class DemocrazikApplication implements CommandLineRunner{
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemocrazikApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
