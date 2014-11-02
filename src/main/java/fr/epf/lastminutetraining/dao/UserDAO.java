package fr.epf.lastminutetraining.dao;

import fr.epf.lastminutetraining.domain.User;

public abstract class UserDAO {
	public abstract User connectUser(String login, String password);
	
	protected static final String SALT = "Ahf54zdF";
	
	protected static String encrypt(String x) throws Exception {
	    java.security.MessageDigest d = null;
	    x += SALT; //add salt
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(x.getBytes());
	    return new String(d.digest(), "UTF-8");
	  }
}
