package vue.modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class CustomBordure implements Border {
	
	private final Color couleur;
	private final int epaisseur;
	private final Insets marges;
	
	public CustomBordure(Color couleur, int epaisseur, Insets marges) {
		this.couleur = couleur;
		this.epaisseur = epaisseur;
		this.marges = marges;
	}

	@Override
	public void paintBorder(Component c, Graphics graph, int x, int y, int width, int height) {
		if (epaisseur != 0) {
			graph.setColor(couleur);
			graph.drawRoundRect(x+epaisseur/2, y+epaisseur/2, width-1-epaisseur, height-1-epaisseur, height-1, height-1);
		}
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return marges;
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

}
