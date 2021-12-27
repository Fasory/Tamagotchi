package modele;

public class Animal extends Personnage  {
	private String race;
	private Caracteristique moral;
	private Caracteristique faim;
	private Caracteristique toilettes;
	
	public Animal(String nom, String race) {
		super(nom);
		type = "Animal";
		this.race = race;
		// Caractéristiques
		faim = new Caracteristique(100 , "Nourriture", "Manger", 0, 100);
		caracteristiques.put(this.faim.getNom(), this.faim);
		moral = new Caracteristique(100 , "Moral", "Jouer", 0, 100);
		caracteristiques.put(this.moral.getNom(), this.moral);
		toilettes = new Caracteristique(100 , "Toilettes", "Toilettes", 0, 100);
		caracteristiques.put(this.toilettes.getNom(), this.toilettes);
	}
	
}
