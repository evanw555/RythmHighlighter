package com.rythmplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class RythmLexerAdapter extends FlexAdapter {
  public RythmLexerAdapter() {
    super(new RythmLexer((Reader) null));
  }
}
