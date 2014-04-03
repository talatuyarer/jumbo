package com.sun.jna.examples;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

/** Simple example of JNA interface mapping and usage. */
public class HelloWorld {

    // This is the standard, stable way of mapping, which supports extensive
    // customization and mapping of Java to native types.
  /*
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
            Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                               CLibrary.class);

        void printf(String format, Object... args);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Hello, World\n");
        for (int i=0;i < args.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
    }
    */
  
    public static void main(String[] args) {
      Pointer p = NativeLibrary.getInstance("gumbo").getGlobalVariableAddress("kGumboDefaultOptions");
      p.getPointer(0);
//      System.out.println(Gumboc.INSTANCE.utf8_is_invalid_code_point(1));
      
    }
  
}