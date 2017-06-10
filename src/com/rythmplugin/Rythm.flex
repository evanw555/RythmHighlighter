package com.rythmplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.rythmplugin.psi.RythmTypes;
import com.intellij.psi.TokenType;

%%

%class RythmLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
  boolean argsWaitingType = true;

%}

NamespaceChar=[\w\.]
Identifier=[a-zA-Z_][a-zA-Z_0-9]*
Comma=","

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".

END_OF_LINE_COMMENT=("@//")[^\r\n]*
MULTILINE_COMMENT=("@*")[^@*]*("*@")

SEPARATOR=[:=]
KEY_CHARACTER=[^:=@\ \n\t\f\\] | "\\ "

%state WAITING_VALUE IMPORT ARGS

%%

<YYINITIAL> {END_OF_LINE_COMMENT}|{MULTILINE_COMMENT}       { yybegin(YYINITIAL); return RythmTypes.COMMENT; }

<YYINITIAL> "@import"                                       { yybegin(IMPORT); return RythmTypes.IMPORT_DIRECTIVE; }

<IMPORT> {

  {NamespaceChar}+ ";"                                      { yybegin(YYINITIAL); return RythmTypes.IMPORT_VALUE; }

}

<YYINITIAL> "@args"                                         { yybegin(ARGS); return RythmTypes.ARGS_DIRECTIVE; }

<ARGS> {

  {Identifier}{Comma}?                            { argsWaitingType = !argsWaitingType; return argsWaitingType ? RythmTypes.IDENTIFIER : RythmTypes.TYPE; }

  {CRLF}                                          { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

}



<YYINITIAL> {Identifier} "NOTHINGWILLMATHCME"               { yybegin(YYINITIAL); return RythmTypes.TYPE; }

<YYINITIAL> {Identifier}{Comma}?                            { yybegin(YYINITIAL); return RythmTypes.IDENTIFIER; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return RythmTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return RythmTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return RythmTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }