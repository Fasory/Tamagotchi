package controleur;

/**
 * Classe abstraite qui a pour but de gérer la création d'un type de				<br/>
 * contrôleur afin d'avoir un seul et unique sous contrôleur de créer				<br/>
 * dans l'application																<br/>
 * 																					<br/>
 * Cela permet notemment d'éviter la modification des sous contrôleurs				<br/>
 * du contrôleur général qui ont une portée public, cela permet						<br/>
 * également d'éviter la lourdeur des getteurs / setteurs sur ces sous				<br/>
 * controleurs																		<br/>
 */
public abstract class Controleur {
	
	/**
	 * Constructeur																	<br/>
	 * 																				<br/>
	 * @param estCree - int désignant le repère de création du controleur fils		<br/>
	 */
	protected Controleur(boolean estCree) {
		try {
			if (estCree) throw new Exception("Erreur - tentative d'instentiation d'un controleur déjà existant");
		} catch (Exception err) {
			System.err.println(err);
			System.exit(1);
		}
	}
	
	abstract public void delControleur();
}
