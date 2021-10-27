package menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.ControleurGeneral;

public class Option extends Menu {

	public Option(ControleurGeneral controleur) {
		super(controleur);
		
		// partie affichage
		setLayout(new GridBagLayout()); // nouvelle grille
		
		JPanel panelBtn = new JPanel(new GridLayout(4, 1, 0, 40)) { // nouveau panel
			@Override
			public Dimension getPreferredSize() { // dimension du panel
				return new Dimension(200, 350);
			}
		};
		
		JButton btnVoirCredits = new JButton("Voir les crédits");
		btnVoirCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdAfficheCredits();
			}
		});
		panelBtn.add(btnVoirCredits);
		
		JButton btnQuitterOptions = new JButton("Quitter les options");
		btnQuitterOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdQuitterOptions();
			}
		});
		panelBtn.add(btnQuitterOptions);
		
		add(panelBtn);
		
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Menu des crédits
	 */
	public void cmdAfficheCredits() {
		controleur.ctrlDeBouton.rqtAffichageCredits();
	}
	
	public void cmdQuitterOptions() {
		controleur.ctrlDeBouton.rqtQuitterOptions();
	}
}
