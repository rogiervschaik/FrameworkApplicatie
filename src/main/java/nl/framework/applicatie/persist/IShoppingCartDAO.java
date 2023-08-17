package nl.framework.applicatie.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.framework.applicatie.domein.ShoppingCart;

public interface IShoppingCartDAO extends JpaRepository<ShoppingCart, Long>{

	
}
