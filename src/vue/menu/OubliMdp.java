package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

public class OubliMdp extends Menu {
	
	private JTextField txtId;
	private JTextField txtMail;
	private JLabel lbInfoConfirmation;

	/**
	 * Constructeur										<br/>
	 * 													<br/>
	 * @param controleur- Controleur de l'application	<br/>	
	 */
	public OubliMdp() {
		super();
		
		// Partie Affichage
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		// Formulaire ID / Mail
		JPanel formulaire = new JPanel(new GridBagLayout());
		
		
		JLabel lbId = new JLabel("Identifiant");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 10, 10);
		formulaire.add(lbId, gbc);
		
		
		txtId = new JTextField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtId, gbc);
		
		
		JLabel lbMail = new JLabel("Adresse Mail");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 5, 10);
		formulaire.add(lbMail, gbc);
		
		
		txtMail = new JTextField();
		txtMail.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		formulaire.add(txtMail, gbc);
		
		// Construction du menu
		JLabel lbInfo_p1 = new JLabel("Veuillez entrer votre identifiant et votre adresse mail afin de réinitialiser");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p1, gbc);	
		
		
		JLabel lbInfo_p2 = new JLabel("votre mot de passe.");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfo_p2, gbc);
		
		
		JLabel lbConsigne_p1 = new JLabel("Une fois la demande effectuée, entrez le code qui vous a été envoyé");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(lbConsigne_p1, gbc);
		
		
		JLabel lbConsigne_p2 = new JLabel("par e-mail pour modifier votre mot de passe.");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbConsigne_p2, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(25, 0, 5, 0);
		add(formulaire, gbc);
		
		
		lbInfoConfirmation = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbInfoConfirmation, gbc);
		
		
		JButton btnRenitialisation = new JButton("Réinitialiser");
		btnRenitialisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRenitialisation();
			}
		});
		btnRenitialisation.setPreferredSize(new Dimension(110,25));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(btnRenitialisation, gbc);
		
		
		JButton btnRetour = new JButton("Annuler");
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
	private void cmdRenitialisation() {
		
	}
	
	/**
	 * 
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}

}
