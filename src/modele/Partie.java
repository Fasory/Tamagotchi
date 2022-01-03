package modele;

import java.util.UUID;


public class Partie extends ObjectId {
	
	private Personnage tamagotchi;
	private final boolean triche;
	
	public Partie(Personnage tamagotchi, boolean triche) {
		super(UUID.randomUUID());
		this.triche = triche;
		this.tamagotchi = tamagotchi;
	}
	
	public Personnage getTamagotchi() {
		return tamagotchi;
	}
	
	public boolean getTriche() {
		return triche; 
	}
}
