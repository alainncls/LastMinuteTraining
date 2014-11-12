package fr.epf.lastminutetraining.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import fr.epf.lastminutetraining.domain.Training;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.NestedServletException;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class TrainingDAO {

	public static final String DB_NAME = "LMT";
	public static final String DB_COLLECTION = "trainings";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;
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
			String a = result.getLevel();
			switch(a){
			case "1" : result.setTextLevel("Overview");
			break;
			case "2" : result.setTextLevel("Foundation");
			break;
			case "3" : result.setTextLevel("Detailed");
			break;				
			case "4" : result.setTextLevel("Delta Knowledge");
			break;				
			case "5" : result.setTextLevel("Consultant Academy");
			break;			
			case "6" : result.setTextLevel("Certification");
			break;			
			case "9" : result.setTextLevel("Grouped Offering");
			break;
			default : result.setTextLevel("");

			}
		}
		catch(IllegalArgumentException e){
			result=null;
		}
		String regex= "(?<=Curriculum=)(.*?)(?=&)";
		Pattern pattern = Pattern.compile(regex);
		for(String x : result.getRelatedCurricula()){
			Matcher matcher = pattern.matcher(x);
			if(matcher.find()){
				result.addAcademy(matcher.group(1));
			}
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
