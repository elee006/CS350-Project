package edu.odu.cs.cs350;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;


public class SourceFilesList extends ArrayList<SourceFile>
{	
	/*
	 * Create an empty ArrayList of SourceFile s
	 */
	public SourceFilesList() {
		
	}
	
	/*
	 * Create an ArrayList with an array of paths, without checking to see if they exist
	 */
	public SourceFilesList( String[] str ) {
		for (String s: str) {
	    	add(s);
	    }
	}
	
	/*
	 * Create an ArrayList with an array of paths, checking to see if they exist if b = true
	 */
	public SourceFilesList( String[] str, boolean b ) throws NoSuchFileException {
		for (String s: str) {
        	add(s);
        }
		if (b == true) {
			for ( SourceFile source : this )
	        {
	        	if (!source.exists())
	        		throw new NoSuchFileException(source.getPath());
	        }
		}
	}
	
	/*
	 * Create an ArrayList with an array of paths, checking to see if they exist and match the file extensions present in extensions
	 */
//	public SourceFilesList( String[] str, ArrayList<String> extensions ) throws NoSuchFileException {
//		for (String s: str) {
//        	add(s);
//        }
//		for ( SourceFile source : this )
//        {
//        	if (!source.exists())
//        		throw new NoSuchFileException(source.getPath());
//        	else {
//        		for ( String ext: extensions ) {
//        			
//        		}
//        	}
//        }
//	}
	
	/*
	 * Add a single path
	 */
	public void add( String s ) {
		add( new SourceFile(s) );
	}
	
	// Sort into ascending order
	public void sort() {
		Collections.sort(this);
	}
	
	// Print the file paths
	public void printFiles() {
		for ( SourceFile source : this )
        {
        	source.printPath();
        }
	}
}