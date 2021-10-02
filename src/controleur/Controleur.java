package controleur;

import vue.FenetrePrincipale;

public class Controleur {

	FenetrePrincipale fenetre;

	/**
	 * Racine de l'application Tamagotchi
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Controleur();
	}
	
	
	/**
	 * Constructeur
	 * 
	 * Initialisation de l'application
	 */
	public Controleur() {
		fenetre = new FenetrePrincipale(this);
		fenetre.setVisible(true);
	}

}
