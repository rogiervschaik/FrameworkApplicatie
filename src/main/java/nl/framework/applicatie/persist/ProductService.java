package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public void gaIetsDoen(String x){
        Product nieuwinvoer = new Product();
        pr.save(nieuwinvoer);
        System.out.println("lukt het?" + x);

    }
    public Iterable<Product> geefAlleProducten() {
        System.out.println("find all producten");
        return pr.findAll();
    }

    public void bewaarProduct(Product product) {
        pr.save(product);
    }

    public void verwijderProduct(long productid) {
        pr.deleteById(productid);
    }
}
