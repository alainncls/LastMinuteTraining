package fr.epf.lastminutetraining.service;

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

	public void create(FormationDAO formation){
		formationDAO.createFormation(formation);
	}
	
	public void update(FormationDAO formation){
		formationDAO.updateFormation(formation);
	}

	private FormationDAO formationDAO = FOrmationDAO.getInstance();

	public FormationDAO get(Long id){
		return formationDAO.getFomation(id); 
	}

	public List<FormationDAO> getAll(){
		return formationDAO.getAll();
	}

}
