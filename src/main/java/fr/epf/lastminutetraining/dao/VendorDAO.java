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
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.domain.User;
import fr.epf.lastminutetraining.domain.Vendor;

@Repository
public class VendorDAO {
	public static final String DBNAME = "LMT";
	public static final String DBCOLLECTION = "vendors";
	public static final String MONGOHOST = "localhost";
	public static final int MONGOPORT = 27017;

	private MongoCollection collection = init();

	private VendorDAO() {
	}

	public MongoCollection init() {
		MongoCollection collec = null;
		try {
			MongoClient mongo = new MongoClient(MONGOHOST, MONGOPORT);
			DB db = mongo.getDB(DBNAME);

			Jongo jongo = new Jongo(db);
			collec = jongo.getCollection(DBCOLLECTION);

		} catch (UnknownHostException e) {
			log(e);
		}
		return collec;
	}

	public void saveVendor(Vendor vendor) {
		collection.save(vendor);
	}

	public void removeVendor(Vendor vendor) {
		collection.remove("{id: #}", vendor.getId());
	}

	// Method to find vendor by id
	public Vendor findVendor(ObjectId id) {
		return collection.findOne(id).as(Vendor.class);
	}

	public List<Vendor> findAllVendors() {
		List<Vendor> vendors = new ArrayList<Vendor>();
		MongoCursor<Vendor> cursor = collection.find().as(Vendor.class);
		List<Vendor> result = iterateAndReturn(vendors, cursor);
		return result;
	}

	public Vendor connect(String login, String password) {
		return collection.findOne("{login:#, password:#}", login,
				User.encrypt(password)).as(Vendor.class);
	}

	public List<Vendor> iterateAndReturn(List<Vendor> vendors,
			MongoCursor<Vendor> cursor) {
		while (cursor.hasNext()) {
			vendors.add(cursor.next());
		}
		return vendors;
	}

	public void log(Exception e) {
		Logger logger = LoggerFactory
				.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}
}
