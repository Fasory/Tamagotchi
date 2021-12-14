package modele;

import java.io.Serializable;
import java.util.UUID;


public class Partie extends ObjectId implements Serializable {
	
	private Personnage tamagotchi;
	private final boolean triche;
	
	public Partie(Personnage tamagotchi, boolean triche) {
		super(UUID.randomUUID());
		this.triche = triche;
	}
	
	public Personnage getTamagotchi() {
		return tamagotchi;
	}
	
	public boolean getTriche() {
		return triche;
	}
}
