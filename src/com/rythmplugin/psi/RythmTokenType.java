package com.rythmplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.rythmplugin.RythmLanguage;
import org.jetbrains.annotations.*;

public class RythmTokenType extends IElementType {
  public RythmTokenType(@NotNull @NonNls String debugName) {
    super(debugName, RythmLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "RythmTokenType." + super.toString();
  }
}