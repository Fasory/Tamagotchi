package vue.modele;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import controleur.ControleurFichier;
import controleur.ControleurGeneral;

/**
 * La classe CustomStyle est une classe abstraite
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */


public abstract class CustomStyle {

	
	////////////////////////////////////////
	//            DEFINITION DES          //
	//               COULEURS             //        
	////////////////////////////////////////

	public final static Color ROSE_DEFAUT = new Color(255, 110, 160);
	public final static Color ROSE_DEFAUT_FONCE = new Color(255, 40, 110);
	public final static Color ROSE_ALPHA = new Color(255, 110, 160, 200);
	public final static Color BLANC_ALPHA = new Color(255, 255, 255, 200);
	public final static Color BLANC_DEFAUT = Color.WHITE;
	public final static Color ROUGE_DEFAUT = new Color(240, 20, 60);
	public final static Color ROUGE_ALPHA = new Color(240, 20, 60, 200);
	public final static Color BLEU_DEFAUT = new Color(32, 97, 200);
	public final static Color GRIS_DEFAUT = new Color(199, 199, 199);
	public final static Color GRIS_DEFAUT_FONCE =new Color(96, 96, 96);
	public final static Color GRIS_ALPHA = new Color(199, 199, 199, 200);
	public final static Color ALPHA = new Color(0, 0, 0, 0);
	public final static Color ROSE_FOND = new Color(255,222,233);
	public final static Color VERT_DEFAUT = new Color(39, 174, 96);
	public final static Color JAUNE_DEFAUT = new Color(241, 196, 15);
	public final static Color ORANGE_DEFAUT = new Color(220, 118, 51);
	
	/**
	 * Initialisation de la taille de la police
	 * 
	 * @param taille - float définit taille de la police 
	 * @return Font - la police définie
	 */
	public static Font getFont(float taille) {
		Font police;
		try {
			police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
			police = police.deriveFont(taille);
			return police;
		} catch (FontFormatException | IOException err) {
	    	ControleurGeneral.ctrlFichier.addLogs("Erreur - échec lors de la création de la Font", true);
	    	ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			return null;
		}
	}
	
	/**
	 * Initialisation de la police
	 * 
	 * @return Font - la police définie
	 */
	public static Font getFont() {
		return getFont(15f);
	}
	
	////////////////////////////////////////
	//            DEFINITION DES          //
	//                STYLES              //        
	////////////////////////////////////////
	/**
	 * Initialisation du style pour le texte par défaut
	 * @return SimpleAttributSet - style appliqué par défaut
	 */
	public static SimpleAttributeSet getStyleNormal() {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontSize(style, 14);
		return style;
	}
	
	/**
	 * Initialisation du style pour les titres
	 * @return SimpleAttributSet - style appliqué aux titres
	 */
	public static SimpleAttributeSet getStyleTitre() {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontSize(style, 30);
		StyleConstants.setBold(style, true);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
		return style;
	}
	
	/**
	 * Initialisation du style pour les sous-titres
	 * @return SimpleAttributSet - style appliqué aux sous-titres
	 */
	public static SimpleAttributeSet getStyleSousTritre() {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontSize(style, 18);
		StyleConstants.setBold(style, true);
		return style;
	}
	
	/**
	 * Initialisation du style pour centrer le texte
	 * @return SimpleAttributSet - style centré appliqué au texte
	 */
	public static SimpleAttributeSet getStyleCentrer() {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
		return style;
	}
	
	/**
	 * Initialisation du style par défaut
	 * 
	 * @param taille - int définit la taille par défaut
	 * @return SimpleAttributSet - style par défaut appliqué au texte
	 */
	public static SimpleAttributeSet getStyleDefaut(int taille) {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontSize(style, taille);
		return style;
	}
}
