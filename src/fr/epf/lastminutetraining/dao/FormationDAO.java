package fr.epf.lastminutetraining.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.lastminutetraining.domain.Formation;

public enum FormationDAO {
	
	INSTANCE;
	
	EntityManagerFactory emf;
	
	public static FormationDAO getInstance(){
		return INSTANCE;
	}
	
	private FormationDAO(){
	
		emf = Persistence.createEntityManagerFactory("formationdatabase-PU");
	}
	
	public Formation getFormation (Long id){
		EntityManager em = null;
		try {
			em = getEntityManager();
			return (Formation) em.createQuery("SELECT f FROM Formation f WHERE f.id ="+id).getSingleResult();
		} finally {
			if(em != null){
				em.close();	
			}
		}
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<Formation> getAll(){
		
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT f FROM Formation f").getResultList();
		} finally {
			if(em != null){
				em.close();	
			}
		}
	}
	
	public void createFormation(Formation formation){
		EntityManager em = null;
		try{
			em = getEntityManager();
			//open a transaction
			em.getTransaction().begin();
			//save the formation
			em.persist(formation);
			//Really save in DB
			em.getTransaction().commit();
			
		}	finally{
			if (em!=null){
				em.close();
			}
		}
	}
	
	public void updateFormation(Formation formation){
		EntityManager em = null;
		try{
			em = getEntityManager();
			//open a transaction
			
			Formation f = em.find(Formation.class, formation.getId());
			em.getTransaction().begin();
			//save the formation
			f.setName(formation.getName());
			f.setPrerequis(formation.getPrerequis());
			f.setCustomerId(formation.getCustomerId());
			f.setDescription(formation.getDescription());
			f.setDifficulty(formation.getDifficulty());
			f.setEndDate(formation.getEndDate());
			f.setPrice(formation.getPrice());
			f.setPriceLMT(formation.getPriceLMT());
			f.setStartDate(formation.getStartDate());
			//Really save in DB
			em.getTransaction().commit();
			
		}	finally{
			if (em!=null){
				em.close();
			}
		}
	}
}
