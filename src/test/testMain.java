package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.implementation.CategoryImpl;
import fr.istic.nplouzeau.cartaylor.api.implementation.ConfiguratorImpl;
import fr.istic.nplouzeau.cartaylor.api.implementation.PartTypeImpl;

public class testMain {
	private ConfiguratorImpl configurator;
	private Map<PartType,Set<PartType>> tableInc = new HashMap<PartType,Set<PartType>>();
	
	
	
	public testMain() {
		Set<Category> Categories = new HashSet<Category>();
		Set<Category> Categories995 = new HashSet<Category>();
		Set<PartType> PartTypes = new HashSet<PartType>();
		
		
    	
    	CategoryImpl categoryEngine = new CategoryImpl("Engine");
    	PartTypeImpl paryTypeEngine = new PartTypeImpl("E150",categoryEngine);
    	PartTypeImpl paryTypeEngine39 =  new PartTypeImpl("E15242",categoryEngine);
    	
    	
    	
    	
    	Categories.add(categoryEngine);
    	Categories995.add(categoryEngine);
    	PartTypes.add(paryTypeEngine);
    	PartTypes.add(paryTypeEngine39);
        configurator = new ConfiguratorImpl(Categories,PartTypes);
        
        
        tableInc.put(paryTypeEngine, PartTypes);
        
       
        System.out.println("1jet");
        
       // (
        //tableInc.put(paryTypeEngine2, PartTypes);
    //   int i =0;
        for (Map.Entry<PartType, Set<PartType>> p : tableInc.entrySet()) {
            
        	PartType key = p.getKey();
        	Set<PartType> value = p.getValue();
        	
        	//PartType ke= value.;
        	
           // System.out.println("Clé: " + key.getName() + ", Valeur: " + value );
            //i++;
        }
        
	}
	
	
	
	public static void main(String[] args) {
	 	
		testMain t = new testMain();
		
		//for(Category c : t.configurator.getCategories()) System.out.println(c.getName());
			
		
		
       
	}

}
