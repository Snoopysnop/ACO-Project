package fr.istic.nplouzeau.cartaylor.api.implementation.transmission;

import java.util.HashSet;
import java.util.Set;

public class TA6 extends Transmission {

	Set<String> priceS = new HashSet<>();
	Set<String> descriptionS = new HashSet<>();
	
	public TA6() {
		super();
		priceS.add("1600.0");
		descriptionS.add("Automatic, 6 gears");
		addProperty("price", () -> getPrice(), (p) -> setPrice(p), priceS);
		addProperty("description", () -> getDescription(), (d) -> setDescription(d), descriptionS);
		setProperty("price","1600.0");
		setProperty("description","Automatic, 6 gears");
	}
}
