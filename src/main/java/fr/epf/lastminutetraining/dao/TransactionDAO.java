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

import fr.epf.lastminutetraining.domain.Transaction;

@Repository
public class TransactionDAO {
	public static final String DBNAME = "LMT";
	public static final String DBCOLLECTION = "transactions";
	public static final String MONGOHOST = "localhost";
	public static final int MONGOPORT = 27017;
	
	private MongoCollection collection = init();

	private TransactionDAO() {
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

	public void saveTransaction(Transaction transaction) {
		collection.save(transaction);
	}

	public void removeTransaction(Transaction transaction) {
		collection.remove("{id: #}", transaction.getId());
	}

	// Method to find transaction by id
	public Transaction findTransaction(String id) {
		ObjectId oid = new ObjectId(id);
		return collection.findOne(oid).as(Transaction.class);
	}

	public List<Transaction> findAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		MongoCursor<Transaction> cursor = collection.find().as(Transaction.class);
		List<Transaction> result = iterateAndReturn(transactions, cursor);
		return result;
	}

	public List<Transaction> iterateAndReturn(List<Transaction> transactions,
			MongoCursor<Transaction> cursor) {
		while (cursor.hasNext()) {
			transactions.add(cursor.next());
		}
		return transactions;
	}

	public void log(Exception e) {
		Logger logger = LoggerFactory
				.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}
}
