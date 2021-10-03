package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controleur.Controleur;

public class MenuPrincipal extends JPanel {
	
	private Controleur controleur;
	
	/**
	 * Constructeur
	 * 
	 * @param controleur
	 */
	public MenuPrincipal(Controleur controleur) {
		super();
		this.controleur = controleur;
		
		
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
		
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdQuitter();
			}
		});
		panelBtn.add(btnQuitter);
		
		
		add(panelBtn);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	* Demande de changement de menu : MenuCreerPartie
	*/
	public void cmdMenuCreerPartie() {
		controleur.rqtMenuCreerPartie();
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie
	*/
	public void cmdMenuSelecPartie() {
		controleur.rqtMenuSelecPartie();
	}
	
	/**
	* Demande de changement de menu : MenuOption
	*/
	public void cmdMenuOption() {
		controleur.rqtMenuOption();
	}
	
	/**
	* Demande de changement de menu : MenuScore
	*/
	public void cmdMenuScore() {
		controleur.rqtMenuScore();
	}
	
	/**
	* Demande de fermeture de l'application
	*/
	public void cmdQuitter() {
		controleur.rqtQuitter();
	}
	
	
}
