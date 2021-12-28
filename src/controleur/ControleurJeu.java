package controleur;

import java.io.IOException;

import modele.Animal;
import modele.Caracteristique;
import modele.Partie;
import modele.Personnage;
import modele.Robot;
import vue.menu.MenuDeJeu;

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
	
	public void lancePartie(String id) {
		try {
			partie = (Partie) ControleurGeneral.ctrlFichier.chargerObjet(id + ".save", ControleurFichier.REP_SAUVEGARDE);
			start();
		} catch (Exception err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de chargmeent de la partie " + id  + ".save", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
	}
	
	public void lancePartie(String type, String nom, boolean triche) {
		Personnage tamagotchi;
		if (type.equals(Robot.class.getSimpleName())) {
			tamagotchi = new Robot(nom);
		} else {
			tamagotchi = new Animal(nom, type);
		}
		partie = new Partie(tamagotchi, triche);
		try {
			ControleurGeneral.ctrlFichier.enregistrerObjet(partie, partie.getId().toString() + ".save", ControleurFichier.REP_SAUVEGARDE);
		} catch (IOException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de sauvegarde de la partie " + partie.getId().toString() + ".save", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		ControleurGeneral.ctrlConnexion.getCompte().addPartie(partie.getId());
		ControleurGeneral.ctrlConnexion.enregistrerCompte();
		start();
	}
	
	
	public void start() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuDeJeu(partie.getTamagotchi()), 1);
		majAffichage();
		ControleurGeneral.ctrlTemps.threadMajCaracteristiques(ControleurGeneral.TEMPS_MAJ, new Runnable() {
			@Override
			public void run() {
				majCaracteristiques();
			}
		});
	}
	
	
	private MenuDeJeu getMenu() {
		return (MenuDeJeu) ControleurGeneral.ctrlAffichage.getMenu();
	}
	
	
	public boolean peutCreerPartie() {
		return ControleurGeneral.ctrlConnexion.getCompte().getPartiesId().size() < ControleurGeneral.NB_MAX_PARTIE;
	}
	
	
	public void rqtAction(String clef) {
		Caracteristique caracteristique = partie.getTamagotchi().getCaracteristique(clef);
		caracteristique.add((float) ((caracteristique.getMax()-caracteristique.getMin())*0.15));
		// Update Affichage
		majAffichage();
	}
	
	
	public void majCaracteristiques() {
		// Update Caracteristiques
		partie.getTamagotchi().cycleVie(partie.getTamagotchi().reglesVie());
		// Update Affichage
		majAffichage();
	}
	
	public void majAffichage() {
		getMenu().setAll(partie.getTamagotchi().getCaracteristiques(), partie.getTamagotchi().getVie());
	}
}
