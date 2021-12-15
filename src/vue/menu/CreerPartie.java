package vue.menu;

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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;

public class CreerPartie extends Menu {

	private JTextField txtNom;
	private JPanel nom;
	private JPanel choixType;
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
		
		choixType = new JPanel(new GridBagLayout());
		choixType.setOpaque(false);
		
		JLabel lbChoisirType = new JLabel("Choisir votre Tamagotchi :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		lbChoisirType.setFont(new Font("Calibri", Font.PLAIN, 12));
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
		
		JLabel lbChoisirNom = new JLabel("Choisir le nom de votre Tamagotchi :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		lbChoisirNom.setFont(new Font("Calibri", Font.PLAIN, 12));
		lbChoisirNom.setVisible(true);
		nom.add(lbChoisirNom, gbc);
		
		
		txtNom = new JTextField();
		txtNom.setPreferredSize(new Dimension(200, 25));
		txtNom.setVisible(true);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 0);
		nom.add(txtNom, gbc);
		
		
		CustomBtn btnJouer = new CustomBtn("Jouer");
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
		
		JCheckBox cbTriche = new JCheckBox("Activation du mode triche");
		cbTriche.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		nom.add(cbTriche, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Retour", new Insets(12,40,10,40));
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
		
		
		CustomBtn btnChoixAleatoire = new CustomBtn("Choisir aléatoirement", new Insets(12,40,12,40));
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
