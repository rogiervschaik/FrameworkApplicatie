package nl.framework.applicatie.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.domein.ShoppingCartEntry;
import nl.framework.applicatie.dto.AddProductDto;
import nl.framework.applicatie.persist.AccountService;
import nl.framework.applicatie.service.ShoppingCartService;

@RestController
public class ShoppingCartEndPoint {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	// Endpoint om product toe te voegen aan winkelwagen
	@PostMapping("/api/shoppingcart/addproduct")
	public boolean addToShoppingCart(@RequestBody AddProductDto dto ) {
		// In praktijk ga je als eerst checken of iemand is ingelogd of niet

		// Daarna validatie. In ons geval hebben we alleen int's dus die 
		// zijn altijd ingevuld (Niet null). 

		// Vertel de service om een shoppingcart entry aan te maken
		// Een service doet het meeste reken werk. 
		boolean gelukt = shoppingCartService.addProductToShoppingCart(dto.getAccountId(), dto.getProductId(), dto.getAmount());

		return gelukt;
	}

	@GetMapping("/api/shoppingcart/{accountId}/entry/count")
	public long countShoppingCartEntry(@PathVariable long accountId) {
		return this.shoppingCartService.countShoppingCartEntries(accountId);
	}

	@GetMapping("/api/shoppingcart/{accountId}/entries")
	public List<ShoppingCartEntry> getShoppingCartEntries(@PathVariable long accountId) {
		Account account = this.accountService.getAccountById(accountId);

		if (account != null) {
			return account.getShoppingCart().getEntries();
		}

		return new ArrayList<>();
	}

	@DeleteMapping("/api/shoppingcart/entry/{entryId}")
	public boolean deleteShoppingCartEntry(@PathVariable long entryId) {
		Optional<ShoppingCartEntry> optionalShoppingCartEntry = this.shoppingCartService.getShoppingCartEntry(entryId);
		if (optionalShoppingCartEntry.isPresent()) {
			ShoppingCartEntry shoppingCartEntry = optionalShoppingCartEntry.get();

			// In praktijk willen we hier ook nog permissies checken

			if (shoppingCartEntry != null) {
				this.shoppingCartService.deleteShoppingCartEntry(shoppingCartEntry);

				return true;
			}
		}
		
		return false;
	}
	
}
