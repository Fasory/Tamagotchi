package vue.modele;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	
	private final int MARGE;
	private final int ARRONDI;
	private Color couleur_background;
	
	public CustomPanel(LayoutManager gbl) {
		this(gbl, -1, 0, CustomStyle.ALPHA);
	}
	
	public CustomPanel(LayoutManager gbl, int arrondi, int marge) {
		this(gbl, arrondi, marge, CustomStyle.BLANC_ALPHA);
	}
	
	public CustomPanel(LayoutManager gbl, int arrondi, int marge, Color background) {
		super(gbl);
		setOpaque(false);
		ARRONDI = arrondi;
		MARGE = marge;
		setBorder(BorderFactory.createEmptyBorder(MARGE, MARGE, MARGE, MARGE));
		couleur_background = background;
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		Graphics2D graph = (Graphics2D) graphParam;
		Dimension size = getSize();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(couleur_background);
		int arrondi;
		if (ARRONDI == -1) arrondi = size.height;
		else arrondi = ARRONDI;
		graph.fillRoundRect(0, 0, size.width, size.height, arrondi, arrondi);
		super.paintComponent(graphParam);
	}
}
