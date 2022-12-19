package fr.istic.nplouzeau.cartaylor.api.implementation.interior;

import java.util.HashSet;
import java.util.Set;

public class IS extends Interior {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public IS() {
		super();
		priceS.add("1500.0");
		descriptionS.add("Sport finish");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1500.0");
		setProperty("description","Sport finish");
	}
}
