package epidemicInterface;

import java.util.ArrayList;
import simulation.*;
import world.*;

/**
 * This class create a Demo for the simulation with pre-defined parameter. The
 * class also create an interface for the user
 * 
 * @author user
 * 
 */

public class EpidemicDemo {

	private World world;
	private Grid grid;
	private EpidemicDemoInterface menu;

	/**
	 * Construct a Demo with a world already defined World param : 15 Human and
	 * 3 pig / duck / chicken and grid length : 6 and boardness : 5
	 */
	public EpidemicDemo() {
		ArrayList<LivingBeing> livingList = new ArrayList<LivingBeing>();
		for (int i = 0; i < 15; i++) {
			Human human = new Human();
			livingList.add(human);
		}
		for (int i = 0; i < 3; i++) {
			Duck duck = new Duck();
			Chicken chicken = new Chicken();
			Pig pig = new Pig();
			livingList.add(duck);
			livingList.add(chicken);
			livingList.add(pig);
		}

		Human human = new Human();
		human.setState(State.CONTAGIOUS);
		livingList.add(human);

		grid = new Grid(6, 5);

		setWorld(new World(0, grid, livingList));
		world.worldGenerator();

		menu = new EpidemicDemoInterface(world);
	}

	/**
	 * Allow the user to interact with the simulation
	 */
	public void showInterface() {
		menu.run();
	}

	/**
	 * @return the world build in the constructor
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Set the world of the constructor
	 * 
	 * @param world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

}
