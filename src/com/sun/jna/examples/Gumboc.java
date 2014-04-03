package com.sun.jna.examples;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Gumboc extends Library {
  Gumboc INSTANCE = (Gumboc) Native.loadLibrary("gumbo",Gumboc.class);
  
  
  
  boolean utf8_is_invalid_code_point(int c);
}