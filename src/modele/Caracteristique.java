package modele;

import java.io.Serializable;

public class Caracteristique implements Serializable {
	
	private final String nom;
	private String modifieur;
	private float val;
	private final float min;
	private final float max;
	private final float delta;
	private float coef;
	
	public Caracteristique(float val, String nom, String modifieur)  {
		this(val, nom, modifieur, -999999, 999999, 1);
	}
	
	public Caracteristique(float val, String nom, String modifieur, float min) {
		this(val, nom, modifieur, min, 999999, 1);
	}
	
	public Caracteristique(float val, String nom, float min) {
		this(val, nom, "", min, 999999, 1);
	}
	
	public Caracteristique(float val, String nom, String modifieur, float min, float max) {
		this(val, nom, modifieur, min, max, 1);
	}
	
	public Caracteristique(float val, String nom, float min, float max) {
		this(val, nom, "", min, max, 1);
	}
	
	public Caracteristique(float val, String nom, String modifieur, float min, float max, float coef) {
		if (min > max) {
			this.min=max;
			this.max=min;
		} else {
			this.min=min;
			this.max=max;
		}
		this.coef=coef;
		this.nom = nom;
		this.modifieur = modifieur;
		this.delta = this.max-this.min;
		setValeur(val);
	}
	
	public float getValeur() {
		return this.val;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getModifieur() {
		return this.modifieur;
	}

	public float getMin() {
		return this.min;
	}
	
	public float getMax() {
		return this.max;
	}
	
	public float getDelta() {
		return this.delta;
	}
	
	
	public void setValeur(float val) {
		if (val<min) {
			this.val = min;
		} else if (val>max) {
			this.val = max;
		} else {
			this.val = val;
		}
	}
	
	
	public void setModifieur(String mod) {
		this.modifieur = mod;
	}
	
	
	public void add(float val) {
		setValeur(coef*val+this.val);
	}
	
	public boolean equals(Caracteristique car) {
		return car.nom.equals(nom) && car.val == val;
	}
	
	public float tranchePourcent(float pourcentCritique, float retourCritique, float pourcentFaible, float retourFaible, float pourcentFort, float retourFort) {
		if (min + delta * pourcentCritique == val) return retourCritique;
		else if (min + delta * pourcentFaible/100 >= val) return retourFaible;
		else if (min + delta * pourcentFort/100 <= val) return retourFort;
		else return 0;
	}
	
	public float regressionPourcent(float pourcentFaible, float retourFaible, float pourcentMoyen, float retourMoyen, float retourFort) {
		if (min + delta * pourcentFaible/100 >= val) return retourFaible;
		else if (min + delta * pourcentMoyen/100 >= val) return retourMoyen;
		else return retourFort;
	}
	
}
