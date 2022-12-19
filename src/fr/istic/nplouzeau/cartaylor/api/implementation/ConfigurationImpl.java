package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.*;
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
    					if(listIncompatibilities.contains(p)) {
    						return false;
    					}
    				}	
    			}
    		}
    		Set<PartType> listRequierements = checker.getRequirements(piece);
    		if(!listRequierements.isEmpty()) {
    			for(PartType p: listRequierements) {
    				if(p!=piece) {
    					if(!config.contains(p)) {
    						return false;
    					}
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
    }

    public void selectPart(PartType chosenPart) {
    	if(chosenPart != null) {
    		
    		if(!config.contains(chosenPart)) {
    			Class<PartType>classePartType = PartType.class;
    			if(!classePartType.isInstance(getSelectionForCategory(chosenPart.getCategory()))) {
    				config.add(chosenPart);
    			}
    			else {
    				throw new IllegalArgumentException("Erreur, le partType voulant être ajouté à la config"
    						+ " ne peut pas etre ajouté car un partType de la même categorie est déjà dans la configuration");
    			}
    		}
    	}
    	else {
    		throw new IllegalArgumentException("Erreur, le partType voulant être ajouté à la config ne peut pas etre null");
    	}
    }
    
    public PartType getSelectionForCategory(Category category) {
    	if(category != null) {
	    	for(PartType piece: config) {
	    		if(piece.getCategory().getName().equals(category.getName())) {
	    			return piece;
	    		}
	    	}
	    	return null;
	    	
	    	
    	}
    	else{
    		
    		throw new IllegalArgumentException("Erreur, la category en parametre ne peut pas etre null");
    		
    	}
    }

    public void unselectPartType(Category categoryToClear) {	
    	if(categoryToClear != null) {
    		ArrayList<PartType> arrayPartType = new ArrayList<>(config);
    		int i=0;
    		boolean breakBool = false;
    		while(i<arrayPartType.size() && breakBool == false) {
    			if (arrayPartType.get(i).getCategory().equals(categoryToClear)){	
    				arrayPartType.remove(i);
    				breakBool=true;
        		}
    			i++;
        	}
    		config = new HashSet<>(arrayPartType);
    	}
    	else {
    		throw new IllegalArgumentException("Erreur, le partType voulant être enlevé de la config ne peut pas etre null");
    	}
    }
    
    @Override
    public void clear() {
    	config.clear();
    }
}

