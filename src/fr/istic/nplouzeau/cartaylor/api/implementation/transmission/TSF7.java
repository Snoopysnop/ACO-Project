package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TSF7 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TSF7() {
		super();
		priceS.add("3700.0");
		descriptionS.add("Sequential, 7 gears, 4 wheels drive");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","3700.0");
		setProperty("description","Sequential, 7 gears, 4 wheels drive");
	}
}
