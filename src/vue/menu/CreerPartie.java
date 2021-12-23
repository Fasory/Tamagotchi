package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;
import vue.modole.CustomCheckBox;
import vue.modole.CustomLb;
import vue.modole.CustomStyle;
import vue.modole.CustomTxtField;

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
	private ButtonGroup grpType;
	private JCheckBox cbTriche; 
	private HashMap<String, JRadioButton> listRadio;
	
	
	/**
	 * Constructeur
	 */
	public CreerPartie() {
		super();
		// TODO Auto-generated constructor stub 
		// partie affichage
		setLayout(new GridBagLayout()); // nouvelle grille
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dmBouton = new Dimension(150,38);
		Dimension taille = new Dimension(300, 25);
		
		choixType = new JPanel(new GridBagLayout());
		choixType.setOpaque(false);
		
		CustomLb lbChoisirType = new CustomLb("Choisir votre Tamagotchi :",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		choixType.add(lbChoisirType, gbc);
		
		
		grpType = new ButtonGroup();
		listRadio = new HashMap<String, JRadioButton>();
		for (String elt: ControleurGeneral.TYPE) {
			JRadioButton rad = new JRadioButton(elt);
			rad.setOpaque(false);
			rad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					cmdChoixType();
				}
			});
			gbc.gridx = 0;
			gbc.gridy ++;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(0, 0, 0, 30);
			rad.setPreferredSize(dmBouton);
			rad.setActionCommand(elt);
			choixType.add(rad,gbc);
			grpType.add(rad);
			listRadio.put(elt, rad);
		}
		
		
		nom = new JPanel(new GridBagLayout());
		nom.setOpaque(false);
		
		CustomLb lbChoisirNom = new CustomLb("Choisir le nom de votre Tamagotchi :",Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		lbChoisirNom.setVisible(true);
		nom.add(lbChoisirNom, gbc);
		
		
		txtNom = new CustomTxtField();
		txtNom.setPreferredSize(taille);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		nom.add(txtNom, gbc);
		
		
		CustomBtn btnJouer = new CustomBtn("Jouer");
		lsCustomBtn.add(btnJouer);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		btnJouer.setVisible(true);
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		nom.add(btnJouer,gbc);
		
		
		triche = new JPanel(new GridBagLayout());
		triche.setOpaque(false);
		
		
		CustomCheckBox cbTriche = new CustomCheckBox();
		cbTriche.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		triche.add(cbTriche, gbc);
		
		
		CustomLb lbTriche = new CustomLb("Activer le mode triche", 10f, Color.WHITE, CustomStyle.ROSE_ALPHA);
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		triche.add(lbTriche, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Retour", new Insets(12,40,10,40));
		lsCustomBtn.add(btnRetour);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		add(btnRetour,gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 0, 0, 0);
		choixType.setVisible(true);
		add(choixType, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 0, 0, 0);
		nom.setVisible(false);
		add(nom, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 0, 0, 0);
		nom.setVisible(false);
		nom.add(triche, gbc);
		
		
		CustomBtn btnChoixAleatoire = new CustomBtn("Choisir aléatoirement", new Insets(12,40,12,40));
		lsCustomBtn.add(btnChoixAleatoire);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		btnChoixAleatoire.setVisible(true);
		btnChoixAleatoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixAleatoire();
			}
		});
		add(btnChoixAleatoire,gbc);
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
