package fr.istic.nplouzeau.cartaylor.api;

public interface Part extends PropertyManager {
	default String getName() {
		return this.getClass().getTypeName();
	}
	
	/**
	 * get the category of the PartType
	 * @return the category of the PartType
	 */
	Category getCategory();
	
	/**
	 * get the partType assiociated with this part
	 * @return the partType
	 */
	PartType getType();
}