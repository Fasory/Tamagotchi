package controleur;

import java.util.Vector;

import modele.ThreadJeu;
import modele.ThreadJeuSecondaire;

public class ControleurTemps extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	private ThreadJeu threadJeu;
	private Vector<ThreadJeuSecondaire> threadJeuSecondaire;


	public ControleurTemps() {
		super(estCree);
		estCree = true;
		
		threadJeu = null;
		threadJeuSecondaire = new Vector<ThreadJeuSecondaire>();
	}
	
	@Override
	public void delControleur() {
		estCree = false;
	}
	
	public void threadEnvoieMail(String sujet, String contenu, String destinataire) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				if (!ControleurGeneral.envoyerMail(sujet, contenu, destinataire)) ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Echec de l'envoie du mail.");
		    }
		};
		thread.start();
	}
	
	public void threadMajCaracteristiques(int pause, Runnable action) {
		threadJeu = new ThreadJeu(pause, action);
		threadJeu.start();
	}
	
	public void addThreadJeu(int pause, Runnable action) {
		for (ThreadJeuSecondaire thread : threadJeuSecondaire) {
			if (thread.getState() == Thread.State.TERMINATED) threadJeuSecondaire.remove(thread);
		}
		threadJeuSecondaire.add(new ThreadJeuSecondaire(pause, action));
		threadJeuSecondaire.lastElement().start();
	}
	
	public void threadJeuPause(boolean pause) {
		if (pause) {
			threadJeu.suspendre();
			for (ThreadJeuSecondaire thread : threadJeuSecondaire) {
				if (thread.getState() == Thread.State.TERMINATED) threadJeuSecondaire.remove(thread);
				else thread.suspendre();
			}
		} else {
			threadJeu.reprendre();
			for (ThreadJeuSecondaire thread : threadJeuSecondaire) {
				if (thread.getState() == Thread.State.TERMINATED) threadJeuSecondaire.remove(thread);
				else thread.reprendre();
			}
		}
	}
	
	public void threadJeuKill() {
		threadJeu.interrupt();
		for (ThreadJeuSecondaire thread : threadJeuSecondaire) thread.interrupt();
		threadJeu = null;
		threadJeuSecondaire = new Vector<ThreadJeuSecondaire>();
	}
}
