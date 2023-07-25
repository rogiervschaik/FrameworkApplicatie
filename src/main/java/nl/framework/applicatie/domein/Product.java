package nl.framework.applicatie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private double prijs;
    private String categorie;
    private int voorraad;
    private String leverancier;
    private String productfoto;
    private String productbeschrijving;
    private String beoordeling;
    private String maat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public String getLeverancier() {
        return leverancier;
    }

    public void setLeverancier(String leverancier) {
        this.leverancier = leverancier;
    }

    public String getProductfoto() {
        return productfoto;
    }

    public void setProductfoto(String productfoto) {
        this.productfoto = productfoto;
    }

    public String getProductbeschrijving() {
        return productbeschrijving;
    }

    public void setProductbeschrijving(String productbeschrijving) {
        this.productbeschrijving = productbeschrijving;
    }

    public String getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

    public String getMaat() {
        return maat;
    }

    public void setMaat(String maat) {
        this.maat = maat;
    }


}
