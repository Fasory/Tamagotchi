package vue.menu;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.Set;

import controleur.ControleurGeneral;

public abstract class Menu extends JPanel {
	
	protected final static Color COULEUR_ALERTE = Color.RED;
	// Constantes publics
	public final Color COULEUR_EN_SELEC = COULEUR_ALERTE;
	public final Color COULEUR_EN_NON_SELEC = Color.BLUE;
	
	protected ControleurGeneral controleur;
	protected HashMap<String, JLabel> lsAlerte;
	
	protected Menu(ControleurGeneral controleur) {
		super();
		
		this.controleur = controleur;
		lsAlerte = new HashMap<String, JLabel>();
	}
	
	public void curseurDefault() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	public void curseurHand() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public void renitialiser() {
		// A réécrire si besoin dans les menus enfants
	}
	
	public Set<String> getClefLsAlerte() {
		return lsAlerte.keySet();
	}
	
	public void setAlerte(String alerteCible, String message) {
		lsAlerte.get(alerteCible).setText(message);
	}
	
	public void changeCouleurLabel(JLabel label, Color couleur) {
		label.setForeground(couleur);
	}
	
	public void setActive(JComponent composant, boolean actif) {
		composant.setEnabled(actif);
	}
}
