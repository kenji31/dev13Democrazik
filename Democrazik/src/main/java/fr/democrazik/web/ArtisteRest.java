package fr.democrazik.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.democrazik.dao.ArtisteRepository;

import fr.democrazik.entities.Artiste;
import fr.democrazik.entities.Genre;
import fr.democrazik.entities.Session;

@RestController
@CrossOrigin("*")
public class ArtisteRest {

	@Autowired
	private ArtisteRepository artisteRepo;
	
	//Afficher tout
	@RequestMapping(value="/artistes",method=RequestMethod.GET)
	public List<Artiste> getArtistes(){
		return artisteRepo.findAll();
	}
	
	//Ajouter dans BD
			@RequestMapping(value="/artiste",method=RequestMethod.POST)
			public Artiste save(@RequestBody Artiste a){
				List<Artiste> stock = artisteRepo.findArtisteByNom(a.getNom());
				if (stock.isEmpty()) {
					return artisteRepo.save(a);
				}
				else {
					return stock.get(0);
				}
			}
			
			//Rechercher en fonction nom
			@RequestMapping(value="/artistes/{nom}",method=RequestMethod.GET)
			public Artiste findArtistebyNom(@PathVariable String nom){
				List<Artiste> stock = artisteRepo.findArtisteByNom(nom);
				if (stock.isEmpty()) {
					Artiste a = new Artiste();
					return a;
				}
				else {
					return stock.get(0);
				}
			}
			
			@RequestMapping(value="/useless-artists",method=RequestMethod.GET)
			public  List<BigInteger> uselessArtist(){
				return artisteRepo.idOfUselessArtists();
			}
			
	
}
