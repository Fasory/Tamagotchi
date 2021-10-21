package controleur;

import javax.swing.JFrame;

import fenetre.FenetreDeConfirmation;
import fenetre.FenetrePrincipale;
import menu.MenuDeConfirmation;
import menu.MenuPrincipal;

public class Controleur {
	
	private ControleurDeFichier ctrlDeFichier;

	private FenetrePrincipale fenetrePrincipale;
	private FenetreDeConfirmation fenetreDeConfirmation;
	private MenuPrincipal menuPrincipal;
	private MenuDeConfirmation menuDeConfirmation;
	
	private short statutConfirmation;

	/**
	 * Racine de l'application Tamagotchi									<br/>
	 * 																		<br/>
	 * @param args - liste de paramètres au lancement de l'application 		<br/>
	 */
	public static void main(String[] args) {
		new Controleur();
		System.out.println("cc");
	}
	
	
	/**
	 * Constructeur							<br/>
	 * 										<br/>
	 * Initialisation de l'application		<br/>
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
	* Demande de changement de menu : MenuCreerPartie		<br/>
	*/
	public void rqtMenuCreerPartie() {
		System.out.println("Clic");
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie		<br/>
	*/
	public void rqtMenuSelecPartie() {
	
	}
	
	/**
	* Demande de changement de menu : MenuOption			<br/>
	*/
	public void rqtMenuOption() {
	
	}
	
	/**
	* Demande de changement de menu : MenuScore				<br/>
	*/
	public void rqtMenuScore() {
	
	}
	
	/**
	* Demande de fermeture de l'application					<br/>
	*/
	public void rqtQuitter() {
		fenetrePrincipale.setActivite(false);
		fenetreDeConfirmation.setAffiche(true);
	}
	
	public void rqtStatutConfirmation(short confirmation) {
		statutConfirmation = confirmation;
		statutConfirmation = null;
	}
}
