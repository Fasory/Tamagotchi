package vue.modele;

import javax.swing.JRadioButton;

import controleur.ControleurFichier;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;

/**
 * La classe CustomRadioBtn implémente un style de bouton radio
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomRadioBtn extends JRadioButton {
	// Attributs
	private final float TAILLE;
	private final int TAILLE_BTN;
	private final int TAILLE_BTN_INTERNE;
	private final int TAILLE_BTN_SELEC;
	private final int MARGE;
	private Color couleur_foreground;
	private Color couleur_background;
	private Font police;
	
	/**
	 * Constructeur de la classe CustomRadioBtn
	 * 
	 * @param elt - String chaine de caractère placé à la suite du bouton radio
	 */
	public CustomRadioBtn(String elt) {
		super(elt);
		TAILLE = 12f;
		TAILLE_BTN = (int) (TAILLE*1.5);
		TAILLE_BTN_INTERNE = TAILLE_BTN - 6;
		TAILLE_BTN_SELEC = TAILLE_BTN_INTERNE - 6;
		MARGE = 10;
		couleur_foreground = CustomStyle.ROSE_DEFAUT;
		couleur_background = CustomStyle.BLANC_DEFAUT;
		try {
			police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
			//police.deriveFont(15f);
			police = police.deriveFont(TAILLE);
		} catch (FontFormatException | IOException err) {
			err.printStackTrace();
		}
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				couleur_background = CustomStyle.GRIS_DEFAUT;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				couleur_foreground = CustomStyle.ROSE_DEFAUT;
				couleur_background = CustomStyle.BLANC_DEFAUT;
			}
		});
	}
	
	// Redéfinition
	
	@Override
	public void paintComponent(Graphics graphParam) {
		// Ajustement de la taille
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    FontMetrics renduFont = graph.getFontMetrics(police);
	    int tailleTextX = renduFont.stringWidth(getText());
	    int tailleTextY = renduFont.getHeight();
		setSize(new Dimension(tailleTextX + TAILLE_BTN + MARGE, tailleTextY));
		Dimension size = getSize();
		// Texte
		graph.setFont(police);
		graph.setColor(couleur_foreground);
		graph.drawString(getText(), TAILLE_BTN + MARGE, renduFont.getAscent());
		// Bouton
		graph.setColor(couleur_foreground);
		graph.fillOval(0, (size.height-TAILLE_BTN)/2, TAILLE_BTN, TAILLE_BTN);
		graph.setColor(couleur_background);
		graph.fillOval((TAILLE_BTN-TAILLE_BTN_INTERNE)/2, (size.height-TAILLE_BTN_INTERNE)/2, TAILLE_BTN_INTERNE, TAILLE_BTN_INTERNE);
		if (isSelected() ) {
			graph.setColor(couleur_foreground);
			graph.fillOval((TAILLE_BTN-TAILLE_BTN_SELEC)/2, (size.height-TAILLE_BTN_SELEC)/2, TAILLE_BTN_SELEC, TAILLE_BTN_SELEC);
		}
	}
}
