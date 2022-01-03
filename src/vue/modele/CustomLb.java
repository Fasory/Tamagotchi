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
import javax.swing.JLabel;
import javax.swing.border.Border;

import controleur.ControleurFichier;

/**
 * La classe CustomLb implémente un style de label
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomLb extends JLabel {
	// Attributs
	private Font police = null;
	private Color couleur_foreground;
	private Color couleur_background;
	
	// Constructeurs
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 */
	public CustomLb(String texte) {
		this(texte, 10f);
	}
	
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 * @param taille - float taille de police à appliquer au label
	 */
	public CustomLb(String texte, float taille) {
		this(texte, taille, CustomStyle.ROSE_DEFAUT, CustomStyle.BLANC_ALPHA);
	}
	
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 * @param foreground - Color définit la couleur au premier plan
	 * @param background - Color définit la couleur au second plan
	 */
	public CustomLb(String texte, Color foreground, Color background) {
		this(texte, 10f, foreground, background);
	}
	
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 * @param foreground - Color définit la couleur au premier plan
	 * @param background - Color définit la couleur au second plan
	 * @param marge - Insets définit l'espacement autour du label
	 */
	public CustomLb(String texte, Color foreground, Color background, Border marge) {
		this(texte, 10f, foreground, background, marge);
	}
	
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 * @param taille - float taille de police à appliquer au texte
	 * @param foreground - Color définit la couleur au premier plan
	 * @param background - Color définit la couleur au second plan
	 */
	public CustomLb(String texte, float taille, Color foreground, Color background) {
		this(texte, taille, foreground, background, BorderFactory.createEmptyBorder(5, 10, 3, 10));
	}
	
	/**
	 * Constructeur de la classe CustomLb
	 * 
	 * @param texte - String définissant le texte sur lequel l'appliquer
	 * @param taille - float taille de police à appliquer au texte
	 * @param foreground - Color définit la couleur au premier plan
	 * @param background - Color définit la couleur au second plan
	 * @param marge - Insets définit l'espacement autour du label
	 */
	public CustomLb(String texte, float taille, Color foreground, Color background, Border marge) {
		super(texte);
		try {
			police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
			//police.deriveFont(15f);
			police = police.deriveFont(taille);
		} catch (FontFormatException | IOException err) {
			err.printStackTrace();
		}
		setFont(police);
		setBorder(BorderFactory.createCompoundBorder(this.getBorder(), marge)); // Padding interne du Field
		couleur_foreground = foreground;
		couleur_background = background;
	}
	
	//Redéfinition
	
	@Override
	public void setForeground(Color couleur) {
		super.setForeground(couleur);
		couleur_foreground = couleur;
	}
	
	@Override
	public void setBackground(Color couleur) {
		super.setBackground(couleur);
		couleur_background = couleur;
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setForeground(couleur_foreground);
		Graphics2D graph = (Graphics2D) graphParam;
		if (!getText().trim().equals("")) {
			Dimension size = getSize();
			setSize(size);
			graph.setColor(couleur_background);
			graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);
		}
		super.paintComponent(graph);
	}
}
