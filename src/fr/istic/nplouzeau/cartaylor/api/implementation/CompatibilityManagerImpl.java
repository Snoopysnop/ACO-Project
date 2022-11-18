package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;

public class CompatibilityManagerImpl implements CompatibilityManager{

	private Map<PartType,Set<PartType>> tableInc = new HashMap<PartType,Set<PartType>>();
	private Map<PartType,Set<PartType>> tableReq = new HashMap<PartType,Set<PartType>>();
	
	public CompatibilityManagerImpl() {
	}

	public Set<PartType> getIncompatibilities(PartType reference){
		return Collections.unmodifiableSet(tableInc.get(reference));
	}

	public Set<PartType> getRequirements(PartType reference){
		return Collections.unmodifiableSet(tableReq.get(reference));
	}
	
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
			tableInc.put(reference,target);
		}

    public void removeIncompatibility(PartType reference, PartType target) {
    	boolean b = getIncompatibilities(reference).remove(target);
    }

    public void addRequirements(PartType reference, Set<PartType> target) {
    	for (PartType p : target) {
			boolean b = getRequirements(reference).add(p);
		}
    }

    public void removeRequirement(PartType reference, PartType target) {
    	boolean b = getRequirements(reference).remove(target);
    }

}
