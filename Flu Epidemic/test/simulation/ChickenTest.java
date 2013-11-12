package simulation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChickenTest {

	private Chicken chicken;
	
	@Before
	public void initialize() throws Exception {
		chicken = new Chicken();
	}
	
	@After
	public void clean() throws Exception {
		chicken = null;
	}

	@Test
	public void test() {
		assertNotNull("chicken is create",chicken);
	}

}
