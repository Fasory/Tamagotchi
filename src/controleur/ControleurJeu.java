package controleur;

import java.io.IOException;
import java.util.Hashtable;
import java.util.UUID;

import modele.Animal;
import modele.Caracteristique;
import modele.Partie;
import modele.Personnage;
import modele.Piece;
import modele.Robot;
import vue.menu.MenuDeJeu;
import vue.menu.MenuFin;
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
		Hashtable<String, Piece> maison = getMaison();
		if (type.equals(Robot.class.getSimpleName())) {
			tamagotchi = new Robot(nom, maison.get(ControleurGeneral.LIEN_PIECES[0][0]));
		} else {
			tamagotchi = new Animal(nom, type, maison.get(ControleurGeneral.LIEN_PIECES[0][0]));
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
				// Check en vie
				if (partie.getTamagotchi().getVie().getValeur() == 0) finPartie();
				else {
					// Update Caracteristiques
					partie.getTamagotchi().cycleVie(partie.getTamagotchi().reglesVie());
					// Update Affichage
					majAffichage();
				}
			}
		});
		ControleurGeneral.ctrlTemps.addThreadJeu(ControleurGeneral.TEMPS_VIEILLIR, new Runnable() {
			@Override
			public void run() {
				// Check en vie
				if (partie.getTamagotchi().getVie().getValeur() != 0) {
					// Update Caracteristiques
					partie.getTamagotchi().cycleAge();
					// Update Affichage
					majAffichage();
				}
			}
		}, true);
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
		//Baisse energie
		if (caracteristique.getNom()!="Energie") {
			Caracteristique energ = partie.getTamagotchi().getCaracteristique("Energie");
			energ.add(-5);
		}
		// Update Affichage
		majAffichage();
	}
	
	public void majAffichage() {
		getMenu().setAll(partie.getTamagotchi().getCaracteristiques(), partie.getTamagotchi().getVie(), partie.getTamagotchi().getAge());
	}
	
	
	/**
	 * Demande de changement de menu : Menu Fin
	 */
	public void finPartie() {
		ControleurGeneral.ctrlTemps.threadJeuKill();
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuFin(partie.getTamagotchi().getType(), partie.getTamagotchi().getNom(), (int) partie.getTamagotchi().getAge().getValeur()));
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
	
	private Hashtable<String, Piece> getMaison() {
		Hashtable<String, Piece> maison = new Hashtable<String, Piece>();
		for (String elt : ControleurGeneral.PIECE.keySet()) maison.put(elt, new Piece(elt));
		for (String[] elt : ControleurGeneral.LIEN_PIECES) maison.get(elt[0]).addLiens(Integer.parseInt(elt[1]), maison.get(elt[2]), Integer.parseInt(elt[3]));
		return maison;
	}
	
	public void rqtChangeLieu(int direction) {
		partie.getTamagotchi().changerDeLocalisation(direction);
		ControleurGeneral.ctrlAffichage.renitialiserMenu();
	}
	
	public Piece rqtGetLieu() {
		return partie.getTamagotchi().getLocalisation();
	}
}
