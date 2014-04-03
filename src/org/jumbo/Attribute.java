package org.jumbo;

public class Attribute {
  private AttributeNamespace namespace;
  private String name;
  private String value;
  private StringPiece original_name;
  private StringPiece original_value;
  private SourcePosition name_start;
  private SourcePosition name_end;
  private SourcePosition value_start;
  private SourcePosition value_end;
}
