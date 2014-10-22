package fr.epf.lastminutetraining.domain;


import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

public class Vendeur {

	@Id
	@ObjectId
	private Long id;
	
	/*
	 * ou
	 * @Id
	 * private ObjectId id;
	 * 
	 * + import org.bson.types.ObjectId;
	 */

	public Vendeur() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vendeur [id=" + id + "]";
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
		Vendeur other = (Vendeur) obj;
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

		private Vendeur vendeur;

		private Builder() {
			vendeur = new Vendeur();
		}

		public Builder id(Long id) {
			vendeur.id = id;
			return this;
		}

		public Vendeur build() {
			return vendeur;
		}
	}

}
