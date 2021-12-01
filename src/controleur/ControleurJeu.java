package controleur;

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
		if(type.equals(ControleurGeneral.TYPE[0])) {
			tamagotchi = new Robot(nom);
		}else {
			tamagotchi = new Animal(nom, type);
		}
		partie = new Partie(tamagotchi, triche);
		ControleurGeneral.ctrlFichier.enregistrer(partie, ControleurFichier.REP_SAUVEGARDE);
	}
	
	
}
