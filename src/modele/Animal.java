package modele;

import java.util.Hashtable;

public class Animal extends Personnage  {
	private String race;
	private Caracteristique moral;
	private Caracteristique faim;
	private Caracteristique toilettes;
	
	public Animal(String nom, String race, Piece localisation) {
		super(nom, "Animal", localisation);
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
		nouvellesCaracteristiques.put(vie, valVie);					// vie -> attribut hérité de la classe Personnage
		
		// Energie
		float valEne = 0;
		valEne += energie.regressionPourcent(25, -3, 50, -2, -1); 	// en-dessous ou égal à 25 -> -3; en-dessous ou égal à 50 -> -2; en-dessous ou égal à 100
		nouvellesCaracteristiques.put(energie, valEne);
		
		// Hygiène
		float valHyg = 0;
		valHyg+=hygiene.regressionPourcent(25, -3, 50, -2, -1);
		nouvellesCaracteristiques.put(hygiene, valHyg);
		
		// Moral
		float valMor = 0;
		valMor += moral.regressionPourcent(25, -3, 50, -2, -1);
		nouvellesCaracteristiques.put(moral, valMor);
		
		// Faim
		float valFaim = 0;
		valFaim += faim.regressionPourcent(25, -3, 50, -2, -1);
		nouvellesCaracteristiques.put(faim, valFaim);
		
		// Toilettes
		float valToi = 0;
		valToi += toilettes.regressionPourcent(25, -3, 50, -2, -1);
		nouvellesCaracteristiques.put(toilettes, valToi);
		
		// Retourne la liste des règles à appliquer
		return nouvellesCaracteristiques;
	}
}
