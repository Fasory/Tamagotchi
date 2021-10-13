package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import controleur.Controleur;

public class FenetrePrincipale extends JFrame {
	
	private JPanel panelCourant;
	private Controleur controleur;
	
	
	/**
	 * Constructeur
	 * 
	 * Initialisation de la fenêtre principale
	 * 
	 * @param controleur
	 */
	public FenetrePrincipale(Controleur controleur, JPanel panelCourant) {
		super();
		
		this.controleur = controleur;
		this.panelCourant = panelCourant;
		
		setTitle("Tamagotchi");
		setSize(1024,640);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
		    public void windowClosing(WindowEvent evt) {
		    	controleur.rqtQuitter();
		   }
		});

		// On définie la vue courante sur la quelle on veut qu'on arrive au lancement
		setContentPane(this.panelCourant);
		setVisible(true);
	}
	
	
	public void setActivite(boolean enActivite) {
		setEnabled(enActivite);
	}
	
}
