// This is a generated file. Not intended for manual editing.
package com.rythmplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.rythmplugin.psi.impl.*;

public interface RythmTypes {

  IElementType IMPORT = new RythmElementType("IMPORT");
  IElementType PROPERTY = new RythmElementType("PROPERTY");
  IElementType TEMPLATE_ARGS = new RythmElementType("TEMPLATE_ARGS");

  IElementType ARGS_DIRECTIVE = new RythmTokenType("ARGS_DIRECTIVE");
  IElementType COMMENT = new RythmTokenType("COMMENT");
  IElementType CRLF = new RythmTokenType("CRLF");
  IElementType IDENTIFIER = new RythmTokenType("IDENTIFIER");
  IElementType IMPORT_$ = new RythmTokenType("import_$");
  IElementType IMPORT_DIRECTIVE = new RythmTokenType("IMPORT_DIRECTIVE");
  IElementType IMPORT_VALUE = new RythmTokenType("IMPORT_VALUE");
  IElementType KEY = new RythmTokenType("KEY");
  IElementType SEPARATOR = new RythmTokenType("SEPARATOR");
  IElementType TYPE = new RythmTokenType("TYPE");
  IElementType VALUE = new RythmTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == IMPORT) {
        return new RythmImportImpl(node);
      }
      else if (type == PROPERTY) {
        return new RythmPropertyImpl(node);
      }
      else if (type == TEMPLATE_ARGS) {
        return new RythmTemplateArgsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
