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

	@Override
	public Set<PartType> getIncompatibilities(PartType reference){
		
		if(reference != null) {
			if(tableInc.containsKey(reference)) {
				return Collections.unmodifiableSet(tableInc.get(reference));
			}
			else {
				return Collections.unmodifiableSet(new HashSet<PartType>());
			}
		}
		else {
			throw new IllegalArgumentException("Erreur, le partype en parametre ne peut pas etre null");
		}
	}

	@Override
	public Set<PartType> getRequirements(PartType reference){
		
		if(reference != null) {
			if(tableReq.containsKey(reference)) {
				return Collections.unmodifiableSet(tableReq.get(reference));
		
			}
			else {
				return Collections.unmodifiableSet(new HashSet<PartType>());
			}	
		}
		else {
			throw new IllegalArgumentException("Erreur, le partype en parametre ne peut pas etre null");
		}
	}

	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		if(reference != null && target != null) {
			if(!tableInc.containsKey(reference)) {
				tableInc.put(reference,target);
			}
			else {
				Set<PartType> setRes = new HashSet<>();
				setRes.addAll(target);
				setRes.addAll(tableInc.get(reference));
				tableInc.put(reference,setRes);
			}
		}
		else {
			throw new IllegalArgumentException("Erreur, un ou plusieurs parametres sont null. C'est impossible");
		}
	}

	
	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		
	    	if(reference != null && target !=null ) {
	    		if(tableInc.containsKey(reference)) {
	    			ArrayList<PartType> arrayPartType = new ArrayList<>(tableInc.get(reference));
		    		int i=0;
		    		boolean breakBool = false;
		    		while(i<arrayPartType.size() && breakBool == false) {
		    			if (arrayPartType.get(i).equals(target)){	
		    				arrayPartType.remove(i);
		    				breakBool=true;
		        		}
		    			i++;
		    		}
		    		tableInc.put(reference,new HashSet<>(arrayPartType));
	        	}
	    		else {
	    			throw new IllegalArgumentException("Erreur, la reference choisi n'existe pas dans la table.");
	        	}
	    	}
	    	else {
	    		throw new IllegalArgumentException("Erreur, le partType voulant être enlevé de la config ne peut pas etre null");
	    	}
	    }
	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		if(reference != null && target != null) {
			if(!tableReq.containsKey(reference)) {
				tableReq.put(reference,target);
			}
			else {
				Set<PartType> setRes = new HashSet<>();
				setRes.addAll(target);
				setRes.addAll(tableReq.get(reference));
				tableReq.put(reference,setRes);
			}
		}
		else {
			throw new IllegalArgumentException("Erreur, un ou plusieurs parametres sont null. C'est impossible");
		}
	}
	@Override
	public void removeRequirement(PartType reference, PartType target) {
				
    	if(reference != null && target !=null ) {
    		if(tableReq.containsKey(reference)) {
    			ArrayList<PartType> arrayPartType = new ArrayList<>(tableReq.get(reference));
	    		int i=0;
	    		boolean breakBool = false;
	    		while(i<arrayPartType.size() && breakBool == false) {
	    			if (arrayPartType.get(i).equals(target)){	
	    				arrayPartType.remove(i);
	    				breakBool=true;
	        		}
	    			i++;
	    		}
	    		tableReq.put(reference,new HashSet<>(arrayPartType));
        	}
    		else {
    			throw new IllegalArgumentException("Erreur, la reference choisi n'existe pas dans la table.");
        	}
    	}
    	else {
    		throw new IllegalArgumentException("Erreur, le partType voulant être enlevé de la config ne peut pas etre null");
    	}
    }
}
