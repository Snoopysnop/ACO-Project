package fr.istic.nplouzeau.cartaylor.api.implementation.exterior;

import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.implementation.PartImpl;

public class Exterior extends PartImpl {
	
	public enum Colored {
		BLUE,RED,PURPLE
	}
	
	private Colored color;
	private double price;
	private String description;

	private Set<String> possibleColors = new HashSet<>();
	
	
	public Exterior() {
		super();
		possibleColors.add("BLUE");
		possibleColors.add("RED");
		possibleColors.add("PURPLE");
		
		addProperty("color", () -> getColor(), (c) -> setColor(c), possibleColors);
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

	
	public String getColor() {
		return color.name();
	}	
	
	public void setColor(String color) {
		Colored col =  Colored.valueOf(color);
		if(col == null) {
			throw new IllegalArgumentException("null value for color");
		}
		this.color = col;
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
