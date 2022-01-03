package vue.modele;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * La classe CustomPanel implémente un style de panel
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomPanel extends JPanel {
	// Attributs
	private final int MARGE;
	private final int ARRONDI;
	private Color couleur_background;
	
	// Constructeurs
	
	/**
	 * Constructeur de la classe CustomPanel
	 * 
	 * @param gbl - LayoutManager définit un gestionnaire d'affichage
	 */
	
	public CustomPanel(LayoutManager gbl) {
		this(gbl, -1, 0, CustomStyle.ALPHA);
	}
	
	/**
	 * Constructeur de la classe CustomPanel
	 * 
	 * @param gbl - LayoutManager définit un gestionnaire d'affichage
	 * @param arrondi - int définit l'arrondi du panel
	 * @param marge - Insets définit l'espacement autour du panel
	 */
	public CustomPanel(LayoutManager gbl, int arrondi, int marge) {
		this(gbl, arrondi, marge, CustomStyle.BLANC_ALPHA);
	}
	
	/**
	 * Constructeur de la classe CustomPanel
	 * 
	 * @param gbl - LayoutManager définit un gestionnaire d'affichage
	 * @param arrondi - int définit l'arrondi du panel
	 * @param marge - Insets définit l'espacement autour du panel
	 * @param background - Color définit une couleur d'arrière-plan
	 */
	public CustomPanel(LayoutManager gbl, int arrondi, int marge, Color background) {
		super(gbl);
		setOpaque(false);
		ARRONDI = arrondi;
		MARGE = marge;
		setBorder(BorderFactory.createEmptyBorder(MARGE, MARGE, MARGE, MARGE));
		couleur_background = background;
	}
	
	// Redéfinition
	
	@Override
	public void paintComponent(Graphics graphParam) {
		Graphics2D graph = (Graphics2D) graphParam;
		Dimension size = getSize();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(couleur_background);
		int arrondi;
		if (ARRONDI == -1) arrondi = size.height;
		else arrondi = ARRONDI;
		graph.fillRoundRect(0, 0, size.width, size.height, arrondi, arrondi);
		super.paintComponent(graphParam);
	}
	
	@Override
	public void setBackground(Color couleur) {
		couleur_background = couleur;
		super.setBackground(couleur);
	}
}
