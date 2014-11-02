package fr.epf.lastminutetraining.domain;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public abstract class User {

	@Id
	protected ObjectId id;
	protected String mail;
	protected String login;
	protected String password;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public abstract String getStatus();

}
