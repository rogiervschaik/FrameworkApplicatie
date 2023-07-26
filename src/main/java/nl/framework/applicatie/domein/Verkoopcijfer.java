package nl.framework.applicatie.domein;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Verkoopcijfer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categorie;
    private int getal; //waarom geen float?

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getGetal() {
        return getal;
    }

    public void setGetal(int getal) {
        this.getal = getal;
    }
}
