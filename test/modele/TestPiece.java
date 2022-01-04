package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPiece {

	//////////////////////////////
	//		Test Controleur		//
	//////////////////////////////
	
	@Test
	void testConstructeur1() {
		String expected_nom = "Jardin";
		Piece[] expected_pieces = new Piece[] { new Piece("Salon"), new Piece("Salle de Bain"), new Piece("Cuisine") };
		
		Piece testPiece = new Piece("Jardin", expected_pieces);
		
		assertNotNull(testPiece);
		assertEquals(expected_nom, testPiece.getNom());
		assertEquals(expected_pieces[0], testPiece.voirPiece(0));
		assertEquals(expected_pieces[1], testPiece.voirPiece(1));
		assertEquals(expected_pieces[2], testPiece.voirPiece(2));
	}
	
	@Test
	void testConstructeur2() {
		String expected_nom = "Jardin";
		
		Piece testPiece = new Piece("Jardin");
		
		assertNotNull(testPiece);
		assertEquals(expected_nom, testPiece.getNom());
		assertFalse(testPiece.existePiece(0));
		assertFalse(testPiece.existePiece(1));
		assertFalse(testPiece.existePiece(2));
		assertFalse(testPiece.existePiece(3));
	}
	
	//////////////////////////
	//		Test Getter		//
	//////////////////////////
	
	@Test
	public void testGetNom() {
		String expected_nom = "Jardin";

        Piece testPiece = new Piece("Jardin");

        // Cas sans erreur

        assertEquals(expected_nom,testPiece.getNom());

        // Cas avec erreur

        String notExpected_nom = "Jardin du voisin";
        assertNotEquals(notExpected_nom,testPiece.getNom());
	}
	
	//////////////////////////////
	//		Test Methodes		//
	//////////////////////////////
	
	@Test
	public void testAddLiens() {
		Piece testPiece1 = new Piece("Salon");
        Piece testPiece2 = new Piece("Jardin");
        
        // Test de la focntion
        
        testPiece1.addLiens(3, testPiece2, 1);
        assertEquals(testPiece1,testPiece2.voirPiece(1));
        assertEquals(testPiece2,testPiece1.voirPiece(3));
	}
	
	@Test
	public void testVoirPiece() {
		Piece exected_piece1 = new Piece("Salon");
		Piece exected_piece2 = new Piece("Salle de Bain");
		Piece exected_piece3 = new Piece("Cuisine");
		Piece exected_piece4 = new Piece("Chambre");
		
		Piece[] pieces = new Piece[] { exected_piece1, exected_piece2, exected_piece3, exected_piece4};
		Piece testPiece = new Piece("Salon",pieces);
		
		// Test de la foncton
		
		assertEquals(exected_piece1, testPiece.voirPiece(0));
		assertEquals(exected_piece2, testPiece.voirPiece(1));
		assertEquals(exected_piece3, testPiece.voirPiece(2));
		assertEquals(exected_piece4, testPiece.voirPiece(3));
	}
	
	@Test
	public void testExistePiece() {
		Piece exected_piece1 = new Piece("Salon");
		Piece exected_piece2 = new Piece("Salle de Bain");
		Piece exected_piece3 = new Piece("Cuisine");
		Piece exected_piece4 = new Piece("Chambre");
		
		Piece[] pieces = new Piece[] { exected_piece1, exected_piece2, exected_piece3, exected_piece4};
		Piece testPiece = new Piece("Salon",pieces);
		Piece testFalse = new Piece("Cuisine");
		
		// Test de la foncton
		
		assertTrue(testPiece.existePiece(0));
		assertTrue(testPiece.existePiece(1));
		assertTrue(testPiece.existePiece(2));
		assertTrue(testPiece.existePiece(3));
		
		assertFalse(testFalse.existePiece(2));
	}
	
	@Test
	public void testToString() {
		String expected_str = "Salon : Jardin, Salle de Bain, Cuisine, Chambre";
		
		Piece piece1 = new Piece("Jardin");
		Piece piece2 = new Piece("Salle de Bain");
		Piece piece3 = new Piece("Cuisine");
		Piece piece4 = new Piece("Chambre");
		
		Piece[] pieces = new Piece[] { piece1, piece2, piece3, piece4};
		Piece testPiece = new Piece("Salon",pieces);
		
		// Test de la fonction
		
		assertEquals(expected_str,testPiece.toString());
	}
}
