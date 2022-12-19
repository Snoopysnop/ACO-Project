package fr.istic.nplouzeau.cartaylor.api.implementation.interior;

import fr.istic.nplouzeau.cartaylor.api.implementation.PartImpl;

public class Interior extends PartImpl {

	private double price;
	private String description;
	
	
	public Interior() {
		super();
	}



	public String getPrice() {
		return "" + price;
	}


	public void setPrice(String price) {
		double p = Double.parseDouble(price);
		if(p<0.0) {
			throw new IllegalArgumentException("The price cannot be negative");
		}
		this.price = p;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("Your description is null");
		}
		this.description = description;
	}
}
