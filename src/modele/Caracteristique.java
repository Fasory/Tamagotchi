package modele;

public class Caracteristique {
	private float val;
	private float min;
	private float max;
	private float coef;
	
	public Caracteristique(float val)  {
		this(val, -999999, 999999, 1);
	}
	
	public Caracteristique(float val, float min) {
		this(val, min, 999999, 1);
	}
	
	public Caracteristique(float val, float min, float max) {
		this(val, min, max, 1);
	}
	
	public Caracteristique(float val, float min, float max, float coef) {
		this.min=min;
		this.max=max;
		this.coef=coef;
		setValeur(val);
	}
	
	public float getValeur() {
		return this.val;
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
}
