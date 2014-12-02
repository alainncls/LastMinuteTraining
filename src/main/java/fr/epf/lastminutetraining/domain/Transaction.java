package fr.epf.lastminutetraining.domain;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Transaction {
	@Id
	private ObjectId id;
	
	// training, prixUnitaire, Quantité
	private List< Order > orders;
	private Client client;
	private Date date;
	private String status;//Facturatnio, paiement, validation/note

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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
	
	public float getTotal() {
		float tot = 0;
		for (Order order : orders) {
			tot += order.getTotalPrice();
		}
		return tot;
	}
}
