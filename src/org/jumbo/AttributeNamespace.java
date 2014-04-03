package org.jumbo;

public enum AttributeNamespace {
  NONE("http://www.w3.org/1999/xhtml"),
  XLINK("http://www.w3.org/1999/xlink"),
  XML("http://www.w3.org/XML/1998/namespace"),
  XMLNS("http://www.w3.org/2000/xmlns");
  
  private String value;

  private AttributeNamespace(String value) {
    this.value = value;
  }


}
