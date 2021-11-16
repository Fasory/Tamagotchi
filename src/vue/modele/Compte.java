package vue.modele;

import java.util.HashMap;
import java.util.UUID;

public class Compte {
	
	private final String utilisateur;
	private String mdp;
	private String mail;
	private final UUID id;
	private HashMap<UUID, Partie> parties;
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * @param utilisateur - String représentant le			<br/>
	 * nom de l'utilisateur									<br/>
	 * @param mdp - String représentant le hash du			<br/>
	 * mot de passe de l'utilisateur						<br/>
	 * @param mail - String représentant le hash 			<br/>
	 * l'adresse mail de l'utilisateur						<br/>
	 * @param id - UUID lier au compte de l'utilisateur		<br/>
	 * @param partie - Partie[] représentant la liste		<br/>
	 * des parties en cours de l'utilisateurs				<br/>
	 */
	public Compte(String utilisateur, String mdp, String mail, UUID id, HashMap<UUID, Partie> partie) {
		this.utilisateur = utilisateur;
		this.mdp = mdp;
		this.mail = mail;
		this.id = id;
		this.parties = partie;
	}
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * Par défaut, un UUID est généré aléatoirement			<br/>
	 * et aucune partie est associée au compte				<br/>
	 * 														<br/>
	 * @param utilisateur - String représentant le			<br/>
	 * nom de l'utilisateur									<br/>
	 * @param mdp - String représentant le hash du			<br/>
	 * mot de passe de l'utilisateur						<br/>
	 * @param mail - String représentant l'adresse			<br/>
	 * mail de l'utilisateur								<br/>
	 */
	public Compte(String utilisateur, String mdp, String mail) {
		this(utilisateur, mdp, mail, UUID.randomUUID(), new HashMap<UUID, Partie>(3));
	}
	
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	public String getUtilisateur() {
		return utilisateur;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public String getMail() {
		return mail;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getStrIdParties() {
		String strIdParties = "";
		for (UUID id :  parties.keySet().toArray(new UUID[parties.keySet().size()])) {
			strIdParties += id.toString() + " ";
		}
		return strIdParties;
	}
	
	public HashMap<UUID, Partie> getParties() {
		return parties;
	}
}
