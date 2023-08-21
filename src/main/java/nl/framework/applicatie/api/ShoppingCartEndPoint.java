package nl.framework.applicatie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.framework.applicatie.dto.AddProductDto;
import nl.framework.applicatie.service.ShoppingCartService;

@RestController
public class ShoppingCartEndPoint {

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

}
