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

import controleur.ControleurGeneral;

public class CreerPartie extends Menu {

	public CreerPartie(ControleurGeneral controleur) {
		super(controleur);
		// TODO Auto-generated constructor stub
		// partie affichage
		setLayout(new GridBagLayout()); // nouvelle grille
		GridBagConstraints gbc = new GridBagConstraints();
				
		JPanel panelBtn = new JPanel(new GridLayout(4, 1, 0, 50)) { // nouveau panel
			@Override
			public Dimension getPreferredSize() { // dimension du panel
				return new Dimension(200, 350);
			}
		};
		
		JLabel lbCredits = new JLabel("Choisir le type de votre Tamagotchi");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbCredits, gbc);
		
		JButton btnJouer = new JButton("Jouer");
		
		panelBtn.add(btnJouer);
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		add(panelBtn);
		
		JButton btnRetour = new JButton("Retour");
		
		panelBtn.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		add(panelBtn);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	public void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
	
	public void cmdJouer() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
}
