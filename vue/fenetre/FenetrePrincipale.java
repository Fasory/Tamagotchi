package fenetre;

import javax.swing.JPanel;

import controleur.Controleur;

public class FenetrePrincipale extends Fenetre {
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * Initialisation de la fenêtre principale			<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public FenetrePrincipale(Controleur controleur, JPanel panelCourant) {
		super(controleur, panelCourant);
		setLocationRelativeTo(null);
		setTitle("Tamagotchi");
		setSize(1024,640);
		//setResizable(false);
		mettreEnAvant(true);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//            A LA  FENETRE           //        
	////////////////////////////////////////
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	public void cmdQuitter() {
		controleur.rqtDemandeQuitter();
	}
	
}
