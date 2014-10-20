package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.marshall.jackson.oid.ObjectId;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Vendeur;

public enum VendeurDAO {
	
	INSTANCE;
	
	public static final String DB_NAME = "LMT";
	public static final String DB_COLLECTION = "vendeur";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;
	
	private MongoCollection collection = init();

	public static VendeurDAO getInstance() {
		return INSTANCE;
	}

	private VendeurDAO() {

	}

	public MongoCollection init() {
		MongoCollection collection = null;
		try {
			MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
			DB db = mongo.getDB(DB_NAME);

			Jongo jongo = new Jongo(db);
			collection = jongo.getCollection(DB_COLLECTION);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return collection;
	}


	public void saveVendeur(Vendeur Vendeur) {
		collection.save(Vendeur);
	}
	
	public void removeVendeur(Vendeur Vendeur) {
		collection.remove("{id: #}", Vendeur.getId());
	}
	
//	public List<Vendeur> findVendeur(Long id) {
//		List<Vendeur> Vendeurs = new ArrayList<Vendeur>();
//		MongoCursor<Vendeur> cursor = collection.find()
//				.as(Vendeur.class);
//		while (cursor.hasNext()) {
//			Vendeurs.add(cursor.next());
//		}
//		return Vendeurs;
//	}

	public void finish() {
		collection.drop();
	}
}
