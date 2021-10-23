package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Controleur;

public class Connexion extends Menu {

	public Connexion(Controleur controleur) {
		super(controleur);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel lbId = new JLabel("Identifiant :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbId, gbc);
		
		
		JLabel lbMdp = new JLabel("Mot de passe :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 5, 30);
		add(lbMdp, gbc);
		
		
		JTextField txtId = new JTextField();
		txtId.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtId, gbc);
		
		
		JPasswordField txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(200, 25));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(txtMdp, gbc);
		
		
		JLabel lbOublieMdp = new JLabel("Mot de passe oublié ?");
		lbOublieMdp.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // the mouse has entered the label
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // the mouse has exited the label
		    }
		});
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbOublieMdp, gbc);
	}

}
