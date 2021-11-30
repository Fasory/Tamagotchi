package controleur;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class ControleurSecurite extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	
	// Constantes
	private final String CHAINE_CLEF = "myYh6TdAAmWNsrn23kuKbdpXiYJRMLbE";
	private final String HEX = "0123456789abcdef";
	
	private SecretKeySpec clef;						// Clef secrète AES-128
	private Cipher chiffrement;						// Algorithme de chiffrmeent AES-128
	private MessageDigest hachage;					// Algorithme de hachage SHA-256
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur de la sécurité de l'application	<br/>
	 */
	public ControleurSecurite() {
		super(estCree);
		estCree = true;
		// Initialisation de l'agorithme de chiffrement
		try {
			clef = new SecretKeySpec(CHAINE_CLEF.getBytes(), "AES");
			chiffrement = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de chargement de l'agorithme de chiffrement (AES-128)", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		// Initialisation de l'agorithme de hachage
		try {
			hachage = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de chargement de l'agorithme de hachage (SHA-256)", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
	}
	
	@Override
	public void delControleur() {
		if (estCree) {
			clef = null;
			chiffrement = null;
			hachage = null;
			estCree = false;
		}
	}
	
	/**
	 * Permet de hacher une chaîne de caractères				<br/>
	 * 															<br/>
	 * @param msg - String dont on souhaite obtenir le hash		<br/>
	 * @return String - hash du msg								<br/>
	 */
	public String hash(String msg) {
		hachage.reset();
		return conversionVersStr(hachage.digest(msg.getBytes()));
	}
	
	/**
	 * Permet de crypter des données							<br/>
	 * 															<br/>
	 * @param data - String représentant les données à crypter	<br/>
	 * @return String - données crpytées						<br/>
	 * 															<br/>
	 * @throws InvalidKeyException								<br/>
	 * @throws IllegalBlockSizeException						<br/>
	 * @throws BadPaddingException								<br/>
	 */
	public byte[] crypter(byte[] dataDecryptee) {
		byte[] dataCryptee = new byte[0];
		try {
			chiffrement.init(Cipher.ENCRYPT_MODE, clef);
	        dataCryptee = chiffrement.doFinal(dataDecryptee);
		} catch (Exception err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de chiffrement", true);
			ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
		}
		return dataCryptee;
	}
	
	/**
	 * Permet de décrypter des données							<br/>
	 * 															<br/>
	 * @param data - String représentant les données à			<br/>
	 * décrypter												<br/>
	 * @return String - données décyptées						<br/>
	 * 															<br/>
	 * @throws InvalidKeyException								<br/>
	 * @throws IllegalBlockSizeException						<br/>
	 * @throws BadPaddingException								<br/>
	 */
	public byte[] decrypter(byte[] dataCryptee) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		chiffrement.init(Cipher.DECRYPT_MODE, clef);
	    return chiffrement.doFinal(dataCryptee);
	}
	
	/**
	 * Permet de convertir un tableau d'octets en une chaine	<br/>
	 * de caractères avec pour chaque octet, la chiffre			<br/>
	 * hexadécimal associé										<br/>
	 * 															<br/>
	 * @param lsOctet - Byte[] représentant le talbeau d'octet	<br/>
	 * à convertir en chaine de caractères						<br/>
	 * @return String - représentant le résultat de la			<br/>
	 * conversion												<br/>
	 */
	private String conversionVersStr(byte[] lsOctet) {
		String resultat = "";
		for (byte octet : lsOctet) {
			resultat += HEX.charAt((0xF0 & octet) >> 4);		// On garde les 4 premiers bits de l'cotet et on les shift à droite pour avoir le nombre en hexa
			resultat += HEX.charAt(0x0F & octet);				// On garde les 4 derniers bits de l'octet pour avoir le nombre en hexa
		}
		return resultat.toString();
	}
}
