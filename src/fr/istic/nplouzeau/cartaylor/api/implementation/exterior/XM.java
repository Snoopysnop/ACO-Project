package fr.istic.nplouzeau.cartaylor.api.implementation.exterior;

import java.util.HashSet;
import java.util.Set;

public class XM extends Exterior {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public XM() {
		super();
		priceS.add("700.0");
		descriptionS.add("Metallic paint");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","700.0");
		setProperty("description","Metallic paint");
	}
}
