package fr.istic.nplouzeau.cartaylor.api.implementation.exterior;

import java.util.HashSet;
import java.util.Set;

public class XS extends Exterior {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public XS() {
		super();
		priceS.add("1200.0");
		descriptionS.add("Red paint and sport decoration");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1200.0");
		setProperty("description","Red paint and sport decoration");
	}
}
