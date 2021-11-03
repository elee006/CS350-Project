package edu.odu.cs.cs350;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;

//import edu.odu.cs.cs350.DupDetector;

public class SourceFile implements Comparable<SourceFile>
{
	/**
	 * The absolute path of this file
	 */
	private String path;
	
	/*
	 * Constructs a SourceFile using an absolute path
	 */
	public SourceFile( String p )
	{
		path = p;
	}
	
	/*
	 * Returns the absolute path of the file as a string
	 */
	public String getPath()
	{
		return path;
	}
	
	/*
	 * Prints the absolute path of the file to the console
	 */
	public void printPath()
	{
		System.out.println(path);
	}
	
	@Override
    public int compareTo( SourceFile rhs )
    {
		return this.getPath().compareTo( rhs.getPath() );
    }
}

//public class SourceFiles implements Iterable<SourceFile>
//{
//	private ArrayList<SourceFile> sf = new ArrayList();
//	
//	public void add( String s ) {
//		sf.add( new SourceFile(s) );
//	}
//	
//	public void remove( int index ) {
//		sf.remove(index);
//	}
//	
//	public void sort() {
//		Collections.sort(sf);
//	}
//	
//	@Override
//	public Iterator<SourceFile> iterator(){
//		return sf.iterator();
//	}
//}