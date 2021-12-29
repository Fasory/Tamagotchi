package controleur;

import java.io.IOException;
import java.util.UUID;

import modele.Animal;
import modele.Caracteristique;
import modele.Partie;
import modele.Personnage;
import modele.Robot;
import vue.menu.MenuDeJeu;
import vue.menu.Pause;
import vue.menu.SelecPartie;

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
			ControleurGeneral.ctrlConnexion.enregistrerCompte();
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
	
	public void sauvegardePartie()  {
		try {
			ControleurGeneral.ctrlFichier.enregistrerObjet(partie, partie.getId().toString() + ".save", ControleurFichier.REP_SAUVEGARDE);
			ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
		} catch (IOException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de sauvegarde de la partie " + partie.getId().toString() + ".save", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			ControleurGeneral.ctrlAffichage.afficherAlerte("general", "La sauvegarde a �chou�e.");
		}
	}
	
	public void mettrePause() {
		ControleurGeneral.ctrlTemps.threadJeuPause(true);
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Pause());
	}
	
	
	public void arreterPause() {
		ControleurGeneral.ctrlAffichage.menuPrecedent();
		ControleurGeneral.ctrlTemps.threadJeuPause(false);
	}
	
	public void rqtSupprimerPartie(String id) {
		try {
			ControleurGeneral.ctrlFichier.supprimerFichier(id + ".save", ControleurFichier.REP_SAUVEGARDE);
		} catch (Exception err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de suppression du fichier " + id + ".save", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		ControleurGeneral.ctrlConnexion.getCompte().supprPartieId(UUID.fromString(id));
		ControleurGeneral.ctrlConnexion.enregistrerCompte();
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new SelecPartie(ControleurGeneral.ctrlConnexion.getCompte().getPartiesId()), 1);
	}
}
