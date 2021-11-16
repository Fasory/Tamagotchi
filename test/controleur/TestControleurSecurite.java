package controleur;

import java.nio.charset.StandardCharsets;

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
		ctrlSecurite.delControleurSecurite();
	}
	
	@Test
	void testHash() {
		String mot = "Hello world!";
		String hashAttentu = "c0535e4be2b79ffd93291305436bf889314e4a3faec05ecffcbb7df31ad9e51a";
		
		Assertions.assertEquals(hashAttentu, ctrlSecurite.hash(mot));
	}
	
	@Test
	void testChiffrement() {
		String motAttendu = "Hello world!";
		byte[] chiffrement = ctrlSecurite.crypter(motAttendu.getBytes());
		String chiffrementStr = new String(chiffrement, StandardCharsets.UTF_8);
		System.out.println(chiffrement.length);
		System.out.println(chiffrementStr.getBytes().length);
		System.out.println(chiffrementStr);
		System.out.println(chiffrementStr.length());
		byte[] t = new byte[16];
		for (int i = 0; i < 16; i++) {
			t[i] = (byte)chiffrementStr.charAt(i);
		}
		Assertions.assertEquals(motAttendu, new String(ctrlSecurite.decrypter(chiffrementStr.getBytes(StandardCharsets.UTF_8))));
	}
}
