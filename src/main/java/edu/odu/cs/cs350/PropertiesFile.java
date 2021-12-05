package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;

public class PropertiesFile {
	
	// Default number of suggestions to print
	static int nSuggestions;
	// Optional properties file
	static File propFile;
	
	public static void handleArguments(String[] args) {
		// Container for the files to be used
		SourceFilesList filesList;
		// File extensions to search for files
		ArrayList<String> fileExtensions = new ArrayList<String>();
		fileExtensions.add(".h"); fileExtensions.add(".cpp");
		// Position of the first file in args. If there is no properties file, this is 1; otherwise, it's 2.
		int positionOfFirstFile = 1;
		
		// No arguments passed - exit
		if ( args == null ) {
			System.out.println("Valid argument order: (number of suggested refactorings) (optional properties file) (files/directories to examine)");
			throw new IllegalArgumentException("No arguments passed.");
		}
		
		// Too few arguments passed - exit
		if ( args.length <= 1 ) {
			System.out.println("Valid argument order: (number of suggested refactorings) (optional properties file) (files/directories to examine)");
			throw new IllegalArgumentException("Too few arguments passed.");
		}
		
		// Try to make the first argument nSuggestions. If it isn't an int, exit
		try {
	        nSuggestions = Integer.parseInt(args[0]);
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Valid argument order: (number of suggested refactorings) (optional properties file) (files/directories to examine)");
	    	throw new IllegalArgumentException("First argument was not an integer.");
	    }
		
		// Check if there is a properties file. If there is, add it. Specifically, checks if the last 3 characters are .ini, which checks
		// that the extension is .ini. pos of first file also increases by 1 to account for that argument being the properties file and not something to analyze.
		if ( args[1].substring( args[1].length() - 4, args[1].length() ).equals(".ini") ) {
			propFile = new File(args[1]);
			positionOfFirstFile = 2;
			
			// If it doesn't exist, something went wrong. Exit so the user can fix it.
			if (!propFile.exists())
        		throw new IllegalArgumentException(propFile.getPath() + " does not exist.");
		}
		
		// Try adding the rest of the files
		try { 
			filesList = new SourceFilesList( Arrays.copyOfRange( args, positionOfFirstFile, args.length ), fileExtensions ); 
		} catch (NoSuchFileException nfe) { 
			System.out.println("Valid argument order: (number of suggested refactorings) (optional properties file) (files/directories to examine)"); 
			throw new IllegalArgumentException("One or more argument files did not exist."); 
		}
		 
		// NOTE: This works, it's just really annoying to have to make real files.
		
		filesList.sort();
		filesList.printFiles();
	}

	public static void main(String[] args) {
		handleArguments(args);
		
	}
	
}


