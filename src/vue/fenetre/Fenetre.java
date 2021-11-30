package vue.fenetre;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import vue.menu.Menu;

/**
 * Fenêtre modèle représentant la structure globale		<br/>
 * d'une fenêtre de l'application						<br/>
 * 														<br/>
 * Elle est liée à un contrôleur et possède				<br/>
 * des méthodes de gestions de fenêtres par				<br/>
 * défaut												<br/>
 */
public abstract class Fenetre extends JFrame {
	
	protected Menu panelCourant;
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param panelCourant - JPanel à afficher dans		<br/>
	 * la fenêtre										<br/>
	 */
	protected Fenetre(Menu panelCourant) {
		this();
		
		this.panelCourant = panelCourant;
		
		setContentPane(this.panelCourant);
	}
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	protected Fenetre() {
		super();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
		    public void windowClosing(WindowEvent evt) {
				cmdQuitter();
		   }
		});
	}
	
	/**
	 * Affiche la fenêtre en premier plan												<br/>
	 * 																					<br/>
	 * @param visible - boolean qui affecte directement la visibilité de la fenêtre		<br/>
	 */
	public void mettreEnAvant(boolean visible) {
		setVisible(visible);
		if (visible) setLocationRelativeTo(null);	// recentre la fenêtre
	}
	
	/**
	 * Change l'activité de la fenêtre, rendant ainsi possible ou impossible			<br/>
	 * les interactions liées à cette fenêtre											<br/>
	 * 																					<br/>
	 * @param enActivite - boolean qui affecte directement l'activite de la fenêtre		<br/>
	 */
	public void mettreEnPause(boolean interruption) {
		setEnabled(!interruption);
	}
	
	/**
	 * Change le contenu de la fenêtre par le nouveauPanel								<br/>
	 * 																					<br/>
	 * @param nouveauPanel - JPanel a affecté à la fenêtre								<br/>
	 */
	public void changePanel(Menu nouveauPanel) {
		this.panelCourant = nouveauPanel;
		setContentPane(panelCourant);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//            A LA  FENETRE           //        
	////////////////////////////////////////
	
	/**
	 * Demande une requête liée au bouton de fermeture de la fenêtre					<br/>
	 */
	protected abstract void cmdQuitter();
}
