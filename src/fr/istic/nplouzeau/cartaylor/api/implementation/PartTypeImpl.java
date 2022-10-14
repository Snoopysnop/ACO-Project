package fr.istic.nplouzeau.cartaylor.api.implementation;

import fr.istic.nplouzeau.cartaylor.api.*;

public class PartTypeImpl implements PartType{

	
	private String name;
	private CategoryImpl category;
	
	public PartTypeImpl(String name,CategoryImpl category ) {
		this.name=name;
		this.category=category;
	}
	
	
	public String getName() {
		return this.name;
	}

	public CategoryImpl getCategory() {
		return this.category;
	}
}
