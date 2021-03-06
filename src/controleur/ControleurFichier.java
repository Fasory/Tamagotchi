package controleur;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.HashMap;

import modele.Compte;

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
	// DATA
	private final static File REP_DATA = new File("data");					// Répertoire contenant les données sauvegardées
	public final static File REP_JOUEUR = new File(REP_DATA, "user");		// Répertoire contenant les fichiers de données de chaque utilisateur
	public final static File REP_SAUVEGARDE = new File(REP_DATA, "save");	// Répertoire contenant les sauvegardes des parties
	// ASSET
	private final static File REP_ASSET = new File("assets");
	public final static File REP_IMG = new File(REP_ASSET, "img");
	public final static File FOND_MENU = new File(REP_IMG, "fondMenu.png");
	private final static File REP_FONT = new File(REP_ASSET, "font");
	public final static File FONT_KAWAII = new File(REP_FONT, "candyshop-2-black.ttf");
	
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
	 * Sérialise un objet dans un fichier avec le
	 * nom voulu dans le répertoire voulu
	 * 
	 * @param objet - Object à sérialisé
	 * @param nom - String représentant le nom du
	 * fichier où sera sérialisé l'object
	 * @param rep - File représentant le répertoire
	 * où se trouve le fichier
	 * @throws IOException 
	 */
	public void enregistrerObjet(Object objet, String nom, File rep) throws IOException {
		File fichier = new File(rep, nom);
		if (!repExiste(rep)) creeRep(rep);
		FileOutputStream fluxFichier = new FileOutputStream(fichier);
		ObjectOutputStream fluxSortant = new ObjectOutputStream(fluxFichier);
		fluxSortant.writeObject(objet);
		fluxSortant.flush();
		fluxSortant.close();
	}
	
	/**
	 * Permet de récupérer un objet sérialisé par
	 * le nom du fichier et du répertoire où il a
	 * été sérialisé
	 * 
	 * @param nom - String représentant le nom du
	 * fichier à charger
	 * @param rep - File représentant le répertoire
	 * où se trouve le fichier
	 * @return Object - désérialisé
	 * @throws Exception 
	 */
	public Object chargerObjet(String nom, File rep) throws Exception {
		File fichier = new File(rep, nom);
		FileInputStream fluxFichier = new FileInputStream(fichier);
		ObjectInputStream fluxEntrant = new ObjectInputStream(fluxFichier);
		Object obj = fluxEntrant.readObject();
		fluxEntrant.close();
		return obj;
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
					Compte compteRecupere = (Compte) chargerObjet(fichier.getName(), REP_JOUEUR);
					lsCompte.put(compteRecupere.getUtilisateur(), compteRecupere);
				} catch (Exception err) {
					addLogs("Erreur	-	échec de chargment du compte : " + fichier.getPath(), true);
					addLogs(err.toString(), true);
				}
			}
		}
		return lsCompte;
	}
	
	public void supprimerFichier(String nom, File rep) throws Exception {
		File fichier = new File(rep, nom);
		if (fichierExiste(fichier)) {
			if(!fichier.delete()) throw new Exception("Le fichier n'a pas pu être supprimé");
		} else {
			throw new Exception("Le fichier n'existe pas");
		}
	}
}
