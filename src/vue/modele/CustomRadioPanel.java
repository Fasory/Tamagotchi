package vue.modele;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private final int WIDTH = 350;
	private final int HEIGHT = 150;
	private final int WIDTH_BUTTON = WIDTH/3;
	private final int HEIGHT_BUTTON = HEIGHT/3;
	private Color couleur_foreground;
	private Color couleur_background;
	private Color couleur_interne;
	private CustomPanel panel;
	private CustomLb lbInfo;
	private static Dimension sizeRef = null;
	
	
	public CustomRadioPanel(String nom, String type, int age, int vie, boolean triche) {
		super();
		
		couleur_foreground = CustomStyle.ROSE_DEFAUT;
		couleur_background = CustomStyle.BLANC_DEFAUT;
		couleur_interne = CustomStyle.GRIS_DEFAUT_FONCE;
		
		// Défition de l'affichage du CustomRadioPanel
		setOpaque(false);
		
		panel = new CustomPanel(new GridBagLayout(), ARRONDI, 10, couleur_background);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		int imageSize = HEIGHT-10;
		JLabel image = new JLabel(new ImageIcon(new ImageIcon((new File(ControleurFichier.REP_IMG, ControleurGeneral.TYPE.get(type))).getPath()).getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT)));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 10);
		panel.add(image, gbc);
		gbc.gridheight = 1;
		
		
		CustomLb lbNom = new CustomLb(nom, couleur_interne, CustomStyle.ALPHA);
		lbNom.setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		lbNom.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Nom", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbNom, gbc);
		gbc.gridwidth = 1;
		
		
		CustomLb lbType = new CustomLb(type, couleur_interne, CustomStyle.ALPHA);
		lbType.setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		lbType.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Type", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbType, gbc);
		
		
		CustomLb lbTriche = new CustomLb(triche ? "Activé" : "Désactivé", couleur_interne, CustomStyle.ALPHA);
		lbTriche.setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		lbTriche.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Triche", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbTriche, gbc);
		
		
		CustomLb lbAge = new CustomLb(age + " ans", couleur_interne, CustomStyle.ALPHA);
		lbAge.setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		lbAge.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Age", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbAge, gbc);
		
		
		CustomLb lbVie = new CustomLb(vie + "%", couleur_interne, CustomStyle.ALPHA);
		lbVie.setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		lbVie.setBorder(new TitledBorder(new CustomBordure(couleur_foreground, 5, new Insets(10,10,10,10), ARRONDI), "Vie", TitledBorder.CENTER, TitledBorder.CENTER, CustomStyle.getFont(10), couleur_foreground));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbVie, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(panel, gbc);
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				couleur_background = CustomStyle.GRIS_DEFAUT;
				panel.setBackground(couleur_background);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				couleur_background = CustomStyle.BLANC_DEFAUT;
				panel.setBackground(couleur_background);
			}
		});
		
		if (sizeRef == null) sizeRef = panel.getPreferredSize();
	}
	
	
	public CustomRadioPanel(String message, boolean active) {
		super();
		
		if (active) couleur_foreground = CustomStyle.ROUGE_DEFAUT;
		else couleur_foreground = CustomStyle.GRIS_DEFAUT_FONCE;
		couleur_background = CustomStyle.BLANC_DEFAUT;
		couleur_interne = CustomStyle.GRIS_DEFAUT_FONCE;
		
		// Défition de l'affichage du CustomRadioPanel
		setOpaque(false);
		
		panel = new CustomPanel(new GridBagLayout(), ARRONDI, 10, couleur_background);
		panel.setPreferredSize(sizeRef);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lbInfo = new CustomLb(message, 12, couleur_foreground, CustomStyle.ALPHA);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lbInfo, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(panel, gbc);
		
		
		if (active) {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					couleur_background = CustomStyle.GRIS_DEFAUT;
					panel.setBackground(couleur_background);
				}
	
				@Override
				public void mouseExited(MouseEvent e) {
					couleur_background = CustomStyle.BLANC_DEFAUT;
					panel.setBackground(couleur_background);
				}
			});
		}
	}
	
	
	@Override
	public void paintComponent(Graphics graphParam) {
		if (isSelected() || !isEnabled()) {
			Graphics2D graph = (Graphics2D) graphParam;
			Dimension size = getSize();
			Dimension sizePanel = panel.getSize();
			graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (isSelected()) graph.setColor(couleur_foreground);
			else graph.setColor(CustomStyle.GRIS_DEFAUT_FONCE);
			int arrondi = size.height*ARRONDI/sizePanel.height+1;
			graph.fillRoundRect(0, 0, size.width, size.height, arrondi, arrondi);
		}
	}
	
	@Override
	public void paintChildren(Graphics graphParam) {
		Graphics2D graph = (Graphics2D) graphParam;
		graph.setStroke(new BasicStroke(5));
		super.paintChildren(graph);
	}
}
