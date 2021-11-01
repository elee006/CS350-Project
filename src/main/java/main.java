package main.java;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class main{
public static void main(String[] args) throws FileNotFoundException {
    Scanner inScanner = new Scanner(System.in);
inScanner.useDelimiter("\n");
int numFiles = 10;
int count;
System.out.println("How many files would you like to be examined?");
numFiles = inScanner.nextInt();
for(count=0; count<numFiles;count++){

System.out.print("Enter input file path and name:");
String inFile = inScanner.next();
System.out.println("You entered: " + inFile);           
FileInputStream fs = new FileInputStream(inFile);
        }
    }
}

public  class DirectoryPath {
        // Directory name entered by the user.
        String directoryName;  
        // File object referring to the directory.
        File directory;        
        // Array of file names in the directory.
        String[] files;        
        // For reading a line of input from the user.
        Scanner scanner;       
        scanner = new Scanner(System.in);  
        System.out.print("Enter a directory name: ");
        directoryName = scanner.nextLine().trim();
        directory = new File(directoryName);
        if (directory.isDirectory() == false) {
            if (directory.exists() == false)
                System.out.println("This directory does not exist...");
            else
                System.out.println("That file is not a directory.");
        }
        else {
            files = directory.list();
            System.out.println("Files in directory \"" + directory + "\":");
            for (int i = 0; i < files.length; i++)
                System.out.println("   " + files[i]);
}
}