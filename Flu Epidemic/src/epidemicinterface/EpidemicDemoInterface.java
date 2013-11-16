package epidemicinterface;

import world.*;

/**
 * Provide an interface for the simulation. There is several command : The user
 * can start with a default simulation or can create a new one The user can
 * change all the parameter with this interface 
 * 
 * @author Quentin Cornevin
 * 
 */

public class EpidemicDemoInterface {

	private World world;
	private Imput imput;

	/**
	 * Create a new Epidemic Interface
	 * 
	 * @param world
	 */
	public EpidemicDemoInterface(World world) {
		this.world = world;
		this.imput = new Imput();
	}

	/**
	 * Run the interface, start the menu
	 */
	public void run() {
		System.out.println(Sentence.NAME);
		System.out.println(Sentence.WELCOME);

		Command command;

		do {
			command = imput.getCommand();
			if (command.equals(Command.LIST)) {
				list();
			} else if (command.equals(Command.NEW)) {
				news();
			} else if (command.equals(Command.HELP)) {
				help();
			} else if (command.equals(Command.PRINT)) {
				print();
			} else if (command.equals(Command.START)) {
				start();
			}
		} while (!(command.equals(Command.QUIT)));
		System.out.println(Sentence.CLOSING);
	}

	/**
	 * list the several command
	 */
	public void list() {
		imput.showCommands();
	}

	/**
	 * Create a new simulation
	 */
	public void news() {
		// TODO :
	}

	/**
	 * Print the grid
	 */
	public void print() {
		world.grid.print();
	}

	/**
	 * Start the simulation Ask the user how many day he want to wait and show
	 * the grid
	 **/
	public void start() {
		System.out.println(Sentence.START);
		int word = imput.getInt();
		world.nextTime(word);
		print();
	}

	/**
	 * Print some indication to help the user
	 */
	public void help() {
		System.out.println(Sentence.HELP);
	}
}
