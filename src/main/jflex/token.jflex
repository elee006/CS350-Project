package edu.odu.cs.cs350;
//@SuprpressWarnings("unused")

%%
/**
*https://git.cs.odu.edu/zeil/jflexdemo/-/blob/master/src/main/jflex/demo.jflex
*/
%%

%public
%class GeneratedScanner

%line 
%column

%type Token 

%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenTypes type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

  private Token symbol(TokenTypes type, String value) {
    return new Token(type, yyline+1, yycolumn+1, value);
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

  {IntegerLiteral}            { return symbol(TokenKinds.INTEGER_LITERAL, yytext()); }

  {Identifier}                   { return symbol(TokenKinds.IDENTIFIER, yytext()); } 
  
{WhiteSpace}                  {/* Ignore: don't return anything. */} 
