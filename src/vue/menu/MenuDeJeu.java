package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import controleur.ControleurGeneral;
import modele.Caracteristique;
import modele.Personnage;
import modele.Piece;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomPanel;
import vue.modele.CustomProgressBar;
import vue.modele.CustomStyle;


public class MenuDeJeu extends Menu {
	protected ControleurGeneral controleurG;
	
	//on initialise certains attributs (qui pourront être modifiés plus tard) hors du constructeur :
	private JLabel labelAge;
	private JLabel labelHumeur;
	private JLabel labelType;
	private JLabel labelNom;
	private JLabel labelAction;
	private JLabel labelLieu;
	private Hashtable<String, CustomProgressBar> barres;
	private Hashtable<String, JButton> btns;
	private JButton[] btnLieu = new JButton[4];
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
		gbc.fill = GridBagConstraints.BOTH;			// Prend toute la place dispo
		add(buildPanelGauche(tamagotchi.getNom(), tamagotchi.getType(), "Humeur", tamagotchi.getLocalisation()), gbc);
		
		
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
	private CustomPanel buildPanelGauche(String nom, String type, String humeur, Piece lieu) {
		CustomPanel panelGauche = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
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
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
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
	private CustomPanel buildPanelDroite(final Personnage tamagotchi) {
		CustomPanel panelDroite = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.anchor = GridBagConstraints.NORTH;
		panelDroite.add(buildPanelCara2((int) tamagotchi.getVie().getValeur(), (int) tamagotchi.getAge().getValeur()), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
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
	private CustomPanel buildPanelLieu(Piece localisation) {
		CustomPanel panelLieu = new CustomPanel(new GridBagLayout());
		Dimension dimPanel = new Dimension(250,30);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		CustomPanel panelPosition = new CustomPanel(new GridBagLayout(), -1, 0, CustomStyle.BLANC_ALPHA);
		panelPosition.setPreferredSize(dimPanel);
		CustomLb labelInfo;
		
		// Pièce
		labelInfo = new CustomLb("Pièce : ", CustomStyle.ROSE_DEFAUT, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 10, 4, 0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelPosition.add(labelInfo, gbc);
		
		
		labelLieu = new CustomLb(" ", CustomStyle.GRIS_DEFAUT_FONCE, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 0, 4, 10));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelPosition.add(labelLieu, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLieu.add(panelPosition, gbc);
		
		// Choix
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(5, 0, 0, 0);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		for (int i = 0; i < btnLieu.length; i++) {
			CustomBtn btnLieuX = new CustomBtn(" ", 8);
			int n = i;
			btnLieuX.setPreferredSize(dimPanel);
			btnLieuX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					cmdLieu(n);
				}
			});
			panelLieu.add(btnLieuX, gbc);
			btnLieu[i] = btnLieuX;
			gbc.gridy++;
		}
		
		
		reinitialiser();
		
		
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
	private CustomPanel buildPanelCara1(String nom, String type, String humeur) {
		CustomPanel panelCara1 = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dimPanel = new Dimension(250,30);
		
		
		CustomPanel panelLbNom = new CustomPanel(new GridBagLayout(), -1, 0, CustomStyle.BLANC_ALPHA);
		panelLbNom.setPreferredSize(dimPanel);
		CustomPanel panelLbType = new CustomPanel(new GridBagLayout(), -1, 0, CustomStyle.BLANC_ALPHA);
		panelLbType.setPreferredSize(dimPanel);
		CustomPanel panelLbHumeur = new CustomPanel(new GridBagLayout(), -1, 0, CustomStyle.BLANC_ALPHA);
		panelLbHumeur.setPreferredSize(dimPanel);
		CustomLb labelInfo;
		
		// Nom
		labelInfo = new CustomLb("Nom : ", CustomStyle.ROSE_DEFAUT, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 10, 4, 0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbNom.add(labelInfo, gbc);
		
		
		labelNom = new CustomLb(nom, CustomStyle.GRIS_DEFAUT_FONCE, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 0, 4, 10));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbNom.add(labelNom, gbc);
		
		// Type
		labelInfo = new CustomLb("Type : ", CustomStyle.ROSE_DEFAUT, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 10, 4, 0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbType.add(labelInfo, gbc);
		
		
		labelType = new CustomLb(type, CustomStyle.GRIS_DEFAUT_FONCE, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 0, 4, 10));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbType.add(labelType, gbc);
		
		// Humeur
		labelInfo = new CustomLb("Humeur : ", CustomStyle.ROSE_DEFAUT, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 10, 4, 0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbHumeur.add(labelInfo, gbc);

	
		labelHumeur = new CustomLb(humeur, CustomStyle.GRIS_DEFAUT_FONCE, CustomStyle.ALPHA, BorderFactory.createEmptyBorder(5, 0, 4, 10));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLbHumeur.add(labelHumeur, gbc);
		
		// Resultat
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 5, 0);
		panelCara1.add(panelLbNom, gbc);
		

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 5, 0);
		panelCara1.add(panelLbType, gbc);
		

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelCara1.add(panelLbHumeur, gbc);
		
		
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
	private CustomPanel buildPanelCara2(int ptsVie, int age) {
		CustomPanel panelCara2 = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		CustomLb labelVie = new CustomLb("Point de vie", 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCara2.add(labelVie, gbc);
		
		
		CustomBtn buttonPause = new CustomBtn("Pause", 10);
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
		barreVie.setPreferredSize(new Dimension(400, 30));
		barreVie.setValue(ptsVie);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		barreVie.setForeground(CustomStyle.VERT_DEFAUT);
		barreVie.setBackground(CustomStyle.ROUGE_DEFAUT);
		panelCara2.add(barreVie, gbc);
		
		
		labelAge = new CustomLb("Age : " + age, 10); 		// Concaténation : le constructeur JLabel prend un String en paramètre
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelCara2.add(labelAge, gbc);
		
	
		labelAction = new CustomLb("Aucune action en cours", 10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		panelCara2.add(labelAction, gbc);
		
		return panelCara2;
	}
	
	
	private CustomPanel buildPanelCara3(Vector<Caracteristique> caracteristiques) {
		CustomPanel panelCara3 = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 0, 0);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.HORIZONTAL;			// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;
		for (Caracteristique caracteristique : caracteristiques) {
			panelCara3.add(buildPanelCaracteristique(caracteristique), gbc);
			gbc.gridy++;
		}
		return panelCara3;
	}
	
	
	private CustomPanel buildPanelCaracteristique(Caracteristique caracteristique) {
		CustomPanel panelCaracteristique = new CustomPanel(new GridBagLayout(), 60, 0, CustomStyle.GRIS_ALPHA);
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dmBouton = new Dimension(80,25);
		
		
		CustomLb labelCaracteristique = new CustomLb(caracteristique.getNom());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 0);
		gbc.anchor = GridBagConstraints.WEST;
		panelCaracteristique.add(labelCaracteristique, gbc);
		
		
		
		CustomProgressBar barreCaracteristique = new CustomProgressBar((int) caracteristique.getMin(), (int) caracteristique.getMax());
		barreCaracteristique.setPreferredSize(new Dimension(400, 30));
		barreCaracteristique.setValue((int) caracteristique.getValeur());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelCaracteristique.add(barreCaracteristique, gbc);
		barres.put(caracteristique.getNom(), barreCaracteristique);
		
		
		CustomBtn btnCaracteristique = new CustomBtn(caracteristique.getModifieur(), 8);
		btnCaracteristique.setSize(dmBouton);
		btnCaracteristique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				cmdAction(caracteristique.getNom());
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelCaracteristique.add(btnCaracteristique, gbc);
		btns.put(caracteristique.getNom(), btnCaracteristique);
		
		
		return panelCaracteristique;
	}
	
	public void setAll(Vector<Caracteristique> caracteristiques, Caracteristique vie, Caracteristique age) {
		for (Caracteristique caracteristique: caracteristiques) {
			barres.get(caracteristique.getNom()).setValue((int) caracteristique.getValeur());
		}
		if (vie.getValeur()>0) {
			barreVie.setValue((int) vie.getValeur());
		}else {
			ControleurGeneral.ctrlJeu.rqtFin(labelType.getText(),labelNom.getText(),(int)age.getValeur());
		} 
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	

	private void cmdLieu(int direction) {
		ControleurGeneral.ctrlJeu.rqtChangeLieu(direction);
	}
	
	
	private void cmdAction(String caracteristique) {
		ControleurGeneral.ctrlJeu.rqtAction(caracteristique);
		String action = "Restaure : "+caracteristique;
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
		ControleurGeneral.ctrlTemps.addThreadJeu(5000, new Runnable(){
			  @Override
			  public void run() {
				  	String action = "Aucune action en cours";
					ControleurGeneral.ctrlAffichage.modifLabel(labelAction, action);
			  }
		});
	}
	
	/**
	 * Demande de changement de menu : Menu pause
	 */
	public void cmdPause() {
		ControleurGeneral.ctrlBouton.rqtPause();
	}
	
	@Override
	public void reinitialiser() {
		Piece localisation = ControleurGeneral.ctrlJeu.rqtGetLieu();
		labelLieu.setText(localisation.getNom());
		int[] lsDirection = {Piece.HAUT, Piece.GAUCHE, Piece.BAS, Piece.DROITE};
		for (int direction : lsDirection) {
			if (localisation.existePiece(direction)) {
				btnLieu[direction].setText(localisation.voirPiece(direction).getNom());
				btnLieu[direction].setEnabled(true);
			} else {
				btnLieu[direction].setText(" ");
				btnLieu[direction].setEnabled(false);
			}
		}
	}
	

	
	
	
}
