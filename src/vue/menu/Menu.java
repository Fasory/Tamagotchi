package vue.menu;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.Set;

public abstract class Menu extends JPanel {
	
	protected final Color COULEUR_ALERTE = Color.RED;
	// Constantes publics
	protected final Color COULEUR_EN_SELEC = COULEUR_ALERTE;
	protected final Color COULEUR_EN_NON_SELEC = Color.BLUE;
	
	protected HashMap<String, JLabel> lsAlerte;
	
	/**
	 * Constructeur
	 */
	protected Menu() {
		super();
		
		lsAlerte = new HashMap<String, JLabel>();
	}
	
	/**
	 * 
	 */
	public void curseurDefault() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	/**
	 * 
	 */
	public void curseurHand() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * 
	 */
	public void renitialiser() {
		// A réécrire si besoin dans les menus enfants
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<String> getClefLsAlerte() {
		return lsAlerte.keySet();
	}
	
	/**
	 * 
	 * @param alerteCible
	 * @param message
	 */
	public void setAlerte(String alerteCible, String message) {
		lsAlerte.get(alerteCible).setText(message);
	}
	
	/**
	 * 
	 * @param label
	 * @param couleur
	 */
	public void changeCouleurLabel(JLabel label, Color couleur) {
		label.setForeground(couleur);
	}
	
	/**
	 * 
	 * @param composant
	 * @param actif
	 */
	public void setActive(JComponent composant, boolean actif) {
		composant.setEnabled(actif);
	}
}
