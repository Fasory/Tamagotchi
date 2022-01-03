package vue.modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;


/**
 * La classe CustomBordure implémente un style de bordure personnalisé
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomBordure implements Border {
	
	// Attributs
	private final int ARRONDI;
	private final Color couleur;
	private final int epaisseur;
	private final Insets marges;
	
	// Constructeurs
	
	/**
	 * Constructeur de la classe CustomBordure avec 4 paramètres
	 * 
	 * @param couleur - Color définit la couleur de la bordure
	 * @param epaisseur - int définit l'épaisseur de la bordure
	 * @param marges - Insets espacement autour de l'objet
	 * @param arrondi - int définit l'arrondi des coins de la bordure
	 */
	public CustomBordure(Color couleur, int epaisseur, Insets marges, int arrondi) {
		ARRONDI = arrondi;
		this.couleur = couleur;
		this.epaisseur = epaisseur;
		this.marges = marges;
	}
	
	/**
	 * Constructeur de la classe CustomBordure avec 3 paramètres
	 * 
	 * @param couleur - Color définit la couleur de la bordure
	 * @param epaisseur - int définit l'épaisseur de la bordure
	 * @param marges - Insets espacement autour de l'objet
	 */
	public CustomBordure(Color couleur, int epaisseur, Insets marges) {
		// Affectation de -1 par défaut à l'épaisseur
		this(couleur, epaisseur, marges, -1);
	}

	@Override
	public void paintBorder(Component c, Graphics graph, int x, int y, int width, int height) {
		if (epaisseur != 0) {
			graph.setColor(couleur);
			int arrondi;
			if (ARRONDI == -1) arrondi = height-1;
			else arrondi = ARRONDI;
			graph.drawRoundRect(x+epaisseur/2, y+epaisseur/2, width-1-epaisseur, height-1-epaisseur, arrondi, arrondi);
		}
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return marges;
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

}
