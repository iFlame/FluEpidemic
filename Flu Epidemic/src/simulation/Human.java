package simulation;

import java.util.Random;

public class Human extends LivingBeing {

	public Human(){
		super();
		this.type= Type.HUMAN;
		// TODO : Penser a changer la maladie !!!
		this.disease = new H1N1();
	}
	

	/**
	 * This method change the state of contagious to dead 
	 * Depend of the mortality rate
	 */
	@Override
	public void dead(){
		Random random = new Random();
		double percent = (random.nextDouble())*100;
		if(percent <= this.disease.getMortalityRate()){
			this.state= State.DEAD;
		}
	}	
}
