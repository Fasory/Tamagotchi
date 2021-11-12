package controleur;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import menu.Connexion;
import modele.Compte;

public class ControleurGeneral extends Controleur {
	
	private static int estCree = 0;														// Repère de création d'une unique instance par type de controleur
	
	// Constantes
	protected final static int NB_MAX_PARTIE = 3;
	protected final static String NOM_ANONYME = "Anonyme";					  
	protected final static String STR_UUID_ANONYME = "00000000-0000-0000-0000-000000000000";
	
	public static ControleurFichier ctrlFichier;			// Controleur assistant pour la gestion de fichiers
	public static ControleurTemps ctrlTemps;				// Controleur assistant pour la gestion du temps
	public static ControleurAffichage ctrlAffichage;		// Controleur assistant pour la gestion de l'affichage
	public static ControleurBouton ctrlBouton;				// Controleur assistant pour la gestion des boutons
	public static ControleurAudio ctrlAudio;				// Controleur assistant pour la gestion de l'audio
	public static ControleurConnexion ctrlConnexion;		// Controleur assistant pour la gestion de l'utilisateur
	public static ControleurSecurite ctrlSecurite;			// Controleur assistant pour la gestion de la sécurité des données
	
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
		ctrlSecurite = new ControleurSecurite();
		ctrlTemps = new ControleurTemps();
		ctrlFichier.addLogs("Satut	-	Lancement de l'application");
		// Chargement des données de connexion de l'applicaton
		ctrlConnexion = new ControleurConnexion();
		ctrlFichier.addLogs("		-	Récupération des données de connexion");
		// Initialisation de l'affichage
		ctrlAffichage = new ControleurAffichage(new Connexion(this));
		ctrlFichier.addLogs("		-	Création des fenêtres");
		// Initialisation des controleurs complémentaires
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
	 * Permet d'envoyer un mail à partir de l'adresse :			<br/>
	 * tamagotchi.univ.ubs@gmail.com							<br/>
	 * 															<br/>
	 * @param sujet - String object du mail						<br/>
	 * @param contenu - String corps du mail					<br/>
	 * @param destinataire - String destinataire du mail		<br/>
	 */
	public void envoyerMail(String sujet, String contenu, String destinataire) {
		// Configuration de la session d'envoie
	    Properties config = new Properties();
	    config.put("mail.smtp.host", "smtp.gmail.com");
	    config.put("mail.smtp.port", "587");
	    config.put("mail.smtp.auth", "true");
	    config.put("mail.smtp.starttls.enable", "true"); //TLS
	    Session session = Session.getDefaultInstance(config, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication("tamagotchi.univ.ubs@gmail.com", "@bcd3fgh");
	    	}
	    });
	    // Création du message
	    try {
	    	MimeMessage mail = new MimeMessage(session);
		  	mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
			mail.setSubject(sujet);
			mail.setText(contenu);
			Transport.send(mail);
	    } catch (MessagingException err) {
	    	ctrlFichier.addLogs("Erreur - échec de l'envoie d'un mail", true);
	    	ctrlFichier.addLogs(err.toString(), true);
	    }
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
