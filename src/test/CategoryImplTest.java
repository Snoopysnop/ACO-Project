package test;
import static org.junit.jupiter.api.Assertions.*;


import fr.istic.nplouzeau.cartaylor.api.implementation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryImplTest {

	CategoryImpl categoryTransmission; 
	
	@BeforeEach
	public void setUp() {
		categoryTransmission = new CategoryImpl("Transmission");
		
	}
	@DisplayName("Test du getName")
	@Test
	void getName1() {
		assertEquals(categoryTransmission.getName(),"Transmission");
	}
}
