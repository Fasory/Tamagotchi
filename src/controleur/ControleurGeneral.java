package controleur;



import fenetre.FenetreDeConfirmation;
import fenetre.FenetrePrincipale;
import menu.Connexion;
import menu.Menu;
import menu.MenuPrincipal;

public class ControleurGeneral extends Controleur {
	
	private static int estCree = 0;											// Repère de création d'une unique instance par type de controleur
	
	public static ControleurDeFichier ctrlDeFichier;								// Controleur assistant pour la gestion de fichiers
	public static ControleurDeBouton ctrlDeBouton;									// Controleur assistant pour la gestion des boutons
	protected static FenetrePrincipale fenetrePrincipale;					// Fenêtre principale qui contient les menus et le jeu
	protected static FenetreDeConfirmation fenetreDeConfirmation;			// Fenêtre destinée à demander la confirmation d'une action
	protected static Menu panelCourant;
	protected static Menu panelPrecedent;
	
	/**
	 * Constructeur							<br/>
	 * 										<br/>
	 * Initialisation de l'application		<br/>
	 */
	private ControleurGeneral() {
		super(estCree);
		estCree++;
		
		// Création des controleurs assistants
		ctrlDeFichier = new ControleurDeFichier();
		ctrlDeBouton = new ControleurDeBouton();
		ctrlDeFichier.addLogs("Satut	-	Lancement de l'application");
		// Création du menu courrant
		panelCourant = new MenuPrincipal(this);
		// Ajustement secondaire
		// ...
		// Création des fenêtres primaires
		ctrlDeFichier.addLogs("		-	Création des fenêtres");
		fenetrePrincipale = new FenetrePrincipale(this, panelCourant);
		fenetreDeConfirmation = new FenetreDeConfirmation(this);
		// Initialisation des attributs complémentaires
		// ...
		// Fin de la construction de l'application
		ctrlDeFichier.addLogs("Satut	-	Application opérationnelle");
	}
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * Appelle dédier aux sous contrôleur qui hérite du		<br/>
	 * contrôleur général									<br/>
	 * 														<br/>
	 * @param autreEstCree - int désignant le repère de		<br/>
	 * création	 du sous controleur							<br/>
	 */
	public ControleurGeneral(int autreEstCree) {
		super(autreEstCree);
	}
	
	
	////////////////////////////////////////
	//            METHODES DU             //
	//         CONTROLEUR GENERAL         //
	////////////////////////////////////////
	
	/**
	 * Racine de l'application Tamagotchi									<br/>
	 * 																		<br/>
	 * @param args - liste de paramètres au lancement de l'application 		<br/>
	 */
	public static void main(String[] args) {
		new ControleurGeneral();
	}
	
	
	////////////////////////////////////////
	//          REQUETES VERS LE          //
	//         CONTROLEUR GENERAL         //
	////////////////////////////////////////
	
	/**
	 * Change le curseur de l'application									<br/>
	 * 																		<br/>
	 * @param type - String corespondant au nom de fichier du curseur		<br/>
	 * sans l'extension (chemin du fichier : 'assets/cursor/')				<br/>
	 */
	public void rqtChangeCurseur(String type) {
		if (type.equals("default")) panelCourant.curseurDefault();
		else if (type.equals("hand")) panelCourant.curseurHand();
		else ctrlDeFichier.addLogs("Erreur		- le curseur de type '" + type + "' n'existe pas", true);
	}
	
	/**
	 * Change la couleur du texte d'oublie de mot de passe					<br/>
	 * 																		<br/>
	 * @param menu - Connexion du menu actuel pour changer					<br/>
	 * les couleurs															<br/>
	 */
	public void rqtCouleurOublieMdp(Connexion menu) {
		if (menu.getCouleurTxtOublieMdp().equals(menu.couleurEnSelec)) menu.setCouleurTxtOublieMdp(menu.couleurEnNonSelec);
		else menu.setCouleurTxtOublieMdp(menu.couleurEnSelec);
	}
}
