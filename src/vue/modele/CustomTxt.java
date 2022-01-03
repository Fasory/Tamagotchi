package vue.modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import controleur.ControleurFichier;

/**
 * La classe CustomTxt implémente un style de texte
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomTxt extends JTextPane {
	// Attributs
	private final static Color DEFAUT_FOREGROUND = Color.WHITE;
	private final static Color DEFAUT_BACKGROUND = new Color(255, 110, 160, 200);
	private Color couleur_foreground;
	private Color couleur_background;
	private static Font police = null;
	private int arrondi;
	
	// Constructeurs
	
	/**
	 * Constructeur de la classe CustomTxt
	 * 
	 * @param contenu - String texte sur lequel appliquer
	 */
	public CustomTxt(String contenu) {
		this(contenu, 8, true, -1);
	}
	
	/**
	 * Constructeur de la classe CustomTxt
	 * 
	 * @param contenu - String texte sur lequel appliquer
	 * @param centrer - boolean active ou désactive le centrage du texte
	 */
	public CustomTxt(String contenu, boolean centrer) {
		this(contenu, 8, centrer, -1);
	}
	
	/**
	 * Constructeur de la classe CustomTxt
	 * 
	 * @param contenu - String texte sur lequel appliquer
	 * @param taille - int taille du texte
	 */
	public CustomTxt(String contenu, int taille) {
		this(contenu, taille, true, -1);
	}
	
	/**
	 * Constructeur de la classe CustomTxt
	 * 
	 * @param contenu - String texte sur lequel appliquer
	 * @param taille - int taille du texte
	 * @param centrer - boolean active ou désactive le centrage du texte
	 * @param arrondi - int définit l'arrondi appliqué
	 */
	public CustomTxt(String contenu, int taille, boolean centrer, int arrondi) {
		super();
		this.arrondi = arrondi;
		couleur_foreground = DEFAUT_FOREGROUND;
		couleur_background = DEFAUT_BACKGROUND;
		if (police == null) {
			try {
				police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
				//police.deriveFont(15f);
				//police = police.deriveFont(Font.BOLD, 10f);
			} catch (FontFormatException | IOException err) {
				err.printStackTrace();
			}
		}
		setFont(police);
	 	setEditable(false);
	 	setOpaque(false);
	 	try {
		 	StyledDocument doc = getStyledDocument();
			doc.insertString(doc.getLength(), contenu, CustomStyle.getStyleDefaut(taille));
			if (centrer) doc.setParagraphAttributes(0, contenu.length(), CustomStyle.getStyleCentrer(), false);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	// Redéfinition
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setForeground(couleur_foreground);
		setBorder(null);
		setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(10, 20, 8, 20))); // Padding interne du Field
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(couleur_background);
		if (arrondi == -1) graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);
		else graph.fillRoundRect(0, 0, size.width, size.height, arrondi, arrondi);

		super.paintComponent(graph);
	}
}
