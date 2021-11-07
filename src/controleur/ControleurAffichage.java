package controleur;

import java.util.Stack;

import fenetre.FenetreConfirmation;
import fenetre.FenetrePrincipale;
import menu.Connexion;
import menu.Menu;
import menu.MenuConfirmation;

public class ControleurAffichage extends ControleurGeneral {
	
	private static int estCree = 0;							// Repère de création d'une unique instance par type de controleur
	
	private FenetrePrincipale fenetrePrincipale;			// Fenêtre principale qui contient les menus et le jeu
	private FenetreConfirmation fenetreDeConfirmation;		// Fenêtre destinée à demander la confirmation d'une action
	private Stack<Menu> pileMenu;							// Pile des menus ouverts
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des boutons de l'application	<br/>
	 * 																<br/>
	 * @param menuInitial - Menu sur lequel l'application commence	<br/>
	 */
	public ControleurAffichage(Menu menuInitial) {
		super(estCree);
		estCree++;
		
		pileMenu = new Stack<Menu>();
		pileMenu.push(menuInitial);
		fenetrePrincipale = new FenetrePrincipale(this, pileMenu.peek());
		fenetreDeConfirmation = new FenetreConfirmation(this);
	}
	
	/**
	 * Change le curseur de l'application									<br/>
	 * 																		<br/>
	 * @param type - String corespondant au nom de fichier du curseur		<br/>
	 * sans l'extension (chemin du fichier : 'assets/cursor/')				<br/>
	 */
	public void rqtChangeCurseur(String type) {
		if (type.equals("default")) pileMenu.peek().curseurDefault();
		else if (type.equals("hand")) pileMenu.peek().curseurHand();
		else ctrlFichier.addLogs("Erreur		- le curseur de type '" + type + "' n'existe pas", true);
	}
	
	/**
	 * Change la couleur du texte d'oublie de mot de passe					<br/>
	 * 																		<br/>
	 * @param menu - Connexion du menu actuel pour changer					<br/>
	 * les couleurs															<br/>
	 */
	public void rqtCouleurOublieMdp(Connexion menu) {
		if (menu.getCouleurTxtOublieMdp().equals(menu.COULEUR_EN_SELEC)) menu.setCouleurTxtOublieMdp(menu.COULEUR_EN_NON_SELEC);
		else menu.setCouleurTxtOublieMdp(menu.COULEUR_EN_SELEC);
	}
	
	/**
	 * Ouvre dans la fenêtre le nouveau menu								<br/>
	 * 																		<br/>
	 * Par défaut, on ne supprime aucun menu avant							<br/>
	 * d'ouvrir le menu demander											<br/>
	 * 																		<br/>
	 * @param menu - Menu que l'on souhaite afficher						<br/>
	 */
	public void ouvrirMenu(Menu menu) {
		ouvrirMenu(menu, 0);
	}
	
	/**
	 * Ouvre dans la fenêtre le nouveau menu								<br/>
	 * 																		<br/>
	 * @param menu - Menu que l'on souhaite afficher						<br/>
	 * @param retour - int représentant le nombre de						<br/>
	 * menu qu'on supprime avant d'ouvrir le nouveau						<br/>
	 * menu																	<br/>
	 */
	public void ouvrirMenu(Menu menu, int retour) {
		for (int i = 0; i < retour; i++) pileMenu.pop();
		renitialiserMenu();
		pileMenu.push(menu);
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Affiche la fenêtre de confirmation avec un menu						<br/>
	 * 																		<br/>
	 * @param menu - MenuConfirmation que l'on souhaite						<br/>
	 * afficher																<br/>
	 */
	public void ouvrirMenuConfirmation(MenuConfirmation menu) {
		fenetrePrincipale.mettreEnPause(true);
		fenetreDeConfirmation.changePanel(menu);
		fenetreDeConfirmation.mettreEnPause(false);
		fenetreDeConfirmation.mettreEnAvant(true);
	}
	
	/**
	 * Fermme la fenêtre de confirmation									<br/>
	 */
	public void fermerMenuConfirmation() {
		fenetreDeConfirmation.mettreEnPause(true);
		fenetreDeConfirmation.mettreEnAvant(false);
		fenetrePrincipale.mettreEnPause(false);
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Ferme les fenêtres de l'application									<br/>
	 */
	public void fermetureApplication() {
		fenetrePrincipale.mettreEnPause(true);
		fenetrePrincipale.mettreEnAvant(false);
		fenetrePrincipale.dispose();
		fenetreDeConfirmation.dispose();
	}
	
	/**
	 * Affiche le précédent précédent										<br/>
	 */	
	public void menuPrecedent() {
		pileMenu.pop();
		renitialiserMenu();
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Rénitialise l'affichage du menu										<br/>
	 */
	public void renitialiserMenu() {
		pileMenu.peek().renitialiser();
	}
	
	/**
	 * Affiche une alerte dans le menu										<br/>
	 * 																		<br/>
	 * @param msg - String à afficher										<br/>
	 */
	public void afficherAlerte(String alerteCible, String msg) {
		Menu tempMenu = pileMenu.peek();
		if (tempMenu.getClefLsAlerte().contains(alerteCible)) tempMenu.setAlerte(alerteCible, msg);
		else ctrlFichier.addLogs("Erreur		- échec d'écrire dans un menu qui ne contient pas l'alerte cible voulu : " + alerteCible, true);
	}
	
	
	public void afficherAlerteConfirmation(String msg) {
		fenetreDeConfirmation.getMenuConfirmation().setAlerte("saisie", msg);
	}
}
