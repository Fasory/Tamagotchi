package menu;

import javax.swing.JPanel;
import java.awt.Cursor;

import controleur.ControleurGeneral;

public abstract class Menu extends JPanel {
	
	protected ControleurGeneral controleur;
	
	protected Menu(ControleurGeneral controleur) {
		super();
		
		this.controleur = controleur;
	}
	
	public void curseurDefault() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	public void curseurHand() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public void renitialiser() {
		
	}
}
