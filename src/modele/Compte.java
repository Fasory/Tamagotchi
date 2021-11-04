package modele;

import java.util.HashMap;
import java.util.UUID;

public class Compte {
	
	private final String utilisateur;
	private final String mdp;
	private final String mail;
	private final UUID id;
	private HashMap<UUID, Partie> partie;
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * @param utilisateur - String représentant le			<br/>
	 * nom de l'utilisateur									<br/>
	 * @param mdp - String représentant le hash du			<br/>
	 * mot de passe de l'utilisateur						<br/>
	 * @param mail - String représentant l'adresse			<br/>
	 * mail de l'utilisateur								<br/>
	 * @param id - UUID lier au compte de l'utilisateur		<br/>
	 * @param partie - Partie[] représentant la liste		<br/>
	 * des parties en cours de l'utilisateurs				<br/>
	 */
	public Compte(String utilisateur, String mdp, String mail, UUID id, HashMap<UUID, Partie> partie) {
		this.utilisateur = utilisateur;
		this.mdp = mdp;
		this.mail = mail;
		this.id = id;
		this.partie = partie;
	}
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	public String getMdp() {
		return mdp;
	}
}
