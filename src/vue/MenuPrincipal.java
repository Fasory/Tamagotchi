package vue;

import javax.swing.*;
import java.awt.*;

import controleur.Controleur;

public class MenuPrincipal extends JPanel {
	
	Controleur controleur;
	
	MenuPrincipal(Controleur controleur) {
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
		panelBtn.add(btnCreerPartie);
		
		JButton btnSelectionnerPartie = new JButton("Sélectionner une partie");
		panelBtn.add(btnSelectionnerPartie);
		
		JButton btnOption = new JButton("Options");
		panelBtn.add(btnOption);
		
		JButton btnScore = new JButton("Voir les scores");
		panelBtn.add(btnScore);
		
		JButton btnQuitter = new JButton("Quitter");
		panelBtn.add(btnQuitter);
		
		add(panelBtn);
	}
}
