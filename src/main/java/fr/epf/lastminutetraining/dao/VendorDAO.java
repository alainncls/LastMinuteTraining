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

import fr.epf.lastminutetraining.domain.User;
import fr.epf.lastminutetraining.domain.Vendor;

@Repository
public class VendorDAO extends UserDAO {

    public static final String DB_NAME = "LMT";
    public static final String DB_COLLECTION = "vendors";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    private MongoCollection collection = init();

    private VendorDAO() {
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

    public void saveVendor(Vendor vendor) {
    	try {
			vendor.setPassword(encrypt(vendor.getPassword()).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
        while (cursor.hasNext()) {
            vendors.add(cursor.next());
        }
        return vendors;
    }

	@Override
	public Vendor connectUser(String login, String password) {
		try {
			return collection.findOne("{login:#, password:#}", login, encrypt(password)).as(Vendor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}