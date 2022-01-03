package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomPwdField;
import vue.modele.CustomStyle;

/**
 * La classe ReinitialiserMdp gère le menu "Réinitialiser mot de passe", 
 * menu accessible après le menu "Oubli de mot de passe",
 * lorsqu'on clique sur le bouton "Réinitialiser"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class ReinitialiserMdp extends Menu {
	
	private CustomPwdField txtMdp;
	private CustomPwdField txtMdpConfirm;
	
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
		
		
		CustomLb lbMdp = new CustomLb("Nouveau mot de passe", Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 10);
		formulaire.add(lbMdp, gbc);
		
		
		txtMdp = new CustomPwdField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdp, gbc);
		
		
		CustomLb lbMdpConfirm = new CustomLb("Confirmez le mot de passe", Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 5, 10);
		formulaire.add(lbMdpConfirm, gbc);
		
		
		txtMdpConfirm = new CustomPwdField();
		txtMdpConfirm.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdpConfirm, gbc);
		
		
		// Création du menu
		CustomLb lbInfo = new CustomLb("Veuillez saisir votre nouveau mot de passe.", Color.WHITE, CustomStyle.ROSE_ALPHA);
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
		
		
		CustomLb lbAlerte = new CustomLb(" ", Color.WHITE, CustomStyle.ROSE_ALPHA);
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
