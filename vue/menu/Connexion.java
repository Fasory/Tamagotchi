package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurGeneral;

public class Connexion extends Menu {
	
	// Constantes publics
	public final Color couleurEnSelec;
	public final Color couleurEnNonSelec;
	// Autres attributs
	private JLabel lbOublieMdp;
	
	/**
	 * Constructeur											<br/>
	 * 														<br/>
	 * @param controleur - Controleur de l'application		<br/>
	 */
	public Connexion(ControleurGeneral controleur) {
		super(controleur);
		
		// Initialisation des attributs
		couleurEnSelec = Color.RED;
		couleurEnNonSelec = Color.BLUE;
		
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
		
		
		lbOublieMdp = new JLabel("Mot de passe oublié ?");
		lbOublieMdp.setForeground(couleurEnNonSelec);
		lbOublieMdp.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	cmdMdpOublier();
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        cmdChangeCurseur("hand");
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	cmdChangeCurseur("default");
		    }
		});
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lbOublieMdp, gbc);
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande à changer le comportement du texte lbOublieMdp	<br/>
	 * 															<br/>
	 * @param type - String qui représente le type de curseur	<br/>
	 * à changer												<br/>
	 */
	public void cmdChangeCurseur(String type) {
		controleur.rqtChangeCurseur(type);
		controleur.rqtCouleurOublieMdp(this);
	}
	
	/**
	 * Demande de changement de mot de passe suite à un oublie	<br/>
	 */
	public void cmdMdpOublier() {
		controleur.ctrlDeBouton.rqtOublieDeMdp();
	}
	
	////////////////////////////////////////
	//         GETTEURS ET SETTEURS       //     
	////////////////////////////////////////
	
	/**
	 * Getteur													<br/>
	 * 															<br/>
	 * @return Color - couleur du texte d'oublie de mot			<br/>
	 * de passe													<br/>
	 */
	public Color getCouleurTxtOublieMdp() {
		return lbOublieMdp.getForeground();
	}
	
	/**
	 * Setteur													<br/>
	 * 															<br/>
	 * @param couleur - Color à affecter au texte d'oublie de	<br/>
	 * mot de passe												<br/>
	 */
	public void setCouleurTxtOublieMdp(Color couleur) {
		lbOublieMdp.setForeground(couleur);
	}
	
}
