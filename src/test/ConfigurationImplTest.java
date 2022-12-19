package test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import fr.istic.nplouzeau.cartaylor.api.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ConfigurationTest {
	ConfiguratorImpl configurator;
	
	Set<Category> categories;
	Set<PartType> partTypes;
	
	CompatibilityManagerImpl manager;
	ConfigurationImpl configuration;
	
	Set<PartType> incompatibilitiesA, incompatibilitiesB, incompatibilitiesC, incompatibilitiesD;	
	Set<PartType> requirementTC120, requirementEH120, requirementIS, requirementXS;
	
	CategoryImpl categoryEngine,categoryTransmission, categoryExterior, categoryInterior;

	PartTypeImpl partTypeEngineEG100, partTypeEngineEG133, partTypeEngineEG210, partTypeEngineED110, partTypeEngineED180, partTypeEngineEH120;
	PartTypeImpl partTypeTransmissionTM5, partTypeTransmissionTM6, partTypeTransmissionTA5, partTypeTransmissionTS6, partTypeTransmissionTSF7, partTypeTransmissionTC120; 
  	PartTypeImpl partTypeExteriorXC, partTypeExteriorXM, partTypeExteriorXS;
  	PartTypeImpl partTypeInteriorIN, partTypeInteriorIH, partTypeInteriorIS; 
	
  	
  	
  	
	@BeforeEach
	public void setUp() {
		
		categories = new HashSet<Category>();
		partTypes = new HashSet<PartType>();
		
		/* category */
		
		
		categoryEngine = new CategoryImpl("Engine");
		categoryTransmission = new CategoryImpl("Transmission");
		categoryExterior = new CategoryImpl("Exterior");
		categoryInterior = new CategoryImpl("Interior");
		
		
		categories.add(categoryEngine);
		categories.add(categoryTransmission);
		categories.add(categoryExterior);
		categories.add(categoryInterior);
		
		/* PartTypes */
		
		partTypeEngineEG100 = new PartTypeImpl("EG100 ",categoryEngine);
		partTypeEngineEG133 = new PartTypeImpl("EG133",categoryEngine);
		partTypeEngineEG210 = new PartTypeImpl("EG210",categoryEngine);
		partTypeEngineED110 = new PartTypeImpl("ED110",categoryEngine);
		partTypeEngineED180 = new PartTypeImpl("ED180",categoryEngine);
		partTypeEngineEH120 = new PartTypeImpl("EH120",categoryEngine);
				
		partTypeTransmissionTM5 = new PartTypeImpl("TM5",categoryTransmission);
		partTypeTransmissionTM6 = new PartTypeImpl("TM6",categoryTransmission);
		partTypeTransmissionTA5 = new PartTypeImpl("TA5",categoryTransmission);
		partTypeTransmissionTS6 = new PartTypeImpl("TS6",categoryTransmission);
		partTypeTransmissionTSF7 = new PartTypeImpl("TSF7",categoryTransmission);
		partTypeTransmissionTC120 = new PartTypeImpl("TC120",categoryTransmission);
		
		
		partTypeExteriorXC = new PartTypeImpl("XC",categoryExterior);
		partTypeExteriorXM = new PartTypeImpl("XM",categoryExterior);
		partTypeExteriorXS = new PartTypeImpl("XS",categoryExterior);
	  	
	  	
		partTypeInteriorIN = new PartTypeImpl("IN",categoryInterior);
		partTypeInteriorIH = new PartTypeImpl("IH",categoryInterior);
		partTypeInteriorIS = new PartTypeImpl("IS",categoryInterior);
		
		partTypes.add(partTypeEngineEG100);
		partTypes.add(partTypeEngineEG133);
		partTypes.add(partTypeEngineEG210);
		partTypes.add(partTypeEngineED110);
		partTypes.add(partTypeEngineED180);
		partTypes.add(partTypeEngineEH120);
		
		partTypes.add(partTypeTransmissionTM5);
		partTypes.add(partTypeTransmissionTM6);
		partTypes.add(partTypeTransmissionTA5);
		partTypes.add(partTypeTransmissionTS6);
		partTypes.add(partTypeTransmissionTSF7);
		partTypes.add(partTypeTransmissionTC120);
		
		partTypes.add(partTypeExteriorXC);
		partTypes.add(partTypeExteriorXM);
		partTypes.add(partTypeExteriorXS);
		
		partTypes.add(partTypeInteriorIN);
		partTypes.add(partTypeInteriorIH);
		partTypes.add(partTypeInteriorIS);
		
		

		
		/* INCOMPATIBILITIES & REQUIREMENT */
		
		
		manager = new CompatibilityManagerImpl();
		
		incompatibilitiesA = new HashSet<PartType>();
		incompatibilitiesA.add(partTypeEngineEG100);
		
		incompatibilitiesB = new HashSet<PartType>();
		incompatibilitiesB.add(partTypeEngineEG100);
		incompatibilitiesB.add(partTypeEngineEG133);
		incompatibilitiesB.add(partTypeEngineED110);
		
		incompatibilitiesC = new HashSet<PartType>();
		incompatibilitiesC.add(partTypeEngineEG210);
		
		incompatibilitiesD = new HashSet<PartType>();
		incompatibilitiesD.add(partTypeEngineEG100);
		incompatibilitiesD.add(partTypeTransmissionTM5);
		
		
		manager.addIncompatibilities(partTypeTransmissionTA5,incompatibilitiesA);
		manager.addIncompatibilities(partTypeTransmissionTSF7,incompatibilitiesB);
		manager.addIncompatibilities(partTypeExteriorXC,incompatibilitiesC);
		manager.addIncompatibilities(partTypeExteriorXM,incompatibilitiesA);
		manager.addIncompatibilities(partTypeExteriorXS,incompatibilitiesA);
		manager.addIncompatibilities(partTypeInteriorIS,incompatibilitiesD);
		
		
		
		requirementTC120 = new HashSet<PartType>();
		requirementTC120.add(partTypeTransmissionTC120);
	
		requirementEH120 = new HashSet<PartType>();
		requirementEH120.add(partTypeEngineEH120);
		
		requirementIS = new HashSet<PartType>();
		requirementIS.add(partTypeInteriorIS);
		
		requirementXS = new HashSet<PartType>();
		requirementXS.add(partTypeExteriorXS);
		
		manager.addRequirements(partTypeEngineEH120,requirementTC120);
		manager.addRequirements(partTypeTransmissionTC120,requirementEH120);
		manager.addRequirements(partTypeExteriorXS,requirementIS);
		manager.addRequirements(partTypeInteriorIS,requirementXS);
			
		
		configurator = new ConfiguratorImpl(categories,partTypes,manager);
		
		configuration = configurator.getConfiguration();
	}
	
	@Test
	@DisplayName("Test du getSelected en essayant de get une configuration vide")
	
	public void getSelectedPart1 () {	
		
		assertEquals(configuration.getSelectedParts(),new HashSet<PartType>());
	}
	@Test
	@DisplayName("Test du getSelected en essayant de get une configuration configuration non vide")
	public void getSelectedParts2 () {
		Set<PartType> configTest = new HashSet<PartType>();
		configTest.add(partTypeTransmissionTSF7);
		
		
		configuration.selectPart(partTypeTransmissionTSF7);
		
		assertEquals(configuration.getSelectedParts(),configTest);
	}
	@Test
	@DisplayName("Test du getSelected en essayant modifier la configuration get en lui ajoutant un element")
	public void getSelectedParts3() {
		assertThrows(UnsupportedOperationException.class, () -> configuration.getSelectedParts().add(partTypeEngineED180));
	}

	@Test
	@DisplayName("Test du selectPart en ajoutant un element null")
	public void selectPart1() {
		configuration.clear();
		PartType partTypeNull = null;
		assertThrows(IllegalArgumentException.class, () -> configuration.selectPart(partTypeNull));
		
	}
	@Test
	@DisplayName("Test du selectPart en ajoutant un element non null")
	public void selectPart2() {
		Set<PartType> configTest = new HashSet<PartType>();
		configTest.add(partTypeTransmissionTC120);
		configTest.add(partTypeEngineEG100);
		configuration.clear();
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTC120);
		
		
		assertEquals(configuration.getSelectedParts(),configTest);
	}
	@Test
	@DisplayName("Test du selectPart en ajoutant un element deja existant")
	public void selectPart3() {
		Set<PartType> configTest = new HashSet<PartType>();
		configTest.add(partTypeTransmissionTC120);
		
		configuration.selectPart(partTypeTransmissionTC120);
		configuration.selectPart(partTypeTransmissionTC120);
		
		assertEquals(configuration.getSelectedParts(),configTest);
		
	}
	@Test
	@DisplayName("Test du selectPart en ajoutant un element de categorie deja existante")
	public void selectPart4() {
		configuration.selectPart(partTypeTransmissionTC120);
		
		assertThrows(IllegalArgumentException.class, () -> configuration.selectPart(partTypeTransmissionTM5));
	}
	
	@Test
	@DisplayName("Test du unselectPartType en essayant d'enlever un element null")
	public void unselectPartType1 () {
		assertThrows(IllegalArgumentException.class, () -> configuration.unselectPartType(null));
	}
	@Test
	@DisplayName("Test du unselectPartType en essayant d'enlever un element present dans la config")
	public void unselectPartType2 () {
		Set<PartType> configTest = new HashSet<PartType>();
		configTest.add(partTypeTransmissionTC120);
		
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTC120);
		//configuration.selectPart(partTypeExteriorXC);
		
		configuration.unselectPartType(categoryEngine);
		//configuration.unselectPartType(categoryTransmission);
		
		assertEquals(configTest,configuration.getSelectedParts());
		
	}
	@Test
	@DisplayName("Test du unselectPartType en essayant d'enlever un element non present dans la config")
	public void unselectPartType3 () {
		Set<PartType> configTest = new HashSet<PartType>();
		configTest.add(partTypeEngineEG100);
		
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEG100);
		configuration.unselectPartType(categoryTransmission);
		
		assertEquals(configTest,configuration.getSelectedParts());
	}
		
	@Test
	@DisplayName("Test du getSelectionForCategory en essayant de get une categorie null")
	public void getSelectionForCategory1 () {
		assertThrows(IllegalArgumentException.class, () -> configuration.getSelectionForCategory(null));
	}
	@Test
	@DisplayName("Test du getSelectionForCategory en essayant de get une category d'une piece existante dans la config")
	public void getSelectionForCategory2 () {
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTC120);
		
		assertEquals(configuration.getSelectionForCategory(categoryTransmission),partTypeTransmissionTC120);
		
	}
	@Test
	@DisplayName("Test du getSelectionForCategory en essayant de get une category d'une piece non existante dans la config")
	public void getSelectionForCategory3 () {
		configuration.selectPart(partTypeEngineEG100);
		
		assertNull(configuration.getSelectionForCategory(categoryInterior));
		
	}
	
	@Test
	@DisplayName("Test du clear en essayant de clear une config avec des elements à l'interieur")
	public void clearWithElement () {
		Set<PartType> configTest = new HashSet<PartType>();
		configuration.selectPart(partTypeEngineEG100);
		configuration.clear();
		assertEquals(configuration.getSelectedParts(),configTest);
	}
	@Test
	@DisplayName("Test du clear en essayant de clear une config vide")
	public void clearEmptyConfig () {
		Set<PartType> configTest = new HashSet<PartType>();
		configuration.clear();
				 
		assertEquals(configuration.getSelectedParts(), configTest);
	}
	
	@Test
	@DisplayName("Test du isValid avec une config non valide a cause d'incompatibilities")
	public void isValidIncompatibilities1 () {
		
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTM6);
		configuration.selectPart(partTypeExteriorXM);
		configuration.selectPart(partTypeInteriorIN);
		
		
		assertEquals(configuration.isValid(),false);
	}
	@Test
	@DisplayName("Test du isValid avec une config valide")
	public void isValidIncompatibilities2 () {
	  		
		configuration.selectPart(partTypeEngineED180);
		assertEquals(configurator.getConfiguration().isValid(),true);
		
		
	}
	@Test
	@DisplayName("Test du isValid avec une config vide")
	public void isValidIncompatibilities3 () {
	  	
		assertEquals(configurator.getConfiguration().isValid(),true);
		
		
	}
	
	@Test
	@DisplayName("Test du isValid avec une config vide")
	public void isValidRequirement1 () {
		
		configuration.selectPart(partTypeEngineED180);

		assertEquals(configurator.getConfiguration().isValid(),true);
		
	}
	@Test
	@DisplayName("Test du isValid avec une config avec un probleme de requirement ")
	public void isValidRequirement2 () {
		
		configuration.selectPart(partTypeEngineEH120);
		configuration.selectPart(partTypeTransmissionTM6);
		assertEquals(configurator.getConfiguration().isValid(),false);
		
	}
	
	@Test
	@DisplayName("Test du isComplete en essayant de tester si une configuration est complete")
	public void isComplete1 () {
		
		configuration.selectPart(partTypeEngineED110);
		configuration.selectPart(partTypeTransmissionTM6);
		configuration.selectPart(partTypeExteriorXM);
		configuration.selectPart(partTypeInteriorIS);
		
		assertEquals(configuration.isComplete(),true);
		
	}
	@Test
	@DisplayName("Test du isComplete en essayant de tester si une configuration n'est pas complete")
	public void isComplete2 () {
		
		System.out.println(configuration.getSelectedParts());
		configuration.selectPart(partTypeEngineED110);
		configuration.selectPart(partTypeTransmissionTM6);
		configuration.selectPart(partTypeExteriorXM);

		assertEquals(configuration.isComplete(),false);
		
	}
}
