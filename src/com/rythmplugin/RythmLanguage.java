package com.rythmplugin;

import com.intellij.lang.Language;

public class RythmLanguage extends Language {
  public static final RythmLanguage INSTANCE = new RythmLanguage();

  private RythmLanguage() {
    super("Rythm");
  }
}