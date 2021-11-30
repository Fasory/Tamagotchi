package vue.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controleur.ControleurGeneral;

public class MenuPrincipal extends Menu {
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Controleur de l'application
	 */
	public MenuPrincipal() {
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		
		JPanel panelBtn = new JPanel(new GridLayout(5, 1, 0, 40)) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(200, 350);
			}
		};
		
		
		JButton btnCreerPartie = new JButton("Créer une nouvelle partie");
		btnCreerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuCreerPartie();
			}
		});
		panelBtn.add(btnCreerPartie);
		
		
		JButton btnSelectionnerPartie = new JButton("Sélectionner une partie");
		btnSelectionnerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuSelecPartie();
			}
		});
		panelBtn.add(btnSelectionnerPartie);
		
		
		JButton btnOption = new JButton("Options");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuOption();
			}
		});
		panelBtn.add(btnOption);
		
		
		JButton btnScore = new JButton("Voir les scores");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdMenuScore();
			}
		});
		panelBtn.add(btnScore);
		
		
		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdDeconnexion();
			}
		});
		panelBtn.add(btnDeconnexion);
		
		
		add(panelBtn);
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
