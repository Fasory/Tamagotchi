package vue.modole;

import javax.swing.JButton;

import controleur.ControleurFichier;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Insets;

public class CustomBtn extends JButton {
	
	private final static Color DEFAUT_FORGROUND = new Color(255, 110, 160);
	private final static Color DEFAUT_BACKGROUND = Color.WHITE;
	private final static Color SURVOLE_FORGROUND = DEFAUT_FORGROUND;
	private final static Color SURVOLE_BACKGROUND = new Color(199, 199, 199);
	private final static Color PRESSION_FORGROUND = new Color(255, 40, 110);
	private final static Color PRESSION_BACKGROUND = new Color(96, 96, 96);
	private final static int EPAISSEUR = 4;
	private static Font police = null;
	private int statut = 0;
	private final Insets marges;
	
	public CustomBtn(String texte) {
		this(texte, new Insets(12, 35, 10, 35));
	}
	
	public CustomBtn(String texte, Insets marges) {
		super(texte);
		this.marges = marges;
		if (police == null) {
			try {
				police = Font.createFont(Font.PLAIN, ControleurFichier.FONT_KAWAII);
				//police.deriveFont(15f);
				police = police.deriveFont(Font.BOLD, 15f);
			} catch (FontFormatException | IOException err) {
				err.printStackTrace();
			}
		}
		setFont(police);
		setContentAreaFilled(false);
		setFocusable(false); 
		addMouseListener(new MouseAdapter() {
			@Override
		    public void mousePressed(MouseEvent e) {
				statut = 2;
		    }
			
			@Override
		    public void mouseReleased(MouseEvent e) {
				if (statut != 0) statut = 1;
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
				statut = 1;
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
				statut = 0;
		    }
		});
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
		if (statut == 0) paintDefaut(graphParam);
		else if (statut == 1) paintSurvole(graphParam);
		else paintPression(graphParam);

		super.paintComponent(graphParam);
	}
	
	public void paintDefaut(Graphics graphParam) {
		setBorder(new CustomBordure(DEFAUT_FORGROUND, EPAISSEUR, marges));
		setForeground(DEFAUT_FORGROUND);
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(DEFAUT_BACKGROUND);
		graph.setStroke(new BasicStroke(EPAISSEUR));
		graph.fillRoundRect(0+EPAISSEUR/2, 0+EPAISSEUR/2, size.width-1-EPAISSEUR, size.height-1-EPAISSEUR, size.height-1, size.height-1);
	}
	
	public void paintSurvole(Graphics graphParam) {
		setBorder(new CustomBordure(SURVOLE_FORGROUND, EPAISSEUR, marges));
		setForeground(SURVOLE_FORGROUND);
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(SURVOLE_BACKGROUND);
		graph.setStroke(new BasicStroke(EPAISSEUR));
		graph.fillRoundRect(0+EPAISSEUR/2, 0+EPAISSEUR/2, size.width-1-EPAISSEUR, size.height-1-EPAISSEUR, size.height-1, size.height-1);
	}
	
	public void paintPression(Graphics graphParam) {
		setBorder(new CustomBordure(SURVOLE_FORGROUND, EPAISSEUR, marges));
		setForeground(PRESSION_FORGROUND);
		Dimension size = getSize();
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setColor(PRESSION_BACKGROUND);
		graph.setStroke(new BasicStroke(EPAISSEUR));
		graph.fillRoundRect(0+EPAISSEUR/2, 0+EPAISSEUR/2, size.width-1-EPAISSEUR, size.height-1-EPAISSEUR, size.height-1, size.height-1);
	}

}
