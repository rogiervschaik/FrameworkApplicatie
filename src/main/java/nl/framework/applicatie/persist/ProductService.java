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
        //nieuwinvoer.setx(x);
        pr.save(nieuwinvoer);
        System.out.println("lukt het?" + x);

    }
    public Iterable<Product> w() {
        System.out.println("Producten in service");
        return pr.findAll();
    }
}
