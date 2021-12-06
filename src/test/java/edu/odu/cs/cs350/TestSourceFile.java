package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSourceFile {

	@Test
	void testConstructor() {
		String testPath = "path/to/file";
		SourceFile sf = new SourceFile(testPath);
		String realPath = "path" + SourceFile.separator + "to" + SourceFile.separator + "file";
		assertEquals( sf.getPath(), realPath );
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
		File testFile = new File(testPath);
		String realPath = "";
		try {
			realPath = testFile.getCanonicalPath();
		} catch (IOException e) {
			assertTrue(false);
		}
		
		try {
			sf.printPath();
		} catch (IOException e) {
			assertTrue(false);
		}
	        
	    assertEquals( realPath, outputStreamCaptor.toString()
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
	
	@Test
	void testCheckExtensionString() {
		String testExt = ".ini";
		String testCh = "a";
		String testEmpty = "";
		SourceFile sf1 = new SourceFile("a.ini");
		SourceFile sf2 = new SourceFile("a");
		
		assertTrue( sf1.checkExtension(testExt) );
		assertTrue( !sf1.checkExtension(testCh) );
		assertTrue( sf1.checkExtension(testEmpty) );
		
		assertTrue( !sf2.checkExtension(testExt) );
		assertTrue( sf2.checkExtension(testCh) );
		assertTrue( sf2.checkExtension(testEmpty) );
	}
	
	@Test
	void testCheckExtensionArrayList() {
		ArrayList<String> str = new ArrayList<String>();
		SourceFile sf1 = new SourceFile("a.ini");
		System.out.println(sf1.getName());
		
		assertTrue( !sf1.checkExtension(str) );
		str.add("a");
		assertTrue( !sf1.checkExtension(str) );
		str.add(".cpp");
		assertTrue( !sf1.checkExtension(str) );
		str.add(".ini");
		assertTrue( sf1.checkExtension(str) );
	}
}
