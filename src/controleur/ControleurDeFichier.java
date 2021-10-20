package controleur;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar; 

public class ControleurDeFichier {
	
	private File logs;								// Fichier logs du jour courant
	private FileOutputStream logsOutStream;			// Flux de sortie pour écrire dans le fichier logs du jour courant
	private File dirLogs;							// Répertoire contenant tous les logs
	private boolean erreurLogs;						// Repère binaire si les logs du jour courant contiennent une erreur
	private File dirData;							// Répertoire contenant les données sauvegardées
	
	/**
	 * Constructeur
	 * 
	 * Initialisation du controleur des fichiers de l'application
	 */
	public ControleurDeFichier() {
		init_logs();
		init_data();
	}
	
	/**
	 * Pré-Destructeur manuel
	 * 
	 * Supprime le fichier logs associé à l'utilisation en cours
	 * si aucune erreur n'a été rapporté
	 */
	public void delControleurDeFichier() {
		if (!erreurLogs) {
			try {
				logs.delete();
			} catch (Exception err) {
				System.err.println(err);
			}
		}
	}
	
	/**
	 * Initalisation de logs
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
		addLogs("***************************************");
		addLogs("		-	" + ((date.get(Calendar.HOUR_OF_DAY)<10) ? "0" : "") + date.get(Calendar.HOUR_OF_DAY) + ":" + ((date.get(Calendar.MINUTE)<10) ? "0" : "") + date.get(Calendar.MINUTE) + ":" + ((date.get(Calendar.SECOND)<10) ? "0" : "") + date.get(Calendar.SECOND)
				+ " - " + ((date.get(Calendar.DAY_OF_MONTH)<10) ? "0" : "") + date.get(Calendar.DAY_OF_MONTH) + "/" + (((date.get(Calendar.MONTH)+1)<10) ? "0" : "") + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR));
	}
	
	/**
	 * Initialisation de data
	 */
	private void init_data() {
		dirData = new File("data");
		if (!dirExiste(dirData)) creeDir(dirData);
	}
	
	/**
	 * Teste l'existence du dossier dir
	 * 
	 * @return bool - existence du dossier dir
	 */
	private boolean dirExiste(File dir) {
		return dir.exists() && dir.isDirectory();
	}
	
	/**
	 * Teste l'existence du fichier logs du jour
	 * 
	 * @return bool - existence du fichier logs
	 */
	public boolean logsExiste() {
		return logs.exists() && logs.isFile();
	}
	
	/**
	 * Créer le dossier dir
	 */
	private void creeDir(File dir) {
		if (!dir.mkdir()) {
			if (dir.getName() != "logs") addLogs("Erreur		- échec de la création du dossier " + dir.getName(), true);
			else System.err.println("Erreur - échec de la création du fichier " + dir.getName());
		}
	}
	
	/**
	 * Créer un fichier le fichier log du jour
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
	 * Ajoute une ligne de rapport dans le fichier logs
	 * qui n'est pas une erreur
	 * 
	 * @param rapport - String contenant le rapport à ajouter aux logs
	 */
	public void addLogs(String rapport) {
		addLogs(rapport, false);
	}
	
	/**
	 * Ajoute une ligne de rapport dans le fichier logs
	 * Possibilité de préciser si la ligne est une erreur ou non
	 * auquel cas les logs ne seront pas supprimés
	 * 
	 * @param rapport - String contenant le rapport à ajouter aux logs
	 * @param typeErreur - vrai si le rapport est une erreur
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
