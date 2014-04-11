package org.jumbo;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

public class Utils {
/*
  def _convert_attrs(attrs):
    # TODO(jdtang): Ideally attributes would pass along their positions as well,
    # but I can't extend the built in str objects with new attributes.  Maybe work
    # around this with a subclass in some way...
    return [(_utf8(attr.name), _utf8(attr.value)) for attr in attrs]
*/
  public static LinkedHashMap<String, String> _convert_attrs(){
    LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
    
    
    
    
    return result;
  }
  
  
/*
  def _utf8(text):
    return text.decode('utf-8', 'replace')
*/
  public static String Utf8(String text){
    String str = null;
    try {
      str = new String(text.getBytes(), "UTF-8");
    } catch (UnsupportedEncodingException e) {
    }
    return str;
  }
}
