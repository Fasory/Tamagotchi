package controleur;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
}
