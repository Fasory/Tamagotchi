package vue.modele;

import javax.swing.JSlider;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * La classe CustomSlider implémente un style de glissière
 * (exemple : barre de volume)
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomSlider extends JSlider {
	// Attributs
	private final int EPAISSEUR;
	private final int EPAISSEUR_POINTEUR;
	private final int EPAISSEUR_POINTEUR_INTERNE;
	private final int MARGE;
	
	/**
	 * Constructeur de la classe CustomSlider
	 * 
	 * @param min - int minimum de la glissière
	 * @param max - int maximum de la glissière
	 * @param valeur - int valeur par défaut de la glissière
	 */
	public CustomSlider(int min, int max, int valeur) {
		super(min, max, valeur);
		EPAISSEUR = 10;
		EPAISSEUR_POINTEUR = 20;
		MARGE = 10;

		EPAISSEUR_POINTEUR_INTERNE = EPAISSEUR_POINTEUR/3*2;
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				Dimension size = getPreferredSize();
				size.width -= EPAISSEUR_POINTEUR + MARGE * 2;
				int valeur = (evt.getX()-MARGE*2)*getMaximum()/size.width;
				if (valeur < getMinimum()) valeur = getMinimum();
				else if (valeur > getMaximum()) valeur = getMaximum();
				setValue(valeur);
			}
		});
			
		addMouseMotionListener(new MouseAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent evt) {
				Dimension size = getPreferredSize();
				size.width -= EPAISSEUR_POINTEUR + MARGE * 2;
				int valeur = (evt.getX()-MARGE*2)*getMaximum()/size.width;
				if (valeur < getMinimum()) valeur = getMinimum();
				else if (valeur > getMaximum()) valeur = getMaximum();
				setValue(valeur);
				repaint();
			}
		});
	}
	
	// Redéfinition
	
	@Override
	public void paintComponent(Graphics graphParam) {

		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension size = getPreferredSize();
		// Arrière plan
		graph.setColor(CustomStyle.GRIS_ALPHA);
		graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);
		// Maj size
		size.width -= EPAISSEUR_POINTEUR + MARGE * 2;
		// Fond
		graph.setColor(CustomStyle.BLANC_DEFAUT);
		graph.fillRoundRect(EPAISSEUR_POINTEUR/2+MARGE, size.height/2-EPAISSEUR/2, size.width, EPAISSEUR, EPAISSEUR, EPAISSEUR);
		// Valeur
		graph.setColor(CustomStyle.ROSE_DEFAUT);
		graph.fillRoundRect(EPAISSEUR_POINTEUR/2+MARGE, size.height/2-EPAISSEUR/2, size.width*getValue()/getMaximum(), EPAISSEUR, EPAISSEUR, EPAISSEUR);
		// Curseur
		graph.setColor(CustomStyle.ROSE_DEFAUT);
		graph.fillOval(EPAISSEUR_POINTEUR/2+size.width*getValue()/getMaximum()-EPAISSEUR_POINTEUR/2+MARGE, size.height/2-EPAISSEUR_POINTEUR/2, EPAISSEUR_POINTEUR, EPAISSEUR_POINTEUR);
		graph.setColor(CustomStyle.BLANC_DEFAUT);
		graph.fillOval(EPAISSEUR_POINTEUR/2+size.width*getValue()/getMaximum()-EPAISSEUR_POINTEUR_INTERNE/2+MARGE, size.height/2-EPAISSEUR_POINTEUR_INTERNE/2, EPAISSEUR_POINTEUR_INTERNE, EPAISSEUR_POINTEUR_INTERNE);
	}
}
