package vue.menu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controleur.ControleurGeneral;

public class Credits extends Menu {
	/**
	 * Constructeur
	 */
	public Credits() {
		super();
		
		// partie affichage
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel lbCredits = new JLabel("Réalisé par :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		lbCredits.setFont(new Font("Calibri", Font.PLAIN, 25));
		gbc.insets = new Insets(0, 0, 30, 30);
		add(lbCredits, gbc);
		
		JLabel lbJA = new JLabel("BIDAULT Julie-Amélie : Chef de projet");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbJA.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbJA, gbc);
		
		JLabel lbclement = new JLabel("BOUQUET Clément : (Architecte logiciel");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbclement.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbclement, gbc);
		
		JLabel lbmatthias = new JLabel("BRZUSTOWSKI Matthias : (Analyste des besoins)");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbmatthias.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbmatthias, gbc);
		
		JLabel lbarthur = new JLabel("CASANOVA Arthur : (Gestionnaire de la qualité/validation)");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbarthur.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbarthur, gbc);
		
		JLabel lbvictor = new JLabel("HAGUET Victor : (Développeur senior)");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbvictor.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 30, 30);
		add(lbvictor, gbc);
		
		JLabel lbmusique = new JLabel("Musique :");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		lbmusique.setFont(new Font("Calibri", Font.PLAIN, 25));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbmusique, gbc);
		
		JLabel lbtitre = new JLabel("Titre : Tender Remains");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbtitre.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbtitre, gbc);
		
		JLabel lbauteur = new JLabel("Auteur : Myuu");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lbauteur.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbauteur, gbc);
		
		JLabel lblicence = new JLabel("Licence : CC BY 3.0");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		lblicence.setFont(new Font("Calibri", Font.PLAIN, 15));
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lblicence, gbc);
		
		JButton btnRetour = new JButton("Quitter les crédits");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetourOptions();
			}
		});
		add(btnRetour, gbc);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Menu option
	 */
	private void cmdRetourOptions() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}

}
