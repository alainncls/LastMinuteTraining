package fr.epf.lastminutetraining.domain;


public class Order {

	private Training training;
	private Vendor vendor;
	private Integer quantity;

	public Order() {
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public float getUnitPrice() {
		// TODO : mettre le prixLMT plutôt que le prix de base
		return Float.parseFloat(training.getPrice());
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
}
