import uebung04.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringSplitting1stTest {

	@Test
	public void testStrExplode() {
		assertArrayEquals(new String[]{"Banane","Apfel","Birne"}, StringSplitting.strSplit("Banane,Apfel,Birne", ','));
	}
	
}
