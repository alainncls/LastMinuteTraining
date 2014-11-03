package fr.epf.lastminutetraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.ClientDAO;
import fr.epf.lastminutetraining.dao.VendorDAO;
import fr.epf.lastminutetraining.domain.User;

@Service
public class UserDBService {
	
	@Autowired
	private VendorDAO vendorDAO;
	@Autowired
	private ClientDAO clientDAO;
	
	public User connect(String login, String password) {
    	User user = vendorDAO.connectUser(login, password);
    	if(user!=null){
    		return user;
    	}
    	
    	user = clientDAO.connectUser(login, password);
    	if(user!=null){
    		return user;
    	}
    	
    	return null;
    }
}
