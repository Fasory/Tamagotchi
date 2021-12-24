package vue.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.ControleurGeneral;

public class SelecPartie extends Menu {
	private ButtonGroup grpPanel;
	
	public SelecPartie() {
		super();
		// TODO Auto-generated constructor stub
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
				
		JLabel lbCredits = new JLabel("Choisissez votre partie : ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(lbCredits, gbc);

	    JPanel partie1 = new JPanel();
	   
	    partie1.setBorder(new TitledBorder("Partie 1"));
	    partie1.setBackground(Color.white);
	    partie1.setSize(420,240);
	    partie1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Partie 1", TitledBorder.CENTER, TitledBorder.TOP));
	    
	    
	    gbc.gridx = 0;
		gbc.gridy++;
	    setVisible(true);
	    add(partie1,gbc);
	    gbc.anchor = GridBagConstraints.BASELINE;
	    
	    JLabel nom = new JLabel("Nom : 'nom'       Age : 'age'");
	    gbc.insets = new Insets(0, 0, 10, 30);
	    partie1.add(nom);
	    
	    JPanel partie2 = new JPanel();
		
	    partie2.setBorder(new TitledBorder("Partie 2"));
	    partie2.setBackground(Color.white);
	    setSize(200,100);
	    
	    gbc.gridx = 0;
		gbc.gridy++;
	    setVisible(true);
	    add(partie2,gbc);
	    gbc.anchor = GridBagConstraints.BASELINE;
	    
	    JLabel nom2 = new JLabel("Nom : 'nom'       Age : 'age'");
	    gbc.insets = new Insets(0, 0, 10, 30);
	    partie2.add(nom2);
	    
	    
	    
	    
	    JPanel partie3 = new JPanel();
		
	    partie3.setBorder(new TitledBorder("Partie 3"));
	    partie3.setBackground(Color.white);
	    setSize(200,100);
	    
	    gbc.gridx = 0;
		gbc.gridy++;
	    setVisible(true);
	    add(partie3,gbc);
	    gbc.anchor = GridBagConstraints.BASELINE;
	    
	    JLabel nom3 = new JLabel("Nom : 'nom'       Age : 'age'");
	    gbc.insets = new Insets(0, 0, 10, 30);
	    partie3.add(nom3);
	    
	    
		
	    
	    JRadioButton choix1 = new JRadioButton();
	    gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix1, gbc);
		
		JRadioButton choix2 = new JRadioButton();
	    gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix2, gbc);
		
		JRadioButton choix3 = new JRadioButton();
	    gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 10, 30);
		choix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdChoixPartie();
			}
		});
		add(choix3, gbc);
		
		JPanel buttons = new JPanel();
	    add(buttons,gbc);
	    JButton btnsupprimer = new JButton("Supprimer la partie");
		gbc.gridx = 0;
		gbc.gridy++;
		buttons.add(btnsupprimer,gbc);
		
		JButton btnJouer = new JButton("Jouer");
		gbc.gridx = 1;
		gbc.gridy++;
		buttons.add(btnJouer,gbc);
		
		JButton btnRetour = new JButton("Retour");
		gbc.gridx = 1;
		gbc.gridy++;
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
		buttons.add(btnRetour,gbc);
		
		grpPanel = new ButtonGroup();
		grpPanel.add(choix1);
		grpPanel.add(choix2);
		grpPanel.add(choix3);
		
		
		
		
		
		
	    
	    
		
		
		
		/*JButton Partie1 = new JButton("Partie 1");
		Partie1.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie1, gbc);
		
		JButton Partie2 = new JButton("Partie 2");
		Partie2.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie2, gbc);
		
		JButton Partie3 = new JButton("Partie 3");
		Partie3.setPreferredSize(new Dimension(360,60));
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(Partie3, gbc);
		
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdJouer();
			}
		});
		btnContinuer.setPreferredSize(new Dimension(110,25));
		btnContinuer.setVisible(false);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 0, 10, 30);
		add(btnContinuer, gbc);
		
		JButton btnRetour = new JButton("Retour");
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
		gbc.insets = new Insets(0, 0, 10, 30);
		add(btnRetour, gbc);
		*/
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////

	public void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
	
	public void cmdJouer() {
		ControleurGeneral.ctrlBouton.rqtRetour();	
	}
	
	public void cmdChoixPartie() {
		
	}

}