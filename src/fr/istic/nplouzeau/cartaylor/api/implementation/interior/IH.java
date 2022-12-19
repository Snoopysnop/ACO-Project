package fr.istic.nplouzeau.cartaylor.api.implementation.interior;

import java.util.HashSet;
import java.util.Set;

public class IH extends Interior {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();

	public IH() {
		super();
		priceS.add("700.0");
		descriptionS.add("High-end interior");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","700.0");
		setProperty("description","High-end interior");
	}
}
