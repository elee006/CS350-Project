package edu.odu.cs.cs350;
/**
 * contains code from https://git.cs.odu.edu/zeil/jflexdemo/-/blob/master/src/main/java/edu/odu/cs/cs350/jflexdemo/TokenStream.java
 */
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TokenStream implements Iterable<token>{
    private List<token> tokens;

    public TokenStream(final Reader input){
        tokens = new LinkedList<token>();
        GeneratedScanner scanner = new GeneratedScanner (input);
        try {
            token token = scanner.yylex();
            while (token != null && token.getType() != TokenTypes.EOF) {
                tokens.add (token);
                token = scanner.yylex();
            }
        } catch (IOException ex) {
        }


    }
    @Override
    public final Iterator<token> iterator() {
        return tokens.iterator();
    }

}
