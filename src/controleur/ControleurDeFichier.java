package controleur;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar; 

public class ControleurDeFichier {
	
	private File logs;
	private FileOutputStream logsOutStream;
	private File dirData;
	
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
	 * Initalisation de logs
	 */
	private void init_logs() {
		Calendar date = Calendar.getInstance();
		logs = new File("logs\\logs-" + date.get(Calendar.YEAR) + "-" + (((date.get(Calendar.MONTH)+1)<10) ? "0" : "") + (date.get(Calendar.MONTH)+1) + "-" + ((date.get(Calendar.DAY_OF_MONTH)<10) ? "0" : "") + date.get(Calendar.DAY_OF_MONTH) + ".txt");
		if (!logsExiste()) creeLogs();
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
		if (!dirDataExiste()) creeDirData();
	}
	
	/**
	 * Teste l'existence du dossier data
	 * 
	 * @return bool - existence du dossier data
	 */
	private boolean dirDataExiste() {
		return dirData.exists() && dirData.isDirectory();
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
	 * Créer le dossier data
	 */
	private void creeDirData() {
		if (!dirData.mkdir()) addLogs("Erreur		- échec de la création du dossier data");
	}
	
	/**
	 * Créer un fichier le fichier log du jour
	 */
	private void creeLogs() {
		File dirLogs = new File("logs");
		if (!(dirLogs.exists() && dirLogs.isDirectory())) if (!dirLogs.mkdir()) System.err.println("Erreur - échec de la création du répertoire logs");
		try {
			logs.createNewFile();
		} catch (Exception err) {
			System.err.println("Erreur - échec de la création du fichier " + logs.getName());
		}
	}
	
	/**
	 * Ajoute une ligne de rapport dans le fichier logs
	 * 
	 * @param rapport
	 */
	public void addLogs(String rapport) {
		try {
			logsOutStream.write((rapport + "\n").getBytes());
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
