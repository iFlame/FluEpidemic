package world;

import java.util.List;

import epidemicInterface.Sentence;

import simulation.LivingBeing;

/**
 * This class create a world with a Grid, a list of living being and the number
 * of day
 * 
 * @author Quentin Cornevin
 */
public class World {

	public int day;
	public Grid grid;
	public List<LivingBeing> livingList;

	/**
	 * Create a world with the different param and automatically generate the
	 * case of the grid and fill it in
	 * 
	 * @param day
	 * @param grid
	 * @param livingList
	 * @param case
	 */
	public World(int day, Grid grid, List<LivingBeing> livingList) {
		this.day = day;
		this.grid = grid;
		this.livingList = livingList;
		/*
		 * for (LivingBeing living : livingList) { grid.fillGrid(living); }
		 */
	}

	/**
	 * The default contructor create a world at day = 0 without grid or list.
	 */
	public World() {
		this(0, null, null);
	}

	/**
	 * Method nextDay : Day = Day + 1 Run the livingList and make next day for
	 * human or animal TODO :
	 */
	private void nextDay() {
		day++;
		grid.nextDay();
	}

	/**
	 * Method nextTime : skip several days Call the nextDay method several times
	 * 
	 * @param time
	 */
	public void nextTime(int time) {
		for (int i = 0; i < time; i++) {
			nextDay();
		}
	}

	/**
	 * Take all the living being and put them randomly on the grid
	 */
	public void worldGenerator() {
		if (livingList.size() < grid.getCaseList().size()) {
			for (LivingBeing living : livingList) {
				if (living != null) {
					grid.putLiving(living);
				}
			}
		} else {
			System.out.println(Sentence.ERROR_WORLDGENERATOR);
		}

	}
}
