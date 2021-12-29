package vue.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.UUID;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import controleur.ControleurFichier;
import controleur.ControleurGeneral;
import modele.Partie;
import modele.Personnage;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomRadioPanel;
import vue.modele.CustomStyle;

public class SelecPartie extends Menu {
	
	private ButtonGroup grpPanel;
	
	public SelecPartie(HashSet<UUID> ids) {
		super();
		// TODO Auto-generated constructor stub
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		// Panel bouton
		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.setOpaque(false);
	    
	    
		CustomBtn btnSuppr = new CustomBtn("Supprimer");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdSupprimer();
			}
		});
	    btnSuppr.setEnabled(false);
	    gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		buttons.add(btnSuppr,gbc);
		
		
		CustomBtn btnJouer = new CustomBtn("Jouer");
		btnJouer.setEnabled(false);
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
	    gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 30, 0, 30);
		buttons.add(btnJouer,gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Retour");
	    gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		buttons.add(btnRetour,gbc);
		
		
		// Construction du menu		
		CustomLb lbTitre = new CustomLb("Sélectionnez une partie", 15, CustomStyle.BLANC_DEFAUT, CustomStyle.ROSE_ALPHA);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbTitre, gbc);
		
	    
	    // Bouton radio
	    grpPanel = new ButtonGroup();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(15, 0, 0, 10);
		for (UUID elt : ids) {
			CustomRadioPanel panelPartie;
			try {
				final Partie partie = (Partie) (ControleurGeneral.ctrlFichier.chargerObjet(elt + ".save", ControleurFichier.REP_SAUVEGARDE));
				final Personnage tamagotchi = partie.getTamagotchi();
				panelPartie = new CustomRadioPanel(tamagotchi.getNom(), tamagotchi.getType(), (int) tamagotchi.getAge().getValeur(), (int) tamagotchi.getVie().getValeur(), partie.getTriche());
				panelPartie.addActionListener(new ActionListener() {	
					public void actionPerformed(ActionEvent evt) {
						cmdActive(btnJouer, true);
						cmdActive(btnSuppr, true);
					}
				});
			} catch (Exception err) {
				ControleurGeneral.ctrlFichier.addLogs("Erreur - échec de lecture du fcihier " + elt.toString() + ".save", true);
				ControleurGeneral.ctrlFichier.addLogs(err.toString(), true);
				panelPartie = new CustomRadioPanel("Sauvegarde corrompue", true);
				panelPartie.addActionListener(new ActionListener() {	
					public void actionPerformed(ActionEvent evt) {
						cmdActive(btnJouer, false);
						cmdActive(btnSuppr, true);
					}
				});
			}
			panelPartie.setActionCommand(elt.toString());
			add(panelPartie, gbc);
			grpPanel.add(panelPartie);
			if(gbc.gridx == 1) {
				gbc.gridy++;
				gbc.gridx--;
				gbc.insets = new Insets(15, 0, 0, 10);
			} else {
				gbc.gridx++;
				gbc.insets = new Insets(15, 10, 0, 0);
			}
		}
		for (int i = 0; i < ControleurGeneral.NB_MAX_PARTIE-ids.size(); i++) {
			CustomRadioPanel panelPartie = new CustomRadioPanel("Emplacement de sauvegarde libre", false);
			panelPartie.setEnabled(false);
			add(panelPartie, gbc);
			if(gbc.gridx == 1) {
				gbc.gridy++;
				gbc.gridx--;
				gbc.insets = new Insets(15, 0, 0, 10);
			} else {
				gbc.gridx++;
				gbc.insets = new Insets(15, 10, 0, 0);
			}
		}
		

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(30, 0, 0, 0);
	    add(buttons,gbc);
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
	
	public void cmdSupprimer() {
		ControleurGeneral.ctrlJeu.rqtSupprimerPartie(grpPanel.getSelection().getActionCommand());
	}
	
	public void cmdActive(CustomBtn btn, boolean activite) {
		ControleurGeneral.ctrlAffichage.rqtComposantActif(this, btn, activite);
	}

}