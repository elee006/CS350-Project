package edu.odu.cs.cs350;

import java.io.File;
import java.util.ArrayList;

public class SourceFile extends File
{
	
	/*
	 * Constructs a SourceFile using an absolute path
	 */
	public SourceFile( String p )
	{
		//path = p;
		super(p);
	}
	
	
	/*
	 * Prints the absolute path of the file to the console
	 */
	public void printPath()
	{
		System.out.println(getPath());	
	}
	
	public boolean checkExtension( ArrayList<String> extensions ) {
		for ( String str: extensions ) {
			if ( checkExtension(str) )
				return true;
		}
		return false;
	}
	
	public boolean checkExtension( String extension ) {
		if ( getName().length() >= extension.length() ) {
			if ( getName().substring( getName().length() - extension.length(), getName().length() ).equals(extension) )
				return true;
		}
		
		return false;
	}
	
}