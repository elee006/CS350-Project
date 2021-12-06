package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;


public class SourceFilesList extends ArrayList<SourceFile>
{	
	/**
	 * Create an empty ArrayList of SourceFile s
	 */
	public SourceFilesList() {
		
	}
	
	/**
	 * Create an ArrayList with an array of paths, without checking to see if they exist
	 * @param str The array of paths to construct the SourceFiles
	 */
	public SourceFilesList( String[] str ) {
		for (String s: str) {
	    	add(s);
	    }
	}
	
	/**
	 * Create an ArrayList with an array of paths, checking to see if they exist if b = true
	 * @param srt The array of paths to construct the SourceFiles
	 * @param b The boolean to determine whether or not to check if the files exist
	 * @throws NoSuchFileException
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
	
	/**
	 * Create an ArrayList with an array of paths, checking to see if they exist and adding files found in
	 * directories if they match the file extensions present in extensions.
	 * This is used primarily to call addRecursive on directories and add on normal files specified directly,
	 * since it seems more useful to be able to analyze, for example, c_code_wip.txt in addition to normal C++ files
	 * without having to analyze every file ending in .txt.
	 * @param path The array of paths to construct the SourceFiles
	 * @param extensions The collection of extensions to require the files to match, if they were specified through a directory
	 * @throws NoSuchFileException
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
	
	/**
	 * Add a single path if it ends in an extension contained in the ArrayList extensions
	 * @param path The string specifying the path to a file
	 * @param extensions The collection of extensions to require the file to match
	 * @throws NoSuchFileException
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

	/**
	 * Add a single path, and if the file is a directory, add all files and directories it contains.
	 * @param path The string specifying the path to a file
	 * @param extensions The collection of extensions to require the files to match
	 * @throws NoSuchFileException
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

	
	/**
	 * Add a single path
	 * @param s The string containing the path to the file
	 */
	public void add( String s ) {
		add( new SourceFile(s) );
	}
	
	
	
	/**
	 *  Sort into ascending order
	 */
	public void sort() {
		Collections.sort(this);
	}
	
	/**
	 * Print the file paths
	 * @throws IOException
	 */
	public void printFiles() throws IOException {
		for ( SourceFile source : this )
        {
        	System.out.println(source.getCanonicalPath());
        }
	}
}