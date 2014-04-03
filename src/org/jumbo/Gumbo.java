package org.jumbo;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Callback;
import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.PointerByReference;

public interface Gumbo extends Library  {
  Gumbo INSTANCE = (Gumbo) Native.loadLibrary("gumbo", Gumbo.class);
  
  public static interface GumboNodeType {
    /**
     * Document node.  v will be a GumboDocument.<br>
     * <i>native declaration : line 8</i>
     */
    public static final int GUMBO_NODE_DOCUMENT = 0;
    /**
     * Element node.  v will be a GumboElement.<br>
     * <i>native declaration : line 10</i>
     */
    public static final int GUMBO_NODE_ELEMENT = 1;
    /**
     * Text node.  v will be a GumboText.<br>
     * <i>native declaration : line 12</i>
     */
    public static final int GUMBO_NODE_TEXT = 2;
    /**
     * CDATA node. v will be a GumboText.<br>
     * <i>native declaration : line 14</i>
     */
    public static final int GUMBO_NODE_CDATA = 3;
    /**
     * Comment node.  v. will be a GumboText, excluding comment delimiters.<br>
     * <i>native declaration : line 16</i>
     */
    public static final int GUMBO_NODE_COMMENT = 4;
    /**
     * Text node, where all contents is whitespace.  v will be a GumboText.<br>
     * <i>native declaration : line 18</i>
     */
    public static final int GUMBO_NODE_WHITESPACE = 5;
  };
  
  public class GumboNode extends Structure{
    /**
     * The type of node that this is.<br>
     * C type : GumboNodeType
     */
    public GumboNodeType type;
    /**
     * Pointer back to parent node.  Not owned.<br>
     * C type : GumboNode*
     */
    public GumboNode.ByReference parent;
    /** The index within the parent's children vector of this node. */
    public SizeT index_within_parent;
    /**
     * A bitvector of flags containing information about why this element was<br>
     * inserted into the parse tree, including a variety of special parse<br>
     * situations.<br>
     * C type : GumboParseFlags
     */
    public GumboParseFlags parse_flags;
    /**
     * The actual node data.<br>
     * C type : VUnion
     */
    public VUnion v;
    /** <i>native declaration : line 20</i> */
    public static class VUnion extends Union{
      /**
       * For GUMBO_NODE_DOCUMENT.<br>
       * C type : GumboDocument
       */
      public GumboDocument document;
      /**
       * For GUMBO_NODE_ELEMENT.<br>
       * C type : GumboElement
       */
      public GumboElement element;
      /**
       * For everything else.<br>
       * C type : GumboText
       */
      public GumboText text;
      public VUnion() {
        super();
      }
      /**
       * @param document For GUMBO_NODE_DOCUMENT.<br>
       * C type : GumboDocument
       */
      public VUnion(GumboDocument document) {
        super();
        this.document = document;
        setType(GumboDocument.class);
      }
      /**
       * @param text For everything else.<br>
       * C type : GumboText
       */
      public VUnion(GumboText text) {
        super();
        this.text = text;
        setType(GumboText.class);
      }
      /**
       * @param element For GUMBO_NODE_ELEMENT.<br>
       * C type : GumboElement
       */
      public VUnion(GumboElement element) {
        super();
        this.element = element;
        setType(GumboElement.class);
      }
      protected ByReference newByReference() { return new ByReference(); }
      protected ByValue newByValue() { return new ByValue(); }
      protected VUnion newInstance() { return new VUnion(); }
     
      public static class ByReference extends VUnion implements Structure.ByReference {
        
      };
      public static class ByValue extends VUnion implements Structure.ByValue {
        
      };
    };
    public GumboNode() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("type", "parent", "index_within_parent", "parse_flags", "v");
    }
    /**
     * @param type The type of node that this is.<br>
     * C type : GumboNodeType<br>
     * @param parent Pointer back to parent node.  Not owned.<br>
     * C type : GumboNode*<br>
     * @param index_within_parent The index within the parent's children vector of this node.<br>
     * @param parse_flags A bitvector of flags containing information about why this element was<br>
     * inserted into the parse tree, including a variety of special parse<br>
     * situations.<br>
     * C type : GumboParseFlags<br>
     * @param v The actual node data.<br>
     * C type : VUnion
     */
    public GumboNode(GumboNodeType type, GumboNode.ByReference parent, SizeT index_within_parent, GumboParseFlags parse_flags, VUnion v) {
      super();
      this.type = type;
      this.parent = parent;
      this.index_within_parent = index_within_parent;
      this.parse_flags = parse_flags;
      this.v = v;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboNode newInstance() { return new GumboNode(); }
   
    public static class ByReference extends GumboNode implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboNode implements Structure.ByValue {
      
    };
  }
  
  public class GumboVector extends Structure {
    /**
     * Data elements.  This points to a dynamically-allocated array of capacity<br>
     * elements, each a void* to the element itself.<br>
     * C type : void**
     */
    public PointerByReference data;
    /** Number of elements currently in the vector. */
    public int length;
    /** Current array capacity. */
    public int capacity;
    public GumboVector() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("data", "length", "capacity");
    }
    /**
     * @param data Data elements.  This points to a dynamically-allocated array of capacity<br>
     * elements, each a void* to the element itself.<br>
     * C type : void**<br>
     * @param length Number of elements currently in the vector.<br>
     * @param capacity Current array capacity.
     */
    public GumboVector(PointerByReference data, int length, int capacity) {
      super();
      this.data = data;
      this.length = length;
      this.capacity = capacity;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboVector newInstance() { return new GumboVector(); }
    public static class ByReference extends GumboVector implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboVector implements Structure.ByValue {
      
    };
  }
  
  public static class GumboOutput extends Structure{
    
    public Pointer document;
    
    public Pointer root;
    
    public GumboVector errors;

    protected List<? > getFieldOrder() {
      return Arrays.asList("document", "root", "errors");
    } 
  }
  
  public GumboOutput gumbo_parse_with_options(GumboOptions options, String buffer, SizeT size);
  
  public static class SizeT extends IntegerType {
    public SizeT() { this(0); }
    public SizeT(long value) { super(Native.SIZE_T_SIZE, value); }
  }
  
  public static class GumboOptions extends Structure {
    /**
     * A memory allocator function.  Default: malloc.<br>
     * C type : GumboAllocatorFunction
     */
    public Gumbo.GumboAllocatorFunction allocator;
    /**
     * A memory deallocator function. Default: free.<br>
     * C type : GumboDeallocatorFunction
     */
    public Gumbo.GumboDeallocatorFunction deallocator;
    /**
     * An opaque object that's passed in as the first argument to all callbacks<br>
     * used by this library.  Default: NULL.<br>
     * C type : void*
     */
    public Pointer userdata;
    /**
     * The tab-stop size, for computing positions in source code that uses tabs.<br>
     * Default: 8.
     */
    public int tab_stop;
    /**
     * Whether or not to stop parsing when the first error is encountered.<br>
     * Default: false.
     */
    public byte stop_on_first_error;
    /**
     * The maximum number of errors before the parser stops recording them.  This<br>
     * is provided so that if the page is totally borked, we don't completely fill<br>
     * up the errors vector and exhaust memory with useless redundant errors.  Set<br>
     * to -1 to disable the limit.<br>
     * Default: -1
     */
    public int max_errors;
    public GumboOptions() {
      super();
    }
    
    public GumboOptions(Pointer p){
      super(p);
      read();
    }
    
    protected List<? > getFieldOrder() {
      return Arrays.asList("allocator", "deallocator", "userdata", "tab_stop", "stop_on_first_error", "max_errors");
    }
    /**
     * @param allocator A memory allocator function.  Default: malloc.<br>
     * C type : GumboAllocatorFunction<br>
     * @param deallocator A memory deallocator function. Default: free.<br>
     * C type : GumboDeallocatorFunction<br>
     * @param userdata An opaque object that's passed in as the first argument to all callbacks<br>
     * used by this library.  Default: NULL.<br>
     * C type : void*<br>
     * @param tab_stop The tab-stop size, for computing positions in source code that uses tabs.<br>
     * Default: 8.<br>
     * @param stop_on_first_error Whether or not to stop parsing when the first error is encountered.<br>
     * Default: false.<br>
     * @param max_errors The maximum number of errors before the parser stops recording them.  This<br>
     * is provided so that if the page is totally borked, we don't completely fill<br>
     * up the errors vector and exhaust memory with useless redundant errors.  Set<br>
     * to -1 to disable the limit.<br>
     * Default: -1
     */
    public GumboOptions(Gumbo.GumboAllocatorFunction allocator, Gumbo.GumboDeallocatorFunction deallocator, Pointer userdata, int tab_stop, byte stop_on_first_error, int max_errors) {
      super();
      this.allocator = allocator;
      this.deallocator = deallocator;
      this.userdata = userdata;
      this.tab_stop = tab_stop;
      this.stop_on_first_error = stop_on_first_error;
      this.max_errors = max_errors;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboOptions newInstance() { return new GumboOptions(); }
    public static class ByReference extends GumboOptions implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboOptions implements Structure.ByValue {
      
    };
  };
  public interface GumboAllocatorFunction extends Callback {
    Pointer apply(Pointer userdata, SizeT size);
  };
  public interface GumboDeallocatorFunction extends Callback {
    void apply(Pointer userdata, Pointer ptr);
  };
  
}
