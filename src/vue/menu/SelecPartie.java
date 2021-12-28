package vue.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.UUID;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleurFichier;
import controleur.ControleurGeneral;
import modele.Partie;
import modele.Personnage;
import vue.modele.CustomRadioBtn;
import vue.modele.CustomRadioPanel;

public class SelecPartie extends Menu {
	private ButtonGroup grpPanel;
	
	public SelecPartie(HashSet<UUID> ids) {
		super();
		// TODO Auto-generated constructor stub
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
				
		JLabel lbCredits = new JLabel("Choisissez votre partie : ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbCredits, gbc);
		
	    
	    // Bouton radio
	    grpPanel = new ButtonGroup();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(15, 10, 0, 0);
		for (UUID elt : ids) {
			try {
				Personnage tamagotchi = ((Partie) ControleurGeneral.ctrlFichier.chargerObjet(elt + ".save", ControleurFichier.REP_SAUVEGARDE)).getTamagotchi();
				CustomRadioPanel panelPartie = new CustomRadioPanel("Partie 1", tamagotchi.getNom(), tamagotchi.getType(), (int) tamagotchi.getAge().getValeur(), (int) tamagotchi.getVie().getValeur());
				panelPartie.setActionCommand(elt.toString());
				add(panelPartie, gbc);
				grpPanel.add(panelPartie);
				gbc.gridy++;
			} catch (Exception err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de lecture du fcihier " + elt.toString() + ".save", true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
			}
		}
	    /*
	    JRadioButton choix1 = new JRadioButton();
	    choix1.setActionCommand("");
	    gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix1, gbc);
		
		JRadioButton choix2 = new JRadioButton();
	    gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix2, gbc);
		
		JRadioButton choix3 = new JRadioButton();
	    gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix3, gbc);
		*/
		JPanel buttons = new JPanel();
		gbc.gridy++;
	    add(buttons,gbc);
	    JButton btnsupprimer = new JButton("Supprimer la partie");
		gbc.gridx = 0;
		gbc.gridy++;
		buttons.add(btnsupprimer,gbc);
		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		gbc.gridx = 1;
		gbc.gridy++;
		buttons.add(btnJouer,gbc);
		
		JButton btnRetour = new JButton("Retour");
		gbc.gridx = 1;
		gbc.gridy++;
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		buttons.add(btnRetour,gbc);
		/*
		grpPanel = new ButtonGroup();
		grpPanel.add(choix1);
		grpPanel.add(choix2);
		grpPanel.add(choix3);
		*/
		
		
		
		
		
	    
	    
		
		
		
		/*JButton Partie1 = new JButton("Partie 1");
		Partie1.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie1, gbc);
		
		JButton Partie2 = new JButton("Partie 2");
		Partie2.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie2, gbc);
		
		JButton Partie3 = new JButton("Partie 3");
		Partie3.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie3, gbc);
		
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		btnContinuer.setPreferredSize(new Dimension(110,25));
		btnContinuer.setVisible(false);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(btnContinuer, gbc);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		btnRetour.setPreferredSize(new Dimension(110,25));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(btnRetour, gbc);
		*/
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////

	public void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
	
	public void cmdJouer() {
		ControleurGeneral.ctrlJeu.lancePartie(grpPanel.getSelection().getActionCommand());
	}
	
	public void cmdChoixPartie() {
		
	}

}