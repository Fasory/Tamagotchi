package modele;

import java.util.Hashtable;

public class Animal extends Personnage  {
	private String race;
	private Caracteristique moral;
	private Caracteristique faim;
	private Caracteristique toilettes;
	
	public Animal(String nom, String race) {
		super(nom, "Animal");
		this.race = race;
		// Caractéristiques
		faim = new Caracteristique(100 , "Nourriture", "Manger", 0, 100);
		caracteristiques.put(this.faim.getNom(), this.faim);
		moral = new Caracteristique(100 , "Moral", "Jouer", 0, 100);
		caracteristiques.put(this.moral.getNom(), this.moral);
		toilettes = new Caracteristique(100 , "Toilettes", "Toilettes", 0, 100);
		caracteristiques.put(this.toilettes.getNom(), this.toilettes);
	}
	
	@Override
	public String getType() {
		return race;
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
