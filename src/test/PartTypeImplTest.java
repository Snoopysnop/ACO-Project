package test;

import static org.junit.jupiter.api.Assertions.*;


import fr.istic.nplouzeau.cartaylor.api.implementation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartTypeImplTest {
	CategoryImpl categoryEngine; 
	PartTypeImpl partTypeEngineEG100;

	
	@BeforeEach
	public void setUp() {
		categoryEngine = new CategoryImpl("Engine");
		partTypeEngineEG100 = new PartTypeImpl("EG100",categoryEngine);
	}
	@DisplayName("Test du getName")
	@Test
	void getName1() {
		assertEquals(partTypeEngineEG100.getName(),"EG100");
	}

	@DisplayName("Test du getCategory")
	@Test
	void getCategory1() {	
		assertEquals(partTypeEngineEG100.getCategory(),categoryEngine);
	}
}
