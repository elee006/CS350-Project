package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSourceFilesList {

	@Test
	void testSourceFiles() {
		SourceFilesList sfs = new SourceFilesList();
		assertEquals(sfs.size(), 0);
	}

	@Test
	void testSourceFilesStringArray() {
		String str[] = {"a", "b", "c"};
		SourceFilesList sfs = new SourceFilesList(str);
		assertEquals(sfs.get(0).getPath(), "a");
		assertEquals(sfs.get(1).getPath(), "b");
		assertEquals(sfs.get(2).getPath(), "c");
	}

	@Test
	void testAdd() {
		SourceFilesList sfs = new SourceFilesList();
		sfs.add("abc");
		assertEquals(sfs.size(), 1);
		assertEquals(sfs.get(0).getPath(), "abc");
	}

	@Test
	void testRemove() {
		String str[] = {"a", "b", "c"};
		SourceFilesList sfs = new SourceFilesList(str);
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
		SourceFilesList sfs = new SourceFilesList();
		assertEquals(sfs.size(), 0);
		sfs.add("a");
		assertEquals(sfs.size(), 1);
		sfs.add("b");
		sfs.add("c");
		assertEquals(sfs.size(), 3);
	}

	@Test
	void testGet() {
		SourceFilesList sfs = new SourceFilesList();
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
		SourceFilesList sorted = new SourceFilesList(str);
		String str2[] = {"b", "a", "c"};
		SourceFilesList unsorted = new SourceFilesList(str2);
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
		SourceFilesList sfs = new SourceFilesList(str);
		
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
		SourceFilesList sf1 = new SourceFilesList();
		SourceFilesList sf2 = new SourceFilesList();
		assertEquals(sf1, sf2);
		
		String str[] = {"a", "b", "c"};
		SourceFilesList sorted = new SourceFilesList(str);
		SourceFilesList sorted1 = new SourceFilesList(str);
		String str2[] = {"b", "a", "c"};
		SourceFilesList unsorted = new SourceFilesList(str2);
		assertNotEquals(sorted, unsorted);
		assertEquals(sorted, sorted1);
	}

}