package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

public class OublieDeMdp extends Menu {

	/**
	 * Controleur										<br/>
	 * 													<br/>
	 * @param controleur- Contoleur de l'application	<br/>	
	 */
	public OublieDeMdp(ControleurGeneral controleur) {
		super(controleur);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel lbInfo = new JLabel("Entrez votre identifiant et votre adresse mailpour changer de mot de passe.");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbInfo, gbc);
		
		
		JLabel lbId = new JLabel("Identifiant :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbId, gbc);
		
		
		JLabel lbMdp = new JLabel("Adresse Mail :");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 30);
		add(lbMdp, gbc);
		
		
		JTextField txtId = new JTextField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtId, gbc);
		
		
		JPasswordField txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtMdp, gbc);
		
		
	}
}
