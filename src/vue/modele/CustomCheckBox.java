package vue.modele;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;

/**
 * La classe CustomCheckBox implémente un style de checkbox
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CustomCheckBox extends JCheckBox {
	// Attributs
	private final int taille;
	private final int EPAISSEUR = 3;
	private final int MARGE = 3;
	
	// Constructeurs 
	
	/**
	 * Constructeur de la classe CustomCheckBox
	 */
	public CustomCheckBox() {
		this(20);
	}
	
	/**
	 * Constructeur de la classe CustomCheckBox
	 * 
	 * @param taille - int définissant la taille de la checkbox
	 */
	public CustomCheckBox(int taille) {
		super();
		if (taille < 20) taille = 20;
		this.taille = taille;
		setPreferredSize(new Dimension(taille,taille));
		setOpaque(false);
	}
	
	// Redéfinition
	@Override
	public void paintComponent(Graphics graphParam) {
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(CustomStyle.ROSE_DEFAUT);
		graph.fillRoundRect(0, 0, taille, taille, taille/2, taille/2);
		graph.setColor(Color.WHITE);
		graph.fillRoundRect(0+EPAISSEUR, 0+EPAISSEUR, taille-EPAISSEUR*2, taille-EPAISSEUR*2, taille/2-EPAISSEUR*2, taille/2-EPAISSEUR*2);
		if (isSelected()) {
			graph.setColor(CustomStyle.ROSE_DEFAUT);
			graph.fillRoundRect(0+EPAISSEUR+MARGE, 0+EPAISSEUR+MARGE, taille-EPAISSEUR*2-MARGE*2, taille-EPAISSEUR*2-MARGE*2, taille/2-EPAISSEUR*2-MARGE*2, taille/2-EPAISSEUR*2-MARGE*2);
		}
	}
}
