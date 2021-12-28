package controleur;

import modele.ThreadJeu;

public class ControleurTemps extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	private ThreadJeu threadJeu;


	public ControleurTemps() {
		super(estCree);
		estCree = true;
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
	
	public void threadJeuPause(boolean pause) {
		if (pause) threadJeu.suspendre();
		else threadJeu.reprendre();
	}
	
	public void threadJeuKill() {
		threadJeu.interrupt();
		threadJeu = null;
	}
}
