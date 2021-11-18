package modele;

import java.util.HashMap;
import java.util.UUID;

import controleur.ControleurGeneral;

public class Compte {
	
	private final String utilisateur;
	private String mdp;
	private String mail;
	private final UUID id;
	private UUID[] partiesId;
	
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
	public Compte(String utilisateur, String mdp, String mail, UUID id, UUID[] partiesId) {
		if (partiesId.length > ControleurGeneral.NB_MAX_PARTIE) throw new IllegalArgumentException("UUID[] a une taille de " + partiesId.length + " alors qu'au maximum il doit être de " + ControleurGeneral.NB_MAX_PARTIE);
		this.utilisateur = utilisateur;
		this.mdp = mdp;
		this.mail = mail;
		this.id = id;
		this.partiesId = new UUID[ControleurGeneral.NB_MAX_PARTIE];
		int i = 0;
		for (UUID partieId : partiesId) {
			this.partiesId[i] = partieId;
			i++;
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
		this(utilisateur, mdp, mail, UUID.randomUUID(), new UUID[0]);
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
	
	public UUID[] getPartiesId() {
		return partiesId;
	}
	
	@Override
	public String toString() {
		String apparence = id().toString() + "\n"
						 + utilisateur() + "\n"
						 + mail() + "\n"
						 + mdp() + "\n";
		return ;
	}
}
