package fr.epf.lastminutetraining.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epf.lastminutetraining.service.VendorDBService;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Training training;
	private Vendor vendor;
	private Integer quantity = 1;

	@Autowired
	private VendorDBService vdbs;

	public Order() {
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
		// TODO à corriger : nullPointerException après validation paiement
		//this.vendor = vdbs.findVendor(new ObjectId(training.getVendorId()));
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public float getUnitPrice() {
		return (Float.parseFloat(training.getPrice()) * 0.8F);
	}

	public float getTotalPrice() {
		return getUnitPrice() * quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return training.getName() + " - " + getUnitPrice() + " - " + quantity;
	}

	public void incrementQuantity() {
		this.quantity++;
	}

	public void decrementQuantity() {
		this.quantity--;
	}
}
