package controleur;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class ControleurSecurite extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	// Constantes
	private final String CHAINE_CLEF = "myYh6TdAAmWNsrn23kuKbdpXiYJRMLbE8uiWsk7gn0XiHnYmF97qAsNZBYKEw5n4FxPpgbmGFXxwddqLFiyhQdlY7hgCnk1e8rn9OkEMWYkpXxAyY8cirlKc8XTNsLht";
	
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
		estCree++;
		
		// Initialisation de l'agorithme de chiffrement
		try {
			clef = new SecretKeySpec(CHAINE_CLEF.getBytes(), "AES");
			chiffrement = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException err) {
			ctrlFichier.addLogs("Erreur - échec de chargement de l'agorithme de chiffrement (AES-128)", true);
			ctrlFichier.addLogs(err.toString(), true);
		}
		// Initialisation de l'agorithme de hachage
		try {
			hachage = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException err) {
			ctrlFichier.addLogs("Erreur - échec de chargement de l'agorithme de hachage (SHA-256)", true);
			ctrlFichier.addLogs(err.toString(), true);
		}
	}
	
	/**
	 * Permet de hacher une chaîne de caractères				<br/>
	 * 															<br/>
	 * @param msg - String dont on souhaite obtenir le hash		<br/>
	 * @return String - hash du msg								<br/>
	 */
	public String hash(String msg) {
		return new String(hachage.digest(msg.getBytes()));
	}
	
	/**
	 * Permet de crypter des données
	 * 
	 * @param data - String représentant les données à crypter
	 * @return String - données crpytées
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String crypter(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		chiffrement.init(Cipher.ENCRYPT_MODE, clef);
        byte[] dataCryptee = chiffrement.doFinal(data.getBytes());
        return new String(dataCryptee);
	}
	
	/**
	 * Permet de décrypter des données
	 * 
	 * @param data - String représentant les données à décrypter
	 * @return String - données décyptées
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypter(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		chiffrement.init(Cipher.DECRYPT_MODE, clef);
        byte[] dataCryptee = chiffrement.doFinal(data.getBytes());
        return new String(dataCryptee);
	}
}
