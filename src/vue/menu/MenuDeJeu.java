package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controleur.ControleurFichier;
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
	//on initialise certains attributs (qui pourront être modifiés plus tard) hors du constructeur :
	private CustomLb labelAge;
	private CustomLb labelHumeur;
	private CustomLb labelType;
	private CustomLb labelNom;
	private CustomLb labelAction;
	private CustomLb labelLieu;
	private Hashtable<String, CustomProgressBar> barres;
	private Hashtable<String, CustomBtn> btns;
	private CustomBtn[] btnLieu = new CustomBtn[4];
	private CustomProgressBar barreVie;
	
	
	/**
	 * Constructeur
	 * 
	 * @param controleur - Controleur de l'application
	 */
	
	public MenuDeJeu(final Personnage tamagotchi) {
		super();
		
		barres = new Hashtable<String, CustomProgressBar>();
		btns = new Hashtable<String, CustomBtn>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Ajout du panel gauche
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.insets = new Insets(20, 20, 20, 10);		// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.BOTH;				// Prend toute la place dispo
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
	 * 		- JLabel (contenant une Image) imageTama
	 * 		- JPanel panelLieu
	 * 
	 * @return JPanel - contenant tout le panel gauche
	 */
	private CustomPanel buildPanelGauche(String nom, String type, String humeur, Piece lieu) {
		CustomPanel panelGauche = new CustomPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;									// Emplacement que va occuper l'objet sur l'axe x
		gbc.gridy = 0;									
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.fill = GridBagConstraints.HORIZONTAL;		// Prend toute la place dispo
		gbc.anchor = GridBagConstraints.NORTH;			// Définit la direction de l'alignement
		panelGauche.add(buildPanelCara1(nom, type, humeur), gbc);	// Ajoute le JPanel buildPanelCara1 au JPanel panelGauche, en appliquant la contriante gbc
		
		
		/**
		 * Ajouter l'Image
		 */
		// dimensions : 245*245
		// avantages : evite le décalage des boutons de changement de lieu et la superposition de l'image avec les barres de caractéristiques
		// inconvénients : le Tamagotchi "vole" sur le décor ou le masque
		JLabel imageTama = new JLabel(new ImageIcon(new ImageIcon((new File(ControleurFichier.REP_IMG, ControleurGeneral.TYPE.get(type))).getPath()).getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT)));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.SOUTH;
		panelGauche.add(imageTama, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
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
		gbc.insets = new Insets(0, 0, 0, 0);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.anchor = GridBagConstraints.NORTH;
		panelDroite.add(buildPanelCara2((int) tamagotchi.getVie().getValeur(), (int) tamagotchi.getAge().getValeur()), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1;								// Espace qu'occupe l'objet dans l'axe y entre 0 et 1 de la cellule (1 -> 100%, 0 -> 0%)
		gbc.weightx = 1;								// Même chose mais sur l'axe x
		gbc.insets = new Insets(0, 0, 0, 0);			// Espacement autour du panel en px, respectivement : top, left, bottom, right
		gbc.anchor = GridBagConstraints.SOUTH;
		panelDroite.add(buildPanelCara3(tamagotchi.getCaracteristiques()), gbc);
		
		
		return panelDroite;
	}
	
	/**
	 * Construit le JPanel lieu contenant :
	 * 		- JPanel position
	 * 		- JLabel info
	 * 		- JLabel lieu
	 * 		- JPanel panelBtn
	 * 		- JButton H(haut), G(gauche), B(bas), D(droite)
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
		gbc.insets = new Insets(0, 0, 5, 0);
		panelLieu.add(panelPosition, gbc);
		
		CustomPanel panelBtn = new CustomPanel(new GridBagLayout());
		
		// Choix
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 0, 0);	// Espacement autour du panel en px, respectivement : top, left, bottom, right
		int[][] position = {{1, 1}, {0, 2}, {1, 3}, {2, 2}};
		String[] nom = {"H", "G", "B", "D"};
		for (int i = 0; i < btnLieu.length; i++) {
			CustomBtn btnLieuX = new CustomBtn(nom[i], 8, new Insets(12,15,10,15));
			int n = i;
			btnLieuX.setPreferredSize(dimPanel);
			btnLieuX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					cmdLieu(n);
				}
			});
			gbc.gridx = position[i][0];
			gbc.gridy = position[i][1];
			panelBtn.add(btnLieuX, gbc);
			btnLieu[i] = btnLieuX;
			gbc.gridy++;
		}
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		panelLieu.add(panelBtn, gbc);
		
		
		reinitialiser();
		
		
		return panelLieu;
	}
	
	/**
	 * Construit le JPanel cara1 contenant :
	 * 		- JPanel Lbnom
	 * 		- JPanel Lbtype
	 * 		- JPanel Lbhumeur
	 * 		- JLabel info
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
	 * 		- JLabel vie
	 * 		- JButton pause
	 *  	- JProgressBar barreVie
	 * 		- JLabel age
	 * 		- JLabel action
	 * 
	 * @return JPanel - contenant tout le panel cara2
	 */
	private CustomPanel buildPanelCara2(int ptsVie, int age) {
		CustomPanel panelCara2 = new CustomPanel(new GridBagLayout());
		panelCara2.setOpaque(false);
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
		barreVie.setMinimumSize(barreVie.getPreferredSize());
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
	
	/**
	 * Construit le JPanel caracteristique contenant :
	 * 		- JLabel caracteristique
	 * 		- JProgressBar caracteristique
	 *  	- JButton caracteristique
	 * 
	 * @return JPanel - contenant tout le panel cara2
	 */
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
		barreCaracteristique.setMinimumSize(barreCaracteristique.getPreferredSize());
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
	
	/**
	 * Méthode permettant de modifier les Caractéristiques
	 * d'un Personnage.
	 * 
	 * @param caracteristiques - Ensemble des caractéristiques
	 * @param vie - Caracteristique qui attribut le poucentage 
	 * de vie à un Personnage, elle évolue
	 * @param age - Caractéristique qui attribut un age au 
	 * Personnage, elle évolue
	 */
	public void setAll(Vector<Caracteristique> caracteristiques, Caracteristique vie, Caracteristique age) {
		for (Caracteristique caracteristique: caracteristiques) {
			barres.get(caracteristique.getNom()).setValue((int) caracteristique.getValeur());
		}
		barreVie.setValue((int) vie.getValeur());
		if (vie.getValeur()>50) {
			ControleurGeneral.ctrlAffichage.modifLabel(labelHumeur, "Heureux");
		}else {
			ControleurGeneral.ctrlAffichage.modifLabel(labelHumeur, "Triste");
		}
		labelAge.setText("Age : " + ((int) age.getValeur()));
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	
	/**
	 * Fonction permettant le changement de lieu
	 * 
	 * @param direction - int attribué à la décision d'aller 
	 * dans la pièce de gauche ou la pièce de droite de la pièce courante
	 * 
	 */
	private void cmdLieu(int direction) {
		ControleurGeneral.ctrlJeu.rqtChangeLieu(direction);
	}
	
	
	/**
	 * Fonction appelée lors d'une action sur le Personnage
	 * exemple : prendre une douche, manger etc...
	 * 
	 * @param caracteristique - Caracteristique affectée par l'action
	 */
	private void cmdAction(String caracteristique) {
		ControleurGeneral.ctrlJeu.rqtAction(caracteristique);
		String action = "Restaure : "+caracteristique;
		ControleurGeneral.ctrlAffichage.modifLabel(labelAction, action);
		// désactive les btn après le lancement d'une première action
		btns.forEach((k, v) -> {
			ControleurGeneral.ctrlAffichage.rqtComposantActif(this,v, false);
		});
		// Réactivation des btns avec un timer
		Menu menu = this;
		ControleurGeneral.ctrlTemps.addThreadJeu(ControleurGeneral.TEMPS_LOCK, new Runnable(){
			  @Override
			  public void run() {
					btns.forEach((k, v) -> {
						ControleurGeneral.ctrlAffichage.rqtComposantActif(menu,v, true);
					});
			  }
		});
		ControleurGeneral.ctrlTemps.addThreadJeu(ControleurGeneral.TEMPS_LOCK, new Runnable(){
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
	private void cmdPause() {
		ControleurGeneral.ctrlBouton.rqtPause();
	}
	
	@Override
	public void reinitialiser() {
		Piece localisation = ControleurGeneral.ctrlJeu.getLieu();
		labelLieu.setText(localisation.getNom());
		int[] lsDirection = {Piece.HAUT, Piece.GAUCHE, Piece.BAS, Piece.DROITE};
		for (int direction : lsDirection) {
			if (localisation.existePiece(direction)) {
				btnLieu[direction].setEnabled(true);
			} else {
				btnLieu[direction].setEnabled(false);
			}
		}
		setFond(new File(ControleurFichier.REP_IMG, ControleurGeneral.PIECE.get(localisation.getNom())));
	}
}
