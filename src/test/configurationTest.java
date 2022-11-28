package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import fr.istic.nplouzeau.cartaylor.api.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.CategoryImpl;
import fr.istic.nplouzeau.cartaylor.api.implementation.PartTypeImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class configurationTest {

	Set<PartType> config;
	CompatibilityChecker checker;
	CompatibilityManager manager;
	
	Set<PartType> incompatibilities;
	
	Set<PartType> incompatibilitiesTA5;
	Set<PartType> incompatibilitiesTSF7;
	Set<PartType> incompatibilitiesXC;
	Set<PartType> incompatibilitiesXM;
	Set<PartType> incompatibilitiesXS;
	Set<PartType> incompatibilitiesIS;
	
	Set<PartType> requirements;
	
	Set<PartType> requirementsEH120;
	Set<PartType> requirementsTC120;
	Set<PartType> requirementsXS;
	Set<PartType> requirementsIS;
	
	CategoryImpl categoryEngine;
	CategoryImpl categoryTransmission;
	CategoryImpl categoryExterior;
	CategoryImpl categoryInterior;
	
	PartTypeImpl partTypeEngineEG100;
	PartTypeImpl partTypeEngineEG133;
	PartTypeImpl partTypeEngineEG210;
	PartTypeImpl partTypeEngineED110;
	PartTypeImpl partTypeEngineED180;
	PartTypeImpl partTypeEngineEH120;
	
	
	
	PartTypeImpl partTypeTransmissionTM5; 
	PartTypeImpl partTypeTransmissionTM6; 
	PartTypeImpl partTypeTransmissionTA5; 
	PartTypeImpl partTypeTransmissionTS6; 
	PartTypeImpl partTypeTransmissionTS7; 
	PartTypeImpl partTypeTransmissionTC120; 
	
	
	
  	PartTypeImpl partTypeExteriorXC;
  	PartTypeImpl partTypeExteriorXM;
  	PartTypeImpl partTypeExteriorXS;
  	
  	
  	PartTypeImpl partTypeInteriorIN; 
  	PartTypeImpl partTypeInteriorIH; 
  	PartTypeImpl partTypeInteriorIS; 
	
  	
  	
	@BeforeEach
	public void setUp() {
		config= new HashSet<PartType>();
	  	
		categoryEngine = new CategoryImpl("Engine");
		categoryTransmission = new CategoryImpl("Transmission");
		categoryExterior = new CategoryImpl("Exterior");
		categoryInterior = new CategoryImpl("Interior");
		
		
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
		partTypeTransmissionTS7 = new PartTypeImpl("TS7",categoryTransmission);
		partTypeTransmissionTC120 = new PartTypeImpl("TC120",categoryTransmission);
		
		
		partTypeExteriorXC = new PartTypeImpl("XC",categoryExterior);
		partTypeExteriorXM = new PartTypeImpl("XM",categoryExterior);
		partTypeExteriorXS = new PartTypeImpl("XS",categoryExterior);
	  	
	  	
		partTypeInteriorIN = new PartTypeImpl("IN",categoryInterior);
		partTypeInteriorIH = new PartTypeImpl("IH",categoryInterior);
		partTypeInteriorIS = new PartTypeImpl("IS",categoryInterior);
		
		incompatibilitiesTA5 = new HashSet<PartType>();
		incompatibilitiesTSF7 = new HashSet<PartType>();
		incompatibilitiesXC = new HashSet<PartType>();
		incompatibilitiesXM = new HashSet<PartType>();
		incompatibilitiesXS = new HashSet<PartType>();
		incompatibilitiesIS = new HashSet<PartType>();
		
		incompatibilities = new HashSet<PartType>();
		requirements = new HashSet<PartType>();
		
		
		
		requirementsEH120 = new HashSet<PartType>();
		requirementsTC120 = new HashSet<PartType>();
		requirementsXS = new HashSet<PartType>();
		requirementsIS = new HashSet<PartType>();
		
//		manager.addRequirements(requirementsEH120, partTypeTransmissionTC120);
//		manager.addRequirements(requirementsTC120, partTypeEngineEH120);
//		manager.addRequirements(requirementsXS, partTypeInteriorIS);
//		manager.addRequirements(requirementsIS, partTypeExteriorXS);
		
		//use : Map<PartType,Set<PartType>> tableInc = new HashMap<PartType,Set<PartType>>();
		// Map<PartType,Set<PartType>> tableReq = new HashMap<PartType,Set<PartType>>();
		
		//attention, fail car on doit add dans tableInc et tableReq
		// on a juste a creer des Set<PartType> pour chaque incompatibilities
		
		// ex : incompatibilitiesTest = new HashSet<PartType>();
		// ( si possible add) incompatibilitiesTest.add  (PartType1); incompatibilitiesTest.add  (PartType2); ... ect

		
		manager.addIncompatibilities(partTypeEngineEG100,incompatibilitiesTA5);
		
		manager.addIncompatibilities(partTypeEngineEG100,incompatibilitiesTSF7);
		manager.addIncompatibilities(partTypeEngineEG133,incompatibilitiesTSF7);
		manager.addIncompatibilities(partTypeEngineED110,incompatibilitiesTSF7);
		
		manager.addIncompatibilities(partTypeEngineEG210,incompatibilitiesXC);
		
		manager.addIncompatibilities(partTypeEngineEG100,incompatibilitiesXM);
		
		manager.addIncompatibilities(partTypeEngineEG100,incompatibilitiesXS);
		
		manager.addIncompatibilities(partTypeEngineEG100,incompatibilitiesIS);
		manager.addIncompatibilities(partTypeTransmissionTM5,incompatibilitiesIS);
	}
	
	@Test
	public void isValid1 () {
	  	
	  	
		config.add(partTypeEngineED180);
		config.add(partTypeTransmissionTM6);
		config.add(partTypeExteriorXM);
		config.add(partTypeInteriorIN);
		
		
		
		
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
