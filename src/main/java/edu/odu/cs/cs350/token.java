package edu.odu.cs.cs350;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class token {
    private String lexeme;
    private int column_num;
    private int line_num;
    private TokenTypes type;


    public void Token(TokenTypes theType, int line, int column)
    {
        type = theType;
        lexeme = "";
        line_num = line;
        column_num = column;

    }
    public void Token(String thelexeme, int column, int line, TokenTypes theType){
        type = theType;
        column_num = column;
        line = line_num;
        lexeme = thelexeme;

    }

    public int NumofTokens() {
        int TokenCount = 0;
        while (getLexeme().length() < 0)
        {
            TokenCount++;
        }
        return TokenCount;
    }

    public final TokenTypes getType() {
        return type;
    }

    public final String getLexeme(){
        return lexeme;
    }

    public int getLineNum(){
        return line_num;
    }

    public int getColumnNum(){
        return column_num;
    }




}
