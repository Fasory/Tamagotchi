package modele;

import controleur.ControleurGeneral;

public class ThreadJeuSecondaire extends Thread {
	
	private boolean threadSuspendre = false;
	private boolean interuption = false;

	private final long PRECISION = 100;
	private final Runnable action;
	private final long pause;
	private final boolean repeat;
	
	
	public ThreadJeuSecondaire(int pause, Runnable action) {
		this(pause, action, false);
	}
	
	
	public ThreadJeuSecondaire(int pause, Runnable action, boolean repeat) {
		super();
		this.pause = pause;	// Car on effectue les pauses durant 100ms par 100ms
		this.action = action;
		this.repeat = repeat;
	}
	
	
	@Override
	public void run() {
		do {
			try {
				for (int i = 0; i < pause; i += PRECISION) {
					Thread.sleep(PRECISION);
					if (threadSuspendre) synchronized(this) {
						while (threadSuspendre) wait();
						if (interuption) break;
					}
				}
			} catch (InterruptedException err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de la mise en pause du Thread majCaracteristiques", true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			}
			if (!interuption) action.run();
		} while(repeat && !interuption);
    }
	
	
	@Override
	public void interrupt() {
		reprendre();
		interuption = true;
	}
	
	
	public void suspendre() {
		threadSuspendre = true;
	}
	
	
	public synchronized void reprendre() {
		threadSuspendre = false;
		notify();
	}
}
