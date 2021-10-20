package controleur;

import javax.swing.JFrame;

import vue.FenetreDeConfirmation;
import vue.FenetrePrincipale;
import vue.MenuDeConfirmation;
import vue.MenuPrincipal;

public class Controleur {
	
	private ControleurDeFichier ctrlDeFichier;

	private FenetrePrincipale fenetrePrincipale;
	private FenetreDeConfirmation fenetreDeConfirmation;
	private MenuPrincipal menuPrincipal;
	private MenuDeConfirmation menuDeConfirmation;

	/**
	 * Racine de l'application Tamagotchi
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Controleur();
		System.out.println("cc");
	}
	
	
	/**
	 * Constructeur
	 * 
	 * Initialisation de l'application
	 */
	public Controleur() {
		// Création des controleurs assistants
		ctrlDeFichier = new ControleurDeFichier();
		ctrlDeFichier.addLogs("Satut	-	Lancement de l'application");
		// Création des menus primaires
		ctrlDeFichier.addLogs("		-	Création des menus");
		menuPrincipal = new MenuPrincipal(this);
		menuDeConfirmation = new MenuDeConfirmation(this);
		ctrlDeFichier.addLogs("		-	Création des fenêtres");
		// Création des fenêtres primaires
		fenetrePrincipale = new FenetrePrincipale(this, menuPrincipal);
		fenetreDeConfirmation = new FenetreDeConfirmation(this, menuDeConfirmation);
		// Fin de la construction de l'application
		ctrlDeFichier.addLogs("Satut	-	Application opérationnelle");
	}
	
	
	////////////////////////////////////////
	//          REQUETES VERS LE          //
	//             CONTROLEUR             //        
	////////////////////////////////////////
	
	/**
	* Demande de changement de menu : MenuCreerPartie
	*/
	public void rqtMenuCreerPartie() {
		System.out.println("Clic");
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie
	*/
	public void rqtMenuSelecPartie() {
	
	}
	
	/**
	* Demande de changement de menu : MenuOption
	*/
	public void rqtMenuOption() {
	
	}
	
	/**
	* Demande de changement de menu : MenuScore
	*/
	public void rqtMenuScore() {
	
	}
	
	/**
	* Demande de fermeture de l'application
	*/
	public void rqtQuitter() {
		fenetreDeConfirmation.setVisible(true);
		if (fenetreDeConfirmation.getState() == JFrame.ICONIFIED) {
			fenetreDeConfirmation.setState(JFrame.NORMAL);
		}
		fenetrePrincipale.setActivite(false);
	}
	
	/**
	 * Demande d'exécution de fermeture de l'application si confirmation
	 * 
	 * @param confirmation
	 */
	public void rqtFermer(boolean confirmation) {
		if (confirmation) {
			ctrlDeFichier.delControleurDeFichier();
			System.exit(1);
		} else {
			fenetreDeConfirmation.setVisible(false);
			fenetrePrincipale.setActivite(!confirmation);
			fenetrePrincipale.setVisible(true); // redonne le focus à la fen�tre principale
		}
	}
}
