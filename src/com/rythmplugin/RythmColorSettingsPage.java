package com.rythmplugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class RythmColorSettingsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
      new AttributesDescriptor("Directive", RythmSyntaxHighlighter.DIRECTIVE),
      new AttributesDescriptor("Separator", RythmSyntaxHighlighter.SEPARATOR),
      new AttributesDescriptor("Value", RythmSyntaxHighlighter.VALUE),
      new AttributesDescriptor("Comment", RythmSyntaxHighlighter.COMMENT),
      new AttributesDescriptor("Identifier", RythmSyntaxHighlighter.IDENTIFIER),
  };

  @Nullable
  @Override
  public Icon getIcon() {
    return RythmIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new RythmSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "import com.linkedin.restli.datagenerator.csharp.CSharpType;\n" +
        "@import org.rythmengine.RythmEngine;\n" +
        "@args CSharpType cSharpType, RythmEngine engine\n\n" +
        "@*\nThis is a multiline comment!\nLook at it go!\n*@\n\n" +
        "// This is a java/C# comment\n\n" +
        "@// This is a rythm line comment!\n" +
        "public class @cSharpType.getName()\n" +
        "{\n" +
        "@if (cSharpType instanceof CSharpPrimitive) {\n" +
        "  private int primitiveId;\n" +
        "}\n" +
        "  private double alwaysHasField;\n" +
        "}\n" +
        "# Add spaces to the key\n" +
        "key\\ with\\ spaces = This is the value that could be looked up with the key \"key with spaces\".\n" +
        "# Unicode\n" +
        "tab : \\u0009";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Rythm";
  }
}