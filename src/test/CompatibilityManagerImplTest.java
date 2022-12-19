package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.implementation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompatibilityManagerImplTest {

		Set<PartType> setIncompatibilities ;
		Set<PartType> setRequirements;
		
		
		CategoryImpl categoryEngine,categoryTransmission, categoryExterior, categoryInterior;

		PartTypeImpl partTypeEngineEG100, partTypeEngineEG133, partTypeEngineEG210, partTypeEngineED110, partTypeEngineED180, partTypeEngineEH120;
		PartTypeImpl partTypeTransmissionTM5, partTypeTransmissionTM6, partTypeTransmissionTA5, partTypeTransmissionTS6, partTypeTransmissionTSF7, partTypeTransmissionTC120; 
	  	PartTypeImpl partTypeExteriorXC, partTypeExteriorXM, partTypeExteriorXS;
	  	PartTypeImpl partTypeInteriorIN, partTypeInteriorIH, partTypeInteriorIS; 
	 
	  	CompatibilityManagerImpl manager;
	 
	@BeforeEach
	public void setUp() {

		
		manager = new CompatibilityManagerImpl();
		
		setIncompatibilities = new HashSet<>();
		setRequirements = new HashSet<>();	
		
		categoryEngine = new CategoryImpl("Engine");
		categoryTransmission = new CategoryImpl("Transmission");
		categoryExterior = new CategoryImpl("Exterior");
		categoryInterior = new CategoryImpl("Interior");
				
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
	}
	
	
	
	
	
	@DisplayName("Test du getIncompatibilities qui get une incompatibility existante ")
	@Test
	void getIncompatibilities1() {
		Set<PartType> setIncompatibilitiesTest = new HashSet<>();
		setIncompatibilitiesTest.add(partTypeTransmissionTA5);
		
		setIncompatibilities.add(partTypeTransmissionTA5);
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities);
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),setIncompatibilitiesTest);
	}
	@DisplayName("Test du getIncompatibilities qui get une incompatibility nulle ")
	@Test
	void getIncompatibilities2() {
		
		assertThrows(IllegalArgumentException.class, () -> manager.getIncompatibilities(null));
	}
	@DisplayName("Test du getIncompatibilities qui get une incompatibility non existante ou qui possede une liste d'incompatibilities vide")
	@Test
	void getIncompatibilities3() {
		
		manager.addIncompatibilities(partTypeEngineEG133, setIncompatibilities);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),new HashSet<>());
		
	}
	
	@DisplayName("Test du getRequirements en testant de get un requirement existant & en testant d'ajouter un element a partir du get")
	@Test
	void getRequirements1() {
		Set<PartType> setRequirementsTest = new HashSet<>();
		setRequirementsTest.add(partTypeTransmissionTA5);
		
		setRequirements.add(partTypeTransmissionTA5);
		manager.addRequirements(partTypeEngineEG100, setRequirements);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),setRequirements);
		assertThrows(UnsupportedOperationException.class, () -> manager.getRequirements(partTypeEngineEG100).add(partTypeEngineEG133));
	}
	@DisplayName("Test du getRequirements qui get un requirement null ")
	@Test
	void getRequirements2() {
		
		assertThrows(IllegalArgumentException.class, () -> manager.getRequirements(null));
		
	}
	@DisplayName("Test du getRequirements qui get un requirement non existant ou qui possede une liste de requirements vide & en testant d'ajouter un element a partir du get")
	@Test
	void getRequirements3() {
		
		manager.addRequirements(partTypeEngineEG133, setIncompatibilities);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),new HashSet<>());
		assertThrows(UnsupportedOperationException.class, () -> manager.getRequirements(partTypeEngineEG100).add(partTypeEngineEG133));
	}
	
	
	@DisplayName("Test du addIncompatibilities qui add une Incompatibilitie non presente dans la table")
	@Test
	void addIncompatibilities1() {
		HashMap<PartType,Set<PartType>> tableIncTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> set = new HashSet<>();
		set.add(partTypeExteriorXM);
		tableIncTest.put(partTypeEngineEG100, set);
		
		setIncompatibilities.add(partTypeExteriorXM);
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities);
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),tableIncTest.get(partTypeEngineEG100));
	}
	@DisplayName("Test du addIncompatibilities qui add une Incompatibilitie avec une cle deja presente, un set deja present et un partType deja present dans la table")
	@Test
	void addIncompatibilities2() {
		HashMap<PartType,Set<PartType>> tableIncTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> setTest = new HashSet<>();
		setTest.add(partTypeExteriorXM);
		setTest.add(partTypeTransmissionTM5);
		setTest.add(partTypeTransmissionTA5);
		
		tableIncTest.put(partTypeEngineEG100, setTest);
		 
		
		setIncompatibilities.add(partTypeExteriorXM);
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities);
		
		Set<PartType> setIncompatibilities2 = new HashSet<>();
		setIncompatibilities2.add(partTypeTransmissionTM5);
		setIncompatibilities2.add(partTypeTransmissionTA5);
		
		
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities2);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),tableIncTest.get(partTypeEngineEG100));
		
		Set<PartType> setIncompatibilities3 = new HashSet<>();
		setIncompatibilities3.add(partTypeTransmissionTM5);
		
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities3);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),tableIncTest.get(partTypeEngineEG100));
	}
	@DisplayName("Test du addIncompatibilities qui essaye d'ajouter un parType null ou un set null")
	@Test
	void addIncompatibilities3() {
		Set<PartType> set = new HashSet<>();
		set.add(partTypeExteriorXM);
		
		assertThrows(IllegalArgumentException.class, () -> manager.addIncompatibilities(null,set));
		assertThrows(IllegalArgumentException.class, () -> manager.addIncompatibilities(partTypeTransmissionTS6,null));
	}
	
	@DisplayName("Test du removeIncompatibility quand on essaye de remove une reference null ou un target null ou quand on essaye "
			+ "de remove un parType d'une key qui n'existe pas")
	@Test
	void removeIncompatibility1() {
		
		assertThrows(IllegalArgumentException.class, () -> manager.removeIncompatibility(null,partTypeTransmissionTS6));
		assertThrows(IllegalArgumentException.class, () -> manager.removeIncompatibility(partTypeTransmissionTS6,null));
		assertThrows(IllegalArgumentException.class, () -> manager.removeIncompatibility(partTypeEngineEG100, partTypeTransmissionTM5));
	}
	@DisplayName("Test du removeIncompatibility quand on essaye de remove un parType d'une key qui existe puis on regarde si"
			+ " remove du meme PartType alors qu'il nexiste plus change quelquechose ou non")
	@Test
	void removeIncompatibility2() {
		HashMap<PartType,Set<PartType>> tableIncTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> setTest = new HashSet<>();
		setTest.add(partTypeExteriorXM);
		setTest.add(partTypeTransmissionTA5);
		
		tableIncTest.put(partTypeEngineEG100, setTest);
		 
		
		setIncompatibilities.add(partTypeExteriorXM);
		setIncompatibilities.add(partTypeTransmissionTM5);
		setIncompatibilities.add(partTypeTransmissionTA5);
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities);
		
		manager.removeIncompatibility(partTypeEngineEG100, partTypeTransmissionTM5);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),tableIncTest.get(partTypeEngineEG100));
		
		manager.removeIncompatibility(partTypeEngineEG100, partTypeTransmissionTM5);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),tableIncTest.get(partTypeEngineEG100));

	}
	@DisplayName("Test du removeIncompatibility quand on essaye de remove un parType laissant normalement un ensemble vide")
	@Test
	void removeIncompatibility3() {

		setIncompatibilities.add(partTypeExteriorXM);
		manager.addIncompatibilities(partTypeEngineEG100, setIncompatibilities);
		
		manager.removeIncompatibility(partTypeEngineEG100, partTypeExteriorXM);
		
		assertEquals(manager.getIncompatibilities(partTypeEngineEG100),new HashSet<>());
	}
	
	@DisplayName("Test du addRequirement qui add un requirement non present dans la table")
	@Test
	void addRequirement1() {
		HashMap<PartType,Set<PartType>> tableReqTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> set = new HashSet<>();
		set.add(partTypeExteriorXM);
		tableReqTest.put(partTypeEngineEG100, set);
		
		setIncompatibilities.add(partTypeExteriorXM);
		manager.addRequirements(partTypeEngineEG100, setIncompatibilities);
		assertEquals(manager.getRequirements(partTypeEngineEG100),tableReqTest.get(partTypeEngineEG100));
	}
	@DisplayName("Test du addRequirement qui add un requirement avec une cle deja presente, un set deja present et un partType deja present dans la table")
	@Test
	void addRequirement2() {
		HashMap<PartType,Set<PartType>> tableReqTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> setTest = new HashSet<>();
		setTest.add(partTypeExteriorXM);
		setTest.add(partTypeTransmissionTM5);
		setTest.add(partTypeTransmissionTA5);
		
		tableReqTest.put(partTypeEngineEG100, setTest);
		 
		
		setRequirements.add(partTypeExteriorXM);
		manager.addRequirements(partTypeEngineEG100, setRequirements);
		
		Set<PartType> setRequirements2 = new HashSet<>();
		setRequirements2.add(partTypeTransmissionTM5);
		setRequirements2.add(partTypeTransmissionTA5);
		
		
		manager.addRequirements(partTypeEngineEG100, setRequirements2);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),tableReqTest.get(partTypeEngineEG100));
		
		Set<PartType> setRequirements3 = new HashSet<>();
		setRequirements3.add(partTypeTransmissionTM5);
		
		manager.addRequirements(partTypeEngineEG100, setRequirements3);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),tableReqTest.get(partTypeEngineEG100));
	}
	@DisplayName("Test du addRequirement qui essaye d'ajouter un parType null ou un set null")
	@Test
	void addRequirement3() {
		Set<PartType> set = new HashSet<>();
		set.add(partTypeExteriorXM);
		
		assertThrows(IllegalArgumentException.class, () -> manager.addRequirements(null,set));
		assertThrows(IllegalArgumentException.class, () -> manager.addRequirements(partTypeTransmissionTS6,null));
	}
	
	@DisplayName("Test du removeRequirement quand on essaye de remove une reference null ou un target null ou quand on essaye "
			+ "de remove un parType d'une key qui n'existe pas")
	@Test
	void removeRequirement1() {
		
		assertThrows(IllegalArgumentException.class, () -> manager.removeRequirement(null,partTypeTransmissionTS6));
		assertThrows(IllegalArgumentException.class, () -> manager.removeRequirement(partTypeTransmissionTS6,null));
		assertThrows(IllegalArgumentException.class, () -> manager.removeRequirement(partTypeEngineEG100, partTypeTransmissionTM5));
	}
	@DisplayName("Test du removeIncompatibility quand on essaye de remove un parType d'une key qui existe puis on regarde si"
			+ " remove du meme PartType alors qu'il nexiste plus change quelquechose ou non")
	@Test
	void removeRequirement2() {
		HashMap<PartType,Set<PartType>> tableReqTest = new HashMap<PartType,Set<PartType>>();
		Set<PartType> setTest = new HashSet<>();
		setTest.add(partTypeExteriorXM);
		setTest.add(partTypeTransmissionTA5);
		
		tableReqTest.put(partTypeEngineEG100, setTest);
		 
		
		setRequirements.add(partTypeExteriorXM);
		setRequirements.add(partTypeTransmissionTM5);
		setRequirements.add(partTypeTransmissionTA5);
		manager.addRequirements(partTypeEngineEG100, setRequirements);
		
		manager.removeRequirement(partTypeEngineEG100, partTypeTransmissionTM5);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),tableReqTest.get(partTypeEngineEG100));
		
		manager.removeRequirement(partTypeEngineEG100, partTypeTransmissionTM5);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),tableReqTest.get(partTypeEngineEG100));

	}
	@DisplayName("Test du removeRequirement quand on essaye de remove un parType laissant normalement un ensemble vide")
	@Test
	void removeRequirement3() {

		setRequirements.add(partTypeExteriorXM);
		manager.addRequirements(partTypeEngineEG100, setRequirements);
		
		manager.removeRequirement(partTypeEngineEG100, partTypeExteriorXM);
		
		assertEquals(manager.getRequirements(partTypeEngineEG100),new HashSet<>());
	}
}

