import uebung06.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringToolkit1stTest {

	private StringToolkit toolkit = new StringToolkitImpl();

	@Test
	public void testStrToUpper() {
		assertEquals("GDI IST EINE ABK�RZUNG F�R GRUNDLAGEN DER INFORMATIK.", toolkit.toUpper("GDI ist eine Abk�rzung f�r Grundlagen der Informatik."));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrScan() {
		assertEquals(4, toolkit.indexOf("abcdefghi", "efg"));
	}
}
