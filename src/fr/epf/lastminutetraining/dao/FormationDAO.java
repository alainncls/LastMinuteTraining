package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Formation;

public enum FormationDAO {

	INSTANCE;

	public static final String DB_NAME = "test";
	public static final String DB_COLLECTION = "formation";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

	private MongoCollection collection;

	public static FormationDAO getInstance() {
		return INSTANCE;
	}

	private FormationDAO() {

	}

	public void init() {
		try {
			MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
			DB db = mongo.getDB(DB_NAME);

			Jongo jongo = new Jongo(db);
			collection = jongo.getCollection(DB_COLLECTION);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public List<Formation> findLastFormation() {
		List<Formation> formations = new ArrayList<Formation>();
		/*MongoCursor<Formation> cursor = collection.find().limit(10)
				.as(Formation.class);
		while (cursor.hasNext()) {
			formations.add(cursor.next());
		}*/
		return formations;
	}

	public void saveFormation(Formation formation) {
		collection.save(formation);
	}

	/*
	 * public void createFormation(Formation formation) {
	 * collection.insert(formation); }
	 * 
	 * public void updateFormation(Formation formation) {
	 * collection.update("{id: #}", formation.getId()).with(formation); }
	 */

	public void removeFormation(Formation formation) {
		collection.remove("{id: #}", formation.getId());
	}

	public void finish() {
		collection.drop();
	}
}
