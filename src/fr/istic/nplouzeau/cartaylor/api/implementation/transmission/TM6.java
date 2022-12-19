package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TM6 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TM6() {
		super();
		priceS.add("600.0");
		descriptionS.add("Manual, 6 gears");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","600.0");
		setProperty("description","Manual, 6 gears");
	}
}
