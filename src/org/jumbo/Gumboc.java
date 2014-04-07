package org.jumbo;

import org.jumbo.Gumbo.GumboOptions;
import org.jumbo.Gumbo.GumboOutput;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public class Gumboc {

  public static void main(String[] args) {
    Pointer p = NativeLibrary.getInstance("gumbo").getGlobalVariableAddress("kGumboDefaultOptions");
    GumboOptions options = new GumboOptions(p);
    String buffer = "<html><body>Merhaba !!!</body></html>";
    SizeT size = new SizeT((long)buffer.length());
    
//    Gumbo.GumboOptions.ByReference opRef = new Gumbo.GumboOptions.ByReference();

//    GumboOutput.ByReference ali =  Gumbo.INSTANCE.gumbo_parse_with_options(options.newByReference(), buffer, size);
    GumboOutput output =  Gumbo.INSTANCE.gumbo_parse_with_options(p, buffer, size);
    
    
//  GumboOutput ali =  Gumbo.INSTANCE.gumbo_parse( buffer);
    Gumbo.INSTANCE.gumbo_destroy_output(p,output);
  }
  
}
