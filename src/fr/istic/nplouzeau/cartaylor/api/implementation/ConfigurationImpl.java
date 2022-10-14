package fr.istic.nplouzeau.cartaylor.api.implementation;


import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;


public class ConfigurationImpl implements Configuration {

    public boolean isValid() {
    	return false;
    }

    public boolean isComplete() {
    	return false;
    }

    public Set<PartType> getSelectedParts(){
    	return null;
    }

    public void selectPart(PartType chosenPart) {
    	
    }

    public PartType getSelectionForCategory(Category category) {
    	return null;
    }

    public void unselectPartType(Category categoryToClear) {
    	
    }

    public void clear() {
    	
    }

}
