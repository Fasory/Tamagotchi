package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
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
		Dimension dmSlider = new Dimension(500, 50);
		
		
		JLabel txtVolume = new JLabel("Volume");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtVolume, gbc);
		
		JSlider barreVolume = new JSlider(0,100, ControleurGeneral.ctrlAudio.getVolume());
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
		
		JLabel txtMusique = new JLabel("Musique");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(20, 0, 0, 0);
		add(txtMusique, gbc);
		
		JSlider barreMusique = new JSlider(0,100,ControleurGeneral.ctrlAudio.getMusique());
		barreMusique.setPreferredSize(dmSlider);
		barreMusique.setMinorTickSpacing(5);
		barreMusique.setMajorTickSpacing(20);
		barreMusique.setMinimum(0);
		barreMusique.setMaximum(100);
		barreMusique.setPaintTicks(true);
		barreMusique.setPaintLabels(true);
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
	 * @param volume
	 */
	public void cmdChangeVolume(int volume) {
		ControleurGeneral.ctrlBouton.rqtChangeVolume(volume);
	}
	
	/**
	 * Demande de changement de Musique
	 * @param musique
	 */
	public void cmdChangeMusique(int musique) {
		ControleurGeneral.ctrlBouton.rqtChangeMusique(musique);
	}
}
