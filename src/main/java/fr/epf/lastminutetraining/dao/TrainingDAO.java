package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.domain.Vendor;

@Repository
public class TrainingDAO {

	public static final String DB_NAME = "LMT";
	public static final String DB_COLLECTION_TRAININGS = "trainings";
	public static final String DB_COLLECTION_VENDORS = "vendors";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;
	public static final int limit = 10;

	private MongoCollection trainingsCollection = init(DB_NAME,
			DB_COLLECTION_TRAININGS, MONGO_HOST, MONGO_PORT, limit);

	private MongoCollection vendorCollection = init(DB_NAME,
			DB_COLLECTION_VENDORS, MONGO_HOST, MONGO_PORT, limit);

	private TrainingDAO() {
	}

	public MongoCollection init(String dbName, String dbCollection,
			String mongoHost, int mongoPort, int limit) {
		MongoCollection collec = null;
		try {
			MongoClient mongo = new MongoClient(mongoHost, mongoPort);
			DB db = mongo.getDB(dbName);

			Jongo jongo = new Jongo(db);
			collec = jongo.getCollection(dbCollection);

		} catch (UnknownHostException e) {
			log(e);
		}
		return collec;
	}

	public List<Training> findLastTraining() {
		// get 10 last trainings from database
		MongoCursor<Training> cursor = trainingsCollection.find().limit(limit)
				.as(Training.class);
		return iterateAndReturn(cursor);
	}
	
	public Training findOneTraining() {
		Training training = new Training();

		MongoCursor<Training> cursor = trainingsCollection.find().limit(limit)
				.as(Training.class);
		training = cursor.next();
		return training;
	}

	public void saveTraining(Training training) {
		trainingsCollection.save(training);
	}

	public void removeTraining(ObjectId id) {
        trainingsCollection.remove(id);
	}

	// Method to find a training by id
	public Training findTraining(String id) {
		Training result = new Training();
		try {
			ObjectId oid = new ObjectId(id);
			result = trainingsCollection.findOne(oid).as(Training.class);
			String a = result.getLevel();
			switch (a) {
			case "1":
				result.setTextLevel("Overview");
				break;
			case "2":
				result.setTextLevel("Foundation");
				break;
			case "3":
				result.setTextLevel("Detailed");
				break;
			case "4":
				result.setTextLevel("Delta Knowledge");
				break;
			case "5":
				result.setTextLevel("Consultant Academy");
				break;
			case "6":
				result.setTextLevel("Certification");
				break;
			case "9":
				result.setTextLevel("Grouped Offering");
				break;
			default:
				result.setTextLevel("");

			}
		} catch (IllegalArgumentException e) {
			result = null;
		}
//		String regex = "(?<=Curriculum=)(.*?)(?=&)";
//		Pattern pattern = Pattern.compile(regex);
//		for (String x : result.getRelatedCurricula()) {
//			Matcher matcher = pattern.matcher(x);
//			if (matcher.find()) {
//				result.addAcademy(matcher.group(1));
//			}
//		}
		ObjectId oid = new ObjectId(result.getVendorId());
		Vendor vendor = new Vendor();
		vendor = vendorCollection.findOne(oid).as(Vendor.class);
		result.setVendor(vendor);
		return result;
	}

	public List<Training> searchTraining(String name) {
		MongoCursor<Training> cursor = trainingsCollection.find("{name: #}",
				Pattern.compile(".*" + name + ".*")).as(Training.class);
		return iterateAndReturn(cursor);
	}

	public List<Training> searchTraining(Training training) {
		MongoCursor<Training> cursor = trainingsCollection.find("{ $and: [{name:#}, {startDate:#}, {endDate:#}]}",
				Pattern.compile(".*" + training.getName() + ".*"), training.getStartDate(), training.getEndDate()).as(
				Training.class);
		return iterateAndReturn(cursor);
	}

	public List<Training> findAllTrainings() {
		MongoCursor<Training> cursor = trainingsCollection.find().as(
				Training.class);
		return iterateAndReturn(cursor);
	}

	public List<Training> findAllTrainings(ObjectId id) {
		String query = "{vendorId: \"" + id + "\"}";
		//System.out.println(query);
		MongoCursor<Training> cursor = trainingsCollection.find(query).as(
				Training.class);
		return iterateAndReturn(cursor);
	}

	public List<Training> iterateAndReturn(MongoCursor<Training> cursor) {
		List<Training> trainings = new ArrayList<Training>();
		while (cursor.hasNext()) {
			trainings.add(cursor.next());
		}
		return trainings;
	}

	public void log(Exception e) {
		Logger logger = LoggerFactory
				.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}

}
