package world;

import simulation.LivingBeing;

public class Cases {

	private int number;
	private boolean empty;
	private LivingBeing living;

	public Cases() {
		this.number = 00000;
		this.empty = true;
	}	
	
	/**
	 * Put a living being in the case
	 *  !!!! You have to check before if the case is empty !!!!
	 * @param living
	 */
	public void putLivingBeing(LivingBeing living){
		this.living=living;
		this.empty = false;
	}
	
	
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the empty
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * @param empty
	 *            the empty to set
	 */
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	/**
	 * @return the livingBeig in the case
	 */
	public LivingBeing getLiving() {
		return living;
	}

	/**
	 * Change the living Being
	 * 
	 * @param living
	 */
	public void setLiving(LivingBeing living) {
		this.living = living;
	}
}
