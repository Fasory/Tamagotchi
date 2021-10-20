package fenetre;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;

public class FenetreDeConfirmation extends Fenetre {
	
	public FenetreDeConfirmation(Controleur controleur, JPanel menuCourant) {
		super(controleur);
		
		this.controleur = controleur;
		
		setTitle("Confirmation");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(menuCourant);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
		    public void windowClosing(WindowEvent evt) {
				controleur.rqtRetourDeConfirmation(false);
		   }
		});
	}
	
	
}
