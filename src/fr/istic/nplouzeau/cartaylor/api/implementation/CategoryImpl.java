package fr.istic.nplouzeau.cartaylor.api.implementation;

import fr.istic.nplouzeau.cartaylor.api.Category;

/**
 * @author plouzeau
 * <p>
 * A public type to organize part types in categories
 */
public class CategoryImpl implements Category{
	
	private String category;
	
	public CategoryImpl(String category) {
		this.category=category;
	}

    public String getName() {
    	return this.category;
    }
   
}
