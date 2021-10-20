package fenetre;

import javax.swing.JFrame;

import controleur.Controleur;

/**
 * Fenêtre modèle représentant la structure globale		<br/>
 * d'une fenêtre de l'application						<br/>
 * 														<br/>
 * Elle est liée à un contrôleur et possède				<br/>
 * des méthodes de gestions de fenêtres par				<br/>
 * défaut												<br/>
 */
public abstract class Fenetre extends JFrame {
	
	protected Controleur controleur;
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Contoleur de l'application
	 */
	protected Fenetre(Controleur controleur) {
		super();
		
		this.controleur = controleur;
	}
	
	/**
	 * Affiche la fenêtre en premier plan, par défaut, quand on rend visible			<br/>
	 * une fenêtre, on la rend active													<br/>
	 * 																					<br/>
	 * @param visible - boolean qui affecte directement la visibilité de la fenêtre		<br/>
	 */
	public void setAffiche(boolean visible) {
		if (visible) setActivite(true);
		setVisible(visible);
	}
	
	/**
	 * Change l'activité de la fenêtre, rendant ainsi possible ou impossible			<br/>
	 * les interactions liées à cette fenêtre											<br/>
	 * 																					<br/>
	 * @param enActivite - boolean qui affecte directement l'activit de la fenêtre		<br/>
	 */
	public void setActivite(boolean enActivite) {
		setEnabled(enActivite);
	}
}
