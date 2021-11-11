package edu.odu.cs.cs350;

import java.io.File;

public class PropertiesFile {
	
	// Default number of suggestions to print
	static int nSuggestions;
	// Optional properties file
	static File propFile;
	
	public static void handleArguments(String[] args) {
		// Container for the files to be used
		SourceFilesList filesList;
		
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
		// that the extension is .ini. Index also increases by 1 to account for that argument being the properties file and not something to analyze.
		int index = 1;
		if ( args[1].substring( args[1].length() - 4, args[1].length() ).equals(".ini") ) {
			propFile = new File(args[1]);
			index = 2;
			// If it doesn't exist, something went wrong. Exit so the user can fix it.
			if (!propFile.exists())
        		throw new IllegalArgumentException(propFile.getPath() + " does not exist.");
		}
		// Try adding the rest of the files
		/*
		 * try { filesList = new SourceFilesList( Arrays.copyOfRange( args, index,
		 * args.length ), true ); } catch (NoSuchFileException nfe) { System.out.
		 * println("Valid argument order: (number of suggested refactorings) (optional properties file) (files/directories to examine)"
		 * ); throw new
		 * IllegalArgumentException("One or more argument files did not exist."); }
		 */
		// NOTE: This works, it's just really annoying to have to make real files.
	}

	public static void main(String[] args) {
		handleArguments(args);
	}
	
}


