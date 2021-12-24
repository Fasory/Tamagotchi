package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomStyle;
import vue.modele.CustomTxt;
import vue.modele.CustomTxtField;

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
		this("", "Oui", "Non", false, true);
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
		this(message, "Oui", "Non", false, true);
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
		this(message, indicationVrai, indicationFaux, false, true);
	}
	
	public MenuConfirmation(String message, String indicationVrai, String indicationFaux, boolean saisie) {
		this(message, indicationVrai, indicationFaux, saisie, true);
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
	public MenuConfirmation(String message, String indicationVrai, String indicationFaux, boolean saisie, boolean alerte) {
		
		// Appel au constructeur de la super classe Menu
		super(CustomStyle.ROSE_FOND);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Construction du panel des boutons
		JPanel panelBtn = new JPanel(new GridBagLayout());
		panelBtn.setOpaque(false);
		
		
		CustomBtn btnVrai = new CustomBtn(indicationVrai, 12);
		lsCustomBtn.add(btnVrai);
		btnVrai.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdConfirmation();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 5);
		panelBtn.add(btnVrai, gbc);
		
		
		CustomBtn btnFaux = new CustomBtn(indicationFaux, 12);
		lsCustomBtn.add(btnFaux);
		btnFaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		gbc.gridx = 1;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 5, 0, 0);
		panelBtn.add(btnFaux, gbc);
		
		// Construction du menu
		CustomTxt indication = new CustomTxt(message);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 0);
		add(indication, gbc);
		
		
		if (saisie) {
			txtSaisie = new CustomTxtField();
			txtSaisie.setPreferredSize(new Dimension(95, 25));
			txtSaisie.setHorizontalAlignment(JTextField.CENTER);
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.insets = new Insets(0, 0, 0, 0);
			add(txtSaisie, gbc);
		}
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(panelBtn, gbc);
		
		
		if (alerte) {
			CustomLb lbAlerteSaisie = new CustomLb(" ", 7, Color.WHITE, CustomStyle.ROUGE_ALPHA);
			gbc.fill = GridBagConstraints.NONE;
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE;
			gbc.insets = new Insets(10, 0, 0, 0);
			lsAlerte.put("confirmAlerte", lbAlerteSaisie);
			add(lbAlerteSaisie, gbc);
		}
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
