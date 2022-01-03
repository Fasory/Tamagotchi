package vue.menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import controleur.ControleurGeneral;
import vue.modele.CustomBtn;
import vue.modele.CustomStyle;

/**
 * La classe Politique gère le menu "Politique", 
 * menu accessible après le menu "Inscription",
 * lorsqu'on clique sur "Politique de confidentialité"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class Politique extends Menu {
	
	/**
	 * Constructeur
	 */
	public Politique() {
		// Appel au constructeur de la super classe Menu
		super();
		
		// Constantes utiles à la construction du Panel
		final SimpleAttributeSet STYLE_NORMAL = CustomStyle.getStyleNormal();
		final SimpleAttributeSet STYLE_TITRE = CustomStyle.getStyleTitre();
		final SimpleAttributeSet STYLE_SOUSTITRE = CustomStyle.getStyleSousTritre();
		final SimpleAttributeSet STYLE_CENTRER = CustomStyle.getStyleCentrer();
		final String titre = "POLITIQUE DE CONFIDENTIALITÉ\n";
		final String[] titreSecondaire = {
				"\n1. Confidentialité et Protection des Données\n",
				"\n2. Vos droits concernant le traitement de vos données\n",
				"\n\t2.1. Droit d’accès et le droit de portabilité des données\n",
				"\n\t2.2. Droit à l’effacement\n",
				"\n\t2.3. Droit à la limitation du traitement\n",
				"\n3. Stockage et Protection des données\n",
				"\n4. Quelles sont les données que nous collectons ?\n"
		};
		final String[] contenu = {
				// 1.
				"\n\tNous respectons votre vie privée et nous nous engageons à protéger la vie privée de ces "
				+ "personnes («utilisateur(s)» ou «vous») qui accèdent et utilisent notre application.\n"
				+ "\n"
				+ "\tDans toutes nos opérations, nous protégeons les données au plus haut niveau et les traitons "
				+ "de manière confidentielle. Pour assurer cette confidentialité, nous utilisons des technologies "
				+ "appropriées ainsi que des solutions de sécurité des données à caractère personnel en conjonction "
				+ "avec des mesures administratives spécifiques.\n",
				// 2.
				"\n\tVous avez le droit d’agir sur le traitement de vos propres données.\n",
				// 2.1.
				"\n\tVous pouvez vérifier vos propres données ou recevoir les données que vous avez vous-même fournies "
				+ "lors de l’utilisation de notre application sous une forme lisible par machine. Pour ce faire, contactez"
				+ "-nous à l'adresse : bidault.e2001298@etud.univ-ubs.fr .\n",
				// 2.2.
				"\n\tVous avez le droit de demander la suppression des données qui ne sont plus nécessaires. Nous faisons "
				+ "de notre mieux pour supprimer ces données automatiquement, mais si, pour une raison ou une autre, vous "
				+ "détectez des informations inutiles dans notre système, vous pouvez nous contacter à l'adresse : "
				+ "bidault.e2001298@etud.univ-ubs.fr .\n",
				// 2.3.
				"\n\tVous pouvez nous demander de restreindre ou de refuser le traitement de données dans certaines "
				+ "situations. Nous avons cherché à décrire toutes nos méthodes de traitement de données de manière ouverte "
				+ "et compréhensible dans cette politique de confidentialité.\n",
				// 3.
				"\n\tVos données tel que votre adresse mail et votre mot de passe sont enregistré dans un fichier encodé, "
				+ "c'est-à-dire qu'aucune personne est capable de lire et de comprendre ces informations dans un "
				+ "langage humain sans pré-traitement.\n"
				+ "\n"
				+ "\tCes mêmes informations sont elles même encodé de manière irréversible, il faut comprendre que ces "
				+ "informations ne sont pas utilisable, seul une trace numérique partielle est gardée pour comparer "
				+ "les champs de texte des formulaires que les utilisateurs peuvent être amener à remplir pour se "
				+ "connecter ou récuper son mot de passe.\n",
				// 4.
				"\n\tAfin que les utilisateurs puissent bénificier d'une meilleure expérience, nous avons besoin d’informations "
				+ "personnelles suffisantes. Nous avons besoin de vos coordonnées pour communiquer avec vous, comme par exemple "
				+ "pour vous permettre de réinitialiser votre mot de passe si vous l’oubliez.\n"
				+ "\n"
				+ "\tEn raison de la nature de notre application, le traitement des données à caractère personnel est une partie "
				+ "essentielle et indissociable de notre application, même si dans l'application même, nous ne traitons pas votre "
				+ "adresse mail ou toute autre information qui vous identifie directement en tant que personne.\n"
		};
		
		// Partie Affichage
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		// Construction du texte
		JTextPane texte = new JTextPane();
		texte.setEditable(false);
		try {
			// Ajout du texte
			StyledDocument doc = texte.getStyledDocument();
			doc.insertString(doc.getLength(), titre, STYLE_TITRE);
			for (int i = 0; i < titreSecondaire.length && i < contenu.length; i++) {
				doc.insertString(doc.getLength(), titreSecondaire[i], STYLE_SOUSTITRE);
				doc.insertString(doc.getLength(), contenu[i], STYLE_NORMAL);
			}
			
			// Centrage du titre
			doc.setParagraphAttributes(0, titre.length(), STYLE_CENTRER, false);
		} catch (BadLocationException err) {
			ControleurGeneral.ctrlFichier.addLogs("Erreur	-	échec de l'affichage de la politique de confidentialité", true);
		}
		
		
		// Panel contenant la zone de texte
		JScrollPane panelPolitique = new JScrollPane(texte);
		panelPolitique.setPreferredSize(new Dimension(750, 450));
		SwingUtilities.invokeLater(new Runnable() {					// Permet de position tout en haut du JScrollPane à sa après construction
		   public void run() { 
			   panelPolitique.getVerticalScrollBar().setValue(0);
		   }
		});
			
		
		// Création du menu
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(panelPolitique, gbc);
		
		
		CustomBtn btnRetour = new CustomBtn("Retour");
		lsCustomBtn.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cmdRetour();
			}
		});
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
	 * Demande de retour au menu précédent
	 */
	private void cmdRetour() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}

}
