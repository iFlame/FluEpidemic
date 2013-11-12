package simulation;

/**
 * This Class holds an enumeration of all the states
 * @author Quentin Cornevin
 */

public enum State {

	HEALTHY("sain"),
	SICK("malade"),
	CONTAGIOUS("contagieux"),
	DEAD("mort");
		
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	private String word="";
	
	/**
	 * Construct an enumeration with the number of day in the state in param
	 * @param dayState
	 */
	State(String word){
		this.word=word;
	}
	

}