package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TM5 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TM5() {
		super();
		priceS.add("500.0");
		descriptionS.add("Manual, 5 gears");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","500.0");
		setProperty("description","Manual, 5 gears");
	}
}
