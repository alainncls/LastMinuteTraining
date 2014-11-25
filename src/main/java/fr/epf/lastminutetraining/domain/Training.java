package fr.epf.lastminutetraining.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Training {

	@Id
	private ObjectId id;

	private int count;
	// Lieu de formation
	private String location;
	// type de formation (Salle, web, conférence, ...) -> "références"
	private String method;
	// Nombre de places restantes
	private int available;
	// Type de certification (Officielle, groupement privé, etc...) ->
	private short certification;
	// Categorie de la training (ERP, ...) -> références
	private String category;
	// Id vendeur
	private String vendorId;
	// Vendor
	private Vendor vendor;
	// Contact
	private String contact;
	// Résumé
	private String summary;
	// Titre
	private String name;
	// Notes
	private List<String> notes;
	// Langue
	private List<String> language;
	// Solution
	private List<String> solution;
	// Date début
	private String startDate;
	// Date de fin
	private String endDate;
	// difficulté
	private String level;
	// mot difficulté
	private String textLevel;
	// Prix original
	private String price;
	// Prix réduit
	private String priceLMT;
	// Description
	private String description;
	// Introduction de training
	private String introduction;
	// Programme de formation
	private String program;
	// Objectifs
	private Map content;
	// Activités
	private String activities;
	// URL
	private String url;
	// Unité de temps
	private String unit;
	// Objet dates
	private HashMap date;
	// Objet dates
	private HashMap duration;
	// evaluation
	private Float evaluation;
	// Public
	private ArrayList<String> audience;
	// Images
	private ArrayList<String> relatedCurricula;
	private ArrayList<String> academys = new ArrayList<String>();
	// Prerequisiste
	private Map prerequisites;
	// release
	private ArrayList<String> release;
	// prime
	private static final int prime = 31;

	public Training() {

	}

	public static Builder builder() {
		return new Builder();
	}

	public HashMap getDate() {
		return date;
	}

	public void setDate(HashMap<String, String> date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public Map getContent() {
		return content;
	}

	public void setObjectives(Map objectives) {
		this.content = objectives;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
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

	public String getstartDate() {
		return startDate;
	}

	public void setstartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", count=" + count + ", location="
				+ location + ", method=" + method + ", available=" + available
				+ ", certification=" + certification + ", category=" + category
				+ ", vendorId=" + vendorId + ", vendor=" + vendor
				+ ", contact=" + contact + ", summary=" + summary + ", name="
				+ name + ", notes=" + notes + ", language=" + language
				+ ", solution=" + solution + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", level=" + level + ", textLevel="
				+ textLevel + ", price=" + price + ", priceLMT=" + priceLMT
				+ ", description=" + description + ", introduction="
				+ introduction + ", program=" + program + ", content="
				+ content + ", activities=" + activities + ", url=" + url
				+ ", unit=" + unit + ", date=" + date + ", duration="
				+ duration + ", evaluation=" + evaluation + ", audience="
				+ audience + ", relatedCurricula=" + relatedCurricula
				+ ", academys=" + academys + ", prerequisites=" + prerequisites
				+ ", release=" + release + "]";
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}
		Training other = (Training) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public List<String> getSolution() {
		return solution;
	}

	public void setSolution(List<String> solution) {
		this.solution = solution;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}

	class Duration {
		int count;
		String unit;
	}

	public HashMap<String, String> getDuration() {
		return duration;
	}

	public void setDuration(HashMap<String, String> duration) {
		this.duration = duration;
	}

	public double getEvaluation() {
		return evaluation;
	}

	public void addAcademy(String academy) {
		academys.add(academy);
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = Float.parseFloat(evaluation);
	}

	public ArrayList<String> getAudience() {
		return audience;
	}

	public void setAudience(ArrayList<String> audience) {
		this.audience = audience;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String delivery) {
		this.method = delivery;
	}

	public ArrayList<String> getRelatedCurricula() {
		return relatedCurricula;
	}

	public void setRelatedCurricula(ArrayList<String> relatedCurricula) {
		this.relatedCurricula = relatedCurricula;
	}

	public Map getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Map prerequisites) {
		this.prerequisites = prerequisites;
	}

	public ArrayList<String> getRelease() {
		return release;
	}

	public void setRelease(ArrayList<String> release) {
		this.release = release;
	}

	public String getTextLevel() {
		return textLevel;
	}

	public void setTextLevel(String textLevel) {
		this.textLevel = textLevel;
	}

	public ArrayList<String> getAcademys() {
		return academys;
	}

	public void setAcademys(ArrayList<String> academys) {
		this.academys = academys;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public static class Builder {

		private Training training;

		private Builder() {
			training = new Training();
		}

		public Builder id(ObjectId id) {
			training.id = id;
			return this;
		}

		public Builder name(String name) {
			training.name = name;
			return this;
		}

		public Builder startDate(String startDate) {
			training.startDate = startDate;
			return this;
		}

		public Builder endDate(String endDate) {
			training.endDate = endDate;
			return this;
		}

		public Builder level(String level) {
			training.level = level;
			return this;
		}

		public Builder price(String price) {
			training.price = price;
			return this;
		}

		public Builder priceLMT(String priceLMT) {
			training.priceLMT = priceLMT;
			return this;
		}

		public Builder description(String description) {
			training.description = description;
			return this;
		}

		public Builder count(int count) {
			training.count = count;
			return this;
		}

		public Builder location(String location) {
			training.location = location;
			return this;
		}

		public Builder method(String delivery) {
			training.method = delivery;
			return this;
		}

		public Builder available(int available) {
			training.available = available;
			return this;
		}

		public Builder certification(Short certification) {
			training.certification = certification;
			return this;
		}

		public Builder category(int category) {
			training.category = category;
			return this;
		}

		public Builder contact(String contact) {
			training.contact = contact;
			return this;
		}

		public Builder summary(String summary) {
			training.summary = summary;
			return this;
		}

		public Builder introduction(String introduction) {
			training.introduction = introduction;
			return this;
		}

		public Builder program(String program) {
			training.program = program;
			return this;
		}

		public Builder objectives(Map objectives) {
			training.content = objectives;
			return this;
		}

		public Builder activities(String activities) {
			training.activities = activities;
			return this;
		}

		public Builder url(String url) {
			training.url = url;
			return this;
		}

		public Training build() {
			return training;
		}
	}
}
