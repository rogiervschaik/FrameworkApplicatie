package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

}
