package org.jumbo;

public class Element {
  private NodeVector children;
  private Tag tag;
  private Namespace tag_namespace;
  private StringPiece original_tag;
  private StringPiece original_end_tag;
  private SourcePosition start_pos;
  private SourcePosition end_pos;
  private Vector attributes;
}
