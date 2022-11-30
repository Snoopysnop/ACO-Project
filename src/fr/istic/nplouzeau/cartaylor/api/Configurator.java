package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface Configurator {

	/**
	 * getter which returns the set of categories
	 * @return the set of categories
	 */
    Set<Category> getCategories();

    /**
     * return all the PartType of a certain category
     * @param category a category
     * @return the set which contains all the PartType belonging to category
     */
    Set<PartType> getVariants(Category category);

    /**
     * getter which returns the actual configuration
     * @return the actual configuration
     */
    Configuration getConfiguration();

    /**
     * getter which returns the instance of compatibilityChecker to manage all the incompatibilities/requirements
     * @return the instance of compatibilityChecker
     */
    CompatibilityChecker getCompatibilityChecker();

}
