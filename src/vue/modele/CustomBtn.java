package vue.modele;

import javax.swing.JButton;
import javax.swing.UIManager;

import controleur.ControleurFichier;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Insets;

/**
 * La classe CustomBtn implémente un style de bouton personnalisé
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomBtn extends JButton {
	
	// Attributs
	private final static Color DEFAUT_FOREGROUND = new Color(255, 110, 160);
	private final static Color DEFAUT_BACKGROUND = Color.WHITE;
	private final static Color SURVOLE_FOREGROUND = DEFAUT_FOREGROUND;
	private final static Color SURVOLE_BACKGROUND = new Color(199, 199, 199);
	private final static Color PRESSION_FOREGROUND = new Color(255, 40, 110);
	private final static Color PRESSION_BACKGROUND = new Color(96, 96, 96);
	private final static Color DESACTIVE_FOREGROUND = new Color(96, 96, 96);
	private final static Color DESACTIVE_BACKGROUND = new Color(199, 199, 199);
	private final static int EPAISSEUR = 4;
	private Font police = null;
	private final Insets marges;
	private Color couleur_foreground;
	private Color couleur_background;
	private boolean focus;
	
	// Constructeurs
	
	/**
	 * Constructeur de la classe CustomBtn
	 * 
	 * @param texte - String affichage texte à l'intérieur du bouton
	 */
	public CustomBtn(String texte) {
		this(texte, 15f, new Insets(12, 35, 10, 35));
	}
	
	/**
	 * Constructeur de la classe CustomBtn
	 * 
	 * @param texte - String affichage texte à l'intérieur du bouton
	 * @param taille - float paramétrant la taille de la police
	 */
	public CustomBtn(String texte, float taille) {
		this(texte, taille, new Insets(12, 35, 10, 35));
	}
	
	/**
	 * Constructeur de la classe CustomBtn
	 * 
	 * @param texte - String affichage texte à l'intérieur du bouton
	 * @param marges - Insets définit l'espacement autour du bouton
	 */
	public CustomBtn(String texte, Insets marges) {
		this(texte, 15f, marges);
	}
	
	/**
	 * Constructeur de la classe CustomBtn
	 * 
	 * @param texte - String affichage texte à l'intérieur du bouton
	 * @param taille - float paramétrant la taille de la police
	 * @param marges - Insets définit l'espacement autour du bouton
	 */
	public CustomBtn(String texte, float taille, Insets marges) {
		super(texte);
		focus = false;
		this.marges = marges;
		if (police == null) {
			try {
				police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
				//police.deriveFont(15f);
				police = police.deriveFont(taille);
			} catch (FontFormatException | IOException err) {
				err.printStackTrace();
			}
		}
		setFont(police);
		UIManager.getDefaults().put("Button.disabledText", DESACTIVE_FOREGROUND);		// Change la couleur du texte d'un bouton désactivé (insensible au setForeground(...))
		couleur_foreground = DEFAUT_FOREGROUND;
		couleur_background = DEFAUT_BACKGROUND;
		setContentAreaFilled(false);
		setFocusable(false); 
		addMouseListener(new MouseListener() {
			
			// Rédéfinition de méthodes héritées de JButton
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if (isEnabled()) {
					focus = true;
					couleur_foreground = SURVOLE_FOREGROUND;
					couleur_background = SURVOLE_BACKGROUND;
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (isEnabled()) {
					couleur_foreground = PRESSION_FOREGROUND;
					couleur_background = PRESSION_BACKGROUND;
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (isEnabled() & focus) {
					couleur_foreground = SURVOLE_FOREGROUND;
					couleur_background = SURVOLE_BACKGROUND;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (isEnabled()) {
					focus = false;
					couleur_foreground = DEFAUT_FOREGROUND;
					couleur_background = DEFAUT_BACKGROUND;
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	
	@Override
	public void setEnabled(boolean statut) {
		super.setEnabled(statut);
		if (!isEnabled()) {
			couleur_foreground = DESACTIVE_FOREGROUND;
			couleur_background = DESACTIVE_BACKGROUND;
		} else {
			couleur_foreground = DEFAUT_FOREGROUND;
			couleur_background = DEFAUT_BACKGROUND;
		}
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setBorder(new CustomBordure(couleur_foreground, EPAISSEUR, marges));
		setForeground(couleur_foreground);
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(couleur_background);
		graph.setStroke(new BasicStroke(EPAISSEUR));
		graph.fillRoundRect(0+EPAISSEUR/2, 0+EPAISSEUR/2, size.width-1-EPAISSEUR, size.height-1-EPAISSEUR, size.height-1, size.height-1);

		super.paintComponent(graphParam);
	}
	
	/**
	 * Permet le retour du type de bouton par défaut
	 */
	public void reset() {
		if (isEnabled()) {
			focus = false;
			couleur_foreground = DEFAUT_FOREGROUND;
			couleur_background = DEFAUT_BACKGROUND;
		}
	}

}
