package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import fr.istic.nplouzeau.cartaylor.api.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class configurationTest {
	ConfiguratorImpl configurator;
	
	Set<Category> categories;
	Set<PartType> partTypes;
	
	CompatibilityChecker checker;
	CompatibilityManager manager;
	
	Set<PartType> incompatibilitiesA, incompatibilitiesB, incompatibilitiesC, incompatibilitiesD;	
	Set<PartType> requirementTC120, requirementEH120, requirementIS, requirementXS;
	
	CategoryImpl categoryEngine,categoryTransmission, categoryExterior, categoryInterior;

	
	PartTypeImpl partTypeEngineEG100, partTypeEngineEG133, partTypeEngineEG210, partTypeEngineED110, partTypeEngineED180, partTypeEngineEH120 ;
	PartTypeImpl partTypeTransmissionTM5, partTypeTransmissionTM6, partTypeTransmissionTA5, partTypeTransmissionTS6, partTypeTransmissionTSF7, partTypeTransmissionTC120; 
  	PartTypeImpl partTypeExteriorXC, partTypeExteriorXM, partTypeExteriorXS;
  	PartTypeImpl partTypeInteriorIN, partTypeInteriorIH, partTypeInteriorIS; 
	
  	
	@BeforeEach
	public void setUp() {
		
		categories = new HashSet<Category>();
		partTypes = new HashSet<PartType>();
		
		
		categoryEngine = new CategoryImpl("Engine");
		categoryTransmission = new CategoryImpl("Transmission");
		categoryExterior = new CategoryImpl("Exterior");
		categoryInterior = new CategoryImpl("Interior");
		
		
		categories.add(categoryEngine);
		categories.add(categoryTransmission);
		categories.add(categoryExterior);
		categories.add(categoryInterior);
		
		
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
		partTypeTransmissionTSF7 = new PartTypeImpl("TS7",categoryTransmission);
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
		
		
		
		configurator = new ConfiguratorImpl(categories,partTypes);
		
		
		
		/* INCOMPATIBILITIES & REQUIREMENT */
		
		
		
		
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
		manager.addRequirements(partTypeExteriorXC,requirementIS);
		manager.addRequirements(partTypeInteriorIS,requirementXS);
			
		
		
		
	}
	
	@Test
	public void isValid1 () {
	  	
	  	
		configurator.getConfiguration().addConfig(partTypeEngineED180);
		configurator.getConfiguration().addConfig(partTypeTransmissionTM6);
		configurator.getConfiguration().addConfig(partTypeExteriorXM);
		configurator.getConfiguration().addConfig(partTypeInteriorIN);
		

		assertFalse(configurator.getConfiguration().isValid());
		
		
	}
	
	
	@Test
	public void isComplete1 () {
		
	}
	
	@Test
	public void getSelectedParts1 () {
		
	}
	
	@Test
	public void selectPart1 () {
		
	}
	
	@Test
	public void getSelectionForCategory1 () {
		
	}
	
	@Test
	public void unselectPartType1 () {
		
	}
	
	@Test
	public void clear1 () {
		
	}
}
