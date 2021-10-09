package vue;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		setLayout(new GridBagLayout());
		
		JPanel panelBtn = new JPanel(new GridLayout(2, 2, 10, 40)) {
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
