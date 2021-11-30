package controleur;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ControleurAudio extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	private int volume;
	private int musique;
	
	private Clip fondAmbiant;
	private HashMap<String,Clip> bruitage;
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur audio							<br/>
	 */
	public ControleurAudio() {
		super(estCree);
		estCree = true;
		volume=50;
		musique=50;
		try {
			AudioInputStream fluxFondAmbiant = AudioSystem.getAudioInputStream(ControleurFichier.getFichier("assets/sound/ambient/Myuu-TenderRemains.wav"));
			fondAmbiant = AudioSystem.getClip();
			fondAmbiant.open(fluxFondAmbiant);
			changeMusique(musique);
			fondAmbiant.loop(Clip.LOOP_CONTINUOUSLY);
			fondAmbiant.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException err) {
			System.err.println(err);
		}
		bruitage = new HashMap<String,Clip>();
	}
	
	@Override
	public void delControleur() {
		estCree = false;
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
		if (vol<0) vol=0;
		if (vol>100) vol=100;
		volume = vol;
		for (Clip son: bruitage.values()) {
			FloatControl gainControl = (FloatControl) son.getControl(FloatControl.Type.MASTER_GAIN);
			float max = gainControl.getMaximum();
			float min = gainControl.getMinimum();
			gainControl.setValue(((max-min)/100)*volume+min);
		}
		
	}
	
	/**
	 * Changement du volume de la musique
	 * 
	 * @param mus - int représentant le volume de la musique du jeu
	 */
	public void changeMusique(int mus) {
		if (mus<0) mus=0;
		if (mus>100) mus=100;
		musique = mus;
		FloatControl gainControl = (FloatControl) fondAmbiant.getControl(FloatControl.Type.MASTER_GAIN);
		float max = gainControl.getMaximum();
		float min = gainControl.getMinimum();
		gainControl.setValue(((max-min)/100)*musique+min);
	}
}
