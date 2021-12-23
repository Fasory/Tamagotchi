package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;
import vue.modole.CustomLb;
import vue.modole.CustomStyle;
import vue.modole.CustomTxtField;

/**
 * MenuConfirmation met à disposition un choix binaire		<br/>
 * retournant vrai ou faux au contrôleur					<br/>
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI	<br/>
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
	public MenuConfirmation() {
		// Appel du modèle général de constructeur
		this("", "Oui", "Non", false);
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
	public MenuConfirmation(String message) {
		// Appel du modèle général de constructeur
		this(message, "Oui", "Non", false);
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
	public MenuConfirmation(String message, String indicationVrai, String indicationFaux) {
		// Appel du modèle général de constructeur
		this(message, indicationVrai, indicationFaux, false);
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
	public MenuConfirmation(String message, String indicationVrai, String indicationFaux, boolean saisie) {
		
		// Appel au constructeur de la super classe Menu
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Construction du panel des boutons
		JPanel panelBtn = new JPanel(new GridBagLayout());
		
		
		CustomBtn btnVrai = new CustomBtn(indicationVrai);
		lsCustomBtn.add(btnVrai);
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
		
		
		CustomBtn btnFaux = new CustomBtn(indicationFaux);
		lsCustomBtn.add(btnFaux);
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
		CustomLb indication = new CustomLb(message,Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 25, 0);
		add(indication, gbc);
		
		
		if (saisie) {
			txtSaisie = new CustomTxtField();
			txtSaisie.setPreferredSize(new Dimension(95, 25));
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.insets = new Insets(0, 0, 0, 0);
			add(txtSaisie, gbc);
		}
			
		
		CustomLb lbAlerteSaisie = new CustomLb(" ");
		lbAlerteSaisie.setForeground(COULEUR_ALERTE);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 0);
		lsAlerte.put("confirmAlerte", lbAlerteSaisie);
		add(lbAlerteSaisie, gbc);
		
		
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
	protected abstract void cmdConfirmation(); 
	
	/*
	 * Demande d'annulation de confirmation				<br/>
	 */
	protected void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
}
