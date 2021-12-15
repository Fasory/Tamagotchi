package vue.menu;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleurFichier;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
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
	private BufferedImage fondImage;
	
	/**
	 * Constructeur
	 */
	protected Menu() {
		super();
		
		lsAlerte = new HashMap<String, JLabel>();
		try {
			fondImage = ImageIO.read(ControleurFichier.FOND_MENU);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void paintComponent(Graphics graph) {
		super.paintComponent(graph);
		graph.drawImage(fondImage, 0, 0, null);
	}

	
	/**
	 * Change le curseur de la souris par curseur par défaut
	 */
	public void curseurDefault() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	/**
	 * Change le curseur  de la souris par curseur main
	 */
	public void curseurHand() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Méthode appelée lorsque l'on fait apparaitre un menu précédent
	 */
	public void renitialiser() {
		// A réécrire si besoin dans les menus fils
	}
	
	/**
	 * Donne les clés des alertes
	 * @return Set<String> - liste des clés
	 */
	public Set<String> getClefLsAlerte() {
		return lsAlerte.keySet();
	}
	
	/**
	 * Modifie une alerte
	 * 
	 * @param alerteCible - String définissant le nom d'une alerte
	 * @param message - String du message "alerte" liée à l'alerte nommée
	 */
	public void setAlerte(String alerteCible, String message) {
		lsAlerte.get(alerteCible).setText(message);
	}
	
	/**
	 * Change la couleur du label
	 * 
	 * @param label - JLabel définissant le label à modifier
	 * @param couleur - Color choisie pour modifier la couleur de notre JLabel
	 */
	public void changeCouleurLabel(JLabel label, Color couleur) {
		label.setForeground(couleur);
	}
	
	/**
	 * Modifie l'activité d'un composant
	 * 
	 * @param composant - JComponent définissant le label à modifier
	 * @param actif - boolean qui active ou désactive le composant choisi
	 */
	public void setActive(JComponent composant, boolean actif) {
		composant.setEnabled(actif);
	}
}
