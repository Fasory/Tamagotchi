package controleur;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestControleurFichier {
	
	private ControleurFichier ctrlFichier;
	private final static String PATH_REP_TEST = "REP_TEST";
	private final static File REP_TEST = new File(PATH_REP_TEST);
	
	@BeforeEach
	void preTest() throws Exception {
		ctrlFichier = new ControleurFichier();
		REP_TEST.mkdir();
	}
	
	@AfterEach
	void apresTest() throws Exception {
		ctrlFichier.delControleur();
		for (File file : REP_TEST.listFiles()) file.delete();
		REP_TEST.delete();
	}
	
	@Test
	void testGetFichier() {
		Assertions.assertEquals(REP_TEST, ControleurFichier.getFichier(PATH_REP_TEST));
	}
	
	@Test
	void testFichierExisteString() throws IOException {
		File test = new File(REP_TEST, "test.txt");
		Assertions.assertFalse(ControleurFichier.fichierExiste(test.getPath()));
		test.createNewFile();
		Assertions.assertTrue(ControleurFichier.fichierExiste(test.getPath()));
	}
	
	@Test
	void testFichierExisteFile() throws IOException {
		File test = new File(REP_TEST, "test.txt");
		Assertions.assertFalse(ControleurFichier.fichierExiste(test));
		test.createNewFile();
		Assertions.assertTrue(ControleurFichier.fichierExiste(test));
	}
	
	@Test
	void testLogsExiste() {
		Assertions.assertTrue(ctrlFichier.logsExiste());
	}
	
	@Test
	void testEnregistrerObjet_et_chargerObjet() throws Exception {
		final String NOM = "test";
		final String REF = "Hello Worlds !";
		ctrlFichier.enregistrerObjet(REF, NOM, REP_TEST);
		String result = (String) ctrlFichier.chargerObjet(NOM, REP_TEST);
		Assertions.assertEquals(REF, result);
		Assertions.assertNotEquals(REF+"sign", result);
	}
	
	@Test
	void testSupprimerFichier() throws Exception {
		final String NOM = "test.txt";
		File test = new File(REP_TEST, NOM);
		test.createNewFile();
		Assertions.assertTrue(test.exists());
		ctrlFichier.supprimerFichier(NOM, REP_TEST);
		Assertions.assertFalse(test.exists());
	}
}
