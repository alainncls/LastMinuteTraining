package fr.epf.lastminutetraining.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.VendeurDAO;
import fr.epf.lastminutetraining.domain.Formation;
import fr.epf.lastminutetraining.domain.Vendeur;

@Service
public class VendeurDBService {

	public VendeurDBService(){
	}
	
	@Autowired
	private VendeurDAO vendeurDAO;
	
	public Vendeur findVendeur(ObjectId id) {
		return vendeurDAO.findVendeur(id);
	}
	
	public List<Vendeur> findAllVendeurs() {
		return vendeurDAO.findAllVendeurs();
	}
	
	public void save(Vendeur vendeur) {
		vendeurDAO.saveVendeur(vendeur);
	}
	
	public void create(Vendeur vendeur){
		vendeurDAO.saveVendeur(vendeur);
	}
	
	public void update(Vendeur vendeur){
		vendeurDAO.saveVendeur(vendeur);
	}
	
	public void remove(Vendeur vendeur){
		vendeurDAO.removeVendeur(vendeur);
	}
}
