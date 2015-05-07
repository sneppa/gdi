

import uebung04.*;
import static org.junit.Assert.*;
import gdi.MakeItSimple.GDIException;

import org.junit.Test;

public class ISBNToolkit1stTest {
	
	@Test
	public void twelveDigitISBN() {
		assertEquals(8, ISBNToolkit.computeCheckDigitForISBN13("978-3-7657-2781-"));
	}
	
	@Test(expected=GDIException.class)
	public void tooFewDigitsForComputation() {
		ISBNToolkit.computeCheckDigitForISBN13("978-3-7657-278");
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void validNumber() {
		assertTrue(ISBNToolkit.isISBN13Valid("978-3-7657-2781-8"));
	}
	
	@Test
	public void tooFewDigitsForValidation() {
		assertFalse(ISBNToolkit.isISBN13Valid("978-3-7657-2781-"));
	}
	
}
