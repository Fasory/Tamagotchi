package controleur;

import java.util.HashMap;
import java.util.UUID;

import menu.MenuPrincipal;
import modele.Compte;
import modele.Partie;

public class ControleurConnexion extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	private HashMap<String, Compte> lsCompte;

	public ControleurConnexion() {
		super(estCree);
		estCree++;
		
		// Compte null tant qu'aucune connexion est effectué
		compte = null;
		
		lsCompte = ControleurGeneral.ctrlFichier.getListeCompte();
		if (lsCompte.get(NOM_ANONYME) == null) lsCompte.put(NOM_ANONYME, new Compte(NOM_ANONYME, hash(""), hash(""), UUID.fromString(STR_UUID_ANONYME), new HashMap<UUID, Partie>(NB_MAX_PARTIE)));
	}
	
	/**
	 * Emmet une tentative de connexion
	 * 
	 * @param utilisateur - String représentant le nom de
	 * l'utilsateur
	 * @param mdp - String représentant le mot de passe saisie
	 * par l'utilisateur
	 */
	public boolean connexion(String utilisateur, String mdp) {
		Compte compteTemp = lsCompte.get(utilisateur);
		if (compteTemp != null && hash(mdp).equals(compteTemp.getMdp())) {
			ControleurGeneral.ctrlAffichage.ouvrirMenu(new MenuPrincipal(this));
			return true;
		} else return false;
	}
	
	/**
	 * 
	 */
	public void deconnexion() {
		compte = null;
	}
	
	
	
}
