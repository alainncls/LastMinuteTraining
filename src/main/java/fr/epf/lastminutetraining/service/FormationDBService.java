package fr.epf.lastminutetraining.service;

import fr.epf.lastminutetraining.dao.FormationDAO;
import fr.epf.lastminutetraining.domain.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationDBService {

    @Autowired
    private FormationDAO formationDAO;

    public FormationDBService() {
    }

    public List<Formation> findLastFormations() {
        return formationDAO.findLastFormations();
    }

    public List<Formation> findAllFormations() {
        return formationDAO.findAllFormations();
    }

    public List<Formation> findFormation(String name) {
        return formationDAO.findFormation(name);
    }

    public void save(Formation formation) {
        formationDAO.saveFormation(formation);
    }

    public void create(Formation formation) {
        formationDAO.saveFormation(formation);
    }

    public void update(Formation formation) {
        formationDAO.saveFormation(formation);
    }

    public void remove(Formation formation) {
        formationDAO.removeFormation(formation);
    }
}
