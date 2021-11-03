package edu.odu.cs.cs350;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SourceFilesTest {

	@Test
	void testSourceFiles() {
		SourceFiles sfs = new SourceFiles();
		assertEquals(sfs.size(), 0);
	}

	@Test
	void testSourceFilesStringArray() {
		String str[] = {"a", "b", "c"};
		SourceFiles sfs = new SourceFiles(str);
		assertEquals(sfs.get(0).getPath(), "a");
		assertEquals(sfs.get(1).getPath(), "b");
		assertEquals(sfs.get(2).getPath(), "c");
	}

	@Test
	void testAdd() {
		SourceFiles sfs = new SourceFiles();
		sfs.add("abc");
		assertEquals(sfs.size(), 1);
		assertEquals(sfs.get(0).getPath(), "abc");
	}

	@Test
	void testRemove() {
		String str[] = {"a", "b", "c"};
		SourceFiles sfs = new SourceFiles(str);
		sfs.remove(0);
		assertEquals(sfs.get(0).getPath(), "b");
		assertEquals(sfs.get(1).getPath(), "c");
		assertEquals(sfs.size(), 2);
		sfs.remove(0);
		assertEquals(sfs.get(0).getPath(), "c");
		assertEquals(sfs.size(), 1);
		sfs.remove(0);
		assertEquals(sfs.size(), 0);
	}

	@Test
	void testSize() {
		SourceFiles sfs = new SourceFiles();
		assertEquals(sfs.size(), 0);
		sfs.add("a");
		assertEquals(sfs.size(), 1);
		sfs.add("b");
		sfs.add("c");
		assertEquals(sfs.size(), 3);
	}

	@Test
	void testGet() {
		SourceFiles sfs = new SourceFiles();
		sfs.add("a");
		assertEquals(sfs.get(0).getPath(), "a");
		sfs.add("b");
		assertEquals(sfs.get(1).getPath(), "b");
		sfs.add("c");
		assertEquals(sfs.get(2).getPath(), "c");
	}

	@Test
	void testSort() {
		String str[] = {"a", "b", "c"};
		SourceFiles sorted = new SourceFiles(str);
		String str2[] = {"b", "a", "c"};
		SourceFiles unsorted = new SourceFiles(str2);
		assertNotEquals(sorted, unsorted);
		unsorted.sort();
		assertEquals(sorted, unsorted);
	}

	/*
	 * Following code taken and modified from https://www.baeldung.com/java-testing-system-out-println
	 */
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final ByteArrayOutputStream outputStreamCaptor1 = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void testPrintFiles() {
		String str[] = {"a", "b", "c"};
		SourceFiles sfs = new SourceFiles(str);
		
		sfs.printFiles();
		String output = outputStreamCaptor.toString().trim();
		System.setOut(new PrintStream(outputStreamCaptor1));
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
		String output1 = outputStreamCaptor1.toString().trim();
		
		assertEquals(output, output1);
	}
	
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	/*
	 * End stolen code
	 */
	
	
	@Test
	void testEquals() {
		SourceFiles sf1 = new SourceFiles();
		SourceFiles sf2 = new SourceFiles();
		assertEquals(sf1, sf2);
		
		String str[] = {"a", "b", "c"};
		SourceFiles sorted = new SourceFiles(str);
		SourceFiles sorted1 = new SourceFiles(str);
		String str2[] = {"b", "a", "c"};
		SourceFiles unsorted = new SourceFiles(str2);
		assertNotEquals(sorted, unsorted);
		assertEquals(sorted, sorted1);
	}

}
