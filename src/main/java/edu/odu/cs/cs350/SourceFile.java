package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SourceFile extends File
{
	
	/*
	 * Constructs a SourceFile using an absolute path
	 */
	public SourceFile( String p )
	{
		super(p);
	}
	
	
	/*
	 * Prints the absolute path of the file to the console
	 */
	public void printPath() throws IOException
	{
		System.out.print(getCanonicalPath());	
	}
	
	/*
	 * Returns true if this SourceFile has an extension contained in the ArrayList extensions
	 */
	public boolean checkExtension( ArrayList<String> extensions ) {
		for ( String str: extensions ) {
			if ( checkExtension(str) )
				return true;
		}
		return false;
	}
	
	/*
	 * Returns true if this SourceFile ends in the extension in extension
	 */
	public boolean checkExtension( String extension ) {
		if ( getName().length() >= extension.length() ) {
			if ( getName().endsWith( extension ) )
				return true;
		}
		
		return false;
	}
	
}