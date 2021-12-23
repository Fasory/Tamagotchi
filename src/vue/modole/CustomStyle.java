package vue.modole;

import java.awt.Color;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public abstract class CustomStyle {

	
	////////////////////////////////////////
	//            DEFINITION DES          //
	//               COULEURS             //        
	////////////////////////////////////////

	public final static Color ROSE_DEFAUT = new Color(255, 110, 160);
	public final static Color ROSE_ALPHA = new Color(255, 110, 160, 200);
	public final static Color BLANC_ALPHA = new Color(255, 255, 255, 200);
	public final static Color ROUGE_DEFAUT = new Color(240, 20, 60);
	public final static Color ROUGE_ALPHA = new Color(240, 20, 60, 200);
	public final static Color BLEU_DEFAUT = new Color(32, 97, 200);
	public final static Color GRIS_DEFAUT = new Color(199, 199, 199);
	public final static Color ALPHA = new Color(0, 0, 0, 0);
	
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
	
	
	public static SimpleAttributeSet getStyleDefaut(int taille) {
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontSize(style, taille);
		return style;
	}
}
