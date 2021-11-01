package edu.odu.cs.cs350;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class token {
    private String lexeme;
    private int column_num;
    private int line_num;

    public void Token(String lexeme, int column_num, int line_num){
        this.lexeme = lexeme;
        this.column_num = column_num;
        this.line_num = line_num;
    }

    public int NumofTokens(File inputFile) throws FileNotFoundException{
        int TokenCount = 0;
        return TokenCount;
    }

}
