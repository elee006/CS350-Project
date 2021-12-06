package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

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
		File fa = new File("a");
		File fb = new File("b");
		File fc = new File("c");
		
		try {
			sfs.printFiles();
		} catch (IOException e) {
			assertTrue(false);
		}
		String output = outputStreamCaptor.toString().trim();
		System.setOut(new PrintStream(outputStreamCaptor1));
		
		try {
			System.out.print(fa.getCanonicalPath());
		} catch (IOException e) {
			assertTrue(false);
		}
		try {
			System.out.print(fb.getCanonicalPath());
		} catch (IOException e) {
			assertTrue(false);
		}
		try {
			System.out.print(fc.getCanonicalPath());
		} catch (IOException e) {
			assertTrue(false);
		}
		
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
	
	@Test
	void testConstructorWithArrayList() throws NoSuchFileException {
		SourceFilesList sf1 = new SourceFilesList();
		String g1 = "adsffadsfdsfds6589393.txt";
		String g2 = "dkclvbjnxqoiewruyy.ini";
		File f1 = new File(g1);
		File f2 = new File(g2);
		
		if ( !f1.exists() ) {
			try {
				assertTrue(f1.createNewFile());
			} catch (IOException e) {
				assertTrue(false);
			}
		}
		
		if ( !f2.exists() ) {
			try {
				assertTrue(f2.createNewFile());
			} catch (IOException e) {
				assertTrue(false);
			}
		}
		
		String paths[] = {g1, g2};
		
		ArrayList<String> als = new ArrayList<String>();
		als.add(".ini"); als.add(".txt");
		
		sf1.add(g1); sf1.add(g2);
		SourceFilesList sf2 = new SourceFilesList(paths, als);
		
		assertEquals( sf1, sf2 );
		assertTrue(f1.delete());
		assertTrue(f2.delete());
	}
	
	@Test
	void testAddWithExtensions() {
		SourceFilesList sf1 = new SourceFilesList();
		String g1 = "adsffadsfdsfds6589393.txt";
		File f1 = new File(g1);
		
		if ( !f1.exists() ) {
			try {
				assertTrue(f1.createNewFile());
			} catch (IOException e) {
				assertTrue(false);
			}
		}
		
		sf1.add(g1);
		SourceFilesList sf2 = new SourceFilesList();
		
		ArrayList<String> extensions = new ArrayList<String>();
		extensions.add(".ini");
		try {
			sf2.add(g1, extensions);
		} catch (NoSuchFileException e) {
			assertTrue(false);
		}
		
		assertNotEquals( sf1, sf2 );
		
		extensions.add(".txt");
		
		try {
			sf2.add(g1, extensions);
		} catch (NoSuchFileException e) {
			assertTrue(false);
		}
		
		assertEquals( sf1, sf2 );
		assertTrue(f1.delete());
	}

	@Test
	void testAddRecursive() {
		SourceFilesList sf1 = new SourceFilesList();
		SourceFilesList sf2 = new SourceFilesList();
		SourceFilesList sf3 = new SourceFilesList();
		assertEquals( sf1.size(), 0 );
		assertEquals( sf2.size(), 0 );
		
		String directory = "adsffadsfdsfds6589393";
		String file = directory + SourceFile.separator + "dkclvbjnxqoiewruyy.cpp";
		File f1 = new File(directory);
		f1.mkdir();
		File f2 = new File(file);
		try {
			f2.createNewFile();
		} catch (IOException e) {
			assertTrue(false);
		}
		
		ArrayList<String> ext = new ArrayList<String>();
		
		try {
			sf1.addRecursive(directory, ext);
		} catch (NoSuchFileException e) {
			assertTrue(false);
		}
		
		sf2.add(directory);
		sf2.add(file);
		
		sf3.add(file);
		
		assertNotEquals( sf1, sf2 );
		
		ext.add(".cpp");
		
		try {
			sf1.addRecursive(directory, ext);
		} catch (NoSuchFileException e) {
			assertTrue(false);
		}
		
		assertNotEquals(sf1, sf2);
		assertEquals(sf1, sf3);
		
		assertTrue(f2.delete());
		assertTrue(f1.delete());

	}
	
}
