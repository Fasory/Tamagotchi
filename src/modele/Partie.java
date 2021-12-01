package modele;

import java.util.UUID;


public class Partie extends ObjectId {
	
	private Personnage tamagotchi;
	private boolean triche;
	
	public Partie(UUID id) {
		super(id);
	}
	
	public Partie(Personnage tamagotchi, boolean triche) {
		super(UUID.randomUUID());
		this.triche = triche;
	}
	
	public Personnage getTamagotchi() {
		return tamagotchi;
	}
	
	/**
	 * Permet de sauvegarder une partie
	 *  __________________________________
	 * | File name : UUID PARTIE_ID       |
	 * |__________________________________|
	 * |UUID PARTIE_ID                    |
	 * |String Personnage                       |
	 * |__________________________________|
	 */
	@Override
	public String toString() {
		String identification = id.toString()+"\n";
		String personnage = getTamagotchi().toString()+"\n";
		return identification+personnage;
	}
}
