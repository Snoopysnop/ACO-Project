package fr.istic.nplouzeau.cartaylor.api.implementation.engine;

import java.util.HashSet;
import java.util.Set;

public class EG100 extends Engine {
	
	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public EG100() {
		super();
		priceS.add("1000.0");
		descriptionS.add("Gasoline, 100 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1000.0");
		setProperty("description","Gasoline, 100 kW");
	}
}
