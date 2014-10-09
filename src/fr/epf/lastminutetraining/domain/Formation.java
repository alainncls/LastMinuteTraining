package fr.epf.lastminutetraining.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formation")
public class Formation {

	

	@Id
	@GeneratedValue
	private Long id;
	
	//durée
	@Column(name="duration")
	private int duration;

	//Lieu de formation
	@Column(name="location")
	private String location;

	// type de formation (Salle, web, conferance, ...) -> "references"
	@Column(name="formationType")
	private Short formationType;

	//Nombre de place restante
	@Column(name="available")
	private int available;

	//Type de certification (Officielle, groupement privé, etc...) -> references
	@Column(name="certification")
	private short certification;

	//Categorie de la formation (ERP, ...) -> références
	@Column(name="category")
	private int category;

	//Id vendeur
	@Column(name="sellerId")
	private int sellerId;

	//Contact
	@Column(name="contact")
	private String contact;
	
	//Résumé
	@Column(name="summary")
	private String summary;

	//Titre
	@Column(name="name")
	private String name;

	//Date début
	@Column(name="startDate")
	private String startDate;

	//Date de fin
	@Column(name="endDate")
	private String endDate;

	//difficulté
	@Column(name="difficulty")
	private int difficulty;

	//Prix original
	@Column(name="price")
	private int price;

	//Prix réduc
	@Column(name="priceLMT")
	private int priceLMT;

	
	@Column(name="description")
	private String description;

	@Column(name="prerequis")
	private String prerequis;

	
	//Description détaillée
	
	
	//Introduction de formation
	@Column(name="introduction")
	private String introduction;

	//Utilisateurs cible
	@Column(name="target")
	private String target;

	//Programme de formation
	@Column(name="program")
	private String program;

	public Formation(Long id, int duration, String location,
			Short formationType, int available, short certification,
			int category, int sellerId, String contact, String summary,
			String name, String startDate, String endDate, int difficulty,
			int price, int priceLMT, String description, String prerequis,
			String introduction, String target, String program,
			String objectives, String activities) {
		super();
		this.id = id;
		this.duration = duration;
		this.location = location;
		this.formationType = formationType;
		this.available = available;
		this.certification = certification;
		this.category = category;
		this.sellerId = sellerId;
		this.contact = contact;
		this.summary = summary;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.difficulty = difficulty;
		this.price = price;
		this.priceLMT = priceLMT;
		this.description = description;
		this.prerequis = prerequis;
		this.introduction = introduction;
		this.target = target;
		this.program = program;
		this.objectives = objectives;
		this.activities = activities;
	}

	//Objectifs
	@Column(name="objectives")
	private String objectives;

	//activités
	@Column(name="activities")
	private String activities;

	
	public Formation(){

	}

	public Formation(int sellerId, String activities, String objectives, String program, String target,String introduction,Short certification,int category,int available,Short formationType,String location,int duration, String summary, String name, Long id,String startDate, String endDate, Short difficulty, int price, int priceLMT, String description, String prerequis) {
		super();
		this.id = id;
		this.certification=certification;
		this.formationType = formationType;
		this.category=category;
		this.location = location ;
		this.duration = duration;
		this.available=available;
		this.summary = summary;
		this.name = name;
		this.startDate = startDate;
		this.endDate = startDate;
		this.difficulty = difficulty;
		this.price = price;
		this.priceLMT = priceLMT;
		this.description = description;
		this.prerequis = prerequis;
		this.introduction = introduction;
		this.target=target;
		this.program=program;
		this.objectives=objectives;
		this.activities=activities;
		this.sellerId=sellerId;
		
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

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
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

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
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
}
