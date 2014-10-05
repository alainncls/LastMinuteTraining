package fr.epf.lastminutetraining.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formation")
public class Formation {

	public Formation(){

	}

	public Formation(String name, Long id,String startDate, String endDate, Long difficulty, Long customerId, int price, int priceLMT, String description, String prerequis) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = startDate;
		this.difficulty = difficulty;
		this.customerId = customerId;
		this.price = price;
		this.priceLMT = priceLMT;
		this.description = description;
		this.prerequis = prerequis;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="startDate")
	private String startDate;

	@Column(name="endDate")
	private String endDate;

	@Column(name="difficulty")
	private Long difficulty;

	@Column(name="customerId")
	private Long customerId;

	@Column(name="price")
	private int price;

	@Column(name="priceLMT")
	private int priceLMT;

	@Column(name="description")
	private String description;

	@Column(name="prerequis")
	private String prerequis;


	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Long difficulty) {
		this.difficulty = difficulty;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPriceLMT() {
		return priceLMT;
	}

	public void setPriceLMT(int priceLMT) {
		this.priceLMT = priceLMT;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "formation [id=" + id + ", name=" + name + ", startDate="
				+ startDate + ", endDate=" + endDate
				+ ", difficulty=" + difficulty +", customerId=" + customerId +", price=" + price + ", priceLMT=" + priceLMT + ", description=" + description + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static Builder builder(){
		return new Builder();
	}

	public static class Builder{

		private Formation formation;

		private Builder(){
			formation = new Formation();
		}

		public Builder id (Long id){
			formation.id = id;
			return this;
		}

		public Builder name (String name){
			formation.name = name;
			return this;
		}

		public Builder startDate (String startDate){
			formation.startDate = startDate;
			return this;
		}

		public Builder endDate (String endDate){
			formation.endDate = endDate;
			return this;
		}

		public Builder difficulty (Long difficulty){
			formation.difficulty = difficulty;
			return this;
		}

		public Builder customerId (Long customerId){
			formation.customerId = customerId;
			return this;
		}

		public Builder price (int price){
			formation.price = price;
			return this;
		}

		public Builder priceLMT (int priceLMT){
			formation.priceLMT = priceLMT;
			return this;
		}

		public Builder description (String description){
			formation.description = description;
			return this;
		}
		public Builder prerequis (String prerequis){
			formation.prerequis = prerequis;
			return this;
		}


		public Formation build(){
			return formation;
		}
	}
}
