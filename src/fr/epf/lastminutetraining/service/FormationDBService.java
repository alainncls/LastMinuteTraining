package fr.epf.lastminutetraining.service;

import java.util.ArrayList;
import java.util.List;

import org.jongo.MongoCursor;

import fr.epf.lastminutetraining.dao.FormationDAO;
import fr.epf.lastminutetraining.domain.Formation;

public class FormationDBService {


	private static FormationDBService instance = null ;

	//static to be call without an instance
	public static FormationDBService getInstance(){

		if(instance == null){
			//If there is no instance yet just created it.
			instance = new FormationDBService();
		} 
		return instance;
	}

	private FormationDBService(){

	}
	
	private FormationDAO formationDAO = FormationDAO.getInstance();
	
	public List<Formation> findLastFormation() {
		return formationDAO.findLastFormation();
	}
	
	public void save(Formation formation) {
		formationDAO.saveFormation(formation);
	}
	
	/*public void create(Formation formation){
		formationDAO.createFormation(formation);
	}
	
	public void update(Formation formation){
		formationDAO.updateFormation(formation);
	}*/
	
	public void remove(Formation formation){
		formationDAO.removeFormation(formation);
	}

}
