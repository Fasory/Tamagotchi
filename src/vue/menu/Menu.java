package vue.menu;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleurFichier;
import vue.modele.CustomBtn;
import vue.modele.CustomStyle;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe abstraite Menu qui nous permet de définir
 * les autres menus.
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 * 
 */

public abstract class Menu extends JPanel {
	
	protected final Color COULEUR_ALERTE = CustomStyle.ROUGE_DEFAUT;
	// Constantes publics
	protected final Color COULEUR_EN_SELEC = CustomStyle.ROUGE_DEFAUT;
	protected final Color COULEUR_EN_NON_SELEC = CustomStyle.BLEU_DEFAUT;
	
	protected HashMap<String, JLabel> lsAlerte;
	protected HashSet<CustomBtn> lsCustomBtn;
	protected BufferedImage fondImage;
	
	/**
	 * Constructeur de la classe Menu
	 */
	protected Menu() {
		// Appel au constructeur de la super classe JPanel
		super();
		
		lsAlerte = new HashMap<String, JLabel>();
		lsCustomBtn = new HashSet<CustomBtn>();
		try {
			fondImage = ImageIO.read(ControleurFichier.FOND_MENU);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected Menu(Color couleur) {
		super();

		lsCustomBtn = new HashSet<CustomBtn>();
		lsAlerte = new HashMap<String, JLabel>();
		setBackground(couleur);
	}
	
	
	protected void paintComponent(Graphics graph) {
		super.paintComponent(graph);
		if (fondImage != null) graph.drawImage(fondImage, 0, 0, null);
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
	public void reinitialiser() {
		for (CustomBtn btn : lsCustomBtn) btn.reset();
		repaint();
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
