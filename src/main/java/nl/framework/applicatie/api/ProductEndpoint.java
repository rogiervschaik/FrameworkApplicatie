package nl.framework.applicatie.api;

import nl.framework.applicatie.domein.Product;
import nl.framework.applicatie.persist.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class ProductEndpoint {

    @Autowired
    ProductService ps;

    @GetMapping("prijs")
    public String prijs() {
        System.out.println("Deze methode wordt aangeroepen");
        return "alle prijzen";
    }

    @GetMapping("categorie")
    public String categorie() {
        System.out.println("Dit is een andere methode");
        return "alle categories";
    }

    @GetMapping("leverancier")
    public String leverancier() {
        System.out.println("Dit is een andere methode");
        return "alle leveranciers";
    }

    @GetMapping("productfoto")
    public String productfoto() {
        System.out.println("Dit is een andere methode");
        return "alle productfotos";
    }

    @GetMapping("productbeschrijving")
    public String productbeschrijving() {
        System.out.println("Dit is een andere methode");
        return "alle productbeschrijvingen";
    }

    @GetMapping("beoordeling")
    public String beoordeling() {
        System.out.println("Dit is een andere methode");
        return "alle beoordelingen";
    }

    @GetMapping("producten/{mijnvar}/{mijnvar2}")
    public String MijnMethode3(@PathVariable("mijnvar") String onzevar) {
        System.out.println("Dit is de derde methode" + onzevar);
        return "tekst";
    }

    @GetMapping("alleproducten")
    public Iterable<Product> alleProducten() {
        System.out.println("Dit is een andere methode");
        return ps.geefAlleProducten();
    }
    @PostMapping("voegproductentoe")
    public void voegProductenToe(@RequestBody Product product){
        System.out.println(product.getLeverancier());
    }
}

