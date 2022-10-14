package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Tests {

	private ConfiguratorImpl configurator;
	Set<Category> Categories = new HashSet<Category>();
	Set<PartType> PartTypes = new HashSet<PartType>();
	
	@BeforeEach
	public void setUp() {
		

		configurator = new ConfiguratorImpl(Categories,PartTypes);

		//	    	CategoryImpl categoryEngine = new CategoryImpl("Engine");
		//	    	PartTypeImpl paryTypeEngine = new PartTypeImpl("loulou",categoryEngine);
		//	    
		//	    	
		//	    	Categories.add(categoryEngine);
		//	    	PartTypes.add(paryTypeEngine);

	}


	@Test
	public void testCategory1() {

		CategoryImpl categoryEnginetest1 = new CategoryImpl("Engine");
		CategoryImpl categoryEnginetest2 = new CategoryImpl("Transmission");
		Set<Category> CategoriesTest = new HashSet<Category>();

		CategoriesTest.add(categoryEnginetest1);
		CategoriesTest.add(categoryEnginetest2);

		assertFalse(configurator.getCategories().equals(CategoriesTest));

	}

	@Test
	public void testVariant1() {
		
		CategoryImpl categoryEngine = new CategoryImpl("Engine");
		CategoryImpl categoryTransmission = new CategoryImpl("Transmission");
		PartTypeImpl partTypeTransmission1 = new PartTypeImpl("TM5",categoryTransmission);
    	PartTypeImpl partTypeEngine1 = new PartTypeImpl("ED180",categoryEngine);
    	PartTypeImpl partTypeTransmission2 = new PartTypeImpl("TS6",categoryTransmission);
    	
    	Set<PartType> VariantsTest = new HashSet<PartType>();
    	
    	PartTypes.add(partTypeTransmission1);
		PartTypes.add(partTypeTransmission2);
		PartTypes.add(partTypeEngine1);
		
		
    	VariantsTest.add(partTypeTransmission1);
    	VariantsTest.add(partTypeTransmission2);
    	
    	assertTrue(configurator.getVariants(categoryTransmission).equals(VariantsTest));
	}

}
