package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;

public class FenetrePrincipale extends JFrame {
	
	JPanel panelCourant;
	Controleur controleur;
	
	
	/**
	 * Constructeur
	 * 
	 * Initialisation de la fenêtre principale
	 * 
	 * @param controleur
	 */
	public FenetrePrincipale(Controleur controleur) {
		super();
		
		this.controleur = controleur;
		
		setTitle("Tamagotchi");
		setSize(1024,640);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// On définie la vue courante sur la quelel on veut qu'on arrive au lancement
		panelCourant = new MenuPrincipal(controleur);
		setContentPane(panelCourant);
	}

}
