package modele;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public abstract class Personnage implements Serializable {
	
	// Attributs
	// Icone personnage à définir
	protected Hashtable<String, Caracteristique> caracteristiques;
	protected Caracteristique age;
	protected Caracteristique vie;
	protected Caracteristique hygiene;
	protected Caracteristique energie;
	protected final String nom;
	protected final String type;
	
	//Constructeurs
	Personnage(int age, int vie, int hygiene, int energie, String nom, String type){
		this.nom = nom;
		this.type = type;
		// Caractéristiques
		caracteristiques = new Hashtable<String, Caracteristique>();
		this.age = new Caracteristique(age, "Age", 0);
		this.vie = new Caracteristique(vie, "Vie", 0,100);
		this.energie = new Caracteristique(energie, "Energie", "Dormir", 0,100);
		caracteristiques.put(this.energie.getNom(), this.energie);
		this.hygiene = new Caracteristique(hygiene, "Hygiène", "Doucher", 0,100);
		caracteristiques.put(this.hygiene.getNom(), this.hygiene);
	}
	
	Personnage(String nom, String type){
		this(0, 100, 100, 100, nom, type);
	}
	
	//Méthodes
	
	//Getters

	public Vector<Caracteristique> getCaracteristiques() {
		return new Vector<Caracteristique>(caracteristiques.values());
	}

	public Caracteristique getCaracteristique(String caracteristique) {
		return caracteristiques.get(caracteristique);
	}
	

	public Caracteristique getAge() {
		return age;
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
	 * Retourne le type du Personnage
	 * 
	 * @return type - String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Retourne le type general du Personnage
	 * 
	 * @return type - String
	 */
	public String getTypeGeneral() {
		return type;
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
	
	/**
	 * Application des règles de vie
	 * 
	 * @param nouvellesValeurs - Hashtable<String, Float> représentant
	 * les valeurs à affecter pour appliquer les règles dans un cycle
	 * de vie
	 */
	public void cycleVie(Hashtable<Caracteristique, Float> nouvellesCaracteristiques) {
		for (Map.Entry<Caracteristique, Float> caracteristique : nouvellesCaracteristiques.entrySet()) {
			caracteristique.getKey().add(caracteristique.getValue());
		}
	}
	
	/**
	 * Définition des règles de vie
	 * 
	 * @return Hashtable<String, Float> - représentant les valeurs à
	 * affecter pour chacune des caracteristiques sous forme de paires
	 * <Caracteristique, valeur>
	 */
	public abstract Hashtable<Caracteristique, Float> reglesVie();
	
	
}
