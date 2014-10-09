package fr.epf.lastminutetraining.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.lastminutetraining.domain.Formation;

public enum FormationDAO {
	
	INSTANCE;
	
	
	public static FormationDAO getInstance(){
		return INSTANCE;
	}
	
	private FormationDAO(){
	
		
	}
	
	public void createFormation(Formation formation){
		
	}
	
	public void updateFormation(Formation formation){
		
	}
}
