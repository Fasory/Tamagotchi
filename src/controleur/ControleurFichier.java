package controleur;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Calendar; 

/**
 * Sous contrôleur qui a pour but de gérer la	<br/>
 * persistence des données de l'application		<br/>
 * 												<br/>
 * Intègre un système de logs afin de faciliter	<br/>
 * le débuggage et la maintenant liés à la		<br/>
 * persistence des données						<br/>
 */
public class ControleurFichier extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	private File logs;								// Fichier logs du jour courant
	private FileOutputStream logsOutStream;			// Flux de sortie pour écrire dans le fichier logs du jour courant
	private File dirLogs;							// Répertoire contenant tous les logs
	private boolean erreurLogs;						// Repère binaire si les logs du jour courant contiennent une erreur
	private File dirData;							// Répertoire contenant les données sauvegardées
	
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
	public void delControleurDeFichier() {
		if (!erreurLogs) {
			try {
				logsOutStream.close();
				Files.delete(logs.toPath());
			} catch (Exception err) {
				addLogs(err.toString(), true);
			}
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
		dirLogs = new File("logs");
		Calendar date = Calendar.getInstance();
		// Affichage par deux digit (exemple : 9-1-2021 -> 09-01-2021)
		logs = new File(dirLogs, "logs-" + date.get(Calendar.YEAR) + "-" + (((date.get(Calendar.MONTH)+1)<10) ? "0" : "") + (date.get(Calendar.MONTH)+1) + "-" + ((date.get(Calendar.DAY_OF_MONTH)<10) ? "0" : "") + date.get(Calendar.DAY_OF_MONTH) + ".txt");
		if (!dirExiste(dirLogs)) creeDir(dirLogs);
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
		dirData = new File("data");
		if (!dirExiste(dirData)) creeDir(dirData);
	}
	
	/**
	 * Teste l'existence du dossier dir								<br/>
	 * 																<br/>
	 * @param dir - répertoire dont il faut vérifier l'existence	<br/>
	 * @return bool - existence du dossier dir						<br/>
	 */
	private static boolean dirExiste(File dir) {
		return dir.exists() && dir.isDirectory();
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
	private void creeDir(File dir) {
		if (!dir.mkdir()) {
			if (dir.getName() != "logs") addLogs("Erreur		- échec de la création du dossier " + dir.getName(), true);
			else System.err.println("Erreur - échec de la création du fichier " + dir.getName());
		}
	}
	
	/**
	 * Créer un fichier le fichier log du jour		<br/>
	 */
	private void creeLogs() {
		if (!(dirLogs.exists() && dirLogs.isDirectory())) if (!dirLogs.mkdir()) System.err.println("Erreur - échec de la création du répertoire logs");
		// Fichier logs du jour
		try {
			logs.createNewFile();
		} catch (Exception err) {
			System.err.println("Erreur - échec de la création du fichier " + logs.getName());
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
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
