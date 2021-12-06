package edu.odu.cs.cs350;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * Token Class that stores the token type, the lexeme,
 * and the location
 * contains code from https://git.cs.odu.edu/zeil/jflexdemo/-/blob/master/src/main/java/edu/odu/cs/cs350/jflexdemo/Token.java
 */
public class token {
    /**
     * For variables, literals, and operators
     */
    private String lexeme;
    /**
     * Where is is located in the file?
     */
    private int column_num;
    /**
     * Where is it located in the file?
     */
    private int line_num;
    /**
     * What type of token is this?
     */
    private TokenTypes type;

/**
 * Create a token without an explicit lexeme.
 * @param theType
 * @param line
 * @param column
 */
    public token(final TokenTypes theType,final int line,final int column)
    {
        type = theType;
        lexeme = "";
        line_num = line;
        column_num = column;

    }
    /**
     * Create a token.
     * @param theType
     * @param line
     * @param column
     * @param thelexeme
     */
    public token(final TokenTypes theType,final int line,final int column,final String thelexeme){
        type = theType;
        column_num = column;
        line_num = line;
        lexeme = thelexeme;

    }
    /**
     * Finds the total number of tokens
     */
    public int NumofTokens() {
        int TokenCount = 0;
        while (getLexeme().length() < 0)
        {
            TokenCount++;
        }
        return TokenCount;
    }
/**
 * Finds the type of token
 * @return theType
 */
    public final TokenTypes getType() {
        return type;
    }
/**
 * Finds the character string that goes with the token
 * @return lexeme
 */
    public final String getLexeme(){
        return lexeme;
    }
/**
 * @return the line number
 */
    public int getLineNum(){
        return line_num;
    }
/**
 * @return the line number
 */
    public int getColumnNum(){
        return column_num;
    }




}
