package simulation;

/**
 * This Class holds an enumeration of all the Diseases
 * 
 * @author Quentin Cornevin
 **/

public abstract class Disease {

	protected double mortalityRate;
	protected double contagiousRate;
	protected String name;
	protected int incubationTime;
	protected int contagiousTime;
	private static final int incubationTim=3;
	private static final int contagiousTim=3;
	private static final int number=100;

	public Disease(double mortalityRate, double contagiousRate, String name) {
		this.mortalityRate = mortalityRate;
		this.contagiousRate = contagiousRate;
		this.name = name;
		this.incubationTime=incubationTim;
		this.contagiousTime=contagiousTim;
	}

	public Disease() {
		this(number, number, "death");
	}
	
	/**
	 * @return the contagiousTime
	 */
	public int getContagiousTime() {
		return contagiousTime;
	}

	/**
	 * @param contagiousTime the contagiousTime to set
	 */
	public void setContagiousTime(int contagiousTime) {
		this.contagiousTime = contagiousTime;
	}

	/**
	 * @return the mortalityRate
	 */
	public double getMortalityRate() {
		return mortalityRate;
	}

	/**
	 * @param mortalityRate
	 *            the mortalityRate to set
	 */
	public void setMortalityRate(double mortalityRate) {
		this.mortalityRate = mortalityRate;
	}

	/**
	 * @return the contagiousRate
	 */
	public double getContagiousRate() {
		return contagiousRate;
	}

	/**
	 * @param contagiousRate
	 *            the contagiousRate to set
	 */
	public void setContagiousRate(double contagiousRate) {
		this.contagiousRate = contagiousRate;
	}

	/**
	 * @return the incubationTime
	 */
	public int getIncubationTime() {
		return incubationTime;
	}

	/**
	 * @param incubationTime
	 *            the incubationTime to set
	 */
	public void setIncubationTime(int incubationTime) {
		this.incubationTime = incubationTime;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}