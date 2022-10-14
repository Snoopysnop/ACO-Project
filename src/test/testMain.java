package test;

import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.implementation.CategoryImpl;
import fr.istic.nplouzeau.cartaylor.api.implementation.ConfiguratorImpl;
import fr.istic.nplouzeau.cartaylor.api.implementation.PartTypeImpl;

public class testMain {
	private ConfiguratorImpl configurator;
	public testMain() {
		Set<Category> Categories = new HashSet<Category>();
		Set<Category> Categories995 = new HashSet<Category>();
		Set<PartType> PartTypes = new HashSet<PartType>();
    	
    	CategoryImpl categoryEngine = new CategoryImpl("Engine");
    	PartTypeImpl paryTypeEngine = new PartTypeImpl("loulou",categoryEngine);
    
    	
    	Categories.add(categoryEngine);
    	Categories995.add(categoryEngine);
    	PartTypes.add(paryTypeEngine);
        configurator = new ConfiguratorImpl(Categories,PartTypes);
	}
	
	
	
	public static void main(String[] args) {
	 	
		testMain t = new testMain();
		
		for(Category c : t.configurator.getCategories()) System.out.println(c.getName());
			
       
	}

}
