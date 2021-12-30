package modele;

import java.io.Serializable;

public class Piece implements Serializable {
	
	public static final int  HAUT = 0;
	public static final int  GAUCHE = 1;
	public static final int  BAS = 2;
	public static final int  DROITE = 3;
	
	private final String nom;
	private final Piece[] liens;	// Connections avec les autres pièces, respectivement : haut, gauche, bas, droite
	
	public Piece(String nom) {
		this(nom, null);
	}
	
	
	public Piece(String nom, Piece[] mitoyen) {
		this.nom = nom;
		if (mitoyen == null) this.liens = new Piece[4];
		else this.liens = mitoyen;
	}
	
	
	public void addLiens(int pos, Piece o, int posO) {
		if (pos < 4 && posO < 4 && !existePiece(pos) && !o.existePiece(posO)) {
			liens[pos] = o;
			o.liens[posO] = this;
		}
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public Piece voirPiece(int direction) {
		return liens[direction];
	}
	
	
	public boolean existePiece(int direction) {
		return voirPiece(direction) != null;
	}
	
	@Override
	public String toString() {
		return nom + " : " + (liens[0] != null ? liens[0].getNom() : "null") + ", " + (liens[1] != null ? liens[1].getNom() : "null") + ", " + (liens[2] != null ? liens[2].getNom() : "null") + ", " + (liens[3] != null ? liens[3].getNom() : "null");
	}
}
