package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurGeneral;
import vue.modole.CustomBtn;

public class Inscription extends Menu {
	
	// Autres attributs
	private JTextField txtId;
	private JTextField txtMail;
	private JPasswordField txtMdp;
	private JPasswordField txtMdpConfirme;
	private JCheckBox cbVerifMail;
	private JCheckBox cbPolitique;
	private JLabel lbCbPolitique_2;
	private CustomBtn btnInscription;
	
	/**
	 * Constructeur
	 */
	public Inscription() { 
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		// CheckBox Mail
		JPanel checkBoxMail = new JPanel(new GridBagLayout());
		checkBoxMail.setOpaque(false);
		
		
		cbVerifMail = new JCheckBox();
		cbVerifMail.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxMail.add(cbVerifMail, gbc);
		
		
		JLabel lbCbMail = new JLabel("Ne pas vérifier l'adresse e-mail.");
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxMail.add(lbCbMail, gbc);
		
		
		// CheckBox Politique de Confidentialité
		JPanel checkBoxPolitique = new JPanel(new GridBagLayout());
		checkBoxPolitique.setOpaque(false);
		
		
		cbPolitique = new JCheckBox();
		cbPolitique.setOpaque(false);
		cbPolitique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdPolitique();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxPolitique.add(cbPolitique, gbc);
		
		
		JLabel lbCbPolitique_1 = new JLabel("J'ai lu et j'accepte la ");
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxPolitique.add(lbCbPolitique_1, gbc);
		
		
		lbCbPolitique_2 = new JLabel("politique de confidentialité");
		lbCbPolitique_2.setForeground(COULEUR_EN_NON_SELEC);
		lbCbPolitique_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	cmdVoirPolitique();
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	cmdSurvolePolitique("hand", COULEUR_EN_SELEC);
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	cmdSurvolePolitique("default", COULEUR_EN_NON_SELEC);
		    }
		});
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxPolitique.add(lbCbPolitique_2, gbc);
		
		
		JLabel lbCbPolitique_3 = new JLabel(".");
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		checkBoxPolitique.add(lbCbPolitique_3, gbc);
		
		
		// Formulaire ID / Mail / MDP / Confirmation MDP
		JPanel formulaire = new JPanel(new GridBagLayout());
		formulaire.setOpaque(false);
		
		
		JLabel lbId = new JLabel("Identifiant");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 3, 0);
		formulaire.add(lbId, gbc);
		
		
		JLabel lbMail = new JLabel("Adresse e-mail");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 3, 0);
		formulaire.add(lbMail, gbc);
		
		
		txtId = new JTextField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 20);
		formulaire.add(txtId, gbc);
		
		
		txtMail = new JTextField();
		txtMail.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMail, gbc);
		
		
		JLabel lbAlerteId = new JLabel(" ");
		lbAlerteId.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 0);
		lsAlerte.put("id", lbAlerteId);
		formulaire.add(lbAlerteId, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(checkBoxMail, gbc);
		
		
		JLabel lbAlerteMail = new JLabel(" ");
		lbAlerteMail.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 0);
		lsAlerte.put("mail", lbAlerteMail);
		formulaire.add(lbAlerteMail, gbc);
		
		
		JLabel lbMdp = new JLabel("Mot de passe");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 3, 0);
		formulaire.add(lbMdp, gbc);
		
		
		JLabel lbMdpConfirme = new JLabel("Confirmez le mot de passe");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 3, 0);
		formulaire.add(lbMdpConfirme, gbc);
		
		
		txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 20);
		formulaire.add(txtMdp, gbc);
		
		
		txtMdpConfirme = new JPasswordField();
		txtMdpConfirme.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdpConfirme, gbc);
		
		
		JLabel lbAlerteMdp = new JLabel(" ");
		lbAlerteMdp.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 0);
		lsAlerte.put("mdp", lbAlerteMdp);
		formulaire.add(lbAlerteMdp, gbc);
		
		
		JLabel lbAlerteMdpConfirme = new JLabel(" ");
		lbAlerteMdpConfirme.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 0);
		lsAlerte.put("mdpConfirme", lbAlerteMdpConfirme);
		formulaire.add(lbAlerteMdpConfirme, gbc);
		
		// Construction du menu
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 0, 0, 0);
		add(formulaire, gbc);
		
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(checkBoxPolitique, gbc);
		
		JPanel button = new JPanel(new GridBagLayout());
		button.setOpaque(false);
		
		btnInscription = new CustomBtn("S'inscrire");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdInscrire();
			}
		});
		btnInscription.setEnabled(cbPolitique.isSelected());
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		button.add(btnInscription, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Annuler");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		button.add(btnRetour, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(button,gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande d'affichage de la politique de confidentialité
	 */
	private void cmdVoirPolitique() {
		ControleurGeneral.ctrlBouton.rqtAffichagePolitique();
	}
	
	/**
	 * Demande d'ouvrir la fenêtre d'inscription
	 */
	private void cmdInscrire() {
		ControleurGeneral.ctrlBouton.rqtTentativeInscription(txtId.getText(), txtMail.getText(), txtMdp.getPassword(), txtMdpConfirme.getPassword(), !cbVerifMail.isSelected());
	}
	
	/**
	 * Demande de retour au menu précédent
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
	
	/**
	 * Demande d'acceptation de la politique de confidentialisté
	 */
	private void cmdPolitique() {
		ControleurGeneral.ctrlAffichage.rqtComposantActif(this, btnInscription, cbPolitique.isSelected());
	}
	
	/**
	 * Demande de changement de la couleur d'un texte à son survole
	 * 
	 * @param type - Chaine de caractère à laquelle appliquer le changement de couleur
	 * @param couleur - Couleur choisie pour le changement de couleur
	 */
	private void cmdSurvolePolitique(String type, Color couleur) {
		ControleurGeneral.ctrlAffichage.rqtChangeCurseur(type);
		ControleurGeneral.ctrlAffichage.rqtChangeCouleurLabel(this, lbCbPolitique_2, couleur);
	}
	
	
	////////////////////////////////////////
	//            METHODES DU             //
	//         CONTROLEUR GENERAL         //
	////////////////////////////////////////
	
	/**
	 * Réinitialise l'affichage de la fenêtre
	 */
	@Override
	public void renitialiser() {
		ControleurGeneral.ctrlAffichage.afficherAlerte("id", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mail", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mdp", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mdpConfirme", " ");
		lbCbPolitique_2.setForeground(COULEUR_EN_NON_SELEC);
	}
}
