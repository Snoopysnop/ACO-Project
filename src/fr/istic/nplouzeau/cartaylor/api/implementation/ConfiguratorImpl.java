package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;


public class ConfiguratorImpl implements Configurator{

	private Set<Category> categories;
	private Set<PartType> partTypes;

	private ConfigurationImpl config;
	private CompatibilityCheckerImpl compaCheck;
	
	Set<PartType> incompatibilities ;
	Set<PartType> requirements ;
	
	public ConfiguratorImpl(Set<Category> categories,Set<PartType> partTypes) {
		this.categories=categories;
		this.partTypes=partTypes;
		config = new ConfigurationImpl();
		compaCheck = new CompatibilityCheckerImpl(incompatibilities,requirements);
		
		
	}
	
    public Set<Category> getCategories() {
    	return Collections.unmodifiableSet(categories);
    }

    public Set<PartType> getVariants(Category category){
    	Set<PartType> res = new HashSet<PartType>();
    	for(PartType p : partTypes) {
    		if(p.getCategory().equals(category))res.add(p);
    	}
    	return Collections.unmodifiableSet(res);
    }

    public ConfigurationImpl getConfiguration() {
    	return config;
    }

    public CompatibilityCheckerImpl getCompatibilityChecker() {
    	return compaCheck;
    }
    
    
}
