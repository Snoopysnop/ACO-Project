package fr.istic.nplouzeau.cartaylor.api.implementation.engine;

import java.util.HashSet;
import java.util.Set;

public class EH120 extends Engine {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public EH120() {
		super();
		priceS.add("2120.0");
		descriptionS.add("Gasoline/electric hybrid, 120 kW");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","2120.0");
		setProperty("description","Gasoline/electric hybrid, 120 kW");
	}
}
