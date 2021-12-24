package vue.modele;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	
	private final int MARGE;
	private final int ARRONDI;
	
	public CustomPanel(LayoutManager gbl) {
		this(gbl, -1, 0);
	}
	
	public CustomPanel(LayoutManager gbl, int arrondi, int marge) {
		super(gbl);
		setOpaque(false);
		ARRONDI = arrondi;
		MARGE = marge;
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setBorder(BorderFactory.createEmptyBorder(MARGE, MARGE, MARGE, MARGE));
		Graphics2D graph = (Graphics2D) graphParam;
		Dimension size = getPreferredSize();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(CustomStyle.BLANC_ALPHA);
		int arrondi;
		if (ARRONDI == -1) arrondi = size.height;
		else arrondi = ARRONDI;
		graph.fillRoundRect(0, 0, size.width, size.height, arrondi, arrondi);
		super.paintComponent(graphParam);
	}
}
