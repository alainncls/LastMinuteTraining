package fr.epf.lastminutetraining.domain;


public class Vendor extends User {

	// Nom
	private String name;
	// Logo de l'entreprse
	private String avatar;
	// Marge éffectuée par LMT
	private String margin;
	// Type de souscription à LMT
	private String sub;
	// Numéro IBAN
	private String iban;
	// prime
	private static final int prime = 31;

	public Vendor() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	@Override
	public String toString() {
		return "Vendor [name=" + name + ", avatar=" + avatar + ", margin="
				+ margin + ", sub=" + sub + ", iban=" + iban + "]";
	}

	@Override
	public int hashCode() {
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
		Vendor other = (Vendor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getStatus() {
		return "vendor";
	}

}