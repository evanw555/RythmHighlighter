// This is a generated file. Not intended for manual editing.
package com.rythmplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.rythmplugin.psi.RythmTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RythmParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == IMPORT) {
      r = consumeToken(b, IMPORT_$);
    }
    else if (t == PROPERTY) {
      r = property(b, 0);
    }
    else if (t == TEMPLATE_ARGS) {
      r = templateArgs(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return rythmFile(b, l + 1);
  }

  /* ********************************************************** */
  // IMPORT_DIRECTIVE IMPORT_VALUE
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, IMPORT_DIRECTIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT_DIRECTIVE, IMPORT_VALUE);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    if (!nextTokenIs(b, "", COMMENT, CRLF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, "<property>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // import* templateArgs* item_*
  static boolean rythmFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rythmFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rythmFile_0(b, l + 1);
    r = r && rythmFile_1(b, l + 1);
    r = r && rythmFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // import*
  private static boolean rythmFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rythmFile_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!import_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rythmFile_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // templateArgs*
  private static boolean rythmFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rythmFile_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!templateArgs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rythmFile_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // item_*
  private static boolean rythmFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rythmFile_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rythmFile_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ARGS_DIRECTIVE (IDENTIFIER|TYPE IDENTIFIER)+ CRLF
  public static boolean templateArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateArgs")) return false;
    if (!nextTokenIs(b, ARGS_DIRECTIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARGS_DIRECTIVE);
    r = r && templateArgs_1(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, m, TEMPLATE_ARGS, r);
    return r;
  }

  // (IDENTIFIER|TYPE IDENTIFIER)+
  private static boolean templateArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateArgs_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = templateArgs_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!templateArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "templateArgs_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER|TYPE IDENTIFIER
  private static boolean templateArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = parseTokens(b, 0, TYPE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

}
