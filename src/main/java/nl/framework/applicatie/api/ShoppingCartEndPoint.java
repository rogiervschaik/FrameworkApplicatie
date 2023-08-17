package nl.framework.applicatie.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.framework.applicatie.dto.AddProductDto;

@RestController
public class ShoppingCartEndPoint {

	// Endpoint om product toe te voegen aan winkelwagen
	@PostMapping("/api/shoppingcart/addproduct")
	public void addToShoppingCart(@RequestBody AddProductDto dto ) {
		dto.getAmount();
		dto.getProductId();
		dto.getAccountId();

		// Eerst een IShoppingcartDAO + IShoppingcartEntryDAO
		// Daarna ga je de service maken (ShoppingcartService)

		// 1. Heeft de account al een shoppingcart
		//		Zo niet maak een shopping cart aan

		// 2. Maak een shopping cart entry aan en sla die op
		//		Koppel 

	}
}
