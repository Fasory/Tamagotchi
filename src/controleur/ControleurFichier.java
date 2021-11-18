package controleur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import modele.Compte;
import modele.Partie; 

/**
 * Sous contrôleur qui a pour but de gérer la	<br/>
 * persistence des données de l'application		<br/>
 * 												<br/>
 * Intègre un système de logs afin de faciliter	<br/>
 * le débuggage et la maintenant liés à la		<br/>
 * persistence des données						<br/>
 */
public class ControleurFichier extends Controleur {
	
	private static int estCree = 0;									// Repère de création d'une unique instance par type de controleur
	
	private File logs;												// Fichier logs du jour courant
	private FileOutputStream logsOutStream;							// Flux de sortie pour écrire dans le fichier logs du jour courant
	private File repLogs;											// Répertoire contenant tous les logs
	private boolean erreurLogs;										// Repère binaire si les logs du jour courant contiennent une erreur
	private final File dirData = new File("data");					// Répertoire contenant les données sauvegardées
	private final File repJoueur = new File(dirData, "user");		// Répertoire contenant les fichiers de données de chaque utilisateur
	private final File repSauvegarde = new File(dirData, "save");	// Répertoire contenant les sauvegardes des parties
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des fichiers de l'application	<br/>
	 */
	public ControleurFichier() {
		super(estCree);
		estCree++;
		
		// Initialisation des logs
		init_logs();
		// Initialisation du chemin des datas
		init_data();
	}
	
	/**
	 * Pré-Destructeur manuel										<br/>
	 * 																<br/>
	 * Supprime le fichier logs associé à l'utilisation en cours	<br/>
	 * si aucune erreur n'a été rapporté							<br/>
	 */
	public void delControleurFichier() {
		if (!erreurLogs) {
			try {
				logsOutStream.close();
				Files.delete(logs.toPath());
			} catch (Exception err) {
				addLogs(err.toString(), true);
			}
		}
		
		estCree--;
	}
	
	/**
	 * Retourne l'objet File lier au fichier dont un précise le chemin,		<br/>
	 * on ne fera pas de vérification d'existence du fichier				<br/>
	 * 																		<br/>
	 * @param chemin - String représentant le chemin du fichier à obtenir	<br/>
	 * @return File - fichier souhaiter										<br/>
	 */
	public static File getFichier(String chemin) {
		return new File(chemin);
	}
	
	/**
	 * Initalisation de logs	<br/>
	 */
	private void init_logs() {
		repLogs = new File("logs");
		Calendar date = Calendar.getInstance();
		// Affichage par deux digit (exemple : 9-1-2021 -> 09-01-2021)
		logs = new File(repLogs, "logs-" + date.get(Calendar.YEAR) + "-" + (((date.get(Calendar.MONTH)+1)<10) ? "0" : "") + (date.get(Calendar.MONTH)+1) + "-" + ((date.get(Calendar.DAY_OF_MONTH)<10) ? "0" : "") + date.get(Calendar.DAY_OF_MONTH) + ".txt");
		if (!repExiste(repLogs)) creeRep(repLogs);
		if (!logsExiste()) {
			erreurLogs = false;
			creeLogs();
		}
		// Le fichier existe déjà et contient donc une erreur
		else erreurLogs = true;
		try {
			logsOutStream = new FileOutputStream(logs, true);
		} catch (Exception err) {
			System.err.println(err);
		}
		addLogs("****************************************");
		addLogs("		-	" + ((date.get(Calendar.HOUR_OF_DAY)<10) ? "0" : "") + date.get(Calendar.HOUR_OF_DAY) + ":" + ((date.get(Calendar.MINUTE)<10) ? "0" : "") + date.get(Calendar.MINUTE) + ":" + ((date.get(Calendar.SECOND)<10) ? "0" : "") + date.get(Calendar.SECOND)
				+ " - " + ((date.get(Calendar.DAY_OF_MONTH)<10) ? "0" : "") + date.get(Calendar.DAY_OF_MONTH) + "/" + (((date.get(Calendar.MONTH)+1)<10) ? "0" : "") + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR));
	}
	
	/**
	 * Initialisation de data		<br/>
	 */
	private void init_data() {
		if (!repExiste(dirData)) creeRep(dirData);
	}
	
	/**
	 * Teste l'existence du dossier dir								<br/>
	 * 																<br/>
	 * @param dir - répertoire dont il faut vérifier l'existence	<br/>
	 * @return bool - existence du dossier dir						<br/>
	 */
	private static boolean repExiste(File rep) {
		return rep.exists() && rep.isDirectory();
	}
	
	/**
	 * Vérifier l'existence d'un fichier							<br/>
	 * 																<br/>
	 * @param chemin - String représentant le chemin du fichier		<br/>
	 * @return bool - existence du fichier							<br/>
	 */
	public static boolean fichierExiste(String chemin) {
		File fichier = new File(chemin);
		return fichier.exists() && fichier.isFile();
	}
	
	/**
	 * Vérifier l'existence d'un fichier							<br/>
	 * 																<br/>
	 * @param ficiher - File représentant le fichier				<br/>
	 * @return bool - existence du fichier							<br/>
	 */
	public static boolean fichierExiste(File fichier) {
		return fichier.exists() && fichier.isFile();
	}
	
	/**
	 * Teste l'existence du fichier logs du jour		<br/>
	 * 													<br/>
	 * @return bool - existence du fichier logs			<br/>
	 */
	public boolean logsExiste() {
		return logs.exists() && logs.isFile();
	}
	
	/**
	 * Créer le dossier dir						<br/>
	 * 											<br/>
	 * @param dir - créé le répertoire dir		<br/>
	 */
	private void creeRep(File rep) {
		if (!rep.mkdir()) {
			if (rep.getName() != "logs") addLogs("Erreur	- échec de la création du dossier " + rep.getName(), true);
			else System.err.println("Erreur - échec de la création du fichier " + rep.getName());
		}
	}
	
	/**
	 * Créer un fichier le fichier log du jour		<br/>
	 */
	private void creeLogs() {
		if (!(repLogs.exists() && repLogs.isDirectory())) if (!repLogs.mkdir()) System.err.println("Erreur - échec de la création du répertoire logs");
		// Fichier logs du jour
		try {
			logs.createNewFile();
		} catch (Exception err) {
			System.err.println("Erreur	- échec de la création du fichier " + logs.getName());
		}
	}
	
	/**
	 * Ajoute une ligne de rapport dans le fichier logs						<br/>
	 * qui n'est pas une erreur												<br/>
	 * 																		<br/>
	 * @param rapport - String contenant le rapport à ajouter aux logs		<br/>
	 */
	public void addLogs(String rapport) {
		addLogs(rapport, false);
	}
	
	/**
	 * Ajoute une ligne de rapport dans le fichier logs						<br/>
	 * Possibilité de préciser si la ligne est une erreur ou non			<br/>
	 * auquel cas les logs ne seront pas supprimés							<br/>
	 * 																		<br/>
	 * @param rapport - String contenant le rapport à ajouter aux logs		<br/>
	 * @param typeErreur - vrai si le rapport est une erreur				<br/>
	 */
	public void addLogs(String rapport, boolean typeErreur) {
		if (typeErreur) erreurLogs = true;
		try {
			logsOutStream.write((rapport + "\n").getBytes());
			if (ControleurGeneral.DEBUG) {
				if (typeErreur) System.err.println(rapport);
				else System.out.println(rapport);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
	}
	
	/**
	 * Permet de lire tous les octets d'un fcihier
	 * 
	 * @param fichier - File représentant le fichier à lire
	 * @return byte[] - représentant les octets lu du fichier
 	 * @throws IOException
	 */
	public byte[] lireFichier(File fichier) throws IOException {
		FileInputStream fluxEntree = new FileInputStream(fichier);
		byte contenu[] = new byte[(int) fichier.length()];		// Création du stockage
		fluxEntree.read(contenu);	// Lecture du fichier
		fluxEntree.close();
		return contenu;
	}
	
	/**
	 * Permet d'écrire des octets dans un fichier
	 * 
	 * @param fichier - File représentant le fichier où il faut écrire
	 * @param contenu - byte[] représentant les octets à écrire
	 * @throws IOException
	 */
	public void ecrireFichier(File fichier, byte[] contenu) throws IOException {
		FileOutputStream fluxSortie = new FileOutputStream(fichier);
		fluxSortie.write(contenu);
		fluxSortie.close();
	}
	
	
	public void enregistreCompte(Compte compte) {
		
	}
	
	/**
	 * 
	 * @return
	 */	
	/*
	public HashMap<String, Compte> getListeCompte() {
		HashMap<String, Compte> lsCompte = new HashMap<String, Compte>();
		if (repExiste(repJoueur)) {
			for (File objet : repJoueur.listFiles()) {
				if (objet.isFile() && fichierUtilisateurIntegre(objet)) {
					try {
						Scanner scanne = new Scanner(objet);
						scanne.nextLine();
						System.out.println("No time !");
						UUID id = UUID.fromString(objet.getName());
						String utilisateur = scanne.nextLine();
						String mail = scanne.nextLine();
						String mdp = scanne.nextLine();
						HashMap<UUID, Partie> partie = new HashMap<UUID, Partie>(NB_MAX_PARTIE);
						for (String strUUID : scanne.nextLine().split(" ")) {
							//partie.put(UUID.fromString(strUUID), new Partie(UUID.fromString(strUUID)));
						}
						lsCompte.put(utilisateur, new Compte(utilisateur, mdp, mail, id, partie));
						scanne.close();
					} catch (FileNotFoundException err) {
						addLogs("Erreur	- échec de lecture de fichier d'utilisateur " + objet.getName(), true);
						addLogs(err.toString(), true);
					}
				}
			}
		}
		return lsCompte;
	}
	*/
	
	/**
	 * Permet de se rassurer si le fichier qu'on va traiter contient
	 * des données modifiées ou non
	 * 
	 * Structure théorique d'un fichier utilisateur :
	 *  _______________________________
	 * | File name : UUID USER_ID      |
	 * |_______________________________|
	 * | UUID USER_ID 			       |
	 * | String USER_NAME			   |
	 * | String USER_MAIL 		[HASH] |
	 * | String MDP				[HASH] |
	 * | UUID[] PARTIE_ID              |
	 * |_______________________________|
	 * 
	 * @param fichier - File qu'on cherche à vérifier l'intégrité
	 * @return boolean - vrai si l'intégrité du fichier est vérifiée
	 */
	/*
	public boolean fichierUtilisateurIntegre(File fichier) {
		try {
			Scanner scanne = new Scanner(fichier);
			// Vérification entre nom du fichier qui est l'UUID de l'utilisateur et l'UUID dans le fichier (1er ligne)
			String ln = scanne.nextLine();
			if (!fichier.getName().equals(ln)) {
				addLogs("Warning	-	Un fichier n'est pas reconnu dans le répertoire " + repJoueur.getPath() + " : " + fichier.getName(), true);
				scanne.close();
				return false;
			}
			// Récupération du User_Name pour des vérifier du compte anonyme
			String temp = ln;
			ln = scanne.nextLine();
			// Vérification de l'UUID si le compte est anonyme
			if (ln.equals(NOM_ANONYME) && !temp.equals(STR_UUID_ANONYME)) {
				addLogs("Warning	-	Le fichier " + fichier.getPath() + " a été modifié, l'UUID est différent de celui attendu", true);
				scanne.close();
				return false;
			}
			// Vériifcaion de l'adresse mail si l'utilisateur est anonyme
			if (ln.equals(NOM_ANONYME) && !ctrlSecurite.hash("").equals(scanne.nextLine())) {
				addLogs("Warning	-	Le fichier " + fichier.getPath() + " a été modifié, il contient des lignes supplémentaires indésirables", true);
				scanne.close();
				return false;
			}
			// Aucune vérification du mot de passe
			scanne.nextLine();
			// Vérification de l'existence des parties
			ln = scanne.nextLine();
			int cpt = 0;
			for (String strUUID : ln.split(" ")) {
				cpt++;
				if (cpt > NB_MAX_PARTIE) {
					addLogs("Warning	-	Le fichier " + fichier.getPath() + " a été modifié, il contient de " + NB_MAX_PARTIE + " références à des parties", true);
					scanne.close();
					return false;
				}
				if (!fichierExiste(repSauvegarde.getName() + "/" + strUUID)) {
					// On se contente juste d'informer la disparition d'une sauvegarde
					addLogs("Warning -	Une sauvegarde n'existe plus : " + strUUID, true);
				}
			}
			// Vérification de l'inexistence des lignes suivantes
			if (scanne.hasNextLine()) {
				addLogs("Warning	-	Le fichier " + fichier.getPath() + " a été modifié, il contient des lignes supplémentaires indésirables", true);
				scanne.close();
				return false;
			}
			scanne.close();
		} catch (Exception err) {
			addLogs("Erreur	- échec de lecture de fichier d'utilisateur " + fichier.getName(), true);
			addLogs(err.toString(), true);
			return false;
		}
		return true;
	}
	*/
	
	/*
	public void enregistreCompte(Compte compte) {
		File fichierCompte = new File(repJoueur, compte.getId().toString());
		// Vérification de l'existence du fichier associé compte
		if (!fichierExiste(fichierCompte)) {
			try {
				if (!repExiste(fichierCompte.getParentFile())) creeRep(fichierCompte.getParentFile());
				fichierCompte.createNewFile();
			} catch (Exception err) {
				addLogs("Erreur	- échec de la création du fichier du compte " + compte.getId().toString(), true);
				addLogs(err.toString(), true);
			}
		}
		try {
			// Structuration des données
			String contenu = compte.getId().toString() + "\n"
						   + compte.getUtilisateur() + "\n"
						   + compte.getMail() + "\n"
						   + compte.getMdp() + "\n"
						   + compte.getStrIdParties();
			if (DEBUG) System.out.println("\n[-- CONTENU DU FICHIER " + fichierCompte.getName() + " --]\n"+ contenu + "\n[-- ------------------------------------------------------- --]\n");
			// Cryptage des données
			////////////////////////////////////////////////////////////////contenu = ctrlSecurite.crypter(contenu);
			if (DEBUG) System.out.println("\n[-- CONTENU DU FICHIER " + fichierCompte.getName() + " --]\n"+ contenu + "\n[-- ------------------------------------------------------- --]\n");
			// Ecriture des données
			PrintWriter ecrireFichier = new PrintWriter(fichierCompte);
			ecrireFichier.println(contenu);
			ecrireFichier.close();
		} catch (Exception err) {
			addLogs("Erreur	- échec de l'écriture du compte " + compte.getId().toString(), true);
			addLogs(err.toString(), true);
		}
		
	}
	*/
}
