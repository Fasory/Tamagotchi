package vue.modole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import controleur.ControleurFichier;

public class CustomLb extends JLabel {

	private Font police = null;
	private Color couleur_foreground;
	private Color couleur_background;
	
	public CustomLb(String texte) {
		this(texte, 10f);
	}
	
	public CustomLb(String texte, float taille) {
		this(texte, taille, CustomStyle.ROSE_DEFAUT, CustomStyle.BLANC_ALPHA);
	}
	
	public CustomLb(String texte, Color foreground, Color background) {
		this(texte, 10f, foreground, background);
	}
	
	public CustomLb(String texte, float taille, Color foreground, Color background) {
		super(texte);
		try {
			police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
			//police.deriveFont(15f);
			police = police.deriveFont(taille);
		} catch (FontFormatException | IOException err) {
			err.printStackTrace();
		}
		setFont(police);
		setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(5, 10, 4, 10))); // Padding interne du Field
		couleur_foreground = foreground;
		couleur_background = background;
	}
	
	@Override
	public void setForeground(Color couleur) {
		super.setForeground(couleur);
		couleur_foreground = couleur;
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setForeground(couleur_foreground);
		Graphics2D graph = (Graphics2D) graphParam;
		if (!getText().trim().equals("")) {
			Dimension size = getSize();
			graph.setColor(couleur_background);
			graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);
		}
		super.paintComponent(graph);
	}
}
