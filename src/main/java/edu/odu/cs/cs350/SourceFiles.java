package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//import edu.odu.cs.cs350.DupDetector;

public class SourceFiles implements Iterable<SourceFile>
{
	private ArrayList<SourceFile> sf = new ArrayList<SourceFile>();
	
	/*
	 * Create an empty ArrayList of SourceFile s
	 */
	public SourceFiles() {
		
	}
	
	/*
	 * Create an ArrayList with an array of paths
	 */
	public SourceFiles( String[] str ) {
		for (String s: str) {
        	add(s);
        }
	}
	
	/*
	 * Add a single path
	 */
	public void add( String s ) {
		sf.add( new SourceFile(s) );
	}
	
	// Remove an element at index
	public void remove( int index ) {
		sf.remove(index);
	}
	
	// Get the number of elements
	public int size() {
		return sf.size();
	}
	
	// Get the SourceFile at index
	public SourceFile get( int index ) {
		return sf.get(index);
	}
	
	// Sort into ascending order
	public void sort() {
		Collections.sort(sf);
	}
	
	// Test if two SourceFiless (plural) are equal
	@Override
	public boolean equals( Object rhs ) {
		if (rhs == null || this == null) 
			return false;
		else if (this.getClass() != rhs.getClass()) 
			return false;
		//If not same size then not equal
		else if (size() != ((SourceFiles)rhs).size()) 
			return false;
		//Both empty, return true
		else if (size() == 0 && ((SourceFiles)rhs).size() == 0) 
			return true;
		
		for (int i = 0; i < size(); ++i) {
			if ( !this.get(i).getPath().equals( ((SourceFiles)rhs).get(i).getPath() ) ) return false;
		}
			return true;
	}
	
	// Print the file paths
	public void printFiles() {
		for ( SourceFile source : sf )
        {
        	source.printPath();
        }
	}
	
	// Create a string of all file paths
	@Override
	public String toString() {
		String s = new String();
		for ( SourceFile source: sf ) {
			s += source.getPath() + " ";
		}
		return s;
	}
	
	// A basic iterator, for iterator activities
	@Override
	public Iterator<SourceFile> iterator(){
		return sf.iterator();
	}
}