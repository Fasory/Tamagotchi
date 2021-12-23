package vue.modole;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class CustomPanelLb extends JPanel {
	
	public CustomPanelLb(LayoutManager gbl) {
		super(gbl);
		setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Graphics2D graph = (Graphics2D) graphParam;
		Dimension size = getPreferredSize();
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(CustomStyle.BLANC_ALPHA);
		graph.fillRoundRect(0, 0, size.width, size.height, size.height, size.height);
		super.paintComponent(graphParam);
	}
}
