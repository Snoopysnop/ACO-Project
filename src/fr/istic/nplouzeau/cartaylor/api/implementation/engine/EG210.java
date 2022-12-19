package fr.istic.nplouzeau.cartaylor.api.implementation.engine;

import java.util.HashSet;
import java.util.Set;

public class EG210 extends Engine {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public EG210() {
		super();
		priceS.add("1210.0");
		descriptionS.add("Gasoline, 210 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1210.0");
		setProperty("description","Gasoline, 210 kW");
	}
}
