package controleur;

public class ControleurTemps extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur


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
}
