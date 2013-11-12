package world;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simulation.LivingBeing;

import world.Grid;



public class GridTest {
	
	private Boolean bool;
	private Grid grid;
	private Grid grid2;
	private LivingBeing living;
	private List<LivingBeing> livingList;
	
	@Before
	public void initialiser() throws Exception {
		grid2 = new Grid(5,5);
		bool = false;
	}
	

	@After
	public void nettoyer() throws Exception {
	   grid = null;
	   grid2= null;
	   bool = null;
	}
	
	@Test
	public void testGrid() {
		assertNotNull("Default grid is create", grid);
		assertNotNull("Grid is create", grid2);
	}
	
	
	@Test
	public void testFillGrid(){
		/**
		 * TODO:
		 */
	}
	
	@Test
	public void testGetLength() {
		assertEquals(10,grid.getLength());
		assertEquals(5,grid2.getLength());
	}
	
	@Test
	public void testGetBoardness() {
		assertEquals(10,grid.getBoardness());
		assertEquals(5,grid2.getBoardness());
	}
	
	@Test
	public void testSetBoardness() {;
		grid2.setBoard(8);
		assertEquals(8,grid2.getBoardness());
	}
	
	@Test
	public void testSetLength() {
		grid.setLength(15);
		assertEquals(15,grid.getLength());
	}
	
}
