package fr.epf.lastminutetraining.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.ClientDAO;
import fr.epf.lastminutetraining.domain.Client;

@Service
public class ClientDBService {
	@Autowired
	private ClientDAO clientDAO;

	public ClientDBService() {
	}

	public Client findClient(ObjectId id) {
		return clientDAO.findClient(id);
	}

	public List<Client> findAllClients() {
		return clientDAO.findAllClients();
	}

	public void save(Client client) {
		clientDAO.saveClient(client);
	}

	public void create(Client client) {
		clientDAO.saveClient(client);
	}

	public void update(Client client) {
		clientDAO.saveClient(client);
	}

	public void remove(Client client) {
		clientDAO.removeClient(client);
	}

	public Client connect(String login, String password) {
		return clientDAO.connect(login, password);
	}
}
