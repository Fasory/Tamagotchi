package controleur;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestControleurAudio {
	
	private ControleurAudio ctrlAudio;

	@BeforeEach
	void preTest() throws Exception {
		ctrlAudio = new ControleurAudio();
	}

	@AfterEach
	void apresTest() throws Exception {
		ctrlAudio.delControleur();
	}

	@Test
	void testGetVolume() {
		Assertions.assertEquals(50, ctrlAudio.getVolume());
	}

	@Test
	void testGetMusique() {
		Assertions.assertEquals(50, ctrlAudio.getMusique());
	}

	@Test
	void testSetVolume() {
		final int REF = 75;
		Assertions.assertNotEquals(REF, ctrlAudio.getVolume());
		ctrlAudio.changeVolume(REF);
		Assertions.assertEquals(REF, ctrlAudio.getVolume());
	}

	@Test
	void testSetMusique() {
		final int REF = 75;
		Assertions.assertNotEquals(REF, ctrlAudio.getMusique());
		ctrlAudio.changeMusique(REF);
		Assertions.assertEquals(REF, ctrlAudio.getMusique());
	}

	@Test
	void testLimiteVolume() {
		final int REF = 5000;
		Assertions.assertNotEquals(REF, ctrlAudio.getVolume());
		ctrlAudio.changeVolume(REF);
		Assertions.assertEquals(100, ctrlAudio.getVolume());
		final int REF_2 = -5000;
		ctrlAudio.changeVolume(REF_2);
		Assertions.assertEquals(0, ctrlAudio.getVolume());
	}

	@Test
	void testLimiteMusique() {
		final int REF = 5000;
		Assertions.assertNotEquals(REF, ctrlAudio.getMusique());
		ctrlAudio.changeMusique(REF);
		Assertions.assertEquals(100, ctrlAudio.getMusique());
		final int REF_2 = -5000;
		ctrlAudio.changeMusique(REF_2);
		Assertions.assertEquals(0, ctrlAudio.getMusique());
	}
}
