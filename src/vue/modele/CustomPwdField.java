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
import javax.swing.JPasswordField;

import controleur.ControleurFichier;

/**
 * La classe CustomPwdField implémente un style de champ d'entrée de mot de passe
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomPwdField extends JPasswordField {
	// Attribut
	private static Font police = null;
	
	/**
	 * Constructeur de la classe CustomPwdField
	 */
	public CustomPwdField() {
		super();
		if (police == null) {
			try {
				police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
				//police.deriveFont(15f);
				police = police.deriveFont(Font.BOLD, 8f);
			} catch (FontFormatException | IOException err) {
				err.printStackTrace();
			}
		}
		setFont(police);
		setOpaque(false);
		setBorder(null);
		setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(2, 10, 0, 10))); // Padding interne du Field
	}
	
	// Redéfinition
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setEchoChar('#');
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setColor(Color.WHITE);
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);

		super.paintComponent(graph);
	}
}
