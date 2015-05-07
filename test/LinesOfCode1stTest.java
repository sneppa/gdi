import uebung05.*;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class LinesOfCode1stTest {
	
	private static final String TEST_FILE_NAME = "HelloWorld.java";

	@BeforeClass
	public static void setUp() throws Exception {
		String[] content = {
				"package uebung06;", 
				"", 
				"import static gdi.MakeItSimple.*;", 
				"", 
				"public class HelloWorld {", 
				"	//Main Methode", 
				"    public static void main(String[] args) {", 
				"    	print(\"Hello \");", 
				"    	println(\"World!\");	// diese Zeile zählt", 
				"    }", 
				"}"
				};
		BufferedWriter out = new BufferedWriter(new FileWriter(TEST_FILE_NAME));
		for (String line : content) {
			out.write(line);
			out.newLine();
		}
		out.close();
	}
	
	@Test
	public void testCountLines() throws IOException {
		assertEquals(8, LinesOfCode.countLines(TEST_FILE_NAME));
	}

}
