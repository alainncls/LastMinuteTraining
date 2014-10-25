package fr.epf.lastminutetraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.FormationDAO;
import fr.epf.lastminutetraining.domain.Formation;

@Service
public class FormationDBService {

	public FormationDBService(){
	}
	
	@Autowired
	private FormationDAO formationDAO;
	
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
	
	public void create(Formation formation){
		formationDAO.saveFormation(formation);
	}
	
	public void update(Formation formation){
		formationDAO.saveFormation(formation);
	}
	
	public void remove(Formation formation){
		formationDAO.removeFormation(formation);
	}
}
