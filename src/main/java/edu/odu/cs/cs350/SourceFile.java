package edu.odu.cs.cs350;

import java.io.File;

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
	
}