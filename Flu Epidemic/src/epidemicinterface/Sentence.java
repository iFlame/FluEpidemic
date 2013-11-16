package epidemicinterface;

/**
 * This class hold all the stirng use in the different class of the simulation
 * 
 * @author Quentin Cornevin
 * 
 */

public class Sentence {

	/**
	 * String use in the class EpidemicDemoInterface :
	 */
	public static final String NAME = "*** Flu Epidemic ***";
	public static final String WELCOME = "Bienvenu dans le menu : Entrez votre commande ("
			+ Command.LIST.toString() + " pour voir la liste des commandes)";
	public static final String CLOSING = "Aurevoir";
	public static final String HELP = "Bienvenu dans l'aide de Flu Epidemic tapper "
			+ Command.LIST.toString()
			+ " pour avoir la liste des commandes disponibles. \n "
			+ "La commande " + Command.DEFAULT.toString()
			+ " lance la simulation par défaut et " + Command.NEW.toString()
			+ " vous permet de créer votre propre simulation.";
	public static final String DEFAULT = "Vous venez de lancer la simulation par défaut.\n"
			+ "Si vous voulez voir les paramètres par défaut entrez "
			+ Command.DEFAULT_PARAMETER.toString()
			+ " \n"
			+ "Si vous voulez voir la grille taper "
			+ Command.PRINT.toString()
			+ "\n"
			+ "Sinon entrez "
			+ Command.START.toString()
			+ " pour commencer la simulation.";
	public static final String START = "Entrez la durée de la simulation : ( jour ) ";

	public static final String ERROR = " Commande non-reconnue : ";

	public static final String COMMAND_AVAILABLE = "Les commandes disponibles";

	/**
	 * String pour la classe world
	 */
	public static final String ERROR_WORLDGENERATOR = "Le nombre d'ètre vivant est supérieur au nombre de case, le monde n'a pas été créé";

}
