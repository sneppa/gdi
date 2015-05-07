import uebung08.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class Labyrinth1stTest {

	@Test
	public void test() {
		Labyrinth lab = new LabyrinthImpl();
		lab.readFromFile("labyrinth1.txt");
		
		assertEquals(new Position(4, 9), lab.entrancePosition());
		lab.findWay();
		assertEquals(new Position(0, 2), lab.exitPosition());
	}

}
