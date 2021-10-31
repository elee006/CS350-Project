package main.java;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class main{
public static void main(String[] args) throws FileNotFoundException {
    Scanner inScanner = new Scanner(System.in);
inScanner.useDelimiter("\n");
System.out.print("Enter input file path and name:");
String inFile = inScanner.next();
System.out.println("You entered: " + inFile);           
FileInputStream fs = new FileInputStream(inFile);
}
}