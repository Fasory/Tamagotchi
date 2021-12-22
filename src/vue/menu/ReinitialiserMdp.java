package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;

public class ReinitialiserMdp extends Menu {
	
	private JPasswordField txtMdp;
	private JPasswordField txtMdpConfirm;
	
	/**
	 * Constructeur de la classe ReinitialiserMdp
	 */
	
	public ReinitialiserMdp() {
		
		// Appel au constructeur de la super classe Menu
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Formulaire ID / Mail
		JPanel formulaire = new JPanel(new GridBagLayout());
		
		
		JLabel lbMdp = new JLabel("Nouveau mot de passe");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 10);
		formulaire.add(lbMdp, gbc);
		
		
		txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdp, gbc);
		
		
		JLabel lbMdpConfirm = new JLabel("Confirmez le mot de passe");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 5, 10);
		formulaire.add(lbMdpConfirm, gbc);
		
		
		txtMdpConfirm = new JPasswordField();
		txtMdpConfirm.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdpConfirm, gbc);
		
		
		// Création du menu
		JLabel lbInfo = new JLabel("Veuillez saisir votre nouveau mot de passe.");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(formulaire, gbc);
		
		
		JLabel lbAlerte = new JLabel(" ");
		lbAlerte.setForeground(COULEUR_ALERTE);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(5, 0, 0, 0);
		lsAlerte.put("verif", lbAlerte);
		add(lbAlerte, gbc);
		
		
		CustomBtn btnReinitialiser = new CustomBtn("Réinitialiser");
		lsCustomBtn.add(btnReinitialiser);
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdReinitialiser();
			}
		});
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(btnReinitialiser, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Annuler");
		lsCustomBtn.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(btnRetour, gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande d'affichage de la politique de confidentialité
	 */
	private void cmdReinitialiser() {
		ControleurGeneral.ctrlBouton.rqtChangeMdp(txtMdp.getPassword(), txtMdpConfirm.getPassword());
	}
	
	/**
	 * Demande d'affichage de la politique de confidentialité
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
}
