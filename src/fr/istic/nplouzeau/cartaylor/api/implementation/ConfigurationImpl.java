package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;



public class ConfigurationImpl implements Configuration {

	private Set<PartType> config = new HashSet<PartType>();
	
	private ConfiguratorImpl configurator;
	private  CompatibilityChecker checker;
	
	public ConfigurationImpl(ConfiguratorImpl configurator) {
		this.configurator=configurator;				
	}
    public boolean isValid() {
    	checker=configurator.getCompatibilityChecker();
    	for(PartType piece: config) {
    		Set<PartType> listIncompatibilities = checker.getIncompatibilities(piece);
    		if(!listIncompatibilities.isEmpty()){
    			for(PartType p: config) {
    				if(p!=piece) {
    					if(listIncompatibilities.contains(p))return false;
    				}	
    			}
    		}
    		Set<PartType> listRequierements = checker.getRequirements(piece);
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
    	
    	return config.size()==configurator.getCategories().size();
    	
    }

    public Set<PartType> getSelectedParts(){
    	return Collections.unmodifiableSet(config);
    	//return config;
    }

    public void selectPart(PartType chosenPart) {
    	if(!chosenPart.equals(null)) {
    		config.add(chosenPart);
    	}
    	
    	
    }

    public PartType getSelectionForCategory(Category category) {//return la piece associee a la category donnee en parametre
    	for(PartType piece: config) {
    		if(piece.getCategory().getName().equals(category.getName())) return piece;
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
    @Override
    public void clear() {//enlever toutes les pieces de la config
    	config = new HashSet<PartType>();
    	//config.clear();
    }
}
