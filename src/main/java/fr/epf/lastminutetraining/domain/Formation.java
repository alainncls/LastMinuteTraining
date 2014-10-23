package fr.epf.lastminutetraining.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.bson.types.ObjectId;

public class Formation {

	@Id
	private ObjectId id;

	private int duration;
	// Lieu de formation
	private String location;
	// type de formation (Salle, web, conferance, ...) -> "references"
	private Short formationType;
	// Nombre de place restante
	private int available;
	// Type de certification (Officielle, groupement privé, etc...) ->
	// references
	private short certification;
	// Categorie de la formation (ERP, ...) -> références
	private int category;
	// Id vendeur
	private ObjectId sellerId;
	// Contact
	private String contact;
	// Résumé
	private String summary;
	// Titre
	private String name;
	// Date début
	private String startDate;
	// Date de fin
	private String endDate;
	// difficulté
	private String difficulty;
	// Prix original
	private String price;
	// Prix réduc
	private String priceLMT;
	// description
	private String description;
	// Formations requises (liste ??)
	private String prerequis;
	// Introduction de formation
	private String introduction;
	// Utilisateurs cible
	private String target;
	// Programme de formation
	private String program;
	// Objectifs
	private String objectives;
	// activités
	private String activities;

	public Formation() {

	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Short getFormationType() {
		return formationType;
	}

	public void setFormationType(Short formationType) {
		this.formationType = formationType;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public short getCertification() {
		return certification;
	}

	public void setCertification(short certification) {
		this.certification = certification;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public ObjectId getSellerId() {
		return sellerId;
	}

	public void setSellerId(ObjectId sellerId) {
		this.sellerId = sellerId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriceLMT() {
		return priceLMT;
	}

	public void setPriceLMT(String priceLMT) {
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
		return "Formation [id=" + id + ", duration=" + duration + ", location="
				+ location + ", formationType=" + formationType
				+ ", available=" + available + ", certification="
				+ certification + ", category=" + category + ", sellerId="
				+ sellerId + ", contact=" + contact + ", summary=" + summary
				+ ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", difficulty=" + difficulty + ", price=" + price
				+ ", priceLMT=" + priceLMT + ", description=" + description
				+ ", prerequis=" + prerequis + ", introduction=" + introduction
				+ ", target=" + target + ", program=" + program
				+ ", objectives=" + objectives + ", activities=" + activities
				+ "]";
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Formation formation;

		private Builder() {
			formation = new Formation();
		}

		public Builder id(ObjectId id) {
			formation.id = id;
			return this;
		}

		public Builder name(String name) {
			formation.name = name;
			return this;
		}

		public Builder startDate(String startDate) {
			formation.startDate = startDate;
			return this;
		}

		public Builder endDate(String endDate) {
			formation.endDate = endDate;
			return this;
		}

		public Builder difficulty(String difficulty) {
			formation.difficulty = difficulty;
			return this;
		}

		public Builder price(String price) {
			formation.price = price;
			return this;
		}

		public Builder priceLMT(String priceLMT) {
			formation.priceLMT = priceLMT;
			return this;
		}

		public Builder description(String description) {
			formation.description = description;
			return this;
		}

		public Builder prerequis(String prerequis) {
			formation.prerequis = prerequis;
			return this;
		}

		public Builder duration(int duration) {
			formation.duration = duration;
			return this;
		}

		public Builder location(String location) {
			formation.location = location;
			return this;
		}

		public Builder formationType(Short formationType) {
			formation.formationType = formationType;
			return this;
		}

		public Builder available(int available) {
			formation.available = available;
			return this;
		}

		public Builder certification(Short certification) {
			formation.certification = certification;
			return this;
		}

		public Builder category(int category) {
			formation.category = category;
			return this;
		}

		public Builder sellerId(ObjectId sellerId) {
			formation.sellerId = sellerId;
			return this;
		}

		public Builder contact(String contact) {
			formation.contact = contact;
			return this;
		}

		public Builder summary(String summary) {
			formation.summary = summary;
			return this;
		}

		public Builder introduction(String introduction) {
			formation.introduction = introduction;
			return this;
		}

		public Builder target(String target) {
			formation.target = target;
			return this;
		}

		public Builder program(String program) {
			formation.program = program;
			return this;
		}

		public Builder objectives(String objectives) {
			formation.objectives = objectives;
			return this;
		}

		public Builder activities(String activities) {
			formation.activities = activities;
			return this;
		}

		public Formation build() {
			return formation;
		}
	}
}
