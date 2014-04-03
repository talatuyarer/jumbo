package org.jumbo;

import com.sun.jna.Pointer;

public class Options {
  
  private Pointer allocator;
  private Pointer deallocator;
  private int tab_stop;
  private boolean stop_on_first_error;
  private int max_utf8_decode_errors;
  private boolean verbatim_mode;
  private boolean preserve_entities;
  
}
