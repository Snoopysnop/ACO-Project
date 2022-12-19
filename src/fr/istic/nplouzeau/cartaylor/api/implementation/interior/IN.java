package fr.istic.nplouzeau.cartaylor.api.implementation.interior;

import java.util.HashSet;
import java.util.Set;

public class IN extends Interior {
	
	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();

	public IN() {
		super();
		priceS.add("200.0");
		descriptionS.add("Standard interior");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","200.0");
		setProperty("description","Standard interior");
	}
}
