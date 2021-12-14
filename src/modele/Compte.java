package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

import controleur.ControleurGeneral;

public class Compte extends ObjectId implements Serializable {
	
	private final String utilisateur;
	private String mdp;
	private final String mail;
	private HashSet<UUID> partiesId;								// Les UUID des parties se trouvent tous à gauche du tableau, dès qu'il y a un UUID à null, tous ceux qui suivent à droite seront considéré comme null
	
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
	public Compte(String utilisateur, String mdp, String mail, UUID id, HashSet<UUID> partiesId) {
		super(id);
		if (partiesId.size() > ControleurGeneral.NB_MAX_PARTIE) throw new IllegalArgumentException("UUID[] a une taille de " + partiesId.size() + " alors qu'au maximum il doit être de " + ControleurGeneral.NB_MAX_PARTIE);
		this.utilisateur = utilisateur;
		this.mdp = mdp;
		this.mail = mail;
		this.partiesId = new HashSet<UUID>(ControleurGeneral.NB_MAX_PARTIE);
		for (UUID partieId : partiesId) {
			this.partiesId.add(partieId);
		}
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
		this(utilisateur, mdp, mail, UUID.randomUUID(), new HashSet<UUID>());
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
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getMail() {
		return mail;
	}
	
	public HashSet<UUID> getPartiesId() {
		return partiesId;
	}
}
