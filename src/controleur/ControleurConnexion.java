package controleur;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import modele.Compte;
import vue.menu.InscriptionConfirm;
import vue.menu.MenuPrincipal;

public class ControleurConnexion extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	
	private final int TAILLE_CODE = 6;
	
	private HashMap<String, Compte> lsCompte;
	private String code;
	private Compte compte;							// Compte de l'utilisateur
	private Compte compteInscription;

	public ControleurConnexion() {
		super(estCree);
		estCree = true;
		// Code null tant qu'il n'y a aucun code en cours d'utilisation
		code = null;
		compteInscription = null;
		// Compte null tant qu'aucune connexion est effectué
		compte = null;
		lsCompte = ControleurGeneral.ctrlFichier.getListeCompte();
		if (lsCompte.get(ControleurGeneral.NOM_ANONYME) == null) lsCompte.put(ControleurGeneral.NOM_ANONYME, new Compte(ControleurGeneral.NOM_ANONYME, ControleurGeneral.ctrlSecurite.hash(""), ControleurGeneral.ctrlSecurite.hash(""), UUID.fromString(ControleurGeneral.STR_UUID_ANONYME), new UUID[0]));
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
				ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal());
			} else {
				ControleurGeneral.ctrlAffichage.afficherAlerte("general", "Votre identifiant ou votre mot de passe est incorret.");
			}
		}
	}
	
	/**
	 * Perd le focus du compte ouvert
	 */
	public void deconnexion() {
		ControleurGeneral.ctrlFichier.enregistrer(compte, ControleurFichier.REP_JOUEUR);
		compte = null;
		ControleurGeneral.ctrlAffichage.menuPrecedent();
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
			ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Veuillez saisir une adresse mail.");
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
				ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Adresse mail invalide.");
				possibleInscription = false;
			} else {
				byte cpt = 0;
			 	for (char c : mail.toCharArray()) {
			 		if (c == '@') cpt++;
			 		if (cpt > 1) break;
			 	}
			 	if (cpt != 1) {
			 		ControleurGeneral.ctrlAffichage.afficherAlerte("mail", "Adresse mail invalide.");
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
			compteInscription = new Compte(utilisateur, ControleurGeneral.ctrlSecurite.hash(mdp), mail);
			Random rng = new Random();
			code = "";
			for (int i = 0; i < TAILLE_CODE; i++) code += rng.nextInt(10);
			if (!verifMail) verificationCode(this.code);
			else {
				ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new InscriptionConfirm());
				confirmationInscription();
			}
		}
	}
	
	
	public void confirmationInscription() {
		String sujet = "Confirmation de création de compte";
		String contenu = "Bienvenue " + compteInscription.getUtilisateur() + ",\r\n"
				       + "\r\n"
				       + "Le monde des Tamagotchis n'est plus très loin !\r\n"
				       + "Veuillez saisir le code suivant pour finaliser votre inscription : " + code + "\r\n"
				       + "\r\n"
				       + "Bon jeu !";
		if (!ControleurGeneral.envoyerMail(sujet, contenu, compteInscription.getMail())) ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Echec de l'envoie du mail.");
	}
	
	
	public void verificationCode(String codeSaisie) {
		if (codeSaisie.equals(code)) {
			compte = new Compte(compteInscription.getUtilisateur(), compteInscription.getMdp(), ControleurGeneral.ctrlSecurite.hash(compteInscription.getMail()), compteInscription.getId(), compteInscription.getPartiesId());
			lsCompte.put(compte.getUtilisateur(), compte);
			compteInscription = null;
			ControleurGeneral.ctrlAffichage.fermerMenuConfirmation();
			ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal(), 1);
		} else {
			if (codeSaisie.equals("")) ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Veuillez saisir le code.");
			else ControleurGeneral.ctrlAffichage.afficherAlerteConfirmation("Le code est invalide");
		}
	}
}
