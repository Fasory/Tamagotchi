package modele;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class Personnage implements Serializable {
	
	// Attributs
	// Icone personnage à définir
	protected Hashtable<String, Caracteristique> caracteristiques;
	protected Caracteristique age;
	protected Caracteristique vie;
	protected Caracteristique hygiene;
	protected Caracteristique energie;
	protected String nom;
	protected String type;
	
	//Constructeurs
	Personnage(int age, int vie, int hygiene, int energie, String nom){
		this.nom = nom;
		// Caractéristiques
		caracteristiques = new Hashtable<String, Caracteristique>();
		this.age = new Caracteristique(age, "Age", 0);
		this.vie = new Caracteristique(vie, "Vie", 0,100);
		this.energie = new Caracteristique(energie, "Energie", "Dormir", 0,100);
		caracteristiques.put(this.energie.getNom(), this.energie);
		this.hygiene = new Caracteristique(hygiene, "Hygiène", "Doucher", 0,100);
		caracteristiques.put(this.hygiene.getNom(), this.hygiene);
	}
	
	Personnage(String nom){
		this(0, 100, 100, 100, nom);
	}
	
	//Méthodes
	
	//Getters

	public Vector<Caracteristique> getCaracteristiques() {
		return new Vector<Caracteristique>(caracteristiques.values());
	}

	public Caracteristique getCaracteristique(String caracteristique) {
		return caracteristiques.get(caracteristique);
	}
	
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
