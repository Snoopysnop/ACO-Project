package fr.istic.nplouzeau.cartaylor.api.implementation.engine;

import java.util.HashSet;
import java.util.Set;

public class EG133 extends Engine {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public EG133() {
		super();
		priceS.add("1133.0");
		descriptionS.add("Gasoline, 133 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1133.0");
		setProperty("description","Gasoline, 133 kW");
	}
}
