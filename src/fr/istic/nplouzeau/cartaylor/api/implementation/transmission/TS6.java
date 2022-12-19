package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TS6 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TS6() {
		super();
		priceS.add("2600.0");
		descriptionS.add("Sequential, 6 gears");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","2600.0");
		setProperty("description","Sequential, 6 gears");
	}
}
