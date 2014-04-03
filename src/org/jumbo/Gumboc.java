package org.jumbo;

import org.jumbo.Gumbo.GumboOptions;
import org.jumbo.Gumbo.GumboOutput;
import org.jumbo.Gumbo.SizeT;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public class Gumboc {

  public static void main(String[] args) {
//    Gumbo.GumboInternalOptions options = new Gumbo.GumboInternalOptions(); 
    
    Pointer p = NativeLibrary.getInstance("gumbo").getGlobalVariableAddress("kGumboDefaultOptions");
    GumboOptions options = new GumboOptions(p);
    String buffer = "<html><body>Merhaba !!!</body></html>";
    SizeT size = new SizeT((long)buffer.length());
    
    GumboOutput ali = Gumbo.INSTANCE.gumbo_parse_with_options(options, buffer, size);
    
    
  }
  
}
