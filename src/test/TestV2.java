package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.istic.nplouzeau.cartaylor.api.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.ED110;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.ED180;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.EG100;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.EG133;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.EG210;
import fr.istic.nplouzeau.cartaylor.api.implementation.engine.EH120;
import fr.istic.nplouzeau.cartaylor.api.implementation.exterior.XC;
import fr.istic.nplouzeau.cartaylor.api.implementation.exterior.XM;
import fr.istic.nplouzeau.cartaylor.api.implementation.exterior.XS;
import fr.istic.nplouzeau.cartaylor.api.implementation.interior.IH;
import fr.istic.nplouzeau.cartaylor.api.implementation.interior.IN;
import fr.istic.nplouzeau.cartaylor.api.implementation.interior.IS;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TA5;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TC120;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TM5;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TM6;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TS6;
import fr.istic.nplouzeau.cartaylor.api.implementation.transmission.TSF7;

public class TestV2 {

ConfiguratorImpl configurator;
	
	Set<Category> categories;
	Set<PartType> partTypes;
	
	CompatibilityManagerImpl manager;
	ConfigurationImpl configuration;
	
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
		
		partTypeEngineEG100 = new PartTypeImpl("EG100",EG100.class,categoryEngine);
		partTypeEngineEG133 = new PartTypeImpl("EG133",EG133.class,categoryEngine);
		partTypeEngineEG210 = new PartTypeImpl("EG210",EG210.class,categoryEngine);
		partTypeEngineED110 = new PartTypeImpl("ED110",ED110.class,categoryEngine);
		partTypeEngineED180 = new PartTypeImpl("ED180",ED180.class,categoryEngine);
		partTypeEngineEH120 = new PartTypeImpl("EH120",EH120.class,categoryEngine);
				
		partTypeTransmissionTM5 = new PartTypeImpl("TM5",TM5.class,categoryTransmission);
		partTypeTransmissionTM6 = new PartTypeImpl("TM6",TM6.class,categoryTransmission);
		partTypeTransmissionTA5 = new PartTypeImpl("TA5",TA5.class,categoryTransmission);
		partTypeTransmissionTS6 = new PartTypeImpl("TS6",TS6.class,categoryTransmission);
		partTypeTransmissionTSF7 = new PartTypeImpl("TSF7",TSF7.class,categoryTransmission);
		partTypeTransmissionTC120 = new PartTypeImpl("TC120",TC120.class,categoryTransmission);
		
		
		partTypeExteriorXC = new PartTypeImpl("XC",XC.class,categoryExterior);
		partTypeExteriorXM = new PartTypeImpl("XM",XM.class,categoryExterior);
		partTypeExteriorXS = new PartTypeImpl("XS",XS.class,categoryExterior);
	  	
	  	
		partTypeInteriorIN = new PartTypeImpl("IN",IN.class,categoryInterior);
		partTypeInteriorIH = new PartTypeImpl("IH",IH.class,categoryInterior);
		partTypeInteriorIS = new PartTypeImpl("IS",IS.class,categoryInterior);
		
		
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
		

			
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTM5);
		configuration.selectPart(partTypeExteriorXC);
		configuration.selectPart(partTypeInteriorIN);
		
	
		configuration.chooseColor("PURPLE");
		
		
	}
	
  	
  	@Test
	@DisplayName("test pour verifier qu'on ajoute bien une piece dans la configuration")
  	public void selectPart1() {
  		configuration.clear();
  		configuration.selectPart(partTypeEngineEG100);
  		Set<Part> parts = new HashSet<>();
  		PartImpl p = partTypeEngineEG100.newInstance();
  		p.setType(partTypeEngineEG100);
  		parts.add(p);

  		for(Part p2:parts) {
  			System.out.println("test selectPart1" );
  			System.out.println(p2.getType().getName());
  		}
  		for(Part p2:configuration.getSelectedParts()){
  			System.out.println(p2.getType().getName());
  		}
  	}	
  	
  	@Test
	@DisplayName("test pour verifier qu'on ne peut pas ajouter une piece d'une certaine categorie alors qu'une piece de cette categorie existe deja dans la configuration")
  	public void selectPart2() {
  		configuration.clear();
  		configuration.selectPart(partTypeEngineEG100);
  		assertThrows(IllegalArgumentException.class, () -> configuration.selectPart(partTypeEngineEG133));
  	}
  	
	@Test
	@DisplayName("test sur le prix d'une configuration valide et complete puis le prix de la config apres avoir enleve une piece")
	public void getPrice() {
		double price = 2000.0;
		assertEquals(configuration.getPrice(),price,0);
		configuration.unselectPartType(categoryEngine);
		price = 1000.0; //engine cost 1000.0 -> 2000.0 - 1000.0 = 1000.0
		assertEquals(configuration.getPrice(),price,0);
	}
	@Test
	@DisplayName("isValid pour une configuration correcte")
	public void isValid1() {
		assertEquals(configuration.isValid(),true);
	}
	
	
	@Test
	@DisplayName("isValid pour une configuration incorre	cte : EG100 incompatible XM")
	public void isValid2() {	
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEG100);
		configuration.selectPart(partTypeTransmissionTM5);
		configuration.selectPart(partTypeExteriorXM);
		configuration.selectPart(partTypeInteriorIN);
		
		assertEquals(configuration.isValid(),false);
	}
	
	@Test
	@DisplayName("isValid pour une configuration incorrecte : EH120 a besoin de TC120")
	public void isValid3() {
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEH120);
		configuration.selectPart(partTypeTransmissionTM5);
		configuration.selectPart(partTypeExteriorXM);
		configuration.selectPart(partTypeInteriorIN);
		
		assertEquals(configuration.isValid(),false);
	}
	
	@Test
	@DisplayName("isValid pour une configuration correcte : EH120 et TC120 ensemble")
	public void isValid4() {
		configuration.clear();
		
		configuration.selectPart(partTypeEngineEH120);
		configuration.selectPart(partTypeTransmissionTC120);
		configuration.selectPart(partTypeExteriorXM);
		configuration.selectPart(partTypeInteriorIN);
		
		assertEquals(configuration.isValid(),true);
	}
	
	
	@Test
	@DisplayName("print le fichier html pour pouvoir le tester directement en le mettant dans un fichier html et en l'affichant dans un navigateur")
	public void printHtmlConfiguration() {
	//	System.out.print(configuration.printHtmlConfiguration());
	}
	
	@Test
	@DisplayName("on verifie qu'on a bien la piece associee a la category")
	public void getSelectionForCategory() {
		String s = configuration.getSelectionForCategory(categoryEngine).get().getType().getName();
		assertEquals(s,partTypeEngineEG100.getName());
	}
	
	@Test
	@DisplayName("test pour changer la couleur et check si la valeur est bien mis a jour")
  	public void changeColor() {
		configuration.chooseColor("BLUE");
		String color = configuration.getSelectionForCategory(categoryExterior).get().getProperty("color").get();
		assertEquals(color,"BLUE");
  	}
}
