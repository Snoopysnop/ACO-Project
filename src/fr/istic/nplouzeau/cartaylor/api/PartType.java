package fr.istic.nplouzeau.cartaylor.api;

import fr.istic.nplouzeau.cartaylor.api.implementation.PartImpl;

public interface PartType {

	/**
	 * @return name of the PartType
	 */
    String getName();

    /**
	 * @return Category of the PartType
	 */
    Category getCategory();
    
    
    /**
     * create an instance of PartImpl for the actual PartType
     * @return
     */
    public PartImpl newInstance();
}
