package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityChecker {

	/**
	 * 
	 * @param reference a PartType 
	 * @return the set of PartType which are incompatible with reference
	 */
    Set<PartType> getIncompatibilities(Part reference);

    /**
	 * 
	 * @param reference a PartType 
	 * @return the set of PartType which are to pair up with reference
	 */
    Set<PartType> getRequirements(Part reference);

}
