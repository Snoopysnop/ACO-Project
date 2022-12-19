package fr.istic.nplouzeau.cartaylor.api.implementation.engine;

import java.util.HashSet;
import java.util.Set;

public class ED110 extends Engine {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public ED110() {
		super();
		priceS.add("910.0");
		descriptionS.add("Diesel, 110 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","910.0");
		setProperty("description","Diesel, 110 kW");
	}
}
