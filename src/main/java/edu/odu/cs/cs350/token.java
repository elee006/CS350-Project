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


    public token(final TokenTypes theType,final int line,final int column)
    {
        type = theType;
        lexeme = "";
        line_num = line;
        column_num = column;

    }
    public token(final TokenTypes theType,final int line,final int column,final String thelexeme){
        type = theType;
        column_num = column;
        line_num = line;
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
