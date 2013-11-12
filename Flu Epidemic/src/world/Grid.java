package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import simulation.LivingBeing;
import simulation.State;
import simulation.Type;

/**
 * This class create the grid
 * 
 * @author Quentin Cornevin
 */

public class Grid {

	private int length;
	private int boardness;
	private static final int MINVALUE = 0;
	private List<Cases> caseList;

	/**
	 * Create a grid
	 * 
	 * @param length
	 * @param boardness
	 */
	public Grid(int length, int boardness) {
		this.length = length;
		this.boardness = boardness;
		this.caseList = new ArrayList<Cases>();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < boardness; j++) {
				Cases cases = new Cases();
				int caseNumber = i * boardness + j + 1;
				cases.setNumber(caseNumber);
				caseList.add(cases);
			}
		}

	}

	public void nextDay() {
		for (Cases case1 : caseList) {
			if (!case1.isEmpty()) {
				nextState(case1.getLiving());
				infection(case1);
			}
		}
	}

	/**
	 * Change the state of the human in function of the number of day in the
	 * state
	 * 
	 * @param living
	 */
	private void nextState(LivingBeing living) {
		switch (living.getState()) {
		case SICK:
			if (living.getDayState() == living.getDisease().getIncubationTime()) {
				living.setState(State.CONTAGIOUS);
				living.setDayState(0);
			}
			living.setDayState(living.getDayState() + 1);
			break;
		case CONTAGIOUS:
			if ((living.getDayState() == living.getDisease()
					.getContagiousTime())
					&& (living.getType().equals(Type.HUMAN))) {
				living.dead();
				living.setDayState(0);
			} else if (living.getDayState() == living.getDisease()
					.getContagiousTime()) {
				living.setState(State.HEALTHY);
				living.setDayState(0);
			}
			living.setDayState(living.getDayState() + 1);
			break;
		case DEAD:
			living.setDayState(living.getDayState() + 1);
			living.setState(State.DEAD);
			break;
		}
	}

	/**
	 * Check the type of living being in the case. The infection depend of the
	 * type
	 * 
	 * @param case1
	 */
	public void infection(Cases case1) {
		switch (case1.getLiving().getType()) {
		case HUMAN:
			human(case1);
			break;
		case PIG:
			animalInfection(case1, Type.PIG);
			break;
		case BIRD:
			animalInfection(case1, Type.BIRD);
			break;
		}
	}

	/**
	 * This is the infection for the animals who can contaminate only the animal
	 * of the same type
	 * 
	 * @param cases
	 * @param type
	 * 
	 */
	private void animalInfection(Cases cases, Type type) {
		for (Cases case2 : isNeighboor(cases)) {
			if ((case2.getLiving() != null)
					&& (case2.getLiving().getType().equals(type))
					&& case2.getLiving().getState().equals(State.CONTAGIOUS)) {
				if (case2.getLiving().beingContaminated()) {
					cases.getLiving().beingSick();
				}
			}
		}
	}

	/**
	 * This is the infection for the human who can be infected by every species
	 * 
	 * @param cases
	 */
	private void human(Cases cases) {
		if (cases.getLiving().getState() != State.DEAD) {
			for (Cases case2 : isNeighboor(cases)) {
				if ((case2.getLiving() != null)
						&& (case2.getLiving().getState()
								.equals(State.CONTAGIOUS))) {
					if (case2.getLiving().beingContaminated()) {
						cases.getLiving().beingSick();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param case1
	 * @return tan arrayList of all the neighboor of the case
	 */
	private List<Cases> isNeighboor(Cases case1) {
		List<Cases> neighboorList = new ArrayList<Cases>();
		for (Cases case2 : caseList) {
			if ((case2.getNumber() == case1.getNumber() - 1)
					|| (case2.getNumber() == case1.getNumber() + 1)
					|| (case2.getNumber() == case1.getNumber() - boardness)
					|| (case2.getNumber() == case1.getNumber() + boardness)) {
				neighboorList.add(case2);
			}
		}
		return neighboorList;
	}

	/**
	 * @return the caseList
	 */
	public List<Cases> getCaseList() {
		return caseList;
	}

	/**
	 * @param caseList
	 *            the caseList to set
	 */
	public void setCaseList(List<Cases> caseList) {
		this.caseList = caseList;
	}

	/**
	 * Print the grid with "  " to separate every case TODO :
	 */
	public void print() {
		String grid = "";
		for (Cases cases : caseList) {
			if (cases != null) {
				if (!(cases.isEmpty())) {
					grid = grid + getState(cases);
					grid = grid + getType(cases);
				} else {
					grid = grid + "  -- ";
				}
				if ((cases.getNumber() % boardness == 0)
						&& (cases.getNumber() != 0)) {
					String newLine = System.getProperty("line.separator");
					grid = grid + newLine;
				}
			}
		}
		System.out.println(grid);
	}

	/**
	 * Use to print the grid : return the first letter of the type
	 * 
	 * @param cases
	 * @return the type of living being in the case
	 */
	private String getType(Cases cases) {
		String grid = "";
		// System.out.println("1");
		if (cases.getLiving() != null) {
			switch (cases.getLiving().getType()) {
			case HUMAN:
				grid = grid + "H ";
				break;
			case PIG:
				grid = grid + "P ";
				break;
			case DUCK:
				grid = grid + "D ";
				break;
			case CHICKEN:
				grid = grid + "C ";
				break;
			}
		}
		return grid;
	}

	/**
	 * Use by print to have the state of the living being of the cases of the
	 * grid
	 * 
	 * @param cases
	 * @return the first letter of the state of the living being
	 */
	private String getState(Cases cases) {
		String grid = "";
		if (cases.getLiving() != null) {
			switch (cases.getLiving().getState()) {
			case HEALTHY:
				grid = grid + "  h";
				break;
			case SICK:
				grid = grid + "  s";
				break;
			case CONTAGIOUS:
				grid = grid + "  c";
				break;
			case DEAD:
				grid = grid + "  d";
			}
		}
		return grid;
	}

	/**
	 * Put randomly a living being in the grid
	 * 
	 * @param living
	 */

	public void putLiving(LivingBeing living) {
		Random rand = new Random();
		int value = MINVALUE + rand.nextInt(length * boardness - MINVALUE);
		if (caseList.get(value).isEmpty()) {
			caseList.get(value).putLivingBeing(living);
		} else {
			putLiving(living);
		}
	}

	/**
	 * Set the length of the grid
	 * 
	 * @param length
	 *            will be the new length of the grid
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Set the boardness
	 * 
	 * @param boardness
	 */
	public void setBoard(int board) {
		this.boardness = board;
	}

	/**
	 * Return the length
	 * 
	 * @return length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * return the boardness
	 * 
	 * @return boardness
	 */
	public int getBoardness() {
		return boardness;
	}
}
