package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;

public class CompatibilityManagerImpl extends CompatibilityCheckerImpl {

    public CompatibilityManagerImpl(Set<PartType> incompatibilities, Set<PartType> requirements) {
		super(incompatibilities, requirements);
	}

	public void addIncompatibilities(PartType reference, Set<PartType> target) {
    	
    }

    public void removeIncompatibility(PartType reference, PartType target) {
    	
    }

    public void addRequirements(PartType reference, Set<PartType> target) {
    	
    }

    public void removeRequirement(PartType reference, PartType target) {
    	
    }

}
