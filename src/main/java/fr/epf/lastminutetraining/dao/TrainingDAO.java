package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Training;

@Repository
public class TrainingDAO {
	
	@Value("${database.name}")
	public static String DB_NAME;
	@Value("${database.host}")
	public static String MONGO_HOST;
	@Value("${database.port}")
	public static int MONGO_PORT;
	
	public static final String DB_COLLECTION = "trainings";
	public static final int limit = 10;

	private MongoCollection collection = init();

	private TrainingDAO() {
	}

	public MongoCollection init() {
		MongoCollection collec = null;
		try {
			MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
			DB db = mongo.getDB(DB_NAME);

			Jongo jongo = new Jongo(db);
			collec = jongo.getCollection(DB_COLLECTION);

		} catch (UnknownHostException e) {
			log(e);
		}
		return collec;
	}

	public List<Training> findLastTraining() {
		List<Training> trainings = new ArrayList<Training>();
		//get 10 last trainings from database
		MongoCursor<Training> cursor = collection.find().limit(limit)
				.as(Training.class);
		List<Training> result=iterateAndReturn(trainings, cursor);
		return result;
	}

	public void saveTraining(Training training) {
		collection.save(training);
	}

	public void removeTraining(Training training) {
		collection.remove("{id: #}", training.getId());
	}
	//Method to find a training by id
	public Training findTraining(String id) {
		Training result=new Training();
		try{
			ObjectId oid= new ObjectId(id);
			result = collection.findOne(oid).as(Training.class);
		}
		catch(IllegalArgumentException e){
			result=null;
		}
		return result;
	}

	public List<Training> findAllTrainings() {
		List<Training> trainings = new ArrayList<Training>();
		MongoCursor<Training> cursor = collection.find().as(Training.class);
		List<Training> result=iterateAndReturn(trainings, cursor);
		return result;
	}
	public List<Training> iterateAndReturn(List<Training> trainings, MongoCursor<Training> cursor){
		while (cursor.hasNext()) {
			trainings.add(cursor.next());
		}
		return trainings;
	}
	public void log(Exception e){
		Logger logger = LoggerFactory.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}

}
