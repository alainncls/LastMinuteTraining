package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Formation;

public enum FormationDAO {
	
	INSTANCE;
	public static final String DB_NAME = "test";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;
	
	
	public static FormationDAO getInstance(){
		return INSTANCE;
	}
	
	private FormationDAO(){
	
		
	}
	
	public void init(){
		try {
            MongoClient mongo = new MongoClient(
                    MONGO_HOST, MONGO_PORT);
            DB db = mongo.getDB(DB_NAME);
            
            Jongo jongo = new Jongo(db);
             
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
	
	public void createFormation(Formation formation){
		
	}
	
	public void updateFormation(Formation formation){
		
	}
	
	public void deleteFormation(Formation formation){
		
	}
}
