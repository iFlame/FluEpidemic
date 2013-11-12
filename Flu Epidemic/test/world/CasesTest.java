package world;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simulation.Pig;

public class CasesTest {

	private Cases cases;
	
	@Before
	public void initialize() throws Exception {
		cases = new Cases();
	}
	
	@After
	public void clean() throws Exception {
		cases= null;
	}

	@Test
	public void test() {
		assertNotNull("case is create",cases);
	}
}
