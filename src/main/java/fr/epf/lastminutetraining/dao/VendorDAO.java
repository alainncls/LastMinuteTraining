package fr.epf.lastminutetraining.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.domain.Vendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class VendorDAO extends UserDAO {

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
		try {
			vendor.setPassword(encrypt(vendor.getPassword()).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log(e);
		}
		collection.save(vendor);
	}

	public void removeVendor(Vendor vendor) {
		collection.remove("{id: #}", vendor.getId());
	}
	//Method to find vendor by id
	public Vendor findVendor(ObjectId id) {
		return collection.findOne(id).as(Vendor.class);
	}

	public List<Vendor> findAllVendors() {
		List<Vendor> vendors = new ArrayList<Vendor>();
		MongoCursor<Vendor> cursor = collection.find().as(Vendor.class);
		List<Vendor> result=iterateAndReturn(vendors, cursor);
		return result;
	}

	@Override
	public Vendor connectUser(String login, String password) {
		try {
			return collection.findOne("{login:#, password:#}", login, encrypt(password)).as(Vendor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log(e);
		}
		return null;
	}
	public List<Vendor> iterateAndReturn(List<Vendor> vendors, MongoCursor<Vendor>cursor){
		while (cursor.hasNext()) {
			vendors.add(cursor.next());
		}
		return vendors;
	}

	public void log(Exception e){
		Logger logger = LoggerFactory.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}


}