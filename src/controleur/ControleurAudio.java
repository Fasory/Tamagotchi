package controleur;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ControleurAudio extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	private Clip fondAmbiant;
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des boutons de l'application	<br/>
	 */
	public ControleurAudio() {
		super(estCree);
		estCree++;

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

}
