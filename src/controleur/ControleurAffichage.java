package controleur;

import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Color;

import vue.fenetre.FenetreConfirmation;
import vue.fenetre.FenetrePrincipale;
import vue.menu.Menu;
import vue.menu.MenuConfirmation;

public class ControleurAffichage extends Controleur {
	
	private static boolean estCree = false;							// Repère de création d'une unique instance par type de controleur
	
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
		estCree = true;
		
		pileMenu = new Stack<Menu>();
		pileMenu.push(menuInitial);
		fenetrePrincipale = new FenetrePrincipale(pileMenu.peek());
		fenetreDeConfirmation = new FenetreConfirmation();
	}
	
	/**
	 * Ferme les fenêtres de l'application									<br/>
	 */
	@Override
	public void delControleur() {
		if (estCree) {
			fenetrePrincipale.mettreEnPause(true);
			fenetrePrincipale.mettreEnAvant(false);
			fenetrePrincipale.dispose();
			fenetreDeConfirmation.dispose();
			estCree = false;
		}
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
		else ControleurGeneral.ctrlFichier.addLogs("Erreur		- le curseur de type '" + type + "' n'existe pas", true);
	}
	
	/**
	 * Change la couleur du texte											<br/>
	 * 																		<br/>
	 * @param menu - Menu sur lequel on effectue le changement				<br/>
	 * @param label - JLabel dont on veut changer la couleur				<br/>
	 * @param couleur - Color final que va prendre notre JLabel				<br/>
	 */
	public void rqtChangeCouleurLabel(Menu menu, JLabel label, Color couleur) {
		menu.changeCouleurLabel(label, couleur);
	}
	
	/**
	 * Change un JComponent en actif / inactif								<br/>
	 * 																		<br/>
	 * @param menu - Menu sur lequel on effectue le changement				<br/>
	 * @param composant - JComponent dont on veut modifier l'activité		<br/>
	 * @param actif - boolean représentant l'activité à appliquer			<br/>
	 */
	public void rqtComposantActif(Menu menu, JComponent composant, boolean actif) {
		menu.setActive(composant, actif);
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
		else ControleurGeneral.ctrlFichier.addLogs("Erreur		- échec d'écrire dans un menu qui ne contient pas l'alerte cible voulu : " + alerteCible, true);
	}
	
	
	public void afficherAlerteConfirmation(String msg) {
		fenetreDeConfirmation.getMenuConfirmation().setAlerte("saisie", msg);
	}
}
