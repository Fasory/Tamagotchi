package vue.modole;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controleur.ControleurFichier;

import java.io.IOException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;

public class CustomTxtField extends JTextField {
	
	private static Font police = null;
	
	public CustomTxtField() {
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
	
	@Override
	public void paintComponent(Graphics graphParam) {
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setColor(Color.WHITE);
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);

		super.paintComponent(graph);
	}
}
