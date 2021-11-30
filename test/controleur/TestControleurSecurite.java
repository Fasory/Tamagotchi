package controleur;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestControleurSecurite {
	
	ControleurSecurite ctrlSecurite;
	
	@BeforeEach
	void preTest() throws Exception {
		ctrlSecurite = new ControleurSecurite();
	}
	
	@AfterEach
	void apresTest() throws Exception {
		ctrlSecurite.delControleur();
	}
	
	@Test
	void testHash() {
		String mot = "Hello world!";
		String hashAttentu = "c0535e4be2b79ffd93291305436bf889314e4a3faec05ecffcbb7df31ad9e51a";
		
		Assertions.assertEquals(hashAttentu, ctrlSecurite.hash(mot));
	}
	
	@Test
	void testChiffrement() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String motAttendu = "Hello world!";
		byte[] motOctet = motAttendu.getBytes();
		byte[] chiffrement = ctrlSecurite.crypter(motOctet);
		byte[] dechiffrement = ctrlSecurite.decrypter(chiffrement);
		
		Assertions.assertArrayEquals(motOctet, dechiffrement);
	}
	
	@Test
	void testLimiteDecrypter() {
		// Erreur pour tous tableaux d'octets qui ne sont pas un multiple de 16
		Assertions.assertAll(() -> {
			for (int i = 1; i < 16; i++) {
				byte randomOctet[] = new byte[i];
				Assertions.assertThrows(IllegalBlockSizeException.class, () -> ctrlSecurite.decrypter(randomOctet));
			}
		});
	}
}
