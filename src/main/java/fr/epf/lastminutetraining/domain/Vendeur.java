package fr.epf.lastminutetraining.domain;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

public class Vendeur {

    @Id
    private ObjectId id;
    private String nom;
    private String avatar;
    private String mail;
    private String telephone;
    private String marge;
    private String abonnement;
    private String adresse;
    private String ville;
    private String codePostal;
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
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMarge() {
        return marge;
    }

    public void setMarge(String marge) {
        this.marge = marge;
    }

    public String getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(String abonnement) {
        this.abonnement = abonnement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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

        public Builder nom(String nom) {
            vendeur.nom = nom;
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

        public Builder telephone(String telephone) {
            vendeur.telephone = telephone;
            return this;
        }

        public Builder marge(String marge) {
            vendeur.marge = marge;
            return this;
        }

        public Builder abonnement(String abonnement) {
            vendeur.abonnement = abonnement;
            return this;
        }

        public Builder adresse(String adresse) {
            vendeur.adresse = adresse;
            return this;
        }

        public Builder ville(String ville) {
            vendeur.ville = ville;
            return this;
        }

        public Builder codePostal(String codePostal) {
            vendeur.codePostal = codePostal;
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