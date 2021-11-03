package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import edu.odu.cs.cs350.SourceFile;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSourceFile {

	@Test
	void testConstructor() {
		String testPath = "path/to/file";
		SourceFile sf = new SourceFile(testPath);
		assertEquals( sf.getPath(), testPath );
	}
	
	/*
	 * Following code taken and modified from https://www.baeldung.com/java-testing-system-out-println
	 */
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void testPrintPath() {
		String testPath = "path/to/file";
		SourceFile sf = new SourceFile(testPath);
		
		sf.printPath();
	        
	    assertEquals( testPath, outputStreamCaptor.toString()
	      .trim() );
	}
	
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	/*
	 * End stolen code
	 */
	
	@Test
	void testCompareTo() {
		String testPath1 = "a";
		String testPath2 = "b";
		String testPath3 = "aa";
		SourceFile sf1 = new SourceFile(testPath1);
		SourceFile sf2 = new SourceFile(testPath2);
		SourceFile sf3 = new SourceFile(testPath3);
		
		assertEquals( sf1.compareTo(sf2), testPath1.compareTo(testPath2) );
		assertEquals( sf1.compareTo(sf3), testPath1.compareTo(testPath3) );
		assertEquals( sf2.compareTo(sf3), testPath2.compareTo(testPath3) );
	}
}
