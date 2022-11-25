package test;

import java.util.HashSet;
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
	Set<PartType> requirements;
	
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
		
		incompatibilities = new HashSet<PartType>();
		requirements = new HashSet<PartType>();
		 
//		partTypeEngineEG100
//		manager.addIncompatibilities(partTypeExteriorXS, );
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
