package modele;

import controleur.ControleurGeneral;

public class ThreadJeuSecondaire extends Thread {
	
	private boolean threadSuspendre = false;
	
	private final Runnable action;
	private long pause;
	
	
	public ThreadJeuSecondaire(int pause, Runnable action) {
		super();
		this.pause = pause*10;	// Car on effectue les pauses durant 100ms par 100ms
		this.action = action;
	}
	
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < pause; i++) {
				Thread.sleep(100);
				if (threadSuspendre) synchronized(this) {
					while (threadSuspendre) wait();
					if (isInterrupted()) break;
				}
			}
		} catch (InterruptedException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de la mise en pause du Thread majCaracteristiques", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		action.run();
    }
	
	
	@Override
	public void interrupt() {
		reprendre();
		super.interrupt();
	}
	
	
	public void suspendre() {
		threadSuspendre = true;
	}
	
	
	public synchronized void reprendre() {
		threadSuspendre = false;
		notify();
	}
}
