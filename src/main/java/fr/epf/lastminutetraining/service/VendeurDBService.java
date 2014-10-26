package fr.epf.lastminutetraining.service;

import fr.epf.lastminutetraining.dao.VendeurDAO;
import fr.epf.lastminutetraining.domain.Vendeur;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendeurDBService {

    @Autowired
    private VendeurDAO vendeurDAO;

    public VendeurDBService() {
    }

    public Vendeur findVendeur(ObjectId id) {
        return vendeurDAO.findVendeur(id);
    }

    public List<Vendeur> findAllVendeurs() {
        return vendeurDAO.findAllVendeurs();
    }

    public void save(Vendeur vendeur) {
        vendeurDAO.saveVendeur(vendeur);
    }

    public void create(Vendeur vendeur) {
        vendeurDAO.saveVendeur(vendeur);
    }

    public void update(Vendeur vendeur) {
        vendeurDAO.saveVendeur(vendeur);
    }

    public void remove(Vendeur vendeur) {
        vendeurDAO.removeVendeur(vendeur);
    }
}
