package epidemicinterface;

import java.util.Scanner;

/**
 * A class that reads input lines from the user. Input is filtered via
 * getCommand for valid commands.
 * 
 */
public class Imput {


	private Scanner reader;
	private Command UNKNOWN;

	public Imput() {
		reader = new Scanner(System.in);
	}

	/**
	 * Read the next command from the user. The returned command will be valid.
	 * @return A valid command.
	 */
	public Command getCommand() {

		Command command = null;
		boolean quit = false;
		boolean unknown = true;

		do {
			System.out.print("> ");

			String word = reader.next();
			readLine();

			for (Command keyword : Command.values()) {
				try {
					if (keyword.toString().compareTo(word) == 0) {
						return keyword;
					}
				} catch (IllegalArgumentException | NullPointerException e) {
					command = UNKNOWN;
				}
			}
			if (unknown) {
				System.out.println(Sentence.ERROR + word);
				Command.showAll();
			}

		} while (!quit);
		return command;
	}
	
	/**
	 * Check if the user give a double
	 * @return The double imput by the user if it is really an imput
	 */
	public double getDouble(){

		boolean quit = false;

		do {
			System.out.print("> ");
			double word = reader.nextDouble();
			readLine();		
		return word;
		} while(!quit);
	}
	
	/**
	 * Check if the user give us an integer
	 * @return an integer
	 */
	public int getInt(){
		
		boolean quit = false;

		do {
			System.out.print("> ");
			int word = reader.nextInt();
			readLine();		
		return word;
		} while(!quit);
	}
	
	/**
	 * Print out a list of valid command words.
	 */
	public void showCommands() {
		Command.showAll();
	}

	/**
	 * @return A line of text from the user.
	 */
	public String readLine() {
		return reader.nextLine();
	}
}
