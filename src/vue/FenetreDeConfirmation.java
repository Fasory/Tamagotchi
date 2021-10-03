package vue;

import javax.swing.JFrame;

import controleur.Controleur;

public class FenetreDeConfirmation extends JFrame {
	
	private Controleur controleur;
	
	public FenetreDeConfirmation(Controleur controleur) {
		super();
		
		this.controleur = controleur;
		
		setTitle("Confirmation");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
