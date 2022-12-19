package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ConfiguratorImplTest {

	ConfiguratorImpl configurator;
	
	Set<Category> categories;
	Set<PartType> partTypes;
	
	CompatibilityManagerImpl manager;
	ConfigurationImpl configuration;
	
	Set<PartType> incompatibilitiesA, incompatibilitiesB;	
	
	CategoryImpl categoryEngine,categoryTransmission;

	PartTypeImpl partTypeEngineEG100, partTypeEngineEG133, partTypeEngineEG210;
	PartTypeImpl partTypeTransmissionTM5, partTypeTransmissionTM6; 
	
	@BeforeEach
	public void setUp() {
		
		categories = new HashSet<Category>();
		partTypes = new HashSet<PartType>();
		
		/* category */
		
		
		categoryEngine = new CategoryImpl("Engine");
		categoryTransmission = new CategoryImpl("Transmission");
		
		categories.add(categoryEngine);
		categories.add(categoryTransmission);
		
		
		/* PartTypes */
		
		partTypeEngineEG100 = new PartTypeImpl("EG100 ",categoryEngine);
		partTypeEngineEG133 = new PartTypeImpl("EG133",categoryEngine);
		partTypeEngineEG210 = new PartTypeImpl("EG210",categoryEngine);
				
		partTypeTransmissionTM5 = new PartTypeImpl("TM5",categoryTransmission);
		partTypeTransmissionTM6 = new PartTypeImpl("TM6",categoryTransmission);
		
		partTypes.add(partTypeEngineEG100);
		partTypes.add(partTypeEngineEG133);
		partTypes.add(partTypeEngineEG210);
		
		partTypes.add(partTypeTransmissionTM5);
		partTypes.add(partTypeTransmissionTM6);

		
		/* INCOMPATIBILITIES & REQUIREMENT */
		
		
		manager = new CompatibilityManagerImpl();
		
		incompatibilitiesA = new HashSet<PartType>();
		incompatibilitiesA.add(partTypeEngineEG100);
		
		incompatibilitiesB = new HashSet<PartType>();
		incompatibilitiesB.add(partTypeEngineEG100);
		incompatibilitiesB.add(partTypeEngineEG133);
		
		manager.addIncompatibilities(partTypeTransmissionTM5,incompatibilitiesA);
		manager.addIncompatibilities(partTypeTransmissionTM6,incompatibilitiesB);
		
		configurator = new ConfiguratorImpl(categories,partTypes,manager);
		
		configuration = configurator.getConfiguration();

	}


	@Test
	@DisplayName("Test du selectPart en ajoutant un element de categorie deja existante")
	public void testgetCategories1() {
		Set<Category> categoriesTest = new HashSet<Category>();

		categoriesTest.add(categoryEngine);
		categoriesTest.add(categoryTransmission);

		assertEquals(configurator.getCategories(),categoriesTest);

	}
	@Test
	@DisplayName("Test du getCategories en essayant de modifier la liste de categories en lui ajoutant un element")
	public void testgetCategories2() {
		assertThrows(UnsupportedOperationException.class, () -> configurator.getCategories().add(new CategoryImpl("categorie de test")));
	}
	
	@Test
	@DisplayName("Test du getVariants en faisant un get des variants du configurator")
	public void testgetVariants1() {
		
    	Set<PartType> variantsTest = new HashSet<PartType>();
    	
    	variantsTest.add(partTypeTransmissionTM5);
    	variantsTest.add(partTypeTransmissionTM6);
    	
    	assertEquals(configurator.getVariants(categoryTransmission), variantsTest);
	}
	@Test
	@DisplayName("Test du getVariants en essayant de modifier la liste de variants en lui ajoutant un element")
	public void testgetVariants2() {
		
    	assertThrows(UnsupportedOperationException.class, () -> configurator.getVariants(categoryTransmission).add(partTypeEngineEG133));
	}
	@Test
	@DisplayName("Test du getVariants en essayant de get les variants d'une categorie null")
	public void testgetVariants3() {
		
    	assertThrows(IllegalArgumentException.class, () -> configurator.getVariants(null));
    	
	}
	@Test
	@DisplayName("Test du getVariants quand on ne trouve pas de variants pour la categorie en parametre ou que la categorie n'existe pas dans le configurator")
	public void testgetVariants4() {
		CategoryImpl categorieTest = new CategoryImpl("categorieTest");
    	assertEquals(configurator.getVariants(categorieTest),new HashSet<>());
	}
}
