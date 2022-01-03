package modele;

import controleur.ControleurGeneral;

public class ThreadJeu extends Thread {
	
	private boolean threadSuspendre = false;
	private boolean interuption = false;
	
	private final Runnable action;
	private int pause;
	
	
	public ThreadJeu(int pause, Runnable action) {
		super();
		this.pause = pause;
		this.action = action;
	}
	
	
	@Override
	public void run() {
		while (!interuption) {
			try {
				Thread.sleep(pause);
				if (threadSuspendre) synchronized(this) {while (threadSuspendre) wait();}
			} catch (InterruptedException err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de la mise en pause du Thread majCaracteristiques", true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			}
			if (!interuption) action.run();
		}
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
