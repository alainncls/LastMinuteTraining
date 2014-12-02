package fr.epf.lastminutetraining.domain;

import java.text.DecimalFormat;

public class Order {

	private Training training;
	private Integer quantity;

	public Order() {
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
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
