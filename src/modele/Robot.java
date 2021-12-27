package modele;

import java.util.Hashtable;

public class Robot extends Personnage{
	
	private Caracteristique entretien;
	
	public Robot(String nom) {
		super(nom, "Robot");
	}
	
	/**
	 * Définition des règles de vie
	 * 
	 * @return Hashtable<String, Float> - représentant les valeurs à
	 * affecter pour chacune des caracteristiques sous forme de paires
	 * <Caracteristique, valeur>
	 */
	@Override
	public Hashtable<Caracteristique, Float> reglesVie() {
		// Initialisation de la liste des règles à appliquer
		Hashtable<Caracteristique, Float> nouvellesCaracteristiques = new Hashtable<Caracteristique, Float>();
		
		// Défitions des règles
		// Vie
		float valVie = 0;
		for (Caracteristique caracteristique : getCaracteristiques()) {
			valVie += caracteristique.tranchePourcent(0, -3, 25, -1, 75, 1);
		}
		nouvellesCaracteristiques.put(vie, valVie);
		
		//Energie
		
				float valEne = 0;
				valEne+=energie.regressionPourcent(25, -3, 50, -2, -1);
				nouvellesCaracteristiques.put(energie, valEne);
				
				//Hygiene
				
				float valHyg = 0;
				valHyg+=energie.regressionPourcent(25, -3, 50, -2, -1);
				nouvellesCaracteristiques.put(energie, valHyg);
				
				//Entretien
				
				float valEnt = 0;
				valEnt+=entretien.regressionPourcent(25, -3, 50, -2, -1);
				nouvellesCaracteristiques.put(entretien, valEnt);
		
		// Retourne la liste des règles à appliquer
		return nouvellesCaracteristiques;
	}
}
