package vue.menu;

import java.awt.*;
import java.awt.event.*;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;

/**
 * La classe MenuPrincipal gère le menu "Menu Principal", 
 * menu accessible après le menu "Connexion",
 * lorsqu'on clique sur le bouton "Connexion" ou "Connexion anonyme"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class MenuPrincipal extends Menu {
	
	/**
	 * Constructeur de la classe MenuPrincipal
	 * 
	 * @param controleur - Controleur de l'application
	 */
	public MenuPrincipal() {
		
		// Appel au constructeur de la super classe Menu
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets marges =  new Insets(17, 35, 15, 35);
		
		
		CustomBtn btnCreerPartie = new CustomBtn("Créer une nouvelle partie", marges);
		lsCustomBtn.add(btnCreerPartie);
		btnCreerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuCreerPartie();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(btnCreerPartie, gbc);
		
		
		CustomBtn btnSelectionnerPartie = new CustomBtn("Sélectionner une partie", marges);
		lsCustomBtn.add(btnSelectionnerPartie);
		btnSelectionnerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuSelecPartie();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(btnSelectionnerPartie, gbc);
		
		
		CustomBtn btnOption = new CustomBtn("Options", marges);
		lsCustomBtn.add(btnOption);
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuOption();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(btnOption, gbc);
		
		
		CustomBtn btnScore = new CustomBtn("Voir les scores", marges);
		lsCustomBtn.add(btnScore);
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuScore();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(btnScore, gbc);
		
		
		CustomBtn btnDeconnexion = new CustomBtn("Déconnexion", marges);
		lsCustomBtn.add(btnDeconnexion);
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdDeconnexion();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(btnDeconnexion, gbc);
	}

	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	* Demande de changement de menu : MenuCreerPartie
	*/
	private void cmdMenuCreerPartie() {
		ControleurGeneral.ctrlBouton.rqtMenuCreerPartie();
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie
	*/
	private void cmdMenuSelecPartie() {
		ControleurGeneral.ctrlBouton.rqtMenuSelecPartie();
	}
	
	/**
	* Demande de changement de menu : MenuOption
	*/
	private void cmdMenuOption() {
		ControleurGeneral.ctrlBouton.rqtMenuOption();
	}
	
	/**
	* Demande de changement de menu : MenuScore
	*/
	private void cmdMenuScore() {
		ControleurGeneral.ctrlBouton.rqtMenuScore();
	}
	
	/**
	* Demande de déconnexion
	*/
	private void cmdDeconnexion() {
		ControleurGeneral.ctrlBouton.rqtDemandeDeconnexion(); 
	}
	
}
