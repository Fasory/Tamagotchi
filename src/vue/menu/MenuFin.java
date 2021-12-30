package vue.menu;

import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomLb;
import vue.modele.CustomStyle;

public class MenuFin extends Menu {
	/**
	 * Constructeur
	 */
	public MenuFin(String type, String nom, int age) {
		super();
		// partie affichage
		setLayout(new GridBagLayout()); // nouvelle grille
		GridBagConstraints gbc = new GridBagConstraints();
		
		//////////////////////////////////////
		//		PANEL FIN DE PARTIE			//
		//////////////////////////////////////
		
		CustomLb lbTitre = new CustomLb ("La partie est terminée",25,new Color(255, 110, 160, 200), CustomStyle.BLANC_DEFAUT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(30, 0, 90, 0);
		add(lbTitre,gbc);
		
		
		CustomLb lbRes = new CustomLb ("Voici tes résultats :",15,new Color(255, 110, 160, 200), CustomStyle.BLANC_DEFAUT);
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(30, 0, 10, 0);
		add(lbRes,gbc);
		
		
		CustomLb lbNom = new CustomLb ("Le " + type + " " + nom + " a vécu " + age + " années. Bravo !" ,15,new Color(255, 110, 160, 200), CustomStyle.BLANC_DEFAUT);
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(30, 0, 30, 0);
		add(lbNom,gbc);
		
		
		CustomBtn btnQuitter = new CustomBtn ("Quitter", 12, new Insets(12,40,12,40));
		lsCustomBtn.add(btnQuitter);
		gbc.gridx = 0;
		gbc.gridy ++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 30);
		btnQuitter.setVisible(true);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdQuitter(3);
			}
		});
		add(btnQuitter,gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	public void cmdQuitter(int retour) {
		ControleurGeneral.ctrlBouton.rqtSauvegarde();
		ControleurGeneral.ctrlBouton.rqtMenuPrincipal(retour);
	}
}
