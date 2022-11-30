package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityManager extends CompatibilityChecker {
	
	/**
	 * add a PartType to the set of incompabilities of another PartType
	 * @param reference a PartType
	 * @param target the set of incompatibilites we want to add to the set of incompatibilites of reference
	 */
    void addIncompatibilities(PartType reference, Set<PartType> target);

    /**
	 * remove a PartType of the set of incompabilities of another PartType
	 * @param reference the PartType which will have its set of incompatibilites minus target
	 * @param target the PartType to remove
	 */
    void removeIncompatibility(PartType reference, PartType target);

    /**
	 * add a PartType to the set of requirements of another PartType
	 * @param reference a PartType
	 * @param target the set of requirements we want to add to the set of requirements of reference
	 */
    void addRequirements(PartType reference, Set<PartType> target);

    /**
	 * remove a PartType of the set of requirements of another PartType
	 * @param reference the PartType which will have its set of requirements minus target
	 * @param target the PartType to remove
	 */
    void removeRequirement(PartType reference, PartType target);

}
