package fr.epf.lastminutetraining.domain;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Vendor extends User {

	// Nom
	private String name;
	// Logo de l'entreprse
	private String avatar;
	// Numéro de téléphone
	private String phone;
	// Marge éffectuée par LMT
	private String margin;
	// Type de souscription à LMT
	private String sub;
	// Adresse postale
	private String address;
	// Ville
	private String town;
	// Code Postal
	private String cp;
	// Numéro IBAN
	private String iban;

	public Vendor() {

	}

	public static Builder builder() {
		return new Builder();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCP() {
		return cp;
	}

	public void setCP(String cp) {
		this.cp = cp;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", avatar=" + avatar
				+ ", mail=" + mail + ", phone=" + phone + ", margin=" + margin
				+ ", sub=" + sub + ", address=" + address + ", town=" + town
				+ ", cp=" + cp + ", iban=" + iban + "]";
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
		Vendor other = (Vendor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class Builder {

		private Vendor vendor;

		private Builder() {
			vendor = new Vendor();
		}

		public Builder id(ObjectId id) {
			vendor.id = id;
			return this;
		}

		public Builder name(String name) {
			vendor.name = name;
			return this;
		}

		public Builder avatar(String avatar) {
			vendor.avatar = avatar;
			return this;
		}

		public Builder mail(String mail) {
			vendor.mail = mail;
			return this;
		}

		public Builder phone(String phone) {
			vendor.phone = phone;
			return this;
		}

		public Builder margin(String margin) {
			vendor.margin = margin;
			return this;
		}

		public Builder sub(String sub) {
			vendor.sub = sub;
			return this;
		}

		public Builder address(String address) {
			vendor.address = address;
			return this;
		}

		public Builder town(String town) {
			vendor.town = town;
			return this;
		}

		public Builder cp(String cp) {
			vendor.cp = cp;
			return this;
		}

		public Builder iban(String iban) {
			vendor.iban = iban;
			return this;
		}

		public Vendor build() {
			return vendor;
		}
	}

	@Override
	public String getStatus() {
		return "vendor";
	}

}