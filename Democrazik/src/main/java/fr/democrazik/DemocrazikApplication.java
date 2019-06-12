package fr.democrazik;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.democrazik.dao.ArtisteRepository;
import fr.democrazik.dao.GenreRepository;
import fr.democrazik.dao.MorceauRepository;
import fr.democrazik.dao.SessionRepository;
import fr.democrazik.dao.UtilisateurRepository;
import fr.democrazik.dao.VoteRepository;
import fr.democrazik.entities.Artiste;
import fr.democrazik.entities.Genre;
import fr.democrazik.entities.Morceau;
import fr.democrazik.entities.Session;
import fr.democrazik.entities.Utilisateur;

@SpringBootApplication

public class DemocrazikApplication implements CommandLineRunner{
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private ArtisteRepository artisteRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private MorceauRepository morceauRepo;
	@Autowired
	private VoteRepository voteRepo;
	@Autowired
	private SessionRepository sessionRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemocrazikApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Création utilisateurs BD
utilisateurRepo.save(new Utilisateur ("Test", "Test","test","Test@test.fr" )); 
utilisateurRepo.save(new Utilisateur ("Antho", "T","antho","antho@test.fr" )); 
utilisateurRepo.save(new Utilisateur ("Nico", "R","nico","nico@test.fr" )); 
utilisateurRepo.save(new Utilisateur ("Marie", "B","marie","marie@test.fr" )); 
utilisateurRepo.save(new Utilisateur ("Nath", "C","nath","nath@test.fr" )); 
utilisateurRepo.save(new Utilisateur ("Jo", "B","jo","jo@test.fr" ));

//findAll renvoie liste de tous les utilsateurs de la bd dans personneRepo		
utilisateurRepo.findAll().forEach(u -> {
	System.out.println(u.getNom() + " " + u.getPrenom());
});

		//Création Artiste BD
artisteRepo.save(new Artiste ("The Queens"));
artisteRepo.save(new Artiste ("The Beatles"));
artisteRepo.save(new Artiste ("Amy Winehouse"));
artisteRepo.save(new Artiste ("Johnny Haliday"));
artisteRepo.save(new Artiste ("Elvis Presley"));
artisteRepo.save(new Artiste ("Michael Jackson"));
artisteRepo.save(new Artiste ("Ray Charles"));
artisteRepo.save(new Artiste ("Louis Armstrong"));
artisteRepo.save(new Artiste ("Édith Piaf"));
artisteRepo.save(new Artiste ("Jacques Brel"));
artisteRepo.save(new Artiste ("Georges Brassens"));
artisteRepo.save(new Artiste ("Bob Marley"));
artisteRepo.save(new Artiste ("Nirvana"));
artisteRepo.save(new Artiste ("Johnny Cash"));
artisteRepo.save(new Artiste ("Robert Johnson"));
artisteRepo.save(new Artiste ("Pink Floyd"));
artisteRepo.save(new Artiste ("Elvis Presley"));
artisteRepo.save(new Artiste ("The Velvet Underground"));
artisteRepo.save(new Artiste ("David Bowie"));
artisteRepo.save(new Artiste ("AC/DC"));
artisteRepo.save(new Artiste ("Led Zepelin"));
artisteRepo.save(new Artiste ("Édith Piaf"));
artisteRepo.save(new Artiste ("Britney Spears"));
artisteRepo.save(new Artiste ("Public Enemy"));
artisteRepo.save(new Artiste ("Eminem"));
		
				//findAll renvoie liste de tous les artistes de la bd 
				artisteRepo.findAll().forEach(a -> {
					System.out.println(a.getNom());
				});
		

		//Création Artiste BD
genreRepo.save(new Genre ("Electropop"));
genreRepo.save(new Genre ("House music"));
genreRepo.save(new Genre ("Dance-pop"));
genreRepo.save(new Genre ("Pop-rock"));
genreRepo.save(new Genre ("Rock and Roll"));
genreRepo.save(new Genre ("Soul"));
genreRepo.save(new Genre ("Pop"));
genreRepo.save(new Genre ("Jazz"));
genreRepo.save(new Genre ("Chanson francophone"));
genreRepo.save(new Genre ("Reggae"));
genreRepo.save(new Genre ("Grunge"));
genreRepo.save(new Genre ("Country"));
genreRepo.save(new Genre ("Blues"));
genreRepo.save(new Genre ("Hip-Hop"));
genreRepo.save(new Genre ("Progressive Rock"));
genreRepo.save(new Genre ("Experimental Rock"));
genreRepo.save(new Genre ("Glam Rock"));
genreRepo.save(new Genre ("Hard Rock"));

		
				//findAll renvoie liste de tous les genres de la bd 
				genreRepo.findAll().forEach(g -> {
					System.out.println(g.getLibelle());
				});

				
		//Création Session BD
sessionRepo.save (new Session("Test", "test"));					
sessionRepo.save (new Session("La Boum", "123456789"));		
sessionRepo.save (new Session ("1", "un"));
sessionRepo.save (new Session ("2", "deux"));
sessionRepo.save (new Session ("3", "trois"));

				//findAll renvoie liste des sessions de la bd 
				sessionRepo.findAll().forEach(s -> {
					System.out.println(s.getNom());
				});


//Création Session BD
//morceauRepo.save (new Morceau(titre, null, genre, artiste));					


				//findAll renvoie liste des morceaux de la bd 
				morceauRepo.findAll().forEach(m -> {
					System.out.println(m.getTitre() + " " + m.getArtiste().getNom() + " " + m.getGenre().getLibelle() + " " + m.getSession().getNom());
				});

	}
}
