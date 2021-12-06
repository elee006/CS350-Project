package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestPropertiesFile {
	
	/*
	 * Following code taken from https://www.baeldung.com/junit-assert-exception
	 */	
	@Test
	void testNoArgumentsPassed() {
		PropertiesFile pf = new PropertiesFile();
		String nullString[] = null;
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			pf.handleArguments(nullString);
	    });

	    String expectedMessage = "No arguments passed.";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testOneArgumentPassed() {
		PropertiesFile pf = new PropertiesFile();
		String oneString[] = {""};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			pf.handleArguments(oneString);
	    });

	    String expectedMessage = "Too few arguments passed.";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testFirstArgumentInt() {
		PropertiesFile pf = new PropertiesFile();
		String oneString[] = {"a", "b"};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			pf.handleArguments(oneString);
	    });

	    String expectedMessage = "First argument was not an integer.";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testPropertiesFile() {
		PropertiesFile pf = new PropertiesFile();
		String path = "doesntexist.ini";
		String oneString[] = {"1", path};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			pf.handleArguments(oneString);
	    });

	    String expectedMessage = path + " does not exist.";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
