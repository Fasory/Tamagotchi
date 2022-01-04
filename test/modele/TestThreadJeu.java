package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestThreadJeu {
	
	private final int PAUSE = 30;
	private final int PAUSE_THREAD = 10;
	private int cpt;

	@BeforeEach
	void preTest() throws Exception {
		cpt = 0;
	}

	@Test
	void testInterrupt() throws InterruptedException {
		ThreadJeu test = new ThreadJeu(PAUSE_THREAD, new Runnable() {
			@Override
			public void run() {
				cpt++;
			}
		});
		test.start();
		test.interrupt();
		Thread.sleep(PAUSE);
		assertEquals(Thread.State.TERMINATED, test.getState());
	}

	@Test
	void testThreadJeu() throws InterruptedException {
		ThreadJeu test = new ThreadJeu(PAUSE_THREAD, new Runnable() {
			@Override
			public void run() {
				cpt++;
			}
		});
		test.start();
		Thread.sleep(PAUSE);
		test.interrupt();
		assertTrue(PAUSE/PAUSE_THREAD-1 <= cpt);
	}

	@Test
	void testSuspendre_et_Reprendre() throws InterruptedException {
		ThreadJeu test = new ThreadJeu(PAUSE_THREAD, new Runnable() {
			@Override
			public void run() {
				cpt++;
			}
		});
		test.start();
		Thread.sleep(PAUSE);
		test.suspendre();
		Thread.sleep(PAUSE);
		int temp = cpt;
		Thread.sleep(PAUSE);
		assertEquals(temp, cpt);
		test.reprendre();
		Thread.sleep(PAUSE);
		test.interrupt();
		assertNotEquals(temp, cpt);
	}

}
