package modele;

import java.io.Serializable;

public class Caracteristique implements Serializable {
	
	private final String nom;
	private final String modifieur;
	private float val;
	private final float min;
	private final float max;
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
		this.min=min;
		this.max=max;
		this.coef=coef;
		this.nom = nom;
		this.modifieur = modifieur;
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
	
	
	public void setValeur(float val) {
		if (val<min) {
			this.val = min;
		} else if (val>max) {
			this.val = max;
		} else {
			this.val = val;
		}
	}
	
	public void add(float val) {
		setValeur(coef*val+this.val);
	}
	
	public boolean equals(Caracteristique car) {
		return car.nom.equals(nom) && car.val == val;
	}
}
