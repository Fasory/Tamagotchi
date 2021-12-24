package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomCheckBox;
import vue.modele.CustomLb;
import vue.modele.CustomPanel;
import vue.modele.CustomRadioBtn;
import vue.modele.CustomStyle;
import vue.modele.CustomTxtField;

/**
 * La classe CreerPartie gère le menu "Créer Partie", 
 * menu accessible après le menu "Connexion",
 * lorsqu'on clique sur le bouton "Créer une nouvelle partie" 
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class CreerPartie extends Menu {

	private CustomTxtField txtNom;
	private JPanel nom;
	private JPanel choixType;
	private JPanel triche;
	private CustomBtn btnJouer;
	private ButtonGroup grpType;
	private CustomCheckBox cbTriche; 
	private HashMap<String, JRadioButton> listRadio;
	
	
	/**
	 * Constructeur
	 */
	public CreerPartie() {
		super();
		// partie affichage
		setLayout(new GridBagLayout()); // nouvelle grille
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dmBouton = new Dimension(150,38);
		Dimension taille = new Dimension(180, 25);
		
		// Panel type
		choixType = new JPanel(new GridBagLayout());
		choixType.setOpaque(false);
		
		CustomLb lbChoisirType = new CustomLb("Type du Tamagotchi",Color.WHITE, CustomStyle.ROSE_ALPHA);
		lbChoisirType.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		choixType.add(lbChoisirType, gbc);
		
		
		CustomPanel panelRadio = new CustomPanel(new GridBagLayout(), 50, 10);
		
		
		grpType = new ButtonGroup();
		listRadio = new HashMap<String, JRadioButton>();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(15, 10, 0, 0);
		for (String elt: ControleurGeneral.TYPE) {
			CustomRadioBtn rad = new CustomRadioBtn(elt);
			rad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					cmdChoixType();
				}
			});
			rad.setPreferredSize(dmBouton);
			rad.setActionCommand(elt);
			panelRadio.add(rad,gbc);
			grpType.add(rad);
			listRadio.put(elt, rad);
			gbc.gridy++;
		}
		

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(30, 0, 30, 0);
		choixType.add(panelRadio, gbc);
		
		
		CustomBtn btnChoixAleatoire = new CustomBtn("Choix aléatoire", 12, new Insets(12,40,12,40));
		lsCustomBtn.add(btnChoixAleatoire);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		btnChoixAleatoire.setVisible(true);
		btnChoixAleatoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixAleatoire();
			}
		});
		choixType.add(btnChoixAleatoire,gbc);
		
		// Panel Nom
		nom = new JPanel(new GridBagLayout());
		nom.setOpaque(false);
		
		CustomLb lbChoisirNom = new CustomLb("Nom du Tamagotchi",Color.WHITE, CustomStyle.ROSE_ALPHA);
		lbChoisirNom.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		lbChoisirNom.setVisible(true);
		nom.add(lbChoisirNom, gbc);
		
		
		txtNom = new CustomTxtField();
		txtNom.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
				cmdNom();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				cmdNom();
			}
		});
		txtNom.setPreferredSize(taille);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(30, 0, 10, 0);
		nom.add(txtNom, gbc);
		
		
		triche = new JPanel(new GridBagLayout());
		triche.setOpaque(false);
		
		
		cbTriche = new CustomCheckBox();
		cbTriche.setOpaque(false);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 10);
		triche.add(cbTriche, gbc);
		
		
		CustomLb lbTriche = new CustomLb("Activer le mode triche", 10f);
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		triche.add(lbTriche, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 0, 0, 0);
		nom.setVisible(false);
		nom.add(triche, gbc);
		
		
		JPanel panelBtn = new JPanel(new GridBagLayout());
		panelBtn.setOpaque(false);
		
		
		btnJouer = new CustomBtn("Jouer", 12);
		btnJouer.setEnabled(false);
		lsCustomBtn.add(btnJouer);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 0);
		btnJouer.setVisible(true);
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		panelBtn.add(btnJouer,gbc);
		

		CustomBtn btnRetour = new CustomBtn("Retour", 12, new Insets(12,40,10,40));
		lsCustomBtn.add(btnRetour);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		panelBtn.add(btnRetour,gbc);
		
		// Construction du Menu
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		choixType.setVisible(true);
		add(choixType, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(0, 30, 0, 0);
		nom.setVisible(false);
		add(nom, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		nom.setVisible(false);
		add(panelBtn, gbc);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Retour vers l'ancien menu
	 */
	public void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
	
	/**
	 * Demande d'affichage du panel nom
	 */
	public void cmdChoixType() {
		ControleurGeneral.ctrlBouton.rqtChangeAffichagePanel(nom, this, true);
	}
	
	/**
	 * Demande de lancement de partie
	 */
	public void cmdJouer() {
		ControleurGeneral.ctrlBouton.rqtJouer(grpType.getSelection().getActionCommand(), txtNom.getText(), cbTriche.isSelected());
	}

	/**
	 * Sélectionne les attributs du Tamagotchi de manière aléatoire
	 */
	public void cmdChoixAleatoire() {
		ControleurGeneral.ctrlBouton.rqtRandomType();
	}
	
	public void cmdNom() {
		ControleurGeneral.ctrlAffichage.rqtTestActif(this, btnJouer, txtNom.getText());
	}
	
	/**
	 * Rend visible ou non un panel
	 * 
	 * @param panel- Panel auquel on affecte l'affichage
	 * @param affiche - Choix d'afficher ou non
	 */
	public void affichePanel(JPanel panel, boolean affiche) {
		panel.setVisible(affiche);
	}
	
	/**
	 * Sélectionne un type aléatoire pour le Tamagotchi
	 * 
	 * @param rng - Nombre aléatoire
	 */
	public void selectionType(int rng) {
		grpType.clearSelection();
		listRadio.get(ControleurGeneral.TYPE[rng]).setSelected(true);
		cmdChoixType();
	}
}
