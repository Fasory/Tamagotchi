package modele;

import java.util.Hashtable;

public class Robot extends Personnage{
	
	public Robot(String nom) {
		super(nom, "Robot");
	}
	
	/**
	 * Définition des règles de vie
	 * 
	 * @return Hashtable<String, Float> - représentant les valeurs à
	 * affecter pour chacune des caracteristiques sous forme de paires
	 * <Caracteristique, valeur>
	 */
	@Override
	public Hashtable<Caracteristique, Float> reglesVie() {
		// Initialisation de la liste des règles à appliquer
		Hashtable<Caracteristique, Float> nouvellesCaracteristiques = new Hashtable<Caracteristique, Float>();
		
		// Défitions des règles
		// Vie
		float valVie = 0;
		for (Caracteristique caracteristique : getCaracteristiques()) {
			valVie += caracteristique.tranchePourcent(0, -3, 25, -1, 75, 1);
		}
		nouvellesCaracteristiques.put(vie, valVie);
		// Energie
		// ...
		// Hygiène
		// ...
		// Moral
		// ...
		// Faim
		// ...
		// Toilettes
		// ...
		
		// Retourne la liste des règles à appliquer
		return nouvellesCaracteristiques;
	}
}
