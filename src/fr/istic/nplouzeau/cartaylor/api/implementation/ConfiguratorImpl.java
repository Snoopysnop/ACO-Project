package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;


public class ConfiguratorImpl implements Configurator{

	private Set<Category> Categories;
	private Set<PartType> PartTypes;

	private ConfigurationImpl config;
	private CompatibilityCheckerImpl compaCheck;
	
	
	public ConfiguratorImpl(Set<Category> Categories,Set<PartType> PartTypes) {
		this.Categories=Categories;
		this.PartTypes=PartTypes;
		config = new ConfigurationImpl();
		compaCheck = new CompatibilityCheckerImpl();
		
		
	}
	
    public Set<Category> getCategories() {
    	return Categories;
    }

    public Set<PartType> getVariants(Category category){
    	return PartTypes;
    }

    public ConfigurationImpl getConfiguration() {
    	return config;
    }

    public CompatibilityCheckerImpl getCompatibilityChecker() {
    	return compaCheck;
    }
    
    
}
