package fr.istic.nplouzeau.cartaylor.api.implementation.exterior;

import java.util.HashSet;
import java.util.Set;

public class XC extends Exterior {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public XC() {
		super();
		priceS.add("300.0");
		descriptionS.add("Classic paint");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","300.0");
		setProperty("description","Classic paint");
	}
	
}
