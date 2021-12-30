package vue.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;



public class Pause extends Menu {
	
	/**
	 * Constructeur de la classe Score
	 */
	
	public Pause() {
		// Appel au constructeur de la super classe Menu
		super();
		// TODO Auto-generated constructor stub
		
		// Partie affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		CustomBtn btnReprendre = new CustomBtn("Reprendre");
		lsCustomBtn.add(btnReprendre);
		btnReprendre.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdReprendre();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(btnReprendre, gbc);
		
		
		CustomBtn btnSauvegarde = new CustomBtn("Sauvegarder");
		lsCustomBtn.add(btnSauvegarde);
		btnSauvegarde.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdSauvegarde();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(btnSauvegarde, gbc);
		
		
		CustomBtn btnOptions = new CustomBtn("Options");
		lsCustomBtn.add(btnOptions);
		btnOptions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdOptions();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(btnOptions, gbc);
		
		
		CustomBtn btnQuitter = new CustomBtn("Quitter");
		lsCustomBtn.add(btnQuitter);
		btnQuitter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdQuitter();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(btnQuitter, gbc);
	}
		
		////////////////////////////////////////
		//           COMMANDES LIEES          //
		//             AUX BOUTTONS           //        
		////////////////////////////////////////
		
	/**
	* Demande de changement de menu : Menu des options
	*/
	private void cmdOptions() {
		ControleurGeneral.ctrlBouton.rqtMenuOption();
	}
	
	/**
	* Demande de sauvegarde de la partie
	*/
	private void cmdSauvegarde() {
		ControleurGeneral.ctrlBouton.rqtAfficheSauvegardeMenu();
	}

	/**
	* Demande de changement de menu. Retour au menu de jeu
	*/
	private void cmdReprendre() {
		ControleurGeneral.ctrlBouton.rqtReprendre();
	}
	
	/**
	* Demande de changement de menu. Retour au menu principale
	*/
	private void cmdQuitter() {
		ControleurGeneral.ctrlAffichage.menuPrecedent(2);
	}

}