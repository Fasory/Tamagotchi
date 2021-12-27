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

import vue.menu.Connexion;

public class ControleurGeneral extends Controleur {
	
	private static boolean estCree = false;							// Repère de création d'une unique instance par type de controleur
	
	// Constantes
	public final static int TEMPS_MAJ = 500;			// Temps en milliseconde de pause entre chaque mise à jour du Tamagotchi
	public final static int NB_MAX_PARTIE = 3;
	public final static String[] TYPE = {"Robot","Lapin", "Chat", "Dinosaure"};
	public final static String NOM_ANONYME = "Anonyme";					  
	public final static String STR_UUID_ANONYME = "00000000-0000-0000-0000-000000000000";
	public final static boolean BY_PASS = true;			// Valable que pour la version de développement, il permet de passé oûtre les confirmations
	public final static boolean DEBUG = true;			// Valable que pour la version de développement, permet d'afficher dans la console les actions effectuées
	
	public static ControleurFichier ctrlFichier;			// Controleur assistant pour la gestion de fichiers
	public static ControleurTemps ctrlTemps;				// Controleur assistant pour la gestion du temps
	public static ControleurAffichage ctrlAffichage;		// Controleur assistant pour la gestion de l'affichage
	public static ControleurBouton ctrlBouton;				// Controleur assistant pour la gestion des boutons
	public static ControleurAudio ctrlAudio;				// Controleur assistant pour la gestion de l'audio
	public static ControleurConnexion ctrlConnexion;		// Controleur assistant pour la gestion de l'utilisateur
	public static ControleurSecurite ctrlSecurite;			// Controleur assistant pour la gestion de la sécurité des données
	public static ControleurJeu ctrlJeu;
	
	/**
	 * Constructeur							<br/>
	 * 										<br/>
	 * Initialisation de l'application		<br/>
	 */
	private ControleurGeneral() {
		super(estCree);
		estCree = true;
		// Lancement de l'application
		ctrlFichier = new ControleurFichier();
		ctrlSecurite = new ControleurSecurite();
		ctrlTemps = new ControleurTemps();
		ctrlFichier.addLogs("Satut	-	Lancement de l'application");
		// Chargement des données de connexion de l'applicaton
		ctrlConnexion = new ControleurConnexion();
		ctrlFichier.addLogs("		-	Récupération des données de connexion");
		// Initialisation de l'affichage
		ctrlAffichage = new ControleurAffichage(new Connexion());
		ctrlFichier.addLogs("		-	Création des fenêtres");
		// Initialisation des controleurs complémentaires
		ctrlBouton = new ControleurBouton();
		ctrlAudio = new ControleurAudio();
		ctrlJeu = new ControleurJeu();
		ctrlFichier.addLogs("		-	Initialisation des contrôleurs complémentaires");
		// Fin de la construction de l'application
		ctrlFichier.addLogs("Satut	-	Application opérationnelle");
	}
	
	@Override
	public void delControleur() {
		if (estCree) {
			estCree = false;
		}
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
		ControleurGeneral ctrlGeneral = new ControleurGeneral();
		ctrlGeneral.delControleur();
	}
	
	/**
	 * Permet d'envoyer un mail à partir de l'adresse :			<br/>
	 * tamagotchi.univ.ubs@gmail.com							<br/>
	 * 															<br/>
	 * @param sujet - String object du mail						<br/>
	 * @param contenu - String corps du mail					<br/>
	 * @param destinataire - String destinataire du mail		<br/>
	 */
	public static boolean envoyerMail(String sujet, String contenu, String destinataire) {
		// Constantes d'envoie
		final String SMTP_HOST = "smtp.gmail.com";
        final String SMTP_PORT = "587";
        final String GMAIL_USERNAME = "tamagotchi.univ.ubs@gmail.com";
        final String GMAIL_PASSWORD = "@bcd3fgh";
		// Configuration de la session d'envoie
	    Properties config = new Properties();
	    config.setProperty("mail.smtp.host", SMTP_HOST);
        config.setProperty("mail.smtp.user", GMAIL_USERNAME);
        config.setProperty("mail.smtp.password", GMAIL_PASSWORD);
	    config.setProperty("mail.smtp.port", SMTP_PORT);
	    config.setProperty("mail.smtp.auth", "true");
	    config.setProperty("mail.smtp.starttls.enable", "true"); //TLS
	    Session session = Session.getDefaultInstance(config, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(GMAIL_USERNAME, "@bcd3fgh");
	    	}
	    });
	    // Création du message
	    try {
	    	MimeMessage mail = new MimeMessage(session);
	    	mail.setFrom(new InternetAddress(GMAIL_USERNAME));
		  	mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
			mail.setSubject(sujet);
			mail.setText(contenu);
			Transport transport = session.getTransport("smtp");
            transport.connect(SMTP_HOST, GMAIL_USERNAME, GMAIL_PASSWORD);
            transport.sendMessage(mail, mail.getAllRecipients());
			return true;
	    } catch (MessagingException err) {
	    	ctrlFichier.addLogs("Erreur - échec de l'envoie d'un mail", true);
	    	ctrlFichier.addLogs(err.toString(), true);
	    	return false;
	    }
	}
	
	/**
	* Ferme l'application										<br/>
	*/
	public static void quitter() {
		ctrlAudio.delControleur();
		ctrlBouton.delControleur();
		ctrlAffichage.delControleur();
		ctrlConnexion.delControleur();
		ctrlTemps.delControleur();
		ctrlSecurite.delControleur();
		ctrlFichier.delControleur();
		ctrlJeu.delControleur();
		System.exit(0);
	}
}
