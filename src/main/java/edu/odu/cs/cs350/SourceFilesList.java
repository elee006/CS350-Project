package edu.odu.cs.cs350;

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
	 * Create an ArrayList with an array of paths
	 */
	public SourceFilesList( String[] str ) {
		for (String s: str) {
        	add(s);
        }
	}
	
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