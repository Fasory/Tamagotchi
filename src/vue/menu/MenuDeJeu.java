package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

import controleur.ControleurGeneral;

import controleur.ControleurGeneral;


public class MenuDeJeu extends Menu{
	protected ControleurGeneral controleurG;
	
	//on initialise certains attributs (qui pourront être modifiés plus tard) hors du constructeur
	JProgressBar barreVie;
	JLabel labelHumeur;
	JLabel labelLieu;
	JLabel labelAction;
	JLabel labelAge;
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Controleur de l'application
	 */
	
	public MenuDeJeu(ControleurGeneral controleur) {
		super(controleur);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		Dimension dmBouton = new Dimension(110,25);
		
		//JPanel gauche contenant panelCara1, l'image du Tamagotchi, le label lieu et les boutons de changement de lieu
		JPanel panelGauche = new JPanel(new GridBagLayout());
		//x et y sont relatifs au panel auquel ils appartiennent
		
		
		//JPanel contenant le label nom, le label type, et le label humeur
		JPanel panelCara1 = new JPanel(new GridBagLayout());
		
		
		//label contenant le nom du Tamagotchi		
		final JLabel labelNom = new JLabel(/*nom*/); 
		// @nom - variable importée depuis la classe personnage

		
		//label contenant le type du Tamagotchi		
		final JLabel labelType = new JLabel(/*type*/);
		// @type - variable importée depuis la classe personnage

		
		//label contenant l'humeur du Tamagotchi		
		labelHumeur = new JLabel(/*humeur*/);
		// @humeur - variable importée depuis la classe personnage

		
		//image du tamagotchi

		
		//panel contenant le label lieu, et les boutons lieuG et lieuD
		JPanel panelLieu = new JPanel(new GridBagLayout());

		
		//label contenant le lieu actuel du Tamagotchi		
		labelLieu = new JLabel(/*lieu*/);
		// @lieu - variable importée depuis la classe personnage

		
		JButton btnLieuG = new JButton();
		btnLieuG.setPreferredSize(dmBouton);
		btnLieuG.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdLieuG();
			}
		});

		
		JButton btnLieuD = new JButton();
		btnLieuD.setPreferredSize(dmBouton);
		btnLieuG.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				cmdLieuD();
			}
		});

		
		//JPanel droit contenant panelCara2, panelCara3, le label age et les boutons d'interaction avec le Tamagotchi :
		//boutonDormir, boutonDouche, boutonJouer, boutonManger, et boutonToilettes
		JPanel panelDroit = new JPanel(new GridBagLayout());

		
		//JPanel contenant labelVie, la barre de vie, et labelAction
		JPanel panelCara2 = new JPanel(new GridBagLayout());

		
		//label contenant le texte "Points de vie : "		
		final JLabel labelVie = new JLabel("Points de vie : ");

		
		/*
		//JProgressBar contenant la valeur des points de vie restants
		// @0 - valeur minimale / @100 - valeur maximale
		barreVie = new JProgressbar(int 0, int 100);
		//ajoute du texte dans la barre
		barreVie.setStringPainted(true);
		barreVie.setValue(vie);
		// @vie - variable importée depuis la classe personnage
		*/
		
		//label contenant l'action en cours qu'effectue le Tamagotchi		
		labelAction = new JLabel(/*action*/);
		// @action - variable importée depuis la classe personnage

		
		//label contenant l'âge actuel du Tamagotchi		
		labelAge = new JLabel(/*age*/);
		// @age - variable importée depuis la classe personnage

		
		//JPanel contenant labelEnergie, la barre d'énergie, labelHygiene, la barre d'hygène, labelMoral, la barre de moral, labelNourriture, la barre de nourriture, labelToilettes, et la barre d'envie d'aller aux toilettes
		JPanel panelCara3 = new JPanel(new GridBagLayout());

		
		//label contenant l'énergie actuelle du Tamagotchi		
		final JLabel labelEnergie = new JLabel(/*energie*/);
		// @energie - variable importée depuis la classe personnage

		
		//label contenant le niveau d'hygiène actuel du Tamagotchi		
		final JLabel labelHygiene = new JLabel(/*hygiene*/);
		// @hygiene - variable importée depuis la classe personnage

		
		//label contenant le niveau de moral actuel du Tamagotchi		
		final JLabel labelMoral = new JLabel(/*moral*/);
		// @hygiene - variable importée depuis la classe personnage

		
		//label contenant le niveau de nourriture actuel du Tamagotchi		
		final JLabel labelNourriture = new JLabel(/*nourriture*/);
		// @nourriture - variable importée depuis la classe personnage

		
		//label contenant le niveau d'envie d'aller aux toilettes actuel du Tamagotchi		
		final JLabel labelToilettes = new JLabel(/*toilettes*/);
		// @toilettes - variable importée depuis la classe personnage

		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		//raccourci de this.add (avec this = MenuDeJeu) => applique la contrainte
		add(panelGauche,gbc);
		
		//on applique la contrainte gbc à chaque élément
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelGauche.add(panelCara1,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara1.add(labelNom,gbc);
		
		gbc.gridx = 0;
		//cellule numéro 1
		gbc.gridy = 1;
		panelCara1.add(labelType,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCara1.add(labelHumeur,gbc);
		
		//gbc.gridx = 0;
		//gbc.gridy = 1;
		//panelGauche.add(image,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelGauche.add(panelLieu,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelLieu.add(labelLieu,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		/*
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 20);
		*/
		panelLieu.add(btnLieuG, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		/*
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 20);
		*/
		panelLieu.add(btnLieuG, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(panelDroit,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelDroit.add(panelCara2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara2.add(labelVie,gbc);
		
		//gbc.gridx = 0;
		//gbc.gridy = 1;
		//panelCara2.add(barreDeVie,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCara2.add(labelAction,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelDroit.add(labelAge,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelDroit.add(panelCara3,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara3.add(labelEnergie,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCara3.add(labelHygiene,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelCara3.add(labelMoral,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelCara3.add(labelNourriture,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		panelCara3.add(labelToilettes,gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/*
	 * Demande d'une requête liée au bouton btnLieuG	<br/>
	 */
	public void cmdLieuG() {};
	
	/*
	 * Demande d'une requête liée au bouton btnLieuD	<br/>
	 */
	public void cmdLieuD() {};
	
	
	}
