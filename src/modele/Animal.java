package modele;

public class Animal extends Personnage  {
	private String race;
	private Caracteristique faim;
	
	public Animal(String nom, String race) {
		super(nom);
		type = "Animal";
		this.race=race;
	}
	
}
