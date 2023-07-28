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
    @GetMapping("alleproducten")
    public Iterable<Product> alleProducten() {
        System.out.println("Dit is een andere methode");
        return ps.geefAlleProducten();
    }
    @PostMapping("voegproductentoe")
    public void voegProductenToe(@RequestBody Product product){
        ps.bewaarProduct(product);
    }

  @PutMapping("bewerkproducten/{productid}")
    public void bewerkProducten(@PathVariable("productid") int productid, @RequestBody Product updatedProduct) {

        Product existingProduct = ps.updateProduct(productid);

        if (existingProduct != null) {
            existingProduct.setNaam(updatedProduct.getNaam());
            existingProduct.setPrijs(updatedProduct.getPrijs());
            existingProduct.setCategorie(updatedProduct.getCategorie());
            existingProduct.setLeverancier(updatedProduct.getLeverancier());
            existingProduct.setProductfoto(updatedProduct.getProductfoto());
            existingProduct.setProductbeschrijving(updatedProduct.getProductbeschrijving());
            existingProduct.setBeoordeling(updatedProduct.getBeoordeling());
            existingProduct.setVoorraad(updatedProduct.getVoorraad());
            existingProduct.setMaat(updatedProduct.getMaat());

            ps.bewaarProduct(existingProduct);
        } else {

            System.out.println("Product with ID " + productid + " not found.");
        }
    }


    @DeleteMapping("verwijderproducten/{productid}")
    public void verwijderProducten(@PathVariable("productid") int productid){
    ps.verwijderProduct(productid);
    }
}

