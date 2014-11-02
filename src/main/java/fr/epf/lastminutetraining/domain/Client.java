package fr.epf.lastminutetraining.domain;

public class Client extends User {

	@Override
	public String getStatus() {
		return "client";
	}

}
