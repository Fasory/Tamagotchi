package vue.modele;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Image;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controleur.ControleurFichier;
import controleur.ControleurGeneral;

public class CustomRadioPanel extends JRadioButton {
	
	
	private final int ARRONDI = 30;
	private final int WIDTH = 500;
	private final int HEIGHT = 200;
	private Color couleur_foreground;
	private Color couleur_background;
	private Color couleur_interne;
	
	
	public CustomRadioPanel(String partie, String nom, String type, int age, int vie) {
		super();
		
		couleur_foreground = CustomStyle.ROSE_DEFAUT;
		couleur_background = CustomStyle.BLANC_ALPHA;
		couleur_interne = CustomStyle.GRIS_DEFAUT_FONCE;
		
		// Défition de l'affichage du CustomRadioPanel
		setOpaque(false);
		
		CustomPanel panel = new CustomPanel(new GridBagLayout(), 30, 10);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel image = new JLabel(new ImageIcon(new ImageIcon((new File(ControleurFichier.REP_IMG, ControleurGeneral.TYPE.get(type))).getPath()).getImage().getScaledInstance(HEIGHT, HEIGHT, Image.SCALE_DEFAULT)));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(image, gbc);
		gbc.gridheight = 1;
		
		
		CustomLb lbNom = new CustomLb(nom, couleur_interne, CustomStyle.ALPHA);
		lbNom.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/4));
		lbNom.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Nom", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbNom, gbc);
		
		
		CustomLb lbType = new CustomLb(type, couleur_interne, CustomStyle.ALPHA);
		lbType.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/4));
		lbType.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Type", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbType, gbc);
		
		
		CustomLb lbAge = new CustomLb(age + " ans", couleur_interne, CustomStyle.ALPHA);
		lbAge.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/4));
		lbAge.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Age", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbAge, gbc);
		
		
		CustomLb lbVie = new CustomLb(vie + "%", couleur_interne, CustomStyle.ALPHA);
		lbVie.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/4));
		lbVie.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Vie", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbVie, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(panel, gbc);
	}
	
	@Override
	public void paintComponent(Graphics graphParam) {
	}
	
	@Override
	public void paintChildren(Graphics graphParam) {
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setStroke(new BasicStroke(5));
		super.paintChildren(graph);
	}
}
