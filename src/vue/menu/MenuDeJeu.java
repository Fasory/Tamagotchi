package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.Timer;

import controleur.ControleurAffichage;
import controleur.ControleurGeneral;
import modele.Caracteristique;
import modele.Personnage;
import vue.modele.CustomProgressBar;
import vue.modele.CustomStyle;


public class MenuDeJeu extends Menu {
	protected ControleurGeneral controleurG;
	
	//on initialise certains attributs (qui pourront être modifiés plus tard) hors du constructeur :
	private JLabel labelAge;
	private JLabel labelHumeur;
	private JLabel labelAction;
	private JLabel labelLieu;
	private Hashtable<String, CustomProgressBar> barres;
	private Hashtable<String, JButton> btns;
	private CustomProgressBar barreVie;
	
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Controleur de l'application
	 */
	
	public MenuDeJeu(final Personnage tamagotchi) {
		super();
		
		barres = new Hashtable<String, CustomProgressBar>();
		btns = new Hashtable<String, JButton>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Ajout du panel gauche
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.insets = new Insets(20, 20, 20, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.VERTICAL;			// Prend toute la place dispo
		add(buildPanelGauche(tamagotchi.getNom(), "Type", "Humeur", "Chambre"), gbc);
		
		
		// Ajout du panel droit
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(20, 0, 20, 20);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;				// Prend toute la place dispo
		add(buildPanelDroite(tamagotchi), gbc);
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
	private JPanel buildPanelDroite(final Personnage tamagotchi) {
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
		panelDroite.add(buildPanelCara3(tamagotchi.getCaracteristiques()), gbc);
		
		
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
		
		
		JButton buttonPause = new JButton("Pause");
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		buttonPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdPause();
			}
		});
		panelCara2.add(buttonPause, gbc);
		
		
		
		barreVie = new CustomProgressBar(0, 100,true);
		barreVie.setValue(ptsVie);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 10, 10, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		barreVie.setForeground(CustomStyle.VERT_DEFAUT);
		barreVie.setBackground(CustomStyle.ROUGE_DEFAUT);
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
	
	
	private JPanel buildPanelCara3(Vector<Caracteristique> caracteristiques) {
		JPanel panelCara3 = new JPanel(new GridBagLayout());
		panelCara3.setBackground(Color.ORANGE);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		for (Caracteristique caracteristique : caracteristiques) {
			panelCara3.add(buildPanelCaracteristique(caracteristique), gbc);
			gbc.gridy++;
		}

		
		return panelCara3;
	}
	
	
	private JPanel buildPanelCaracteristique(Caracteristique caracteristique) {
		JPanel panelCaracteristique = new JPanel(new GridBagLayout());
		panelCaracteristique.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Dimension dmBouton = new Dimension(100,25);
		
		
		JLabel labelCaracteristique = new JLabel(caracteristique.getNom());
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCaracteristique.add(labelCaracteristique, gbc);
		
		
		
		CustomProgressBar barreCaracteristique = new CustomProgressBar((int) caracteristique.getMin(), (int) caracteristique.getMax());
		barreCaracteristique.setValue((int) caracteristique.getValeur());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		panelCaracteristique.add(barreCaracteristique, gbc);
		barres.put(caracteristique.getNom(), barreCaracteristique);
		
		
		JButton btnCaracteristique = new JButton(caracteristique.getModifieur());
		btnCaracteristique.setPreferredSize(dmBouton);
		btnCaracteristique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				cmdAction(caracteristique.getNom());
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		panelCaracteristique.add(btnCaracteristique, gbc);
		btns.put(caracteristique.getNom(), btnCaracteristique);
		
		
		return panelCaracteristique;
	}
	
	public void setAll(Vector<Caracteristique> caracteristiques, Caracteristique vie) {
		for (Caracteristique caracteristique: caracteristiques) {
			barres.get(caracteristique.getNom()).setValue((int) caracteristique.getValeur());
		}
		barreVie.setValue((int) vie.getValeur());
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/*
	 * Demande d'une requête liée au bouton btnLieuG	<br/>
	 */
	private void cmdLieuG() {

	}
	
	/*
	 * Demande d'une requête liée au bouton btnLieuD	<br/>
	 */
	private void cmdLieuD() {
	}
	
	private void cmdAction(String caracteristique) {
		ControleurGeneral.ctrlJeu.rqtAction(caracteristique);
		String action = "restaure : "+caracteristique;
		ControleurGeneral.ctrlAffichage.modifLabel(labelAction, action);
		// d�sactive les btn apr�s le lancement d'une premi�re action
		btns.forEach((k, v) -> {
			ControleurGeneral.ctrlAffichage.rqtComposantActif(this,v, false);
		});
		// R�activation des btns avec un timer
		Menu menu = this;
		ControleurGeneral.ctrlTemps.addThreadJeu(5000, new Runnable(){
			  @Override
			  public void run() {
					btns.forEach((k, v) -> {
						ControleurGeneral.ctrlAffichage.rqtComposantActif(menu,v, true);
					});
			  }
		});
	}
	
	/**
	 * Demande de changement de menu : Menu pause
	 */
	public void cmdPause() {
		ControleurGeneral.ctrlBouton.rqtPause();
	}
	
	
}
