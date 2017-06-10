package com.rythmplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.rythmplugin.RythmLanguage;
import org.jetbrains.annotations.*;

public class RythmElementType extends IElementType {
  public RythmElementType(@NotNull @NonNls String debugName) {
    super(debugName, RythmLanguage.INSTANCE);
  }
}