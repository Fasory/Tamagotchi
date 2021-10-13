package controleur;

import javax.swing.JFrame;

import vue.FenetreDeConfirmation;
import vue.FenetrePrincipale;

public class Controleur {

	private FenetrePrincipale fenetrePrincipale;
	private FenetreDeConfirmation fenetreDeConfirmation;

	/**
	 * Racine de l'application Tamagotchi
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Controleur();
	}
	
	
	/**
	 * Constructeur
	 * 
	 * Initialisation de l'application
	 */
	public Controleur() {
		fenetrePrincipale = new FenetrePrincipale(this);
		fenetreDeConfirmation = new FenetreDeConfirmation(this);
		fenetrePrincipale.setVisible(true);
		
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
			System.exit(1);
		} else {
			fenetreDeConfirmation.setVisible(false);
			fenetrePrincipale.setActivite(!confirmation);
			fenetrePrincipale.setVisible(true); // redonne le focus à la fen�tre principale
		}
	}
}
