package nl.framework.applicatie.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.domein.Product;
import nl.framework.applicatie.domein.ShoppingCart;
import nl.framework.applicatie.domein.ShoppingCartEntry;
import nl.framework.applicatie.persist.AccountRepository;
import nl.framework.applicatie.persist.IShoppingCartDAO;
import nl.framework.applicatie.persist.IShoppingCartEntryDAO;
import nl.framework.applicatie.persist.ProductRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private AccountRepository iAccountDAO;

	@Autowired
	private ProductRepository iProductDAO;

	@Autowired
	private IShoppingCartDAO iShoppingCartDAO;
	
	@Autowired
	private IShoppingCartEntryDAO iShoppingCartEntryDAO;
	
	public boolean addProductToShoppingCart(long accountId, long productId, int amount) {
		// Eerst alle gegevens verzamelen
		
		// Vind account
		Optional<Account> optionalAccount = this.iAccountDAO.findById(accountId);
		if (optionalAccount.isEmpty()) {
			return false;
		}

		// Vind product
		Optional<Product> optionalProduct = this.iProductDAO.findById(productId);
		if (optionalProduct.isEmpty()) {
			return false;
		}

		// Alle entities uit de optionals halen
		Account account = optionalAccount.get();
		Product product = optionalProduct.get();
		ShoppingCart shoppingCart = account.getShoppingCart();

		// Stap 1 - Als winkelwagen niet bestaat dan moet die wel aangemaakt worden
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			shoppingCart.setAccount(optionalAccount.get());
			shoppingCart.setCreated(ZonedDateTime.now());

			this.iShoppingCartDAO.save(shoppingCart);
		}

		// Stap 2 - Nu shoppingcartentry aanmaken
		Optional<ShoppingCartEntry> optionalShoppingCartEntry = this.iShoppingCartEntryDAO.findByShoppingCartAndProduct(shoppingCart, product);

		ShoppingCartEntry shoppingCartEntry = optionalShoppingCartEntry.orElse(new ShoppingCartEntry());
		shoppingCartEntry.setAmount(shoppingCartEntry.getAmount() + amount);
		shoppingCartEntry.setProduct(product);
		shoppingCartEntry.setShoppingCart(shoppingCart);
		this.iShoppingCartEntryDAO.save(shoppingCartEntry);
		
		return true;
	}
	
	public long countShoppingCartEntries(long accountId) {
		// Vind account
		Optional<Account> optionalAccount = this.iAccountDAO.findById(accountId);
		if (optionalAccount.isEmpty()) {
			return 0;
		}

		ShoppingCart shoppingCart = optionalAccount.get().getShoppingCart();
		return this.iShoppingCartEntryDAO.countByShoppingCart(shoppingCart);
	}
	
	public Optional<ShoppingCartEntry> getShoppingCartEntry(long id) {
		return this.iShoppingCartEntryDAO.findById(id);
	}
	
	public void deleteShoppingCartEntry(ShoppingCartEntry shoppingCartEntry) {
		this.iShoppingCartEntryDAO.delete(shoppingCartEntry);
	}
	
}
