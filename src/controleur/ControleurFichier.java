package controleur;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import modele.Compte;
import modele.ObjectId;

/**
 * Sous contrôleur qui a pour but de gérer la	<br/>
 * persistence des données de l'application		<br/>
 * 												<br/>
 * Intègre un système de logs afin de faciliter	<br/>
 * le débuggage et la maintenant liés à la		<br/>
 * persistence des données						<br/>
 */
public class ControleurFichier extends Controleur {
	
	private static boolean estCree = false;									// Repère de création d'une unique instance par type de controleur
	
	private File logs;												// Fichier logs du jour courant
	private FileOutputStream logsOutStream;							// Flux de sortie pour écrire dans le fichier logs du jour courant
	private File repLogs;											// Répertoire contenant tous les logs
	private boolean erreurLogs;										// Repère binaire si les logs du jour courant contiennent une erreur
	private final static File REP_DATA = new File("data");					// Répertoire contenant les données sauvegardées
	public final static File REP_JOUEUR = new File(REP_DATA, "user");		// Répertoire contenant les fichiers de données de chaque utilisateur
	public final static File REP_SAUVEGARDE = new File(REP_DATA, "save");	// Répertoire contenant les sauvegardes des parties
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des fichiers de l'application	<br/>
	 */
	public ControleurFichier() {
		super(estCree);
		estCree = true;
		
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
	@Override
	public void delControleur() {
		if (estCree) {
			if (!erreurLogs) {
				try {
					logsOutStream.close();
					Files.delete(logs.toPath());
				} catch (Exception err) {
					addLogs(err.toString(), true);
				}
			}
			estCree = false;
		}
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
		if (!repExiste(REP_DATA)) creeRep(REP_DATA);
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
	
	/**
	 * Permet de sauvegarder le compte dans un fichier crypté
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
	 * @param compte - Compte à sauvegarder
	 * @return boolean - Vrai si enregistré avec succès, faux sinon
	 */
	public boolean enregistrer(ObjectId objet, File rep) {
		if (!repExiste(rep)) creeRep(rep);
		File fichierCompte = new File(rep, objet.getId().toString());
		byte[] encodeCompte = ControleurGeneral.ctrlSecurite.crypter(objet.toString().getBytes());
		try {
			ecrireFichier(fichierCompte, encodeCompte);
			return true;
		} catch (IOException err) {
			addLogs("Erreur	-	échec d'enregistrement de compte", true);
			return false;
		}
	}
	
	/**
	 * Permet de récupérer un compte enregistré dans un fichier crypté
	 * par l'UUID du compte
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
	 * @param id - UUID représentant le compte à charger
	 * @return Compte - compte de lié à l'UUID
	 */
	public Compte chargerCompte(UUID id) {
		File fichierCompte = new File(REP_JOUEUR, id.toString());
		String[] contenu;
		try {
			contenu = new String(ControleurGeneral.ctrlSecurite.decrypter(lireFichier(fichierCompte))).split("\n");
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException err) {
			addLogs("Erreur	-	échec de récupération du fichier " + fichierCompte.getPath(), true);
			addLogs(err.toString(), true);
			return null;
		}
		// Vérification de l'intégrité des données du fichier
		// 4 lignes dû au split s'il n'y a pas au moins une partie de crée (sinon il y a 5 ligne)
		if (contenu.length != 4 || !fichierCompte.getName().equals(contenu[0]) || (contenu.length == 5 && contenu[4].split(" ").length > ControleurGeneral.NB_MAX_PARTIE)) {
			addLogs("Erreur	-	le fichier " + fichierCompte.getPath() + " est illisible", true);
			return null;
		}
		String[] partiesStr;
		UUID[] partiesId;
		if (contenu.length == 5) {
			partiesStr =  contenu[4].split(" ");
			partiesId = new UUID[partiesStr.length];
			for (int i = 0; i < partiesStr.length; i++) {
				try {
					partiesId[i] = UUID.fromString(partiesStr[i]);
				} catch (Exception err) {
					addLogs("Erreur	-	impossible de retrouver les parties liées au compte " + fichierCompte.getPath(), true);
					addLogs(err.toString(), true);
					return null;
				}
			}
		} else {
			partiesId = new UUID[0];
		}
		// Reconstruction du compte avec succès
		return new Compte(contenu[1], contenu[3], contenu[2], id, partiesId);
	}
	
	/**
	 * Permet de récupérer la liste des comptes présent
	 * dans le répertoire prévu à cet effet
	 * 
	 * @return HashMap<String, Compte> - représentant la
	 * collection des comptes récupérés et ordonnés par
	 * le nom de l'utilisateur du compte
	 */
	public HashMap<String, Compte> getListeCompte() {
		HashMap<String, Compte> lsCompte = new HashMap<String, Compte>();
		if (repExiste(REP_JOUEUR)) {
			// On crée un filtre qui accepte que les fichier qui ne sont pas des répertoires
			FileFilter filtre = new FileFilter() {
				@Override
				public boolean accept(File fichier) {return fichier.isFile();}
			};
			for (File fichier : REP_JOUEUR.listFiles(filtre)) {
				try {
					Compte compteRecupere = chargerCompte(UUID.fromString(fichier.getName()));
					if (compteRecupere != null) lsCompte.put(compteRecupere.getUtilisateur(), compteRecupere);
				} catch (IllegalArgumentException err) {
					addLogs("Warning	-	un fichier imposteur a été détecté : " + fichier.getPath(), true);
				}
			}
		}
		return lsCompte;
	}
}
