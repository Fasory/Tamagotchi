package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

public class Connexion extends Menu {
	
	// Autres attributs
	private JLabel lbOublieMdp;
	private JTextField txtId;
	private JPasswordField txtMdp;
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * @param controleur - Controleur de l'application		<br/>
	 */
	public Connexion() {
		super();
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Formulaire ID / Mail
		JPanel formulaire = new JPanel(new GridBagLayout());
		
		
		JLabel lbId = new JLabel("Identifiant");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 10);
		formulaire.add(lbId, gbc);
		
		
		JLabel lbMdp = new JLabel("Mot de passe");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 5, 10);
		formulaire.add(lbMdp, gbc);
		
		
		txtId = new JTextField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtId, gbc);
		
		
		txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMdp, gbc);
		
		
		lbOublieMdp = new JLabel("Mot de passe oublié ?");
		lbOublieMdp.setForeground(COULEUR_EN_NON_SELEC);
		lbOublieMdp.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	cmdMdpOublier();
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        cmdSurvoleMdp("hand", COULEUR_EN_SELEC);
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	cmdSurvoleMdp("default", COULEUR_EN_NON_SELEC);
		    }
		});
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(lbOublieMdp, gbc);
		
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdConnexion();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		formulaire.add(btnConnexion, gbc);
		
		
		JLabel lbOu = new JLabel("OU");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 0, 0, 0);
		formulaire.add(lbOu, gbc);
		
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdInscription();
			}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(5, 0, 0, 0);
		formulaire.add(btnInscription, gbc);
		
		// Construction du menu
		JLabel lbInfo_p1 = new JLabel("Veuillez entrer votre identifiant et votre mot de passe pour vous connecter.");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p1, gbc);
		
		
		JLabel lbInfo_p2 = new JLabel("Si vous n'avez encore pas de compte, vous pouvez également vous inscrire.");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p2, gbc);
		
		
		JLabel lbAlerte = new JLabel(" ");
		lbAlerte.setForeground(COULEUR_ALERTE);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 0, 0, 0);
		lsAlerte.put("general", lbAlerte);
		add(lbAlerte, gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 0, 0, 0);
		add(formulaire, gbc);
		
		
		JSeparator sepAnonyme = new JSeparator();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 30, 25, 30);
		add(sepAnonyme, gbc);
		
		// Construction du menu
		JLabel lbInfoAnonyme_p1 = new JLabel("Jouer en connexion anonyme permet de créer et de jouer à des parties sans");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfoAnonyme_p1, gbc);
		
		
		JLabel lbInfoAnonyme_p2 = new JLabel("utiliser un compte. Cela veut également dire que toutes les parties sont visibles");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfoAnonyme_p2, gbc);
		
		
		JLabel lbInfoAnonyme_p3 = new JLabel("et accessibles par les autres utilisateurs en connexion anonyme.");
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfoAnonyme_p3, gbc);
		
		
		JButton btnConnexionAnonyme = new JButton("Connexion anonyme");
		btnConnexionAnonyme.setPreferredSize(new Dimension(formulaire.getPreferredSize().width, 25));
		btnConnexionAnonyme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdConnexionAnonyme();
			}
		});
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(btnConnexionAnonyme, gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande à changer le comportement du texte lbOublieMdp	<br/>
	 * 															<br/>
	 * @param type - String qui représente le type de curseur	<br/>
	 * à changer												<br/>
	 */
	private void cmdSurvoleMdp(String type, Color couleur) {
		ControleurGeneral.ctrlAffichage.rqtChangeCurseur(type);
		ControleurGeneral.ctrlAffichage.rqtChangeCouleurLabel(this, lbOublieMdp, couleur);
	}
	
	/**
	 * Demande de changement de mot de passe suite à un oublie	<br/>
	 */
	private void cmdMdpOublier() {
		ControleurGeneral.ctrlBouton.rqtOublieDeMdp();
	}
	
	/**
	 * Demande l'ouverture d'une session à partir d'un identifiant et d'un mot de passe
	 */
	private void cmdConnexion() {
		ControleurGeneral.ctrlBouton.rqtConnexion(txtId.getText(), txtMdp.getPassword());
	}
	
	/**
	 * Demande l'ouverture d'une session anonyme
	 */
	private void cmdConnexionAnonyme() {
		ControleurGeneral.ctrlBouton.rqtConnexion("Anonyme", new char[0]);
	}
	
	/**
	 * Demande d'insciprtion
	 */
	private void cmdInscription() {
		ControleurGeneral.ctrlBouton.rqtInscription();
	}
	
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	/**
	 * Getteur													<br/>
	 * 															<br/>
	 * @return Color - couleur du texte d'oublie de mot			<br/>
	 * de passe													<br/>
	 */
	public Color getCouleurTxtOublieMdp() {
		return lbOublieMdp.getForeground();
	}
	
	/**
	 * Setteur													<br/>
	 * 															<br/>
	 * @param couleur - Color à affecter au texte d'oublie de	<br/>
	 * mot de passe												<br/>
	 */
	public void setCouleurTxtOublieMdp(Color couleur) {
		lbOublieMdp.setForeground(couleur);
	}
	
	
	////////////////////////////////////////
	//          METHODES INTERNES         //
	////////////////////////////////////////
	
	@Override
	public void renitialiser() {
		lbOublieMdp.setForeground(COULEUR_EN_NON_SELEC);
		ControleurGeneral.ctrlAffichage.rqtChangeCurseur("default");
		txtId.setText("");
		txtMdp.setText("");
		ControleurGeneral.ctrlAffichage.afficherAlerte("general", " ");
	}
}
