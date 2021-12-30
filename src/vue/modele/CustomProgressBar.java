package vue.modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JProgressBar;

public class CustomProgressBar extends JProgressBar {
	
	private final static Color DEFAUT_BACKGROUND = CustomStyle.GRIS_ALPHA;
	private final static Color DEFAUT_FOND = CustomStyle.BLANC_DEFAUT;
	private final static Color DEFAUT_0_25 = CustomStyle.ROUGE_DEFAUT;
	private final static Color DEFAUT_25_50 = CustomStyle.ORANGE_DEFAUT;
	private final static Color DEFAUT_50_75 = CustomStyle.JAUNE_DEFAUT;
	private final static Color DEFAUT_75_100 = CustomStyle.VERT_DEFAUT;
	private final static int MARGE = 5;
	private final boolean fixe;
	private Color couleur_background;
	private Color couleur_foreground;
	private Color couleur_fond;
	
	public CustomProgressBar(int min, int max) {
		this(min, max, false);
	}
	
	public CustomProgressBar(int min, int max, boolean fixe) {
		super(min, max);
		
		setOpaque(false);
		
		this.fixe = fixe;
		
		couleur_background = DEFAUT_BACKGROUND;
		couleur_fond = DEFAUT_FOND;
		int pourcent = (getValue()-getMinimum()) * 100 / (getMaximum()-getMinimum());
		if (pourcent <= 25) couleur_foreground = DEFAUT_0_25;
		else if (pourcent <= 50) couleur_foreground = DEFAUT_25_50;
		else if (pourcent <= 75) couleur_foreground = DEFAUT_50_75;
		else couleur_foreground = DEFAUT_75_100;
	}
	
	@Override
	public void setValue(int valeur) {
		super.setValue(valeur);
		if (!fixe) {
			int pourcent = (getValue()-getMinimum()) * 100 / (getMaximum()-getMinimum());
			if (pourcent <= 25) couleur_foreground = DEFAUT_0_25;
			else if (pourcent <= 50) couleur_foreground = DEFAUT_25_50;
			else if (pourcent <= 75) couleur_foreground = DEFAUT_50_75;
			else couleur_foreground = DEFAUT_75_100;
		}
	}
	
	@Override
	public void setBackground(Color couleur) {
		couleur_fond = couleur;
	}
	
	@Override
	public void setForeground(Color couleur) {
		couleur_foreground = couleur;
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		Dimension size = getPreferredSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(couleur_background);
		graph.fillRoundRect(0, 0, size.width-1, size.height-1, size.height-1, size.height-1);
		int height = size.height-MARGE*2-1;
		if (height <= 0) height = 1;
		int width = size.width-MARGE*2-1;
		if (width <= 0) width = 1;
		graph.setColor(couleur_fond);
		graph.fillRoundRect(MARGE, MARGE, width, height, height, height);
		int pourcent = (getValue()-getMinimum()) * 100 / (getMaximum()-getMinimum());
		graph.setColor(couleur_foreground);
		graph.fillRoundRect(MARGE, MARGE, width*pourcent/100, height, height, height);
	}
	
	@Override
	public void paintBorder(Graphics graphParam) {
	}
}
