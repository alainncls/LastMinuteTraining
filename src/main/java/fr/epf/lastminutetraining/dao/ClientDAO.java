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

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Vendor;

@Repository
public class ClientDAO extends UserDAO{
	public static final String DBNAME = "LMT";
	public static final String DBCOLLECTION = "clients";
	public static final String MONGOHOST = "localhost";
	public static final int MONGOPORT = 27017;

	private MongoCollection collection = init();

	private ClientDAO() {
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

	public void saveClient(Client client) {
		try {
			client.setPassword(encrypt(client.getPassword()).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log(e);
		}
		collection.save(client);
	}

	public void removeClient(Client client) {
		collection.remove("{id: #}", client.getId());
	}
	//Method to find client by id
	public Client findClient(ObjectId id) {
		return collection.findOne(id).as(Client.class);
	}

	public List<Client> findAllClients() {
		List<Client> clients = new ArrayList<Client>();
		MongoCursor<Client> cursor = collection.find().as(Client.class);
		List<Client> result=iterateAndReturn(clients, cursor);
		return result;
	}

	@Override
	public Client connectUser(String login, String password) {
		try {
			return collection.findOne("{login:#, password:#}", login, encrypt(password)).as(Client.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log(e);
		}
		return null;
	}
	public List<Client> iterateAndReturn(List<Client> clients, MongoCursor<Client>cursor){
		while (cursor.hasNext()) {
			clients.add(cursor.next());
		}
		return clients;
	}

	public void log(Exception e){
		Logger logger = LoggerFactory.getLogger("fr.epf.lastminutetraining.dao");
		logger.debug(e.getStackTrace().toString());
	}
}
