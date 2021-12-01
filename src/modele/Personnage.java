package modele;

public class Personnage {
	
	// Attributs
	// Icone personnage à définir
	protected Caracteristique age;
	protected Caracteristique vie;
	protected Caracteristique hygiene;
	protected Caracteristique energie;
	protected Caracteristique moral;
	protected String nom;
	protected String type;
	
	//Constructeurs
	Personnage(Caracteristique age, Caracteristique vie, Caracteristique hygiene, Caracteristique energie, String nom){
		this.age = age;
		this.vie = vie;
		this.hygiene = hygiene;
		this.energie = energie;
		this.nom = nom;
	}
	
	Personnage(String nom){
		this.nom = nom;
		age = new Caracteristique(0,0);
		vie = new Caracteristique(100,0,100);
		hygiene = new Caracteristique(100,0,100);
		energie = new Caracteristique(100,0,100);
	}
	
	//Méthodes
	
	//Getters
	
	/**
	 * Retourne le nom du Personnage
	 * 
	 * @return nom - String
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Retourne l'age du Personnage
	 * 
	 * @return age - Caracteristique
	 */
	public Caracteristique getAgeabstract() {
		return age;
	}
	
	/**
	 * Retourne la vie du Personnage
	 * 
	 * @return vie - Caracteristique
	 */
	public Caracteristique getVie() {
		return vie;
	}
	
	/**
	 * Retourne la valeur de l'hygiène du Personnage
	 * 
	 * @return hygiene - Caracteristique
	 */
	public Caracteristique getHygiene() {
		return hygiene;
	}
	
	/**
	 * Retourne la valeur de l'énergie du Personnage 
	 * 
	 * @return energie - int
	 */
	public Caracteristique getEnergie() {
		return energie;
	}
	
	
}
