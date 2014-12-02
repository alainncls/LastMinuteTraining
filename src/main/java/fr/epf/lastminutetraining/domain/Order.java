package fr.epf.lastminutetraining.domain;

public class Order {
	private Training training;
	private Integer quantity;
	
	public Order(){}
	
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public Float getUnitPrice() {
		return Float.valueOf(training.getPriceLMT());
	}
	public Float getTotalPrice() {
		return getUnitPrice()*quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
