package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;



public class ConfigurationImpl implements Configuration {

	private Set<Part> config = new HashSet<Part>();
	
	private ConfiguratorImpl configurator;
	private  CompatibilityChecker checker;
	
	public ConfigurationImpl(ConfiguratorImpl configurator) {
		this.configurator=configurator;				
	}
    public boolean isValid() {
    	checker=configurator.getCompatibilityChecker();
    	for(Part piece: config) {
    		Set<PartType> listIncompatibilities = checker.getIncompatibilities(piece);
    		if(!listIncompatibilities.isEmpty()){
    			for(Part p: config) {
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

    public Set<Part> getSelectedParts(){
    	return Collections.unmodifiableSet(config);
    	//return config;
    }

    public void selectPart(Part chosenPart) {
    	if(!chosenPart.equals(null)) {
    		config.add(chosenPart);
    	}
    	
    	
    }

    public Optional<Part> getSelectionForCategory(Category category) {//return la piece associee a la category donnee en parametre
    	for(Part piece: config) {
    		if(piece.getCategory().getName().equals(category.getName())) return Optional.of(piece);
    	}
    	return null;
    }

    public void unselectPartType(Category categoryToClear) {
    	Set<Part> configRes = config;
    	for(Part piece: configRes) {
    		if (piece.getCategory().equals(categoryToClear)){
    			configRes.remove(piece);
    		}
    	}
    	config=configRes;
    }
    @Override
    public void clear() {//enlever toutes les pieces de la config
    	config = new HashSet<Part>();
    	//config.clear();
    }
}
