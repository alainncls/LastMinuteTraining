package fr.epf.lastminutetraining.service;

import java.util.List;

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

	public void create(Formation formation){
		formationDAO.createFormation(formation);
	}
	
	public void update(Formation formation){
		formationDAO.updateFormation(formation);
	}

	private FormationDAO formationDAO = FormationDAO.getInstance();

	public Formation get(Long id){
		return formationDAO.getFormation(id); 
	}

	public List<Formation> getAll(){
		return formationDAO.getAll();
	}

}
