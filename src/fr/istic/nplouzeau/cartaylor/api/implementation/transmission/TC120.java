package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TC120 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TC120() {
		super();
		priceS.add("1200.0");
		descriptionS.add("Converter, 120 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1200.0");
		setProperty("description","Converter, 120 kW");
	}
}
