package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

public class Inscription extends Menu {
	
	// Autres attributs
	private JTextField txtId;
	private JTextField txtMail;
	private JPasswordField txtMdp;
	private JPasswordField txtMdpConfirme;
	
	
	public Inscription(ControleurGeneral controleur) {
		super(controleur);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Formulaire ID / Mail / MDP / Confirmation MDP
		JPanel formulaire = new JPanel(new GridBagLayout());
		
		
		JLabel lbId = new JLabel("Identifiant");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 3, 0);
		formulaire.add(lbId, gbc);
		
		
		JLabel lbMail = new JLabel("Adresse mail");
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
		
		
		JLabel lbAlerteMail = new JLabel(" ");
		lbAlerteMail.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
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
		
		
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdInscrire();
			}
		});
		btnInscription.setPreferredSize(new Dimension(110,25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(btnInscription, gbc);
		
		
		JButton btnRetour = new JButton("Annuler");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		btnRetour.setPreferredSize(new Dimension(110,25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(btnRetour, gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * 
	 */
	public void cmdInscrire() {
		ControleurGeneral.ctrlBouton.rqtTentativeInscription(txtId.getText(), txtMail.getText(), txtMdp.getPassword(), txtMdpConfirme.getPassword());
	}
	
	/**
	 * 
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
	
	
	////////////////////////////////////////
	//            METHODES DU             //
	//         CONTROLEUR GENERAL         //
	////////////////////////////////////////
	
	@Override
	public void renitialiser() {
		ControleurGeneral.ctrlAffichage.afficherAlerte("id", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mail", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mdp", " ");
		ControleurGeneral.ctrlAffichage.afficherAlerte("mdpConfirme", " ");
	}
	
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	/**
	 * 
	 * @return
	 */
	public String getIdentifiant() {
		return txtId.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMail() {
		return txtMail.getText();
	}

}
