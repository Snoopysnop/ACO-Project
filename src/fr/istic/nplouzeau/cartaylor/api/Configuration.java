package fr.istic.nplouzeau.cartaylor.api;


import java.util.Optional;
import java.util.Set;

public interface Configuration {

	/**
	 * check if the actual configuration is valid i.e if the requirements/incompatibilities of all the PartType in the configuration are respected
	 * @return true if the configuration is valid else false
	 */
    boolean isValid();

    /**
	 * check if the actual configuration is complete i.e if it contains 1 PartType of each categories
	 * @return true if the configuration is complete else false
	 */
    boolean isComplete();

    /**
     * getter which returns the actual configuration
     * @return the actual configuration
     */
    Set<Part> getSelectedParts();

    /**
     * add an instance of Part of the PartType to the actual configuration
     * @param chosenPart the partType to add
     */
    void selectPart(PartType chosenPart);

    /**
     * return a PartType of a certain category in the actual configuration
     * @param category a category
     * @return the PartType which belongs to the category category
     */
    Optional<Part> getSelectionForCategory(Category category);

    /**
     * remove a PartType of the actual configuration
     * @param chosenPart the partType to remove
     */
    void unselectPartType(Category categoryToClear);

    /**
     * remove all the Part of the actual configuration
     */
    void clear();
    
    /**
     * gives the html file of the configuration
     * @return the html file of the configuration as a String
     */
    String printHtmlConfiguration();
    
    /**
     * gives the price of the whole configuration
     * @return the price of the configuration
     */
    double getPrice();


    /*
     * apply the color
     */
    void chooseColor(String chosenColor);
}
