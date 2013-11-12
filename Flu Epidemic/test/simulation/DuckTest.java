package simulation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DuckTest {

	private Duck duck;
	
	@Before
	public void initialize() throws Exception {
		duck = new Duck();
	}
	
	@After
	public void clean() throws Exception {
		duck = null;
	}

	@Test
	public void test() {
		assertNotNull("duck is create",duck);
	}
}
