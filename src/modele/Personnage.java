package modele;

public class Personnage {
	
	// Attributs
	// Icone personnage à définir
	protected Caracteristique age;
	protected Caracteristique vie;
	protected Caracteristique hygiene;
	protected Caracteristique energie;
	protected String nom;
	protected String type;
	
	//Constructeurs
	
	Personnage(Caracteristique age, Caracteristique vie, Caracteristique hygiene, Caracteristique energie, String nom, String type){
		this.age = age;
		this.vie = vie;
		this.hygiene = hygiene;
		this.energie = energie;
		this.nom = nom;
		this.type = type;
	}
	
	Personnage(String nom, String type){
		this.nom = nom;
		this.type = type;
		
		age = 0;
		vie = 100;
		hygiene = 100;
		energie = 100;
	}
	
	//Méthodes
	
	//Getters
	
	/**
	 * Retourne le nom du Personnage
	 * 
	 * @return nom - String
	 */
	public abstract String getNom() {
		return nom;
	}
	
	/**
	 * Retourne l'age du Personnage
	 * 
	 * @return age - Caracteristique
	 */
	public Caracteristique getAge() {
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
	 * Retourne l'action en cours du Personnage
	 * 
	 * @return action - String
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Retourne la valeur de l'énergie du Personnage 
	 * 
	 * @return energie - int
	 */
	public int getEnergie() {
		return energie;
	}
	

}
