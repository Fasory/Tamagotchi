package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controleur.ControleurGeneral;

public class Option extends Menu {

	public Option(ControleurGeneral controleur) {
		super(controleur);
		
		// partie affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dmBouton = new Dimension(200,50);
		Dimension dmSlider = new Dimension(500, 25);
		
		
		JLabel txtVolume = new JLabel("Volume");
		txtVolume.setPreferredSize(new Dimension(95, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtVolume, gbc);
		
		JSlider barreVolume = new JSlider(0,100,20);
		barreVolume.setPreferredSize(dmSlider);
		barreVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				cmdChangeVolume();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(barreVolume, gbc);
		
		JLabel txtMusique = new JLabel("Musique");
		txtMusique.setPreferredSize(new Dimension(95, 25));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 0, 0);
		add(txtMusique, gbc);
		
		JSlider barreMusique = new JSlider(0,100,20);
		barreMusique.setPreferredSize(dmSlider);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(barreMusique, gbc);
		
		JButton btnCredits = new JButton("Crédits");
		btnCredits.setPreferredSize(dmBouton);
		btnCredits.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdAfficheCredits();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(btnCredits, gbc);
		
		JButton btnQuitterOptions = new JButton("Quitter les options");
		btnQuitterOptions.setPreferredSize(dmBouton);
		btnQuitterOptions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdQuitterOptions();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 20, 0);
		add(btnQuitterOptions, gbc);
		
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Menu des crédits
	 */
	public void cmdAfficheCredits() {
		ControleurGeneral.ctrlBouton.rqtAffichageCredits();
	}
	
	/**
	 * Demande de changement de menu : Retour vers l'ancien menu
	 */
	public void cmdQuitterOptions() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
	
	/**
	 * Demande de changement de Volume
	 */
	public void cmdChangeVolume() {
		ControleurGeneral.ctrlBouton.rqtChangeVolume();
	}
}
