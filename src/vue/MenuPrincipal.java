package vue;

import javax.swing.JPanel;

import controleur.Controleur;

public class MenuPrincipal extends JPanel {
	
	Controleur controleur;
	
	MenuPrincipal(Controleur controleur) {
		super();
		this.controleur = controleur;
	}
}
