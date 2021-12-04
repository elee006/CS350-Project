package edu.odu.cs.cs350;
import java.io.File;
import java.io.FilenameFilter;

//Takes a given Directory and prints out files (also prints sub directories.) 
public class DirectoryPath 
{
 //Directory name entered by the user  
String dirName;
 // File object referring to the directory.
File dir;        
 // Array of file names in the directory.
String[] files; 
    public DirectoryPath(String dirName){
        File dir = new File(dirName.trim());
            // dir = new File(dirName.trim());
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    
                    return name.endsWith(".cpp");
                }
            });
            // files = directory.list(); 
        }
    public void printDirFiles(){
        for (int i = 0; i < files.length; i++)
        System.out.println("   " + files[i]);
    }
    public int numofFiles(){
        return files.length;
    }

}
