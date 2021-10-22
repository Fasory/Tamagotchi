package menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;

/**
 * Menu mettant à disposition un choix binaire		<br/>
 * retournant vrai ou faux au contrôleur			<br/>
 */
public abstract class MenuDeConfirmation extends Menu {
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Par défaut, le texte d'idication est inexistant etles boutons binaires sont					<br/>
	 * représentés par "Oui" / "Non"																<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 */
	public MenuDeConfirmation(Controleur controleur) {
		// Appel du modèle général de constructeur
		this(controleur, "", "Oui", "Non");
	}
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Par défaut, les boutons binaires sont représentés par "Oui" / "Non"							<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 * @param message - String contenant le message à afficher dans la fenêtre de confirmation		<br/>
	 */
	public MenuDeConfirmation(Controleur controleur, String message) {
		// Appel du modèle général de constructeur
		this(controleur, message, "Oui", "Non");
	}
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Modèle général de construction du menu														<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 * @param message - String contenant le message à afficher dans la fenêtre de confirmation		<br/>
	 * @param indicationVrai - String afficher sur le bouton de retour vrai							<br/>
	 * @param indicationFaux - String afficher sur le bouton de retour faux							<br/>
	 */
	public MenuDeConfirmation(Controleur controleur, String message, String indicationVrai, String indicationFaux) {
		super(controleur);
		
		// Partie Affichage
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);
		
		
		JLabel indication = new JLabel(message);
		add(indication);
		
		
		JPanel panelBtn = new JPanel(new GridLayout(1, 2, 40, 0)) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(200, 350);
			}
		};
		
		
		JButton btnVrai = new JButton(indicationVrai);
		btnVrai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdConfirmation();
			}
		});
		panelBtn.add(btnVrai);
		
		
		JButton btnFaux = new JButton(indicationFaux);
		btnFaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		panelBtn.add(btnFaux);
		
		
		GridBagConstraints gridBagC = new GridBagConstraints();
		gridBagC.gridx = 1;
		gridBagC.insets = new Insets(20,0,30,0);  //top padding
		gridBag.setConstraints(indication, gridBagC);
		gridBag.setConstraints(panelBtn, gridBagC);
		
		
		add(panelBtn);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/*
	 * Demande d'une requête liée au bouton btnVrai		<br/>
	 */
	public abstract void cmdConfirmation();
	
	/*
	 * Demande d'annulation de confirmation				<br/>
	 */
	public void cmdRetour() {
		controleur.rqtAnnuleConfirmation();
	}
}
