package fr.epf.lastminutetraining.domain;

public class Order {
	private Training training;
	private Float unitPrice;
	private Integer quantity;
	
	public Order(){}
	
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
		this.unitPrice = Float.valueOf(training.getPriceLMT());
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public Float getTotalPrice() {
		return unitPrice*quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
