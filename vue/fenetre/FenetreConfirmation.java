package fenetre;

import controleur.ControleurGeneral;

public class FenetreConfirmation extends Fenetre {
	
	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * Fenêtre secondaire ayant pour but de demander	<br/>
	 * un choix à l'utilisateur							<br/>
	 * 													<br/>
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public FenetreConfirmation(ControleurGeneral controleur) {
		super(controleur);
		
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
	public void cmdQuitter() {
		ControleurGeneral.ctrlBouton.rqtAnnuleConfirmation();
	}
	
	
}
