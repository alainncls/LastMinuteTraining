package fr.epf.lastminutetraining.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import fr.epf.lastminutetraining.domain.Vendor;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VendorDAO {

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

    public void saveVendor(Vendor Vendor) {
        collection.save(Vendor);
    }

    public void removeVendor(Vendor Vendor) {
        collection.remove("{id: #}", Vendor.getId());
    }
    //Method to find vendor by id
    public Vendor findVendor(ObjectId id) {
        return collection.findOne(id).as(Vendor.class);
    }

    public List<Vendor> findAllVendors() {
        List<Vendor> vendors = new ArrayList<Vendor>();
        MongoCursor<Vendor> cursor = collection.find().limit(10)
                .as(Vendor.class);
        while (cursor.hasNext()) {
            vendors.add(cursor.next());
        }
        return vendors;
    }
}