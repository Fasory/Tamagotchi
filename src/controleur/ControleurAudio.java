package controleur;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ControleurAudio extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	private int volume;
	private int musique;
	
	private Clip fondAmbiant;
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur audio							<br/>
	 */
	public ControleurAudio() {
		super(estCree);
		estCree++;
		volume=50;
		musique=50;
		try {
			AudioInputStream fluxFondAmbiant = AudioSystem.getAudioInputStream(ControleurFichier.getFichier("assets/sound/ambient/Myuu-TenderRemains.wav"));
			fondAmbiant = AudioSystem.getClip();
			fondAmbiant.open(fluxFondAmbiant);
			fondAmbiant.loop(Clip.LOOP_CONTINUOUSLY);
			fondAmbiant.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException err) {
			System.err.println(err);
		}
	}
	
	/**
	 * Getter
	 * 
	 * @return int - Volume du jeu
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Getter
	 * 
	 * @return int - musique du jeu
	 */
	public int getMusique() {
		return musique;
	}
	
	/**
	 * Changement du volume
	 * 
	 * @param vol - int représentant le volume du jeu
	 */
	public void changeVolume(int vol) {
		volume = vol;
	}
	
	/**
	 * Changement du volume de la musique
	 * 
	 * @param mus - int représentant le volume de la musique du jeu
	 */
	public void changeMusique(int mus) {
		musique = mus;
	}

}
