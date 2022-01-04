package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPartie {

	//////////////////////////////////
	//		Test Constructeur		//
	//////////////////////////////////
	
	@Test
	public void testConstructeur1(){
		boolean expected_triche = true;
		Piece piece = new Piece("Salon");
		Animal expected_personnage = new Animal("perso","Dinosaure",piece);
		
		Partie partieTest = new Partie(expected_personnage, true);
		assertNotNull(partieTest);
		assertEquals(expected_triche, partieTest.getTriche());
		assertEquals(expected_personnage, partieTest.getTamagotchi());
	}
	
	//////////////////////////////
	//		Test Getters		//
	//////////////////////////////
	
	@Test
	public void testGetTamagotchi() {
		Piece piece = new Piece("Salon");
		Animal expected_personnage = new Animal("perso","Dinosaure",piece);

		Partie partieTest = new Partie(expected_personnage, true);

        // Cas sans erreur

        assertEquals(expected_personnage,partieTest.getTamagotchi());

        // Cas avec erreur

        Animal notExpected_personnage = new Animal("Roger", "Lapin", piece);
        assertNotEquals(notExpected_personnage,partieTest.getTamagotchi());
	}
	@Test
	public void testGetTriche() {
		Piece piece = new Piece("Salon");
		Animal expected_personnage = new Animal("perso","Dinosaure",piece);
		boolean expected_bool = true;

		Partie partieTest = new Partie(expected_personnage, true);

        // Cas sans erreur

        assertEquals(expected_bool,partieTest.getTriche());

        // Cas avec erreur

        boolean notExpected_bool = false;
        assertNotEquals(notExpected_bool,partieTest.getTriche());
	}
}
