package nl.framework.applicatie.persist;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.framework.applicatie.domein.Product;
import nl.framework.applicatie.domein.ShoppingCart;
import nl.framework.applicatie.domein.ShoppingCartEntry;

public interface IShoppingCartEntryDAO extends JpaRepository<ShoppingCartEntry, Long>{
	
	long countByShoppingCart(ShoppingCart shoppingCart);
	
	Optional<ShoppingCartEntry> findByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);
	
}
