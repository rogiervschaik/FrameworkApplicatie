package nl.framework.applicatie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDate;


@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private float prijs;
    private String categorie;
    private String voorraad;
    private String leverancier;
    private String productfoto;
    private String productbeschrijving;
    private String beoordeling;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(String voorraad) {
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



}
