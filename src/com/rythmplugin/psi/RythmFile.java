package com.rythmplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.rythmplugin.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RythmFile extends PsiFileBase {
  public RythmFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, RythmLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return RythmFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Rythm File";
  }

  @Override
  public Icon getIcon(int flags) {
    return super.getIcon(flags);
  }
}