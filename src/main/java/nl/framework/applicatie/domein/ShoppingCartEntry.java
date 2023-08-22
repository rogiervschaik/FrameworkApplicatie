package nl.framework.applicatie.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCartEntry {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@JsonIgnore
	@ManyToOne(optional = false)
	private ShoppingCart shoppingCart;
	
	@ManyToOne(optional = false)
	private Product product;
	
	@Column(nullable = false)
	private int amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
