package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controleur.ControleurGeneral;

public class Politique extends Menu {

	public Politique(ControleurGeneral controleur) {
		super(controleur);
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel lbPolitiqueTitre = new JLabel("POLITIQUE DE CONFIDENTIALITÉ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 30, 0);
		add(lbPolitiqueTitre, gbc);
		
		
		String[] titreSecondaire = {
			"1. Confidentialité et Protection des Données",
			"2. Vos droits concernant le traitement de vos données",
			"3. Stockage et Protection des données"
		};
		String[] texte = {
			"Nous respectons votre vie privée et nous nous engageons à protéger la vie privée de ces\n"
			+ "personnes («utilisateur(s)» ou «vous») qui accèdent et utilisent notre application.\n"
			+ " \n"
			+ "Dans toutes nos opérations, nous protégeons les données au plus haut niveau et les traitons\n"
			+ "de manière confidentielle. Pour assurer cette confidentialité, nous utilisons des technologies\n"
			+ "appropriées ainsi que des solutions de sécurité des données à caractère personnel en conjonction\n"
			+ "avec des mesures administratives spécifiques.\n",
			"Vous avez le droit d’agir sur le traitement de vos propres données.\n",
			"Vos données tel que votre adresse mail et votre mot de passe sont enregistré dans un fichier encodé,\n"
			+ "c'est-à-dire qu'aucune personne est capable de lire et de comprendre ces informations dans un\n"
			+ "langage humain sans pré-traitement.\n"
			+ " \n"
			+ "Ces mêmes informations sont elles même encodé de manière irréversible, il faut comprendre que ces\n"
			+ "informations ne sont pas utilisable, seul une trace numérique partielle est gardée pour comparer\n"
			+ "les champs de texte des formulaires que les utilisateurs peuvent être amener à remplir pour se\n"
			+ "connecter ou récuper son mot de passe.\n"
		};
		int i = 0;
		for (String ligneTitreSecondaire : titreSecondaire) {
			JLabel lbTitreSecondaire = new JLabel(ligneTitreSecondaire);
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc.insets = new Insets(15, 0, 15, 0);
			add(lbTitreSecondaire, gbc);
			for (String ligneTexte : texte[i].split("\n")) {
				JLabel lbTexte= new JLabel(ligneTexte);
				gbc.gridx = 0;
				gbc.gridy++;
				gbc.gridwidth = 1;
				gbc.anchor = GridBagConstraints.BASELINE_LEADING;
				gbc.insets = new Insets(0, 0, 0, 0);
				add(lbTexte, gbc);
			}
			i++;
		}
			
		
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
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(30, 0, 0, 0);
		add(btnRetour, gbc);
	}
	
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * 
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}

}
