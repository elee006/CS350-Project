package edu.odu.cs.cs350;
//@SupressWarnings("unused")


/**
*https://git.cs.odu.edu/zeil/jflexdemo/-/blob/master/src/main/jflex/demo.jflex
*/
%%

%public
%class GeneratedScanner

%line 
%column

%type token 

%{
  StringBuilder string = new StringBuilder();
  
  private token symbol(TokenTypes type) {
    return new token(type, yyline+1, yycolumn+1);
  }

  private token symbol(TokenTypes type, String value) {
    return new token(type, yyline+1, yycolumn+1, value);
  }

%}
/**
*https://jflex.de/manual.html#Installing
*/
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Identifier = [:jletter:][:jletterdigit:]*
IntegerLiteral = [0-9][0-9]* | [0-9][_0-9]*[0-9]

%%


  {IntegerLiteral}            { return symbol(TokenTypes.INTEGER_LITERAL, yytext()); }

  {Identifier}                   { return symbol(TokenTypes.IDENTIFIER, yytext()); } 

        /* operators */
      "="                            { return symbol(TokenTypes.EQ); }
      "=="                           { return symbol(TokenTypes.EQEQ); }
      "+"                            { return symbol(TokenTypes.PLUS); }
  
{WhiteSpace}                  {/* Ignore: don't return anything. */} 

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                            "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(TokenTypes.EOF); }
