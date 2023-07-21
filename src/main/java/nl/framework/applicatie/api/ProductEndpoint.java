package nl.framework.applicatie.api;

import nl.framework.applicatie.domein.Product;
import nl.framework.applicatie.persist.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ProductEndpoint {

    @Autowired
    ProductService ps;

    @GetMapping("Product1")
    public String MijnMethode(){
        System.out.println("Deze methode wordt aangeroepen");
        return "tekst";
    }

    @GetMapping("Product2")
    public String MijnMethode2(){
        System.out.println("Dit is een andere methode");
        return "tekst";
    }
    @GetMapping("product3/{mijnvar}")
    public String MijnMethode3(@PathVariable("mijnvar") String onzevar){
        System.out.println("Dit is de derde methode" + onzevar);
        return "tekst";
    }

}

