package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controleur.ControleurGeneral;


public class MenuDeJeu extends Menu {
	protected ControleurGeneral controleurG;
	
	//on initialise certains attributs (qui pourront être modifiés plus tard) hors du constructeur :
	private JLabel labelAge;
	private JLabel labelHumeur;
	private JLabel labelAction;
	private JLabel labelLieu;
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Controleur de l'application
	 */
	
	public MenuDeJeu() {
		super();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
//
//		
//		//JPanel contenant labelVie, la barre de vie, et labelAction
//		JPanel panelCara2 = new JPanel(new GridBagLayout());
//
//		
//		//label contenant le texte "Points de vie : "		
//		final JLabel labelVie = new JLabel("Points de vie : ");
//
//		
//		/*
//		//JProgressBar contenant la valeur des points de vie restants
//		// @0 - valeur minimale / @100 - valeur maximale
//		barreVie = new JProgressbar(int 0, int 100);
//		//ajoute du texte dans la barre
//		barreVie.setStringPainted(true);
//		barreVie.setValue(vie);
//		// @vie - variable importée depuis la classe personnage
//		*/
//		
//		//label contenant l'action en cours qu'effectue le Tamagotchi		
//		labelAction = new JLabel(/*action*/"action");
//		// @action - variable importée depuis la classe personnage
//
//		
//		//label contenant l'âge actuel du Tamagotchi		
//		labelAge = new JLabel(/*age*/"age");
//		// @age - variable importée depuis la classe personnage
//
//		
//		//JPanel contenant labelEnergie, la barre d'énergie, labelHygiene, la barre d'hygène, labelMoral, la barre de moral, labelNourriture, la barre de nourriture, labelToilettes, et la barre d'envie d'aller aux toilettes
//		JPanel panelCara3 = new JPanel(new GridBagLayout());
//
//		
//		//label contenant l'énergie actuelle du Tamagotchi		
//		final JLabel labelEnergie = new JLabel(/*energie*/"energie");
//		// @energie - variable importée depuis la classe personnage
//
//		
//		//label contenant le niveau d'hygiène actuel du Tamagotchi		
//		final JLabel labelHygiene = new JLabel(/*hygiene*/"hygiene");
//		// @hygiene - variable importée depuis la classe personnage
//
//		
//		//label contenant le niveau de moral actuel du Tamagotchi		
//		final JLabel labelMoral = new JLabel(/*moral*/"moral");
//		// @hygiene - variable importée depuis la classe personnage
//
//		
//		//label contenant le niveau de nourriture actuel du Tamagotchi		
//		final JLabel labelNourriture = new JLabel(/*nourriture*/"nourriture");
//		// @nourriture - variable importée depuis la classe personnage
//
//		
//		//label contenant le niveau d'envie d'aller aux toilettes actuel du Tamagotchi		
//		final JLabel labelToilettes = new JLabel(/*toilettes*/"toilettes");
//		// @toilettes - variable importée depuis la classe personnage

//		
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		add(panelDroit,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelDroit.add(panelCara2,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelCara2.add(labelVie,gbc);
//		
//		//gbc.gridx = 0;
//		//gbc.gridy = 1;
//		//panelCara2.add(barreDeVie,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		panelCara2.add(labelAction,gbc);
//		
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		panelDroit.add(labelAge,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		panelDroit.add(panelCara3,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelCara3.add(labelEnergie,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		panelCara3.add(labelHygiene,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 4;
//		panelCara3.add(labelMoral,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 6;
//		panelCara3.add(labelNourriture,gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 8;
//		panelCara3.add(labelToilettes,gbc);
		
		// Ajout du panel gauche
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.insets = new Insets(20, 20, 20, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.VERTICAL;			// Prend toute la place dispo
		add(buildPanelGauche("Nom", "Type", "Humeur", "Lieu"), gbc);
		
		
		// Ajout du panel droit
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(20, 0, 20, 20);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;				// Prend toute la place dispo
		add(buildPanelDroite(), gbc);
	}
	
	
	////////////////////////////////////////
	//          CONSTRUCTION  DES         //
	//          JPANEL COMPOSANTS         //        
	////////////////////////////////////////
	
	/**
	 * Construit le JPanel gauche contenant :
	 * 		- JPanel panelCara1
	 * 		- Image Tamagotchi
	 * 		- JPanel panelLieu
	 * 
	 * @return JPanel - contenant tout le panel gauche
	 */
	private JPanel buildPanelGauche(String nom, String type, String humeur, String lieu) {
		JPanel panelGauche = new JPanel(new GridBagLayout());
		panelGauche.setBackground(Color.CYAN);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(10, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.HORIZONTAL;		// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelGauche.add(buildPanelCara1(nom, type, humeur), gbc);
		
		
		/**
		 * Ajouter l'Image
		 */
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(10, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.HORIZONTAL; 		// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.SOUTH;
		panelGauche.add(buildPanelLieu(lieu), gbc);
		
		
		return panelGauche;
	}
	
	/**
	 * Construit le JPanel droite contenant :
	 * 		- JPanel panelCara2
	 * 		- JPanel panelCara3
	 * 
	 * @return JPanel - contenant tout le panel droit
	 */
	private JPanel buildPanelDroite() {
		JPanel panelDroite = new JPanel(new GridBagLayout());
		panelDroite.setBackground(Color.GREEN);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(10, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.HORIZONTAL;		// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelDroite.add(buildPanelCara2("Points de vie :", 100, 1,  "Aucune action en cours"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(10, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;				// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.SOUTH;
		panelDroite.add(buildPanelCara3(), gbc);
		
		
		return panelDroite;
	}
	
	/**
	 * Construit le JPanel lieu contenant :
	 * 		- JLabel lieu
	 * 		- JButton aGauche
	 * 		- JButton aDroite
	 * 
	 * @return JPanel - contenant tout le panel lieu
	 */
	private JPanel buildPanelLieu(String lieu) {
		JPanel panelLieu = new JPanel(new GridBagLayout());
		panelLieu.setBackground(Color.RED);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(110,25);
		
			
		labelLieu = new JLabel(lieu);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;	// occupe 2 cellules
		panelLieu.add(labelLieu, gbc);
		
		
		JButton btnLieuG = new JButton("<");
		btnLieuG.setPreferredSize(dmBouton);
		btnLieuG.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdLieuG();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 10);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelLieu.add(btnLieuG, gbc);

		
		JButton btnLieuD = new JButton(">");
		btnLieuD.setPreferredSize(dmBouton);
		btnLieuG.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdLieuD();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 10);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelLieu.add(btnLieuD, gbc);
		
		
		return panelLieu;
	}
	
	/**
	 * Construit le JPanel cara1 contenant :
	 * 		- JLabel nom
	 * 		- JLabel type
	 * 		- JLabel humeur
	 * 
	 * @return JPanel - contenant tout le panel cara1
	 */
	private JPanel buildPanelCara1(String nom, String type, String humeur) {
		JPanel panelCara1 = new JPanel(new GridBagLayout());
		panelCara1.setBackground(Color.YELLOW);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel labelNom = new JLabel(nom);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara1.add(labelNom, gbc);
			
		
		JLabel labelType = new JLabel(type);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelCara1.add(labelType, gbc);

	
		labelHumeur = new JLabel(humeur);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCara1.add(labelHumeur, gbc);
		
		
		return panelCara1;
	}
	
	
	/**
	 * Construit le JPanel cara2 contenant :
	 * 		- JPanel panelEnergie
	 * 		- JPanel panelHygiene
	 *  	- JPanel panelMoral
	 * 		- JPanel panelNourriture
	 * 		- JPanel panelToilettes
	 * 
	 * @return JPanel - contenant tout le panel cara2
	 */
	private JPanel buildPanelCara2(String vie, int ptsVie, int age, String action) {
		JPanel panelCara2 = new JPanel(new GridBagLayout());
		panelCara2.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel labelVie = new JLabel(vie);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara2.add(labelVie, gbc);
			
		
		JProgressBar barreVie = new JProgressBar(0, 100);
		barreVie.setValue(ptsVie);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 10, 10, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelCara2.add(barreVie, gbc);
		
		
		labelAge = new JLabel("Age : "+age); 		// Concaténation : le constructeur JLabel prend un String en paramètre
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelCara2.add(labelAge, gbc);
		
	
		labelAction = new JLabel(action);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelCara2.add(labelAction, gbc);
		
		return panelCara2;
	}
	
	
	private JPanel buildPanelCara3() {
		JPanel panelCara3 = new JPanel(new GridBagLayout());
		panelCara3.setBackground(Color.ORANGE);
		GridBagConstraints gbc = new GridBagConstraints();
			
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelCara3.add(buildPanelEnergie("Energie :", 100), gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelCara3.add(buildPanelHygiene("Hygiène :", 100), gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelCara3.add(buildPanelMoral("Moral :", 100), gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelCara3.add(buildPanelNourriture("Nourriture :", 100), gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 10, 10, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		panelCara3.add(buildPanelToilettes("Toilettes :", 100), gbc);	
		
		
		return panelCara3;
	}
	
	
	/**
	 * Construit le JPanel energie contenant :
	 * 		- JLabel LabelEnergie
	 * 		- JProgressBar barreEnergie
	 *  	- JButton btnDormir
	 * 
	 * @return JPanel - contenant tout le panel energie
	 */
	private JPanel buildPanelEnergie(String energie, int ptsEnergie) {
		JPanel panelEnergie = new JPanel(new GridBagLayout());
		panelEnergie.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelEnergie = new JLabel(energie);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelEnergie.add(labelEnergie, gbc);
		
		
		JProgressBar barreEnergie = new JProgressBar(0, 100);
		barreEnergie.setValue(ptsEnergie);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelEnergie.add(barreEnergie, gbc);
		
		
		JButton btnDormir = new JButton("Dormir");
		btnDormir.setPreferredSize(dmBouton);
		btnDormir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdDormir();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelEnergie.add(btnDormir, gbc);
		
		
		return panelEnergie;
	}
	
	
	/**
	 * Construit le JPanel hygiene contenant :
	 * 		- JLabel LabelHygiene
	 * 		- JProgressBar barreHygiene
	 *  	- JButton btnDouche
	 * 
	 * @return JPanel - contenant tout le panel hygiene
	 */
	private JPanel buildPanelHygiene(String hygiene, int ptsHygiene) {
		JPanel panelHygiene = new JPanel(new GridBagLayout());
		panelHygiene.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelHygiene = new JLabel(hygiene);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelHygiene.add(labelHygiene, gbc);
		
		
		JProgressBar barreHygiene = new JProgressBar(0, 100);
		barreHygiene.setValue(ptsHygiene);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelHygiene.add(barreHygiene, gbc);
		
		
		JButton btnDouche = new JButton("Douche");
		btnDouche.setPreferredSize(dmBouton);
		btnDouche.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdDouche();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelHygiene.add(btnDouche, gbc);
		
		
		return panelHygiene;
	}
	
	
	/**
	 * Construit le JPanel moral contenant :
	 * 		- JLabel LabelMoral
	 * 		- JProgressBar barreMoral
	 *  	- JButton btnJouer
	 * 
	 * @return JPanel - contenant tout le panel moral
	 */
	private JPanel buildPanelMoral(String moral, int ptsMoral) {
		JPanel panelMoral = new JPanel(new GridBagLayout());
		panelMoral.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelMoral = new JLabel(moral);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelMoral.add(labelMoral, gbc);
		
		
		JProgressBar barreMoral = new JProgressBar(0, 100);
		barreMoral.setValue(ptsMoral);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelMoral.add(barreMoral, gbc);
		
		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.setPreferredSize(dmBouton);
		btnJouer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelMoral.add(btnJouer, gbc);
		
		
		return panelMoral;
	}
	
	
	/**
	 * Construit le JPanel nourriture contenant :
	 * 		- JLabel LabelNourriture
	 * 		- JProgressBar barreNourriture
	 *  	- JButton btnManger
	 * 
	 * @return JPanel - contenant tout le panel nourriture
	 */
	private JPanel buildPanelNourriture(String nourriture, int ptsNourriture) {
		JPanel panelNourriture = new JPanel(new GridBagLayout());
		panelNourriture.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelNourriture = new JLabel(nourriture);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelNourriture.add(labelNourriture, gbc);
		
		
		JProgressBar barreNourriture = new JProgressBar(0, 100);
		barreNourriture.setValue(ptsNourriture);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelNourriture.add(barreNourriture, gbc);
		
		
		JButton btnManger = new JButton("Manger");
		btnManger.setPreferredSize(dmBouton);
		btnManger.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdManger();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelNourriture.add(btnManger, gbc);
		
		
		return panelNourriture;
	}
	
	
	/**
	 * Construit le JPanel toilettes contenant :
	 * 		- JLabel LabelToilettes
	 * 		- JProgressBar barreToilettes
	 *  	- JButton btnToilettes
	 * 
	 * @return JPanel - contenant tout le panel toilettes
	 */
	private JPanel buildPanelToilettes(String toilettes, int ptsToilettes) {
		JPanel panelToilettes = new JPanel(new GridBagLayout());
		panelToilettes.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelToilettes = new JLabel(toilettes);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelToilettes.add(labelToilettes, gbc);
		
		
		JProgressBar barreToilettes = new JProgressBar(0, 100);
		barreToilettes.setValue(ptsToilettes);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelToilettes.add(barreToilettes, gbc);
		
		
		JButton btnToilettes = new JButton("Toilettes");
		btnToilettes.setPreferredSize(dmBouton);
		btnToilettes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdToilettes();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelToilettes.add(btnToilettes, gbc);
		
		
		return panelToilettes;
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/*
	 * Demande d'une requête liée au bouton btnLieuG	<br/>
	 */
	private void cmdLieuG() {};
	
	/*
	 * Demande d'une requête liée au bouton btnLieuD	<br/>
	 */
	private void cmdLieuD() {};
	
	/*
	 * Demande d'une requête liée au bouton btnDormir	<br/>
	 */
	private void cmdDormir() {};
	
	/*
	 * Demande d'une requête liée au bouton btnDouche	<br/>
	 */
	private void cmdDouche() {};
	
	/*
	 * Demande d'une requête liée au bouton btnJouer	<br/>
	 */
	private void cmdJouer() {};
	
	/*
	 * Demande d'une requête liée au bouton btnManger	<br/>
	 */
	private void cmdManger() {};
	
	/*
	 * Demande d'une requête liée au bouton btnToilettes	<br/>
	 */
	private void cmdToilettes() {};
	
	
}
