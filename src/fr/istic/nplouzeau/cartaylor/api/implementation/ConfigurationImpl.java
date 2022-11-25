package fr.istic.nplouzeau.cartaylor.api.implementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.ws.api.pipe.Engine;

import fr.istic.nplouzeau.cartaylor.api.*;



public class ConfigurationImpl implements Configuration {

	private Set<PartType> config = new HashSet<PartType>();
	
	private CompatibilityChecker checker;
	
	public ConfigurationImpl(CompatibilityChecker checker) {
		this.checker=checker;
	}
    public boolean isValid() {
    	for(PartType piece: config) {
    		Set<PartType> listIncompatibilities = checker.getIncompatibilities(piece);
    		Set<PartType> listRequierements = checker.getRequirements(piece);
    		if(!listIncompatibilities.isEmpty()){
    			for(PartType p: config) {
    				if(p!=piece) {
    					if(listIncompatibilities.contains(p))return false;
    				}	
    			}
    		}
    		if(!listRequierements.isEmpty()) {
    			for(PartType p: listRequierements) {
    				if(p!=piece) {
    					if(!config.contains(p))return false;
    				}
    			}
    		}
    	}
    	return true;
    }

    
    public boolean isComplete() {
    	//modif s'arreter des que compteurX>1;
    	int compteurEngine=0;
    	int compteurTransmission=0;
    	int compteurExterior=0;
    	int compteurInterior=0;
    	    	
    	for(PartType piece: config) {
    		switch(piece.getCategory().getName()) {
	    		case"Engine":
	    			compteurEngine++;
	    			break;
	    		case"Transmission":
	    			compteurTransmission++;
	    			break;
	    		case"Exterior":
	    			compteurExterior++;
	    			break;
	    		case"Interior":
	    			compteurInterior++;
	    			break;
	    		default:
	    			
    		}
    	}
    	return (compteurEngine==1)&&(compteurTransmission==1)&&(compteurExterior==1)&&(compteurInterior==1);
    }

    public Set<PartType> getSelectedParts(){
    	return Collections.unmodifiableSet(config);
    }

    public void selectPart(PartType chosenPart) {
    	config.add(chosenPart);
    	
    }

    public PartType getSelectionForCategory(Category category) {//return la piece associee a la category donnee en parametre
    	for(PartType piece: config) {
    		if(piece.getCategory().getName().equals(category)) return piece;
    	}
    	return null;
    }

    public void unselectPartType(Category categoryToClear) {
    	Set<PartType> configRes = config;
    	for(PartType piece: configRes) {
    		if (piece.getCategory().equals(categoryToClear)){
    			configRes.remove(piece);
    		}
    	}
    	config=configRes;
    }

    public void clear() {//enlever toutes les pieces de la config
    	config = new HashSet<PartType>();
    }

}
