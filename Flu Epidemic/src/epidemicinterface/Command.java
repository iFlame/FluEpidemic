package epidemicinterface;

/**
 * This class holds all the different command known to the program.
 * 
 * @author Quentin Cornevin
 *
 */
public enum Command {

	LIST("liste"),
	QUIT("quitter"),
	DEFAULT("defaut"),
	NEW("nouvelle"),
	PRINT("afficher"),
	START("commencer"),
	DEFAULT_PARAMETER("parametre"),
	HELP("aide");
	
	private String word="";
	
	Command(String command){
		this.word=command;
	}
	
    /**
     * Print all valid commands to System.out.
     */
	public static void showAll(){
		System.out.println(Sentence.COMMAND_AVAILABLE);
		String word = "";
		for(Command com : values()){
			word += " - " + com.toString();
		}
		System.out.println(word);
	}
	
	/**
	 * Print the command
	 */
	public String toString(){
		return word;
	}
}
