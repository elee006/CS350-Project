package edu.odu.cs.cs350;
import java.io.File;



//Take a Directory 
public class DirectoryPath
{
 //@param Directory name entered by the user  
String directoryName;
 // File object referring to the directory.
File directory;        
 // Array of file names in the directory.
String[] files; 

    public DirectoryPath(String directoryName){
            directory = new File(directoryName.trim());
    }
    public String[] setDirFiles(){
    return files = directory.list();
    }

    public void printDirFiles(){
        for (int i = 0; i < files.length; i++)
        System.out.println("   " + files[i]);
    }

    public int numofFiles(){
        return files.length;
    }
}














// public  class DirectoryPathList {
//     //Source: https://math.hws.edu/javanotes/source/chapter11/DirectoryList.java
    
//             // Directory name entered by the user.
//             private String directoryName;  
//             // File object referring to the directory.
//             private File directory;        
//             // Array of file names in the directory.
//             private String[] files;        


//             public DirectoryPathList(){

//             }

       

//        public String getDirectory(){
//            return directoryName.trim();
//        }

//        public void Directory(String d){
//            directoryName = d;
//     }

//        public String[] Flie(){}

//             directoryName = scanner.nextLine().trim();
//             directory = new File(directoryName);
//                 if (directory.exists() == false)
//                     System.out.println("This directory does not exist...");
//             else {
//                 return files = directory.list();
//     }
//     }
