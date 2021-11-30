package controleur;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Compte;

class TestControleurFichier {
	
	ControleurFichier ctrlFichier;
	
	@BeforeEach
	void preTest() throws Exception {
		ctrlFichier = new ControleurFichier();
	}
	
	@AfterEach
	void apresTest() throws Exception {
		ctrlFichier.delControleur();
	}
	
	/**
	 * Vérification de la bonne écriture et lecture d'otctets
	 * stockés dans un ficher
	 * 
	 * @throws IOException
	 */
	@Test
	void testLectureEcriture() throws IOException {
		File fichierTest = new File("fichierTest");
		byte attendu[] = {1,2,3,4,5,6,7,8,9,10};
		ctrlFichier.ecrireFichier(fichierTest, attendu);
		byte contenu[] = ctrlFichier.lireFichier(fichierTest);
		
		Assertions.assertArrayEquals(attendu, contenu);
	}
	
	/**
	 * Vérification de la bonne décomposition et reconstitution
	 * d'un String stocké par octet dans un fichier
	 * 
	 * @throws IOException
	 */
	@Test
	void testLectureEcritureCompte() throws IOException {
		File fichierTest = new File("fichierTest");
		Compte compte = new Compte("Test", "f4f263e439cf40925e6a412387a9472a6773c2580212a4fb50d224d3a817de17", "00d8d3f11739d2f3537099982b4674c29fc59a8fda350fca1379613adbb09119", UUID.fromString("00000000-0000-0000-0000-000000000000"), new UUID[0]);
		String attendu = compte.toString();
		ctrlFichier.ecrireFichier(fichierTest, attendu.getBytes());
		byte contenu[] = ctrlFichier.lireFichier(fichierTest);
		
		Assertions.assertEquals(attendu, new String(contenu));
	}
}
