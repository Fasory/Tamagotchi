package vue;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;

public class MenuDeConfirmation  extends JPanel {
	
	private Controleur controleur;
	
	/**
	 * Constructeur 
	 * 
	 * @param controleur
	 */
	public MenuDeConfirmation(Controleur controleur) {
		super();
		
		this.controleur = controleur;
		
		// Partie Affichage
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);
		
		
		JLabel indication = new JLabel("Êtes-vous sûr de vouloir fermer l'application ?");
		add(indication);
		
		
		JPanel panelBtn = new JPanel(new GridLayout(1, 2, 40, 0)) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(200, 350);
			}
		};
		
		
		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdFermer(true);
			}
		});
		panelBtn.add(btnOui);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdFermer(false);
			}
		});
		panelBtn.add(btnAnnuler);
		
		
		GridBagConstraints gridBagC = new GridBagConstraints();
		gridBagC.gridx = 1;
		gridBagC.insets = new Insets(20,0,30,0);  //top padding
		gridBag.setConstraints(indication, gridBagC);
		gridBag.setConstraints(panelBtn, gridBagC);
		
		
		add(panelBtn);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/*
	 * Demande de fermeture de l'application après confirmation
	 */
	public void cmdFermer(boolean confirmation) {
		controleur.rqtFermer(confirmation);
	}
	
}
