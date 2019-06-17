package fr.democrazik;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
import fr.democrazik.entities.Vote;

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
//		//Création utilisateurs BD
		

voteRepo.deleteAll();  //attention à l'ordre dans lequel on supprime les tables
morceauRepo.deleteAll();
utilisateurRepo.deleteAll();
artisteRepo.deleteAll();
genreRepo.deleteAll();
sessionRepo.deleteAll();

//Création Session BD

Session s1 = new Session ("Test", "test");									
Session s2 = new Session("La Boum", "123456789");
Session s3 = new Session ("1", "un");
Session s4 = new Session ("2", "deux");
Session s5 = new Session ("3", "trois");

sessionRepo.save(s1); sessionRepo.save(s2); sessionRepo.save(s3); sessionRepo.save(s4); sessionRepo.save(s5);


		
Utilisateur u1 = new Utilisateur ("Test", "Test","test","Test@test.fr", s2);
Utilisateur u2 = new Utilisateur ("Antho", "T","antho","antho@test.fr", s2);
Utilisateur u3 = new Utilisateur ("Nico", "R","nico","nico@test.fr", s2);
Utilisateur u4 = new Utilisateur ("Marie", "B","marie","marie@test.fr", s2);
Utilisateur u5 = new Utilisateur ("Nath", "C","nath","nath@test.fr", s2 );
Utilisateur u6 = new Utilisateur ("Jo", "B","jo","jo@test.fr", s2);
Utilisateur u7 = new Utilisateur ("One", "Un","un","un@test.fr", s1);
Utilisateur u8 = new Utilisateur ("Two", "Deux","deux","deux@test.fr", s1);
Utilisateur u9 = new Utilisateur ("Three", "Trois","trois","trois@test.fr", s1);
Utilisateur u10 = new Utilisateur ("Four", "Quatre","quatre","quatre@test.fr", s1);
Utilisateur u11 = new Utilisateur ("Five", "Cinq","cinq","cinq@test.fr", s1 );
Utilisateur u12 = new Utilisateur ("Six", "Six","six","six@test.fr", s1);

utilisateurRepo.save(u1); utilisateurRepo.save(u2); utilisateurRepo.save(u3); utilisateurRepo.save(u4); utilisateurRepo.save(u5); 
utilisateurRepo.save(u6);utilisateurRepo.save(u7); utilisateurRepo.save(u8); utilisateurRepo.save(u9); utilisateurRepo.save(u10);
utilisateurRepo.save(u11); utilisateurRepo.save(u12);




		

		//Création Genre BD
Genre g1 = new Genre ("Electropop");						
Genre g2 = new Genre ("Rocksteady");
Genre g3 = new Genre ("House music");
Genre g4 = new Genre ("Dance-pop");
Genre g5 = new Genre ("Pop-rock");
Genre g6 = new Genre ("Rock and Roll");
Genre g7 = new Genre ("Soul");
Genre g8 = new Genre ("Pop");
Genre g9 = new Genre ("Jazz");
Genre g10 = new Genre ("Chanson francophone");
Genre g11 = new Genre ("Reggae");
Genre g12 = new Genre ("Grunge");
Genre g13 = new Genre ("Country");
Genre g14 = new Genre ("Blues");
Genre g15 = new Genre ("Hip-Hop");
Genre g16 = new Genre ("Progressive Rock");
Genre g17 = new Genre ("Experimental Rock");
Genre g18 = new Genre ("Glam Rock");
Genre g19 = new Genre ("Hard Rock");

genreRepo.save(g1);	genreRepo.save(g2);	genreRepo.save(g3);	genreRepo.save(g4);	genreRepo.save(g5);	genreRepo.save(g6);	
genreRepo.save(g7);	genreRepo.save(g8);	genreRepo.save(g9);	genreRepo.save(g10);genreRepo.save(g11); genreRepo.save(g12);
genreRepo.save(g13);genreRepo.save(g14);genreRepo.save(g15);genreRepo.save(g16);genreRepo.save(g17); genreRepo.save(g18);
genreRepo.save(g19);	



				


//Création Session BD
Morceau m1 = new Morceau("Toxic", s1, g1, a26);
Morceau m2 = new Morceau("I wanna go", s1, g3, a26);
Morceau m3 = new Morceau("Toxic", s2, g1, a26);
Morceau m4 = new Morceau("Beat it", s1, g8, a6);
Morceau m5 = new Morceau("Thriller", s1, g8, a6);
Morceau m6 = new Morceau("Billy Jeans", s1, g8, a6);
Morceau m7 = new Morceau("Hurt", s1, g13, a17);
Morceau m8 = new Morceau("We are the champions", s1, g5, a1);
Morceau m9 = new Morceau("I want to break free", s1, g18, a1);
Morceau m10 = new Morceau("We will rock you", s1, g2, a1);
Morceau m11 = new Morceau("Yesterday", s1, g5, a2);
Morceau m12 = new Morceau("Hello Goodbye", s1, g5, a2);
Morceau m13 = new Morceau("Let it be", s1, g8, a2);
Morceau m14 = new Morceau("Allumer le feu", s1, g6, a4);
Morceau m15 = new Morceau("Oh Marie", s1, g10, a4);
Morceau m16 = new Morceau("Allez les bleus", s1, g10, a4);
Morceau m17 = new Morceau("La vie en rose", s1, g10, a12);
Morceau m18 = new Morceau("Les copains d'abord", s1, g10, a11);
Morceau m19 = new Morceau("Ne me quitte pas", s1, g10, a13);
Morceau m20 = new Morceau("Another brick in the wall", s2, g16, a19);
Morceau m21 = new Morceau("Another brick in the wall", s1, g16, a19);
Morceau m22 = new Morceau("Space Oddity", s1, g18, a22);
Morceau m23 = new Morceau("Under Pressure", s1, g18, a22);
Morceau m24 = new Morceau("Modern Love", s1, g5, a22);
Morceau m25 = new Morceau("Can't help falling in love", s2, g6, a20);
Morceau m26 = new Morceau("Love me tender", s2, g6, a20);
Morceau m27 = new Morceau("La vie en rose", s2, g10, a12);
Morceau m28 = new Morceau("Les copains d'abord", s2, g10, a11);
Morceau m29 = new Morceau("Ne me quitte pas", s2, g10, a13);
Morceau m30 = new Morceau("Burning love", s2, g10, a20);
Morceau m31 = new Morceau("Highway to hell", s1, g19, a23);
Morceau m32 = new Morceau("Back in black", s1, g19, a23);
Morceau m33 = new Morceau("Thunderstuck", s1, g19, a23);
Morceau m34 = new Morceau("Thunderstuck", s1, g18, a22);
Morceau m35 = new Morceau("Thunderstuck", s1, g15, a15);
Morceau m36 = new Morceau("Thuderstuck", s1, g8, a2);
Morceau m37 = new Morceau("Thuderstuck", s1, g4, a7);
Morceau m38 = new Morceau("Earth song", s1, g5, a6);
Morceau m39 = new Morceau("Rock with you", s1, g4, a6);
Morceau m40 = new Morceau("Smooth Criminal", s2, g3, a6);
Morceau m41 = new Morceau("Venom", s2, g15, a28);
Morceau m42 = new Morceau("No love", s2, g15, a28);
Morceau m43 = new Morceau("The monster", s2, g15, a28);
Morceau m44 = new Morceau("Superman", s2, g15, a28);
Morceau m45 = new Morceau("River", s2, g15, a28);
Morceau m46 = new Morceau("One love", s2, g11, a15);
Morceau m47 = new Morceau("One love", s2, g8, a2);
Morceau m48 = new Morceau("No Woman No cry", s2, g8, a15);
Morceau m49 = new Morceau("Is this love", s2, g8, a15);
Morceau m50 = new Morceau("I shot the sheriff", s2, g8, a15);

morceauRepo.save(m1); morceauRepo.save(m2); morceauRepo.save(m3); morceauRepo.save(m4);morceauRepo.save(m5);morceauRepo.save(m6);
morceauRepo.save(m7);morceauRepo.save(m8);morceauRepo.save(m9);morceauRepo.save(m10);morceauRepo.save(m11);morceauRepo.save(m12);
morceauRepo.save(m13);morceauRepo.save(m14);morceauRepo.save(m15);morceauRepo.save(m16);morceauRepo.save(m17);
morceauRepo.save(m18);morceauRepo.save(m19);morceauRepo.save(m20);morceauRepo.save(m21);morceauRepo.save(m22);morceauRepo.save(m23);
morceauRepo.save(m24); morceauRepo.save(m25); morceauRepo.save(m26); morceauRepo.save(m27); morceauRepo.save(m28);morceauRepo.save(m29);
morceauRepo.save(m30); morceauRepo.save(m31); morceauRepo.save(m32); morceauRepo.save(m33); morceauRepo.save(m34); morceauRepo.save(m35);
morceauRepo.save(m36); morceauRepo.save(m37); morceauRepo.save(m38); morceauRepo.save(m39); morceauRepo.save(m40);
morceauRepo.save(m41); morceauRepo.save(m42); morceauRepo.save(m43); morceauRepo.save(m44); morceauRepo.save(m45);
morceauRepo.save(m46); morceauRepo.save(m47); morceauRepo.save(m48);morceauRepo.save(m49); morceauRepo.save(m50);


				
//Création Vote BD
Vote v1 = new Vote(u1, m26);
Vote v2 = new Vote (u2,m26);
Vote v3 = new Vote (u3, m27);
Vote v4 = new Vote (u4, m42);
Vote v5 = new Vote (u5, m26);
Vote v6 = new Vote (u6, m27);
Vote v7 = new Vote (u7, m7);
Vote v8 = new Vote (u8, m19);
Vote v9 = new Vote (u9, m19);
Vote v10 = new Vote (u10, m7);
Vote v11= new Vote (u11, m31);
Vote v12 = new Vote (u12, m38);
Vote v13 = new Vote (u12, m32);

voteRepo.save(v1); voteRepo.save(v2);voteRepo.save(v3);voteRepo.save(v4);voteRepo.save(v5);voteRepo.save(v6);voteRepo.save(v7);
voteRepo.save(v8);voteRepo.save(v9);voteRepo.save(v10);voteRepo.save(v11);voteRepo.save(v12);voteRepo.save(v13);

//findAll renvoie liste de tous les utilsateurs de la bd dans personneRepo		
utilisateurRepo.findAll().forEach(u -> {
	System.out.println(u.getNom() + " " + u.getPrenom());
});

//findAll renvoie liste de tous les artistes de la bd 
artisteRepo.findAll().forEach(a -> {
	System.out.println(a.getNom());
});

//findAll renvoie liste de tous les genres de la bd 
genreRepo.findAll().forEach(g -> {
	System.out.println(g.getLibelle());
});

//findAll renvoie liste des sessions de la bd 
sessionRepo.findAll().forEach(s -> {
	System.out.println(s.getNom());
});

//findAll renvoie liste des morceaux de la bd 
morceauRepo.findAll().forEach(m -> {
	System.out.println(m.getId() + " " + m.getTitre() + " " + m.getArtiste().getNom() + " " + m.getGenre().getLibelle() + " " + m.getSession().getNom());
});

//findAll renvoie liste des votes de la bd 
				voteRepo.findAll().forEach(v -> {
					System.out.println(v.getId() + " " + v.getMorceau().getTitre() + " " + v.getUtilisateur().getNom());
				});
	}
}
