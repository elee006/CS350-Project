package edu.odu.cs.cs350;

import java.io.File;
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
	public SourceFilesList( String[] path, ArrayList<String> extensions ) throws NoSuchFileException {
		for (String s: path) {
        	File f1 = new File(s);
        	if( !f1.isDirectory() )
        		add(s);
        	else
        		addRecursive(s, extensions);
        }
	}
	
	/*
	 * Add a single path if it ends in an extension contained in the ArrayList extensions
	 */	
	public void add( String path, ArrayList<String> extensions ) throws NoSuchFileException {
		SourceFile source = new SourceFile(path);
		
		if (!source.exists())
    		throw new NoSuchFileException(source.getPath());
    	else {
			if ( source.checkExtension(extensions) )
				add(source);
    	}
	}

		/*
	 * Add a single path, and if the file is a directory, add all files and directories it contains.
	 */
	public void addRecursive( String path, ArrayList<String> extensions ) throws NoSuchFileException {
		SourceFile fileToAdd = new SourceFile(path);
		if( !fileToAdd.isDirectory() ) {
			try {
				add(path, extensions);
			} catch (NoSuchFileException e) {
				throw new NoSuchFileException(fileToAdd.getPath());
			}
		}
		else {
			String[] filesList = fileToAdd.list();
			for( String file: filesList ) {
				file = fileToAdd.getPath() + SourceFile.separator + file;
				addRecursive( file, extensions );
			}
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