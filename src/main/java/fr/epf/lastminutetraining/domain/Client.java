package fr.epf.lastminutetraining.domain;


public class Client extends User {

	private static final long serialVersionUID = 1L;

	@Override
	public String getStatus() {
		return "client";
	}

}
