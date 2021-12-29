package controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

import modele.Compte;
import vue.menu.InscriptionConfirm;
import vue.menu.MenuPrincipal;
import vue.menu.ReinitialiserMdp;
import vue.menu.ReinitialiserMdpConfirm;

public class ControleurConnexion extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	
	private final int TAILLE_CODE = 6;
	
	private HashMap<String, Compte> lsCompte;
	private String code;
	private Compte compte;							// Compte de l'utilisateur
	private Compte compteTemp;

	public ControleurConnexion() {
		super(estCree);
		estCree = true;
		// Code null tant qu'il n'y a aucun code en cours d'utilisation
		code = null;
		compteTemp = null;
		// Compte null tant qu'aucune connexion est effectué
		compte = null;
		lsCompte = ControleurGeneral.ctrlFichier.getListeCompte();
		if (lsCompte.get(ControleurGeneral.NOM_ANONYME) == null) lsCompte.put(ControleurGeneral.NOM_ANONYME, new Compte(ControleurGeneral.NOM_ANONYME, ControleurGeneral.ctrlSecurite.hash(""), ControleurGeneral.ctrlSecurite.hash(""), UUID.fromString(ControleurGeneral.STR_UUID_ANONYME), new HashSet<UUID>()));
	}
	
	@Override
	public void delControleur() {
		if (estCree) {
			if (compte != null) deconnexion();
			estCree = false;
		}
	}
	
	/**
	 * Emmet une tentative de connexion
	 * 
	 * @param utilisateur - String représentant le nom de
	 * l'utilsateur
	 * @param mdp - String représentant le mot de passe saisie
	 * par l'utilisateur
	 */
	public void connexion(String utilisateur, String mdp) {
		if (utilisateur.equals("")) {
			if (mdp.equals("")) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre identifiant et votre mot de passe.");
			} else {
				ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre identifiant.");
			}
		} else if (mdp.equals("") && !utilisateur.equals(ControleurGeneral.NOM_ANONYME)) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre mot de passe.");
		} else {
			compte = lsCompte.get(utilisateur);
			if (compte != null && ControleurGeneral.ctrlSecurite.hash(mdp).equals(compte.getMdp())) {
				ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal(ControleurGeneral.ctrlJeu.peutCreerPartie()));
			} else {
				ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Votre identifiant ou votre mot de passe est incorret.");
				compte = null;
			}
		}
	}
	
	/**
	 * Perd le focus du compte ouvert
	 */
	public void deconnexion() {
		enregistrerCompte();
		compte = null;
	}
	
	
	public void inscription(String utilisateur, String mail, String mdp, String mdpConfirme, boolean verifMail) {
		boolean possibleInscription = true;
		// Vérification dque les champs soient remplis
		ControleurGeneral.ctrlAffichage.renitialiserMenu();
		// Identifiant
		if (utilisateur.equals("")) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("id", "Veuillez saisir un identifiant.");
			possibleInscription = false;
		}
		// Mail
		if (mail.equals("")) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Veuillez saisir une adresse e-mail.");
			possibleInscription = false;
		}
		// Mot de passe
		if (mdp.equals("")) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("mdp", "Veuillez saisir un mot de passe.");
			possibleInscription = false;
		}
		// Confirmation du mot de passe
		else if (mdpConfirme.equals("")) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("mdpConfirme", "Veuillez confirmer le mot de passe.");
			possibleInscription = false;
		}
		// Si remplis
		// Vérification de la conformité des champs
		if (possibleInscription) {
			// Identifiant
			if (utilisateur.equals("Anonyme")) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("id", "Cet identifiant est réservé.");
				possibleInscription = false;
			} else if (lsCompte.get(utilisateur) != null) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("id", "Identifiant déjà utilisé.");
				possibleInscription = false;
			}
			// Mail
			if (mail.contains(".@") || mail.contains("@.") || mail.contains("..")) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Adresse e-mail invalide.");
				possibleInscription = false;
			} else {
				byte cpt = 0;
			 	for (char c : mail.toCharArray()) {
			 		if (c == '@') cpt++;
			 		if (cpt > 1) break;
			 	}
			 	if (cpt != 1) {
			 		ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Adresse e-mail invalide.");
					possibleInscription = false;
			 	}
			}
			// Mot de passe
			if (mdp.length() < 6) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("mdp", "Au moins 6 caractères.");
				possibleInscription = false;
			}
			// Confirmation du mot de passe
			if (!mdpConfirme.equals(mdp)) {
				ControleurGeneral.ctrlAffichage.afficherAlerte("mdpConfirme", "Vérification invalide.");
				possibleInscription = false;
			}
		}
		// Si conformtité des champs
		// Vérification de l'adresse mail
		if (possibleInscription) {
			compteTemp = new Compte(utilisateur, ControleurGeneral.ctrlSecurite.hash(mdp), mail);
			genererCode();
			if (!verifMail) verificationCodeInscri(this.code);
			else {
				ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new InscriptionConfirm());
				String sujet = "Confirmation de création de compte";
				String contenu = "Bienvenue " + compteTemp.getUtilisateur() + ",\r\n"
						       + "\r\n"
						       + "Le monde des Tamagotchis n'est plus très loin !\r\n"
						       + "Veuillez saisir le code suivant pour finaliser votre inscription : " + code + "\r\n"
						       + "\r\n"
						       + "Bon jeu !";
				ControleurGeneral.ctrlTemps.threadEnvoieMail(sujet, contenu, compteTemp.getMail());
			}
		}
	}
	
	
	public void genererCode() {
		Random rng = new Random();
		code = "";
		for (int i = 0; i < TAILLE_CODE; i++) code += rng.nextInt(10);
	}
	
	
	public void verificationCodeInscri(String codeSaisie) {
		if (codeSaisie.equals(code)) {
			compte = new Compte(compteTemp.getUtilisateur(), compteTemp.getMdp(), ControleurGeneral.ctrlSecurite.hash(compteTemp.getMail()), compteTemp.getId(), compteTemp.getPartiesId());
			lsCompte.put(compte.getUtilisateur(), compte);
			compteTemp = null;
			ControleurGeneral.ctrlAffichage.fermerMenuConfirmation();
			ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal(ControleurGeneral.ctrlJeu.peutCreerPartie()), 1);
		} else {
			if (codeSaisie.equals("")) ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Veuillez saisir le code.");
			else ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Le code est invalide");
		}
	}
	
	
	public Compte getCompte() {
		return compte;
	}
	
	
	public void confirmationSuppressionCompte() {
		ControleurGeneral.ctrlAffichage.fermerMenuConfirmation();
		lsCompte.remove(compte.getUtilisateur());
		try {
			ControleurGeneral.ctrlFichier.supprimerFichier(compte.getId().toString() + ".usr", ControleurFichier.REP_JOUEUR);
		} catch (Exception err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de suppression du fichier " + compte.getId().toString() + ".usr", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		for (UUID id : compte.getPartiesId()) {
			if (id != null) {
				try {
					ControleurGeneral.ctrlFichier.supprimerFichier(id.toString() + ".save", ControleurFichier.REP_SAUVEGARDE);
				} catch (Exception err) {
					ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de suppression du fichier " + id.toString() + ".save", true);
					ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
				}
			} else {
				break;
			}
		}
		compte = null;
		ControleurGeneral.ctrlAffichage.menuPrecedent();
		ControleurGeneral.ctrlAffichage.menuPrecedent();
	}
	
	
	public boolean isAnonyme() {
		return compte.getUtilisateur().equals(ControleurGeneral.NOM_ANONYME);
	}
	
	
	public void reinitialiserMdp(String utilisateur, String mail) {
		compteTemp = lsCompte.get(utilisateur);
		if (utilisateur.equals(ControleurGeneral.NOM_ANONYME)) ControleurGeneral.ctrlAffichage.afficherAlerte("info", "Vous ne pouvez pas modifier le comtpe " + ControleurGeneral.NOM_ANONYME);
		else if (compteTemp == null || !compteTemp.getMail().equals(ControleurGeneral.ctrlSecurite.hash(mail))) ControleurGeneral.ctrlAffichage.afficherAlerte("info", "L'identifiant ou l'adresse e-mail sont incorrects.");
		else {
			ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new ReinitialiserMdpConfirm());
			genererCode();
			String sujet = "Réinitialisation du mot de passe";
			String contenu = "Bonjour " + utilisateur + ",\r\n"
					       + "\r\n"
					       + "Vous avez fait une demande de réinitialisation de mot de passe.\r\n"
					       + "Veuillez saisir le code suivant pour réinitialisé votre mot de passe : " + code + "\r\n"
					       + "\r\n"
					       + "Bon jeu !";
			ControleurGeneral.ctrlTemps.threadEnvoieMail(sujet, contenu, mail);
		}
	}
	
	
	public void verificationCodeMdp(String codeSaisie) {
		if (codeSaisie.equals(code)) {
			ControleurGeneral.ctrlAffichage.fermerMenuConfirmation();
			ControleurGeneral.ctrlAffichage.ouvrirMenu(new ReinitialiserMdp());
		} else {
			if (codeSaisie.equals("")) ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Veuillez saisir le code.");
			else ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Le code est invalide");
		}
	}
	
	public void verificationChangeMdp(String mdp, String mdpConfirm) {
		if (mdp.length() < 6) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("verif", "Au moins 6 caractères attendus.");
		} else if (!mdpConfirm.equals(mdp)) {
			ControleurGeneral.ctrlAffichage.afficherAlerte("verif", "Vérification invalide.");
		} else {
			compteTemp.setMdp(ControleurGeneral.ctrlSecurite.hash(mdp));
			try {
				ControleurGeneral.ctrlFichier.enregistrerObjet(compteTemp, compteTemp.getId().toString() + ".usr", ControleurFichier.REP_JOUEUR);
				lsCompte.put(compteTemp.getUtilisateur(), compteTemp);
				compteTemp = null;
				ControleurGeneral.ctrlAffichage.menuPrecedent(2);
				ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Mot de passe réinitialisé avec succès.");
			} catch (IOException err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec l'enregistrement du nouveau mot de passe pour le compte : " + compte.getId().toString(), true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			}
		}
	}
	
	public void enregistrerCompte() {
		if (compte != null) {
			try {
				ControleurGeneral.ctrlFichier.enregistrerObjet(compte, compte.getId().toString() + ".usr", ControleurFichier.REP_JOUEUR);
			} catch (IOException err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec l'enregistrement du Compte " + compte.getId().toString(), true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			}
		}
	}
}

