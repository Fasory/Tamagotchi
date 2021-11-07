package menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

/**
 * Menu mettant à disposition un choix binaire		<br/>
 * retournant vrai ou faux au contrôleur			<br/>
 */
public abstract class MenuConfirmation extends Menu {
	
	protected JTextField txtSaisie;
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Par défaut, le texte d'idication est inexistant etles boutons binaires sont					<br/>
	 * représentés par "Oui" / "Non" et le champ de saisie n'est pas affiché						<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 */
	public MenuConfirmation(ControleurGeneral controleur) {
		// Appel du modèle général de constructeur
		this(controleur, "", "Oui", "Non", false);
	}
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Par défaut, les boutons binaires sont représentés par "Oui" / "Non" et le champ				<br/>
	 * de saisie n'est pas affiché																	<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 * @param message - String contenant le message à afficher dans la fenêtre de confirmation		<br/>
	 */
	public MenuConfirmation(ControleurGeneral controleur, String message) {
		// Appel du modèle général de constructeur
		this(controleur, message, "Oui", "Non", false);
	}
	
	/**
	 * Constructeur																					<br/>
	 * 																								<br/>
	 * Par défaut, le champ de saisie n'est pas affiché												<br/>
	 * 																								<br/>
	 * @param controleur - Contoleur de l'application												<br/>
	 * @param message - String contenant le message à afficher dans la fenêtre de confirmation		<br/>
	 * @param indicationVrai - String afficher sur le bouton de retour vrai							<br/>
	 * @param indicationFaux - String afficher sur le bouton de retour faux							<br/>
	 */
	public MenuConfirmation(ControleurGeneral controleur, String message, String indicationVrai, String indicationFaux) {
		// Appel du modèle général de constructeur
		this(controleur, message, indicationVrai, indicationFaux, false);
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
	 * @param saisie - boolean affiche un champ de saisie											<br/>
	 */
	public MenuConfirmation(ControleurGeneral controleur, String message, String indicationVrai, String indicationFaux, boolean saisie) {
		super(controleur);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Construction du panel des boutons
		JPanel panelBtn = new JPanel(new GridBagLayout());
		Dimension dmBouton = new Dimension(110,25);
		
		
		JButton btnVrai = new JButton(indicationVrai);
		btnVrai.setPreferredSize(dmBouton);
		btnVrai.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdConfirmation();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 20);
		panelBtn.add(btnVrai, gbc);
		
		
		JButton btnFaux = new JButton(indicationFaux);
		btnFaux.setPreferredSize(dmBouton);
		btnFaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelBtn.add(btnFaux, gbc);
		
		// Construction du menu
		JLabel indication = new JLabel(message);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 25, 0);
		add(indication, gbc);
		
		
		if (saisie) {
			txtSaisie = new JTextField();
			txtSaisie.setPreferredSize(new Dimension(95, 25));
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.insets = new Insets(0, 0, 0, 0);
			add(txtSaisie, gbc);
			
			
			JLabel lbAlerteSaisie = new JLabel(" ");
			lbAlerteSaisie.setForeground(COULEUR_ALERTE);
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.insets = new Insets(0, 0, 10, 0);
			lsAlerte.put("saisie", lbAlerteSaisie);
			add(lbAlerteSaisie, gbc);
		}
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(panelBtn, gbc);
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
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
}
