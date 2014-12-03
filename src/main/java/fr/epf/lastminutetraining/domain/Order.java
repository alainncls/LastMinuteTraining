package fr.epf.lastminutetraining.domain;

import org.springframework.beans.factory.annotation.Autowired;

import fr.epf.lastminutetraining.service.VendorDBService;

public class Order {

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
		this.vendor = vdbs.findVendor(training.getVendorId());
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
