package vue.fenetre;

import controleur.ControleurGeneral;
import vue.menu.MenuConfirmation;

public class FenetreConfirmation extends Fenetre {
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * Fenêtre secondaire ayant pour but de demander	<br/>
	 * un choix à l'utilisateur							<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public FenetreConfirmation() {
		super();
		
		setTitle("Confirmation");
		setSize(400, 250);
		setResizable(false);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//            A LA  FENETRE           //        
	////////////////////////////////////////
	
	/**
	* Demande d'annulation de la confirmation			<br/>
	*/
	@Override
	protected void cmdQuitter() {
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
	
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	/**
	 * Getteur											<br/>
	 * 													<br/>
	 * @return MenuConfirmation - renvoie le menu		<br/>
	 * courant											<br/>
	 */
	public MenuConfirmation getMenuConfirmation() {
		// Seul des MenuConfirmation sont dans le ContentPane de la fenêtre
		return (MenuConfirmation) panelCourant;
	}
}
