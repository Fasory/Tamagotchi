package vue.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;
import vue.modole.CustomLb;
import vue.modole.CustomStyle;

/**
 * La classe Credits gère le menu "Crédits", 
 * menu accessible après le menu "Options"
 * losqu'on clique sur le bouton "Crédits"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class Credits extends Menu {
	/**
	 * Constructeur de la classe Credits
	 */
	public Credits() {
		// Appel au constructeur de la super classe Menu
		super();
		
		// partie affichage
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); 
		
		CustomLb lbCredits = new CustomLb("Realise par :",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 30);
		add(lbCredits, gbc);
		
		CustomLb lbJA = new CustomLb("BIDAULT Julie-Amelie : Chef de projet",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbJA, gbc);
		
		CustomLb lbclement = new CustomLb("BOUQUET Clement : Architecte logiciel",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbclement, gbc);
		
		CustomLb lbmatthias = new CustomLb("BRZUSTOWSKI Matthias : Analyste des besoins",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbmatthias, gbc);
		
		CustomLb lbarthur = new CustomLb("CASANOVA Arthur : Gestionnaire de la qualite/validation",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbarthur, gbc);
		
		CustomLb lbvictor = new CustomLb("HAGUET Victor : Developpeur senior",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 30, 30);
		add(lbvictor, gbc);
		
		CustomLb lbmusique = new CustomLb("Musique :",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbmusique, gbc);
		
		CustomLb lbtitre = new CustomLb("Titre : Tender Remains",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbtitre, gbc);
		
		CustomLb lbauteur = new CustomLb("Auteur : Myuu",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbauteur, gbc);
		
		CustomLb lblicence = new CustomLb("Licence : CC BY 3.0",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lblicence, gbc);
		
		CustomBtn btnRetour = new CustomBtn("Quitter les credits");
		lsCustomBtn.add(btnRetour);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetourOptions();
			}
		});
		add(btnRetour, gbc);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Menu option
	 */
	private void cmdRetourOptions() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}

}
