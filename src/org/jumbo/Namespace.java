package org.jumbo;

public enum Namespace {
  HTML("http://www.w3.org/1999/xhtml"),
  SVG("http://www.w3.org/2000/svg"),
  MATHML("http://www.w3.org/1998/Math/MathML");
  
  private String value;
  
  private Namespace(String value){
    this.value = value;
  }

}
