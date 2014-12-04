package fr.epf.lastminutetraining.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Transaction implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;

	// training, prixUnitaire, Quantité
	private List<Order> orders;
	private Client client;
	private Date date;
	private String status;// Facturation, paiement, validation/note

	public Transaction() {
		this.orders = new ArrayList<Order>();
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", orders=" + orders + ", client="
				+ client + ", date=" + date + ", status=" + status + "]";
	}

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

	public void decrementTraining(Training training) {
		int index=0;
		for (Order order : orders) {
			if (order.getTraining().equals(training)) {
				if (order.getQuantity() == 1) {
					orders.remove(index);
				} else {
					order.decrementQuantity();
				}
				return;
			}
			index++;
		}
	}
	
	public void incrementTraining(Training training) {
		this.addTraining(training);
	}
	
	public void addTraining(Training training) {
		for (Order order : orders) {
			if (order.getTraining().equals(training)) {
				order.incrementQuantity();
				return;
			}
		}
		Order order = OrderBuilder.order().training(training).build();
		addOrder(order);
	}
	
	public void removeTraining(Training training) {
		orders.remove(training);
	}

	public void empty() {
		orders = new ArrayList<Order>();
	}
}
