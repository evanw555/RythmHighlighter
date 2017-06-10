package com.rythmplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class RythmFileType extends LanguageFileType {
  public static final RythmFileType INSTANCE = new RythmFileType();

  private RythmFileType() {
    super(RythmLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Rythm file";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Rythm template language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "rythm";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return RythmIcons.FILE;
  }
}