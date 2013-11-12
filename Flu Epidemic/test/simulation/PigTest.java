package simulation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PigTest {

	private Pig pig;
	
	@Before
	public void initialize() throws Exception {
		pig = new Pig();
	}
	
	@After
	public void clean() throws Exception {
		pig = null;
	}

	@Test
	public void test() {
		assertNotNull("pig is create",pig);
	}
}
