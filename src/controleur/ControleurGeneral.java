package controleur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import menu.Connexion;
import modele.Compte;

public class ControleurGeneral extends Controleur {
	
	private static int estCree = 0;														// Repère de création d'une unique instance par type de controleur
	
	// Constantes
	protected final static int NB_MAX_PARTIE = 3;
	protected final static String NOM_ANONYME = "Anonyme";					  
	protected final static String STR_UUID_ANONYME = "00000000-0000-0000-0000-000000000000";
	
	public static ControleurFichier ctrlFichier;			// Controleur assistant pour la gestion de fichiers
	public static ControleurAffichage ctrlAffichage;		// Controleur assistant pour la gestion de l'affichage
	public static ControleurBouton ctrlBouton;				// Controleur assistant pour la gestion des boutons
	public static ControleurAudio ctrlAudio;				// Controleur assistant pour la gestion de l'audio
	public static ControleurConnexion ctrlConnexion;		// Controleur assistant pour la gestion de l'utilisateur
	
	protected static Compte compte;							// Compte de l'utilisateur
	
	/**
	 * Constructeur							<br/>
	 * 										<br/>
	 * Initialisation de l'application		<br/>
	 */
	private ControleurGeneral() {
		super(estCree);
		estCree++;
		
		// Lancement de l'application
		ctrlFichier = new ControleurFichier();
		ctrlFichier.addLogs("Satut	-	Lancement de l'application");
		// Initialisation de l'affichage
		ctrlAffichage = new ControleurAffichage(new Connexion(this));
		ctrlFichier.addLogs("		-	Création des fenêtres");
		// Chargement des données de connexion de l'applicaton
		ctrlConnexion = new ControleurConnexion();
		ctrlFichier.addLogs("		-	Récupération des données de connexion");
		// Initialisation des attributs complémentaires
		ctrlBouton = new ControleurBouton();
		//ctrlAudio = new ControleurAudio();
		ctrlFichier.addLogs("		-	Initialisation des contrôleurs complémentaires");
		// Fin de la construction de l'application
		ctrlFichier.addLogs("Satut	-	Application opérationnelle");
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
	 * Racine de l'application Tamagotchi						<br/>
	 * 															<br/>
	 * @param args - liste de paramètres au lancement de		<br/>
	 * l'application 											<br/>
	 */
	public static void main(String[] args) {
		new ControleurGeneral();
	}
	
	/**
	 * Permet de hasher une chaîne de caractères				<br/>
	 * 															<br/>
	 * @param msg - String dont on souhaite obtenir le hash		<br/>
	 * @return String - hash du msg								<br/>
	 */
	public String hash(String msg) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException err) {
			ctrlFichier.addLogs("Erreur - échec de chargement de l'agorithme de hashage (SHA-256)", true);
			ctrlFichier.addLogs(err.toString(), true);
		}
		return new String(md.digest(msg.getBytes()));
	}
	
	/**
	* Ferme l'application										<br/>
	*/
	public void quitter() {
		ctrlAffichage.fermetureApplication();
		ctrlFichier.delControleurDeFichier();
		System.exit(0);
	}
}
