package controleur;

import java.io.IOException;

import modele.Animal;
import modele.Partie;
import modele.Personnage;
import modele.Robot;

public class ControleurJeu extends Controleur{
	
	private static boolean estCree = false;	
	private Partie partie;
	
	public ControleurJeu() {
		super(estCree);
		estCree = true;
	}
	
	public void delControleur() {
		estCree = false;
	}
	
	public void lancePartie(String type, String nom, boolean triche) {
		Personnage tamagotchi;
		if (type.equals(ControleurGeneral.TYPE[0])) {
			tamagotchi = new Robot(nom);
		} else {
			tamagotchi = new Animal(nom, type);
		}
		partie = new Partie(tamagotchi, triche);
		try {
			ControleurGeneral.ctrlFichier.enregistrerObjet(partie, partie.getId().toString() + "save", ControleurFichier.REP_SAUVEGARDE);
		} catch (IOException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de sauvegarde de la partie " + partie.getId().toString(), true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
	}
	
	
}
