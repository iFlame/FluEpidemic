package simulation;

import java.util.Random;

/**
 * This Class create an living Being
 * @author Quentin Cornevin
 *
 */
public abstract class LivingBeing {
	
	protected State state;
	protected Disease disease;
	protected Type type;
	protected int dayState;
	
	public LivingBeing(){
		this.state = State.HEALTHY;
		// TODO : changer la maladie par defaut
		this.disease=new H1N1();
		this.type=null;
		this.dayState=0;
	}
	
	
	/**
	 * @return the disease
	 */
	public Disease getDisease() {
		return disease;
	}


	/**
	 * @param disease the disease to set
	 */
	public void setDisease(Disease disease) {
		this.disease = disease;
	}


	/**
	 * @return the dayState
	 */
	public int getDayState() {
		return dayState;
	}


	/**
	 * @param dayState the dayState to set
	 */
	public void setDayState(int dayState) {
		this.dayState = dayState;
	}


	public void dead(){
	}
	
	
	/**
	 * 
	 * @return True if the livingBeing is contaminate by the disease
	 */
	public boolean beingContaminated(){
		Random random = new Random();
		Double rand = (random.nextDouble())*100;
		if(rand <= this.disease.getContagiousRate()) {
			return true;
		}		
		return false;
	}
	
	/**
	 * Set the state of the living being to sick
	 */
	public void beingSick(){
		this.state = State.SICK;
	}
	
	/**
	 * Set the state to Contagious
	 */
	public void beingContagious(){
		this.state = State.CONTAGIOUS;
	}
	
	/**
	 * Set the state to Healthy
	 */
	public void beingHealthy(){
		this.state = State.HEALTHY;
	}
	
	/**
	 * @return the state of the living being
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * Change the state of the living being
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
}
