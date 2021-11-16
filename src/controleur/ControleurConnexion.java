package controleur;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import vue.menu.InscriptionConfirm;
import vue.menu.MenuPrincipal;
import vue.modele.Compte;
import vue.modele.Partie;

public class ControleurConnexion extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	private final int TAILLE_CODE = 6;
	
	private HashMap<String, Compte> lsCompte;
	private String code;
	private Compte compteInscription;

	public ControleurConnexion() {
		super(estCree);
		estCree++;
		// Code null tant qu'il n'y a aucun code en cours d'utilisation
		code = null;
		compteInscription = null;
		// Compte null tant qu'aucune connexion est effectué
		compte = null;
		lsCompte = ctrlFichier.getListeCompte();
		if (lsCompte.get(NOM_ANONYME) == null) lsCompte.put(NOM_ANONYME, new Compte(NOM_ANONYME, ctrlSecurite.hash(""), ctrlSecurite.hash(""), UUID.fromString(STR_UUID_ANONYME), new HashMap<UUID, Partie>(NB_MAX_PARTIE)));
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
				ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre identifiant et votre mot de passe.");
			} else {
				ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre identifiant.");
			}
		} else if (mdp.equals("") && !utilisateur.equals(NOM_ANONYME)) {
			ctrlAffichage.afficherAlerte("general", "Veuillez saisir votre mot de passe.");
		} else {
			compte = lsCompte.get(utilisateur);
			if (compte != null && ctrlSecurite.hash(mdp).equals(compte.getMdp())) {
				ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal(this));
			} else {
				ctrlAffichage.afficherAlerte("general", "Votre identifiant ou votre mot de passe est incorret.");
			}
		}
	}
	
	/**
	 * Perd le focus du compte ouvert
	 */
	public void deconnexion() {
		ctrlFichier.enregistreCompte(compte);
		compte = null;
		ctrlAffichage.menuPrecedent();
	}
	
	
	public void inscription(String utilisateur, String mail, String mdp, String mdpConfirme) {
		boolean possibleInscription = true;
		// Vérification dque les champs soient remplis
		ctrlAffichage.renitialiserMenu();
		// Identifiant
		if (utilisateur.equals("")) {
			ctrlAffichage.afficherAlerte("id", "Veuillez saisir un identifiant.");
			possibleInscription = false;
		}
		// Mail
		if (mail.equals("")) {
			ctrlAffichage.afficherAlerte("mail", "Veuillez saisir une adresse mail.");
			possibleInscription = false;
		}
		// Mot de passe
		if (mdp.equals("")) {
			ctrlAffichage.afficherAlerte("mdp", "Veuillez saisir un mot de passe.");
			possibleInscription = false;
		}
		// Confirmation du mot de passe
		else if (mdpConfirme.equals("")) {
			ctrlAffichage.afficherAlerte("mdpConfirme", "Veuillez confirmer le mot de passe.");
			possibleInscription = false;
		}
		// Si remplis
		// Vérification de la conformité des champs
		if (possibleInscription) {
			// Identifiant
			if (utilisateur.equals("Anonyme")) {
				ctrlAffichage.afficherAlerte("id", "Cet identifiant est réservé.");
				possibleInscription = false;
			} else if (lsCompte.get(utilisateur) != null) {
				ctrlAffichage.afficherAlerte("id", "Identifiant déjà utilisé.");
				possibleInscription = false;
			}
			// Mail
			if (mail.contains(".@") || mail.contains("@.") || mail.contains("..")) {
				ctrlAffichage.afficherAlerte("mail", "Adresse mail invalide.");
				possibleInscription = false;
			} else {
				byte cpt = 0;
			 	for (char c : mail.toCharArray()) {
			 		if (c == '@') cpt++;
			 		if (cpt > 1) break;
			 	}
			 	if (cpt != 1) {
			 		ctrlAffichage.afficherAlerte("mail", "Adresse mail invalide.");
					possibleInscription = false;
			 	}
			}
			// Mot de passe
			if (mdp.length() < 6) {
				ctrlAffichage.afficherAlerte("mdp", "Au moins 6 caractères.");
				possibleInscription = false;
			}
			// Confirmation du mot de passe
			if (!mdpConfirme.equals(mdp)) {
				ctrlAffichage.afficherAlerte("mdpConfirme", "Vérification invalide.");
				possibleInscription = false;
			}
		}
		// Si conformtité des champs
		// Vérification de l'adresse mail
		if (possibleInscription) {
			compteInscription = new Compte(utilisateur, ctrlSecurite.hash(mdp), mail);
			code = null;
			confirmationInscription();
			if (BY_PASS) verificationCode(this.code);
			else ctrlAffichage.ouvrirMenuConfirmation(new InscriptionConfirm(this));
		}
	}
	
	
	public void confirmationInscription() {
		Random rng = new Random();
		code = "";
		for (int i = 0; i < TAILLE_CODE; i++) code += rng.nextInt(10);
		if (!BY_PASS) {
			String sujet = "Confirmation de création de compte";
			String contenu = "Bienvenue " + compteInscription.getUtilisateur() + ",\r\n"
					       + "\r\n"
					       + "Le monde des Tamagotchis n'est plus très loin !\r\n"
					       + "Veuillez saisir le code suivant pour finaliser votre inscription : " + code + "\r\n"
					       + "\r\n"
					       + "Bon jeu !";
			envoyerMail(sujet, contenu, compteInscription.getMail());
		}
	}
	
	
	public void verificationCode(String codeSaisie) {
		if (codeSaisie.equals(code)) {
			compte = new Compte(compteInscription.getUtilisateur(), compteInscription.getMdp(), ctrlSecurite.hash(compteInscription.getMail()), compteInscription.getId(), compteInscription.getParties());
			lsCompte.put(compte.getUtilisateur(), compte);
			compteInscription = null;
			ctrlAffichage.fermerMenuConfirmation();
			ctrlAffichage.ouvrirMenu(new MenuPrincipal(this), 1);
		} else {
			if (codeSaisie.equals("")) ctrlAffichage.afficherAlerteConfirmation("Veuillez saisir le code.");
			else ctrlAffichage.afficherAlerteConfirmation("Le code est invalide");
			System.out.println("msg");
		}
	}
}
