package fr.epf.lastminutetraining.domain;

import java.util.Date;
import java.util.List;

public class Transaction {
	// training, prixUnitaire, Quantité
	private List< Order > orders;
	private Client client;
	private Date date;
	private String status;//Facturatnio, paiement, validation/note

	public List< Order > getTrainings() {
		return orders;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
}
