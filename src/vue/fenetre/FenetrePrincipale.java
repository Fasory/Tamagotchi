package vue.fenetre;

import controleur.ControleurGeneral;
import vue.menu.Menu;

public class FenetrePrincipale extends Fenetre {
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * Initialisation de la fenêtre principale			<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public FenetrePrincipale(Menu panelCourant) {
		super(panelCourant);
		setLocationRelativeTo(null);
		setTitle("Tamagotchi");
		setSize(1024,640);
		setResizable(false);
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
	protected void cmdQuitter() {
		ControleurGeneral.ctrlBouton.rqtDemandeQuitter();
	}
	
}
