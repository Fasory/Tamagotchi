package menu;

import javax.swing.JPanel;

import controleur.Controleur;

public abstract class Menu extends JPanel {
	
	protected Controleur controleur;
	
	protected Menu(Controleur controleur) {
		super();
		
		this.controleur = controleur;
	}
}
