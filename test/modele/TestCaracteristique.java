package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCaracteristique {

    //////////////////////////////////////
    //        Test Constructeur     	//
    //////////////////////////////////////
	
	@Test
	public void testConstructeur1() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "Manger";
		float expected_min = 0;
		float expected_max = 100;
		float expected_delta = 100;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture","Manger",0,100,1);
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
	@Test
	public void testConstructeur2() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "Manger";
		float expected_min = 0;
		float expected_max = 100;
		float expected_delta = 100;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture","Manger",0,100);
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
	@Test
	public void testConstructeur3() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "";
		float expected_min = 0;
		float expected_max = 100;
		float expected_delta = 100;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture",0,100);
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
	@Test
	public void testConstructeur4() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "";
		float expected_min = 0;
		float expected_max = 999999;
		float expected_delta = 999999;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture",0);
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
	@Test
	public void testConstructeur5() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "Manger";
		float expected_min = 0;
		float expected_max = 999999;
		float expected_delta = 999999;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture","Manger",0);
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
	@Test
	public void testConstructeur6() {
		float expected_val = 59;
		String expected_nom = "Nourriture";
		String expected_modifieur = "Manger";
		float expected_min = -999999;
		float expected_max = 999999;
		float expected_delta = 999999+999999;
		
		Caracteristique testCaracteristique = new Caracteristique(59,"Nourriture","Manger");
		assertNotNull(testCaracteristique);
		assertEquals(expected_val,testCaracteristique.getValeur());
		assertEquals(expected_nom,testCaracteristique.getNom());
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		assertEquals(expected_min,testCaracteristique.getMin());
		assertEquals(expected_max,testCaracteristique.getMax());
		assertEquals(expected_delta,testCaracteristique.getDelta());
		assertTrue(testCaracteristique.getMin()<testCaracteristique.getMax());
		assertTrue(testCaracteristique.getValeur()<testCaracteristique.getMax()||testCaracteristique.getValeur()>testCaracteristique.getMin());
	}
	
    //////////////////////////////
    //        Test Getters     	//
    //////////////////////////////
	
	@Test
	public void testGetValeur() {
		float expected_val = 66;

        Caracteristique testCaracteristique = new Caracteristique(66,"Nourriture","Manger");

        // Cas sans erreur

        assertEquals(expected_val,testCaracteristique.getValeur());

        // Cas avec erreur

        float notExpected_val = 17;
        assertNotEquals(notExpected_val,testCaracteristique.getValeur());
	}
	
	@Test
	public void testGetNom() {
		String expected_nom = "Energie";

        Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir");

        // Cas sans erreur

        assertEquals(expected_nom,testCaracteristique.getNom());

        // Cas avec erreur

        String notExpected_nom = "Nourriture";
        assertNotEquals(notExpected_nom,testCaracteristique.getNom());
	}
	
	@Test
	public void testGetModifieur() {
		String expected_modifieur = "Dormir";

        Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir");

        // Cas sans erreur

        assertEquals(expected_modifieur,testCaracteristique.getModifieur());

        // Cas avec erreur

        String notExpected_modifieur = "Manger";
        assertNotEquals(notExpected_modifieur,testCaracteristique.getModifieur());
	}
	
	@Test
	public void testGetMin() {
		float expected_min = 0;

        Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0);

        // Cas sans erreur

        assertEquals(expected_min,testCaracteristique.getMin());

        // Cas avec erreur

        float notExpected_min = 7;
        assertNotEquals(notExpected_min,testCaracteristique.getMin());
	}
	
	@Test
	public void testGetMax() {
		float expected_max = 100;

        Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0,100);

        // Cas sans erreur

        assertEquals(expected_max,testCaracteristique.getMax());

        // Cas avec erreur

        float notExpected_max = 93;
        assertNotEquals(notExpected_max,testCaracteristique.getMax());
	}
	
	@Test
	public void testGetDelta() {
		float expected_delta = 100;

        Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0,100);

        // Cas sans erreur

        assertEquals(expected_delta,testCaracteristique.getDelta());

        // Cas avec erreur

        float notExpected_delta = 93;
        assertNotEquals(notExpected_delta,testCaracteristique.getDelta());
	}
	
	//////////////////////////////
	//		TEST METHODS		//
	//////////////////////////////
	
	@Test
	public void testSetValeur() {
		float expected_value = 56;
		
		Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0,100);
		
		// Cas sans erreur
		testCaracteristique.setValeur(56);
		assertEquals(expected_value, testCaracteristique.getValeur());
		
		// Cas avec erreur
		testCaracteristique.setValeur(77);
		assertNotEquals(expected_value, testCaracteristique.getValeur());
		
		// Condition methode
		testCaracteristique.setValeur(-15);
		assertTrue(testCaracteristique.getValeur()>=testCaracteristique.getMin()||testCaracteristique.getValeur()<=testCaracteristique.getMax());
		
		testCaracteristique.setValeur(667);
		assertTrue(testCaracteristique.getValeur()>=testCaracteristique.getMin()||testCaracteristique.getValeur()<=testCaracteristique.getMax());
	}
	
	@Test
	public void testSetModifieur() {
		String expected_modifieur = "Manger";
		
		Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0,100);
		
		//Cas sans erreur
		
		testCaracteristique.setModifieur("Manger");
		assertEquals(expected_modifieur,testCaracteristique.getModifieur());
		
		//Cas avec erreur
		
		String notExpected_modifieur = "Brancher";
		assertNotEquals(notExpected_modifieur, testCaracteristique.getModifieur());
	}
	
	@Test 
	public void testAdd() {
		float expected_value = 23;
		
		Caracteristique testCaracteristique = new Caracteristique(66,"Energie","Dormir",0,100);
		
		//Cas sans erreur
		
		testCaracteristique.add(-43);
		assertEquals(expected_value,testCaracteristique.getValeur());
		
		//Cas avec erreur
		
		float notExpected_value = 55;
		assertNotEquals(notExpected_value, testCaracteristique.getValeur());
	}
	
	@Test
	public void testEquals() {
		Caracteristique car1 = new Caracteristique(66, "Energie", "Dormir", 0, 100);
		Caracteristique car2 = new Caracteristique(66, "Energie", "Dormir", 0, 100);
		Caracteristique car3 = new Caracteristique(55, "Energie", "Dormir", 0, 100);
		
		//Cas sans erreur
		
		assertTrue(car1.equals(car2));
		
		//Cas avec erreur
		
		assertFalse(car1.equals(car3));
	}
	
	@Test
	public void testTranchePourcent() {
		float expected_valCrit = -3;
		float expected_valFaible = -2;
		float expected_valForte = -1;
		float expected_valNul = 0;
		
		Caracteristique testCaracteristique = new Caracteristique(88,"Energie","Dormir",0,100);
		
		// Cas sans erreur
		
		assertEquals(expected_valForte,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(65);
		assertEquals(expected_valNul,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(15);
		assertEquals(expected_valFaible,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(0);
		assertEquals(expected_valCrit,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		
		//Cas avec Erreur
		
		testCaracteristique.setValeur(88);
		assertNotEquals(expected_valCrit,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(65);
		assertNotEquals(expected_valFaible,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(15);
		assertNotEquals(expected_valNul,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
		testCaracteristique.setValeur(0);
		assertNotEquals(expected_valForte,testCaracteristique.tranchePourcent(0, -3, 25, -2, 75, -1));
	}
	
	@Test
	public void testRegressionPourcent() {
		float expected_valFaible = -3;
		float expected_valMoyen = -2;
		float expected_valForte = -1;
		
		Caracteristique testCaracteristique = new Caracteristique(88,"Energie","Dormir",0,100);
		
		// Cas sans erreur
		
		assertEquals(expected_valForte,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));
		testCaracteristique.setValeur(49);
		assertEquals(expected_valMoyen,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));
		testCaracteristique.setValeur(15);
		assertEquals(expected_valFaible,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));

		// Cas sans erreur
		
		testCaracteristique.setValeur(88);
		assertNotEquals(expected_valMoyen,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));
		testCaracteristique.setValeur(49);
		assertNotEquals(expected_valFaible,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));
		testCaracteristique.setValeur(15);
		assertNotEquals(expected_valForte,testCaracteristique.regressionPourcent(25, -3, 50, -2, -1));

	}
}
