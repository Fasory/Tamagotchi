package menu;

import javax.swing.JPanel;
import java.awt.Cursor;

import controleur.Controleur;

public abstract class Menu extends JPanel {
	
	protected Controleur controleur;
	
	protected Menu(Controleur controleur) {
		super();
		
		this.controleur = controleur;
	}
	
	public void curseurDefault() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	public void curseurHand() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
