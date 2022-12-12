package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;

public class CompatibilityManagerImpl implements CompatibilityManager {

	 private Map<PartType,Set<PartType>> tableInc = new HashMap<PartType,Set<PartType>>();
	 private Map<PartType,Set<PartType>> tableReq = new HashMap<PartType,Set<PartType>>();

	public CompatibilityManagerImpl() {
	}

	public Set<PartType> getIncompatibilities(PartType reference){

		if(!reference.equals(null)) {
			if(tableInc.containsKey(reference)) {
				return Collections.unmodifiableSet(tableInc.get(reference));
			}
			else {
				return Collections.unmodifiableSet(new HashSet<PartType>());
//				throw new IllegalArgumentException("Erreur, le partype choisi n'est pas dans le configurator");
			}
		}
		else {
			throw new NullPointerException("Erreur, le partype ne peut pas etre null");
		}
	}

	public Set<PartType> getRequirements(PartType reference){
		
		if(!reference.equals(null)) {
			if(tableReq.containsKey(reference)) {
				return Collections.unmodifiableSet(tableReq.get(reference));
		
			}
			else {
				return Collections.unmodifiableSet(new HashSet<PartType>());
			}	
		}
		else {
			throw new NullPointerException("erreur, partype ne peut pas etre null");
		}
	}

	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		tableInc.put(reference,target);
	}

	public void removeIncompatibility(PartType reference, PartType target) {
		getIncompatibilities(reference).remove(target);
	}

	public void addRequirements(PartType reference, Set<PartType> target) {
		tableReq.put(reference,target);
	}

	public void removeRequirement(PartType reference, PartType target) {
		getRequirements(reference).remove(target);
	}
//	public void printSet() {
//		for (Map.Entry<PartType, Set<PartType>> entry : tableInc.entrySet()) {
//		    for(PartType p : tableInc)
//			System.out.println(entry.getKey().getName() + ":" + entry.getValue().getName());
//		}
		
//		tableInc.forEach((key, value) -> System.out.println(key.getName() + ":" + HashSetToString(value)));
		
//	}
	public String HashSetToString(Set<PartType> s) {
		String res = "";
		for(PartType p : s) {
			res+= p.getName() + " ";
		}
		return res;
	}
	
}
