package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomStyle;
import vue.modele.CustomTxt;
import vue.modele.CustomTxtField;

/**
 * La classe OubliMdp gère le menu "Oubli du mot de passe", 
 * menu accessible après le menu "Menu Principal",
 * lorsqu'on clique sur le bouton "Oubli mot de passe"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class OubliMdp extends Menu {
	
	private CustomTxtField txtId;
	private CustomTxtField txtMail;

	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * @param controleur- Controleur de l'application	<br/>	
	 */
	public OubliMdp() {
		// Appel au constructeur de la super classe Menu
		super();
		
		// Partie Affichage
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		// Formulaire ID / Mail
		JPanel formulaire = new JPanel(new GridBagLayout());
		formulaire.setOpaque(false);
		
		
		CustomLb lbId = new CustomLb("Identifiant", Color.WHITE, CustomStyle.ROSE_ALPHA);
		lbId.setHorizontalAlignment(SwingConstants.CENTER); 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 10);
		formulaire.add(lbId, gbc);
		
		
		txtId = new CustomTxtField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 0);
		formulaire.add(txtId, gbc);
		
		
		CustomLb lbMail = new CustomLb("Adresse Mail", Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 5, 10);
		formulaire.add(lbMail, gbc);
		
		
		txtMail = new CustomTxtField();
		txtMail.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 5, 0);
		formulaire.add(txtMail, gbc);
		
		// Construction du menu
		/*
		JLabel lbInfo_p1 = new JLabel("Veuillez entrer votre identifiant et votre adresse e-mail afin de réinitialiser");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p1, gbc);	
		
		
		JLabel lbInfo_p2 = new JLabel("votre mot de passe.");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p2, gbc);
		
		
		JLabel lbConsigne_p1 = new JLabel("La procédure de réinitialisation de mot de passe nécessite une connexion");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(lbConsigne_p1, gbc);
		
		
		JLabel lbConsigne_p2 = new JLabel("internet afin de recevoir un e-mail de vérification.");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbConsigne_p2, gbc);*/
		
		String contenu = "Veuillez entrer votre identifiant et votre adresse e-mail afin de réinitialiser\n" +
						 "votre mot de passe.\n" +
						 "\nLa procédure de réinitialisation de mot de passe nécessite une connexion\n" +
						 "internet afin de recevoir un e-mail de vérification.";
		CustomTxt consigne = new CustomTxt(contenu, 10, false, 50);
		consigne.setAlignmentX(LEFT_ALIGNMENT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(consigne, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 5, 0);
		add(formulaire, gbc);
		
		
		CustomLb lbAlerteConfirmation = new CustomLb(" ", 7, Color.WHITE, CustomStyle.ROUGE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		lsAlerte.put("info", lbAlerteConfirmation);
		add(lbAlerteConfirmation, gbc);
		
		
		JPanel panelBtn =  new JPanel(new GridBagLayout());
		panelBtn.setOpaque(false);
		
		
		CustomBtn btnRenitialisation = new CustomBtn("Réinitialiser", 10);
		lsCustomBtn.add(btnRenitialisation);
		btnRenitialisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRenitialisation();
			}
		});
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		panelBtn.add(btnRenitialisation, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Annuler", 10);
		lsCustomBtn.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		gbc.fill =  GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		panelBtn.add(btnRetour, gbc);
		
		
		gbc.fill =  GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(panelBtn, gbc);
	}
	
	
	@Override
	public void reinitialiser() {
		ControleurGeneral.ctrlAffichage.afficherAlerte("info", " ");
	}

	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de réinitialisation du mot de passe
	 */
	private void cmdRenitialisation() {
		ControleurGeneral.ctrlBouton.rqtReinitialiser(txtId.getText(), txtMail.getText());
	}
	
	/**
	 * Demande de retour au menu précédent
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	} 

}
