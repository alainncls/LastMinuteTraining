package fr.epf.lastminutetraining.domain;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Vendeur {

    @Id
    private ObjectId id;
    private String name;
    private String avatar;
    private String mail;
    private String phone;
    private String margin;
    private String sub;
    private String address;
    private String town;
    private String cp;
    private String iban;

    public Vendeur() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return phone;
    }

    public void setTelephone(String phone) {
        this.phone = phone;
    }

    public String getMarge() {
        return margin;
    }

    public void setMarge(String margin) {
        this.margin = margin;
    }

    public String getAbonnement() {
        return sub;
    }

    public void setAbonnement(String sub) {
        this.sub = sub;
    }

    public String getAdresse() {
        return address;
    }

    public void setAdresse(String address) {
        this.address = address;
    }

    public String getVille() {
        return town;
    }

    public void setVille(String town) {
        this.town = town;
    }

    public String getCodePostal() {
        return cp;
    }

    public void setCodePostal(String cp) {
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

    public static class Builder {

        private Vendeur vendeur;

        private Builder() {
            vendeur = new Vendeur();
        }

        public Builder id(ObjectId id) {
            vendeur.id = id;
            return this;
        }

        public Builder nom(String name) {
            vendeur.name = name;
            return this;
        }

        public Builder avatar(String avatar) {
            vendeur.avatar = avatar;
            return this;
        }

        public Builder mail(String mail) {
            vendeur.mail = mail;
            return this;
        }

        public Builder telephone(String phone) {
            vendeur.phone = phone;
            return this;
        }

        public Builder marge(String margin) {
            vendeur.margin = margin;
            return this;
        }

        public Builder abonnement(String sub) {
            vendeur.sub = sub;
            return this;
        }

        public Builder adresse(String address) {
            vendeur.address = address;
            return this;
        }

        public Builder ville(String town) {
            vendeur.town = town;
            return this;
        }

        public Builder codePostal(String cp) {
            vendeur.cp = cp;
            return this;
        }

        public Builder iban(String iban) {
            vendeur.iban = iban;
            return this;
        }

        public Vendeur build() {
            return vendeur;
        }
    }

}