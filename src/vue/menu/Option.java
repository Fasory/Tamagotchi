package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomSlider;
import vue.modele.CustomStyle;

/**
 * La classe Option gère le menu "Option", 
 * menu accessible après le menu "Menu Principal",
 * lorsqu'on clique sur le bouton "Connexion" ou "Connexion anonyme"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class Option extends Menu {
	
	/**
	 * Constructeur par défaut de la classe Option
	 */
	public Option() {
		this(false, false);
	}
	
	/**
	 * Constructeur avec paramètre (vraie si connexion en anonyme, faux sinon)
	 * @param anonyme
	 */
	public Option(boolean anonyme) {
		this(anonyme,false);
	}
	
	/**
	 * Constructeur avec paramètre anonyme (vraie si connexion en anonyme, faux sinon)
	 * 					 parametre pause (vraie si ouvert depuis le menu pause, faux sinon)
	 * @param anonyme
	 * @param pause
	 */

	public Option(boolean anonyme,boolean pause) {
		
		// Appel au constructeur de la super classe Menu
		super();
		
		// Partie affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dmSlider = new Dimension(500, 50);
		
		
		CustomLb txtVolume = new CustomLb("Volume",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtVolume, gbc);
		
		CustomSlider barreVolume = new CustomSlider(0,100, ControleurGeneral.ctrlAudio.getVolume());
		barreVolume.setPreferredSize(dmSlider);
		barreVolume.setMinorTickSpacing(5);
		barreVolume.setMajorTickSpacing(20);
		barreVolume.setMinimum(0);
		barreVolume.setMaximum(100);
		barreVolume.setPaintTicks(true);
		barreVolume.setPaintLabels(true);
		barreVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				cmdChangeVolume(barreVolume.getValue());
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(barreVolume, gbc);
		
		
		CustomLb txtMusique = new CustomLb("Musique",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 0, 0); 
		add(txtMusique, gbc);
		
		
		CustomSlider barreMusique = new CustomSlider(0,100,ControleurGeneral.ctrlAudio.getMusique());
		barreMusique.setOpaque(false);
		barreMusique.setPreferredSize(dmSlider);
		barreMusique.setMinorTickSpacing(5);
		barreMusique.setMajorTickSpacing(20);
		barreMusique.setMinimum(0);
		barreMusique.setMaximum(100);
		barreMusique.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				cmdChangeMusique(barreMusique.getValue());
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(barreMusique, gbc);
		
		
		JPanel btnPanel = new JPanel(new GridBagLayout());
		btnPanel.setOpaque(false);
		
		
		CustomBtn btnCredits = new CustomBtn("Crédits");
		lsCustomBtn.add(btnCredits);
		btnCredits.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent evt) {
				cmdAfficheCredits();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 30, 0);
		btnPanel.add(btnCredits, gbc);
		
		
		CustomBtn btnSupprimerCompte = new CustomBtn("Supprimer le compte");
		lsCustomBtn.add(btnSupprimerCompte);
		btnSupprimerCompte.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdSupprimerCompte();
			}
		});
		if (anonyme) btnSupprimerCompte.setEnabled(false);
		if (pause) btnSupprimerCompte.setEnabled(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		btnPanel.add(btnSupprimerCompte, gbc);
		
		
		CustomBtn btnQuitterOptions = new CustomBtn("Retour");
		lsCustomBtn.add(btnQuitterOptions);
		btnQuitterOptions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdQuitterOptions();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		btnPanel.add(btnQuitterOptions, gbc);
		
		

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(btnPanel, gbc);
		
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Menu des crédits
	 */
	private void cmdAfficheCredits() {
		ControleurGeneral.ctrlBouton.rqtAffichageCredits();
	}
	
	/**
	 * Demande de suppression du compte
	 */
	private void cmdSupprimerCompte() {
		ControleurGeneral.ctrlBouton.rqtSuppressionCompte();
	}
	
	/**
	 * Demande de changement de menu : Retour vers l'ancien menu
	 */
	private void cmdQuitterOptions() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
	
	/**
	 * Demande de changement de Volume
	 * @param volume - Volume appliqué aux bruitages 
	 */
	private void cmdChangeVolume(int volume) {
		ControleurGeneral.ctrlBouton.rqtChangeVolume(volume);
	}
	
	/**
	 * Demande de changement de Musique
	 * @param musique - Volument appliqué à la musique
	 */
	private void cmdChangeMusique(int musique) {
		ControleurGeneral.ctrlBouton.rqtChangeMusique(musique);
	}
}
