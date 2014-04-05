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
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface Gumbo extends Library  {
  Gumbo INSTANCE = (Gumbo) Native.loadLibrary("gumbo", Gumbo.class);
  
  public static class GumboText extends Structure{
    /**
     * The text of this node, after entities have been parsed and decoded.  For<br>
     * comment/cdata nodes, this does not include the comment delimiters.<br>
     * C type : const char*
     */
    public Pointer text;
    /**
     * The original text of this node, as a pointer into the original buffer.  For<br>
     * comment/cdata nodes, this includes the comment delimiters.<br>
     * C type : GumboStringPiece
     */
    public GumboStringPiece original_text;
    /**
     * The starting position of this node.  This corresponds to the position of<br>
     * original_text, before entities are decoded.<br>
     * C type : GumboSourcePosition
     */
    public GumboSourcePosition start_pos;
    public GumboText() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("text", "original_text", "start_pos");
    }
    /**
     * @param text The text of this node, after entities have been parsed and decoded.  For<br>
     * comment/cdata nodes, this does not include the comment delimiters.<br>
     * C type : const char*<br>
     * @param original_text The original text of this node, as a pointer into the original buffer.  For<br>
     * comment/cdata nodes, this includes the comment delimiters.<br>
     * C type : GumboStringPiece<br>
     * @param start_pos The starting position of this node.  This corresponds to the position of<br>
     * original_text, before entities are decoded.<br>
     * C type : GumboSourcePosition
     */
    public GumboText(Pointer text, GumboStringPiece original_text, GumboSourcePosition start_pos) {
      super();
      this.text = text;
      this.original_text = original_text;
      this.start_pos = start_pos;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboText newInstance() { return new GumboText(); }
  
    public static class ByReference extends GumboText implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboText implements Structure.ByValue {
      
    };
  };
  
  public static class GumboStringPiece extends Structure{
    /**
     * A pointer to the beginning of the string.  NULL iff length == 0.<br>
     * C type : const char*
     */
    public Pointer data;
    /** The length of the string fragment, in bytes.  May be zero. */
    public SizeT length;
    public GumboStringPiece() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("data", "length");
    }
    /**
     * @param data A pointer to the beginning of the string.  NULL iff length == 0.<br>
     * C type : const char*<br>
     * @param length The length of the string fragment, in bytes.  May be zero.
     */
    public GumboStringPiece(Pointer data, SizeT length) {
      super();
      this.data = data;
      this.length = length;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboStringPiece newInstance() { return new GumboStringPiece(); }
    public static class ByReference extends GumboStringPiece implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboStringPiece implements Structure.ByValue {
      
    };
  };
  
  public static class GumboSourcePosition extends Structure{
    public int line;
    public int column;
    public int offset;
    public GumboSourcePosition() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("line", "column", "offset");
    }
    public GumboSourcePosition(int line, int column, int offset) {
      super();
      this.line = line;
      this.column = column;
      this.offset = offset;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboSourcePosition newInstance() { return new GumboSourcePosition(); }
    public static class ByReference extends GumboSourcePosition implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboSourcePosition implements Structure.ByValue {
      
    };
  };
  
  public static class GumboElement extends Structure{
    /**
     * An array of GumboNodes, containing the children of this element.  Pointers<br>
     * are owned.<br>
     * GumboNode*<br>
     * C type : GumboVector
     */
    public GumboVector children;
    /**
     * The GumboTag enum for this element.<br>
     * C type : GumboTag
     */
    public int tag;
    /**
     * The GumboNamespaceEnum for this element.<br>
     * C type : GumboNamespaceEnum
     */
    public int tag_namespace;
    /**
     * A GumboStringPiece pointing to the original tag text for this element,<br>
     * pointing directly into the source buffer.  If the tag was inserted<br>
     * algorithmically (for example, <head> or <tbody> insertion), this will be a<br>
     * zero-length string.<br>
     * C type : GumboStringPiece
     */
    public GumboStringPiece original_tag;
    /**
     * A GumboStringPiece pointing to the original end tag text for this element.<br>
     * If the end tag was inserted algorithmically, (for example, closing a<br>
     * self-closing tag), this will be a zero-length string.<br>
     * C type : GumboStringPiece
     */
    public GumboStringPiece original_end_tag;
    /**
     * The source position for the start of the start tag.<br>
     * C type : GumboSourcePosition
     */
    public GumboSourcePosition start_pos;
    /**
     * The source position for the start of the end tag.<br>
     * C type : GumboSourcePosition
     */
    public GumboSourcePosition end_pos;
    /**
     * An array of GumboAttributes, containing the attributes for this tag in the<br>
     * order that they were parsed.  Pointers are owned.<br>
     * GumboAttribute*<br>
     * C type : GumboVector
     */
    public GumboVector attributes;
    public GumboElement() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("children", "tag", "tag_namespace", "original_tag", "original_end_tag", "start_pos", "end_pos", "attributes");
    }
    /**
     * @param children An array of GumboNodes, containing the children of this element.  Pointers<br>
     * are owned.<br>
     * GumboNode*<br>
     * C type : GumboVector<br>
     * @param tag The GumboTag enum for this element.<br>
     * C type : GumboTag<br>
     * @param tag_namespace The GumboNamespaceEnum for this element.<br>
     * C type : GumboNamespaceEnum<br>
     * @param original_tag A GumboStringPiece pointing to the original tag text for this element,<br>
     * pointing directly into the source buffer.  If the tag was inserted<br>
     * algorithmically (for example, <head> or <tbody> insertion), this will be a<br>
     * zero-length string.<br>
     * C type : GumboStringPiece<br>
     * @param original_end_tag A GumboStringPiece pointing to the original end tag text for this element.<br>
     * If the end tag was inserted algorithmically, (for example, closing a<br>
     * self-closing tag), this will be a zero-length string.<br>
     * C type : GumboStringPiece<br>
     * @param start_pos The source position for the start of the start tag.<br>
     * C type : GumboSourcePosition<br>
     * @param end_pos The source position for the start of the end tag.<br>
     * C type : GumboSourcePosition<br>
     * @param attributes An array of GumboAttributes, containing the attributes for this tag in the<br>
     * order that they were parsed.  Pointers are owned.<br>
     * GumboAttribute*<br>
     * C type : GumboVector
     */
    public GumboElement(GumboVector children, int tag, int tag_namespace, GumboStringPiece original_tag, GumboStringPiece original_end_tag, GumboSourcePosition start_pos, GumboSourcePosition end_pos, GumboVector attributes) {
      super();
      this.children = children;
      this.tag = tag;
      this.tag_namespace = tag_namespace;
      this.original_tag = original_tag;
      this.original_end_tag = original_end_tag;
      this.start_pos = start_pos;
      this.end_pos = end_pos;
      this.attributes = attributes;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboElement newInstance() { return new GumboElement(); }
    public static class ByReference extends GumboElement implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboElement implements Structure.ByValue {
      
    };
  };
  /** enum values */
  public static interface GumboTag {
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/semantics.html#the-root-element<br>
     * <i>native declaration : line 16</i>
     */
    public static final int GUMBO_TAG_HTML = 0;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/semantics.html#document-metadata<br>
     * <i>native declaration : line 18</i>
     */
    public static final int GUMBO_TAG_HEAD = 1;
    /** <i>native declaration : line 19</i> */
    public static final int GUMBO_TAG_TITLE = 2;
    /** <i>native declaration : line 20</i> */
    public static final int GUMBO_TAG_BASE = 3;
    /** <i>native declaration : line 21</i> */
    public static final int GUMBO_TAG_LINK = 4;
    /** <i>native declaration : line 22</i> */
    public static final int GUMBO_TAG_META = 5;
    /** <i>native declaration : line 23</i> */
    public static final int GUMBO_TAG_STYLE = 6;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/scripting-1.html#scripting-1<br>
     * <i>native declaration : line 25</i>
     */
    public static final int GUMBO_TAG_SCRIPT = 7;
    /** <i>native declaration : line 26</i> */
    public static final int GUMBO_TAG_NOSCRIPT = 8;
    /** <i>native declaration : line 27</i> */
    public static final int GUMBO_TAG_TEMPLATE = 9;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#sections<br>
     * <i>native declaration : line 29</i>
     */
    public static final int GUMBO_TAG_BODY = 10;
    /** <i>native declaration : line 30</i> */
    public static final int GUMBO_TAG_ARTICLE = 11;
    /** <i>native declaration : line 31</i> */
    public static final int GUMBO_TAG_SECTION = 12;
    /** <i>native declaration : line 32</i> */
    public static final int GUMBO_TAG_NAV = 13;
    /** <i>native declaration : line 33</i> */
    public static final int GUMBO_TAG_ASIDE = 14;
    /** <i>native declaration : line 34</i> */
    public static final int GUMBO_TAG_H1 = 15;
    /** <i>native declaration : line 35</i> */
    public static final int GUMBO_TAG_H2 = 16;
    /** <i>native declaration : line 36</i> */
    public static final int GUMBO_TAG_H3 = 17;
    /** <i>native declaration : line 37</i> */
    public static final int GUMBO_TAG_H4 = 18;
    /** <i>native declaration : line 38</i> */
    public static final int GUMBO_TAG_H5 = 19;
    /** <i>native declaration : line 39</i> */
    public static final int GUMBO_TAG_H6 = 20;
    /** <i>native declaration : line 40</i> */
    public static final int GUMBO_TAG_HGROUP = 21;
    /** <i>native declaration : line 41</i> */
    public static final int GUMBO_TAG_HEADER = 22;
    /** <i>native declaration : line 42</i> */
    public static final int GUMBO_TAG_FOOTER = 23;
    /** <i>native declaration : line 43</i> */
    public static final int GUMBO_TAG_ADDRESS = 24;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/grouping-content.html#grouping-content<br>
     * <i>native declaration : line 45</i>
     */
    public static final int GUMBO_TAG_P = 25;
    /** <i>native declaration : line 46</i> */
    public static final int GUMBO_TAG_HR = 26;
    /** <i>native declaration : line 47</i> */
    public static final int GUMBO_TAG_PRE = 27;
    /** <i>native declaration : line 48</i> */
    public static final int GUMBO_TAG_BLOCKQUOTE = 28;
    /** <i>native declaration : line 49</i> */
    public static final int GUMBO_TAG_OL = 29;
    /** <i>native declaration : line 50</i> */
    public static final int GUMBO_TAG_UL = 30;
    /** <i>native declaration : line 51</i> */
    public static final int GUMBO_TAG_LI = 31;
    /** <i>native declaration : line 52</i> */
    public static final int GUMBO_TAG_DL = 32;
    /** <i>native declaration : line 53</i> */
    public static final int GUMBO_TAG_DT = 33;
    /** <i>native declaration : line 54</i> */
    public static final int GUMBO_TAG_DD = 34;
    /** <i>native declaration : line 55</i> */
    public static final int GUMBO_TAG_FIGURE = 35;
    /** <i>native declaration : line 56</i> */
    public static final int GUMBO_TAG_FIGCAPTION = 36;
    /** <i>native declaration : line 57</i> */
    public static final int GUMBO_TAG_MAIN = 37;
    /** <i>native declaration : line 58</i> */
    public static final int GUMBO_TAG_DIV = 38;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/text-level-semantics.html#text-level-semantics<br>
     * <i>native declaration : line 60</i>
     */
    public static final int GUMBO_TAG_A = 39;
    /** <i>native declaration : line 61</i> */
    public static final int GUMBO_TAG_EM = 40;
    /** <i>native declaration : line 62</i> */
    public static final int GUMBO_TAG_STRONG = 41;
    /** <i>native declaration : line 63</i> */
    public static final int GUMBO_TAG_SMALL = 42;
    /** <i>native declaration : line 64</i> */
    public static final int GUMBO_TAG_S = 43;
    /** <i>native declaration : line 65</i> */
    public static final int GUMBO_TAG_CITE = 44;
    /** <i>native declaration : line 66</i> */
    public static final int GUMBO_TAG_Q = 45;
    /** <i>native declaration : line 67</i> */
    public static final int GUMBO_TAG_DFN = 46;
    /** <i>native declaration : line 68</i> */
    public static final int GUMBO_TAG_ABBR = 47;
    /** <i>native declaration : line 69</i> */
    public static final int GUMBO_TAG_DATA = 48;
    /** <i>native declaration : line 70</i> */
    public static final int GUMBO_TAG_TIME = 49;
    /** <i>native declaration : line 71</i> */
    public static final int GUMBO_TAG_CODE = 50;
    /** <i>native declaration : line 72</i> */
    public static final int GUMBO_TAG_VAR = 51;
    /** <i>native declaration : line 73</i> */
    public static final int GUMBO_TAG_SAMP = 52;
    /** <i>native declaration : line 74</i> */
    public static final int GUMBO_TAG_KBD = 53;
    /** <i>native declaration : line 75</i> */
    public static final int GUMBO_TAG_SUB = 54;
    /** <i>native declaration : line 76</i> */
    public static final int GUMBO_TAG_SUP = 55;
    /** <i>native declaration : line 77</i> */
    public static final int GUMBO_TAG_I = 56;
    /** <i>native declaration : line 78</i> */
    public static final int GUMBO_TAG_B = 57;
    /** <i>native declaration : line 79</i> */
    public static final int GUMBO_TAG_U = 58;
    /** <i>native declaration : line 80</i> */
    public static final int GUMBO_TAG_MARK = 59;
    /** <i>native declaration : line 81</i> */
    public static final int GUMBO_TAG_RUBY = 60;
    /** <i>native declaration : line 82</i> */
    public static final int GUMBO_TAG_RT = 61;
    /** <i>native declaration : line 83</i> */
    public static final int GUMBO_TAG_RP = 62;
    /** <i>native declaration : line 84</i> */
    public static final int GUMBO_TAG_BDI = 63;
    /** <i>native declaration : line 85</i> */
    public static final int GUMBO_TAG_BDO = 64;
    /** <i>native declaration : line 86</i> */
    public static final int GUMBO_TAG_SPAN = 65;
    /** <i>native declaration : line 87</i> */
    public static final int GUMBO_TAG_BR = 66;
    /** <i>native declaration : line 88</i> */
    public static final int GUMBO_TAG_WBR = 67;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/edits.html#edits<br>
     * <i>native declaration : line 90</i>
     */
    public static final int GUMBO_TAG_INS = 68;
    /** <i>native declaration : line 91</i> */
    public static final int GUMBO_TAG_DEL = 69;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/embedded-content-1.html#embedded-content-1<br>
     * <i>native declaration : line 93</i>
     */
    public static final int GUMBO_TAG_IMAGE = 70;
    /** <i>native declaration : line 94</i> */
    public static final int GUMBO_TAG_IMG = 71;
    /** <i>native declaration : line 95</i> */
    public static final int GUMBO_TAG_IFRAME = 72;
    /** <i>native declaration : line 96</i> */
    public static final int GUMBO_TAG_EMBED = 73;
    /** <i>native declaration : line 97</i> */
    public static final int GUMBO_TAG_OBJECT = 74;
    /** <i>native declaration : line 98</i> */
    public static final int GUMBO_TAG_PARAM = 75;
    /** <i>native declaration : line 99</i> */
    public static final int GUMBO_TAG_VIDEO = 76;
    /** <i>native declaration : line 100</i> */
    public static final int GUMBO_TAG_AUDIO = 77;
    /** <i>native declaration : line 101</i> */
    public static final int GUMBO_TAG_SOURCE = 78;
    /** <i>native declaration : line 102</i> */
    public static final int GUMBO_TAG_TRACK = 79;
    /** <i>native declaration : line 103</i> */
    public static final int GUMBO_TAG_CANVAS = 80;
    /** <i>native declaration : line 104</i> */
    public static final int GUMBO_TAG_MAP = 81;
    /** <i>native declaration : line 105</i> */
    public static final int GUMBO_TAG_AREA = 82;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/the-map-element.html#mathml<br>
     * <i>native declaration : line 107</i>
     */
    public static final int GUMBO_TAG_MATH = 83;
    /** <i>native declaration : line 108</i> */
    public static final int GUMBO_TAG_MI = 84;
    /** <i>native declaration : line 109</i> */
    public static final int GUMBO_TAG_MO = 85;
    /** <i>native declaration : line 110</i> */
    public static final int GUMBO_TAG_MN = 86;
    /** <i>native declaration : line 111</i> */
    public static final int GUMBO_TAG_MS = 87;
    /** <i>native declaration : line 112</i> */
    public static final int GUMBO_TAG_MTEXT = 88;
    /** <i>native declaration : line 113</i> */
    public static final int GUMBO_TAG_MGLYPH = 89;
    /** <i>native declaration : line 114</i> */
    public static final int GUMBO_TAG_MALIGNMARK = 90;
    /** <i>native declaration : line 115</i> */
    public static final int GUMBO_TAG_ANNOTATION_XML = 91;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/the-map-element.html#svg-0<br>
     * <i>native declaration : line 117</i>
     */
    public static final int GUMBO_TAG_SVG = 92;
    /** <i>native declaration : line 118</i> */
    public static final int GUMBO_TAG_FOREIGNOBJECT = 93;
    /** <i>native declaration : line 119</i> */
    public static final int GUMBO_TAG_DESC = 94;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/tabular-data.html#tabular-data<br>
     * <i>native declaration : line 122</i>
     */
    public static final int GUMBO_TAG_TABLE = 95;
    /** <i>native declaration : line 123</i> */
    public static final int GUMBO_TAG_CAPTION = 96;
    /** <i>native declaration : line 124</i> */
    public static final int GUMBO_TAG_COLGROUP = 97;
    /** <i>native declaration : line 125</i> */
    public static final int GUMBO_TAG_COL = 98;
    /** <i>native declaration : line 126</i> */
    public static final int GUMBO_TAG_TBODY = 99;
    /** <i>native declaration : line 127</i> */
    public static final int GUMBO_TAG_THEAD = 100;
    /** <i>native declaration : line 128</i> */
    public static final int GUMBO_TAG_TFOOT = 101;
    /** <i>native declaration : line 129</i> */
    public static final int GUMBO_TAG_TR = 102;
    /** <i>native declaration : line 130</i> */
    public static final int GUMBO_TAG_TD = 103;
    /** <i>native declaration : line 131</i> */
    public static final int GUMBO_TAG_TH = 104;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/forms.html#forms<br>
     * <i>native declaration : line 133</i>
     */
    public static final int GUMBO_TAG_FORM = 105;
    /** <i>native declaration : line 134</i> */
    public static final int GUMBO_TAG_FIELDSET = 106;
    /** <i>native declaration : line 135</i> */
    public static final int GUMBO_TAG_LEGEND = 107;
    /** <i>native declaration : line 136</i> */
    public static final int GUMBO_TAG_LABEL = 108;
    /** <i>native declaration : line 137</i> */
    public static final int GUMBO_TAG_INPUT = 109;
    /** <i>native declaration : line 138</i> */
    public static final int GUMBO_TAG_BUTTON = 110;
    /** <i>native declaration : line 139</i> */
    public static final int GUMBO_TAG_SELECT = 111;
    /** <i>native declaration : line 140</i> */
    public static final int GUMBO_TAG_DATALIST = 112;
    /** <i>native declaration : line 141</i> */
    public static final int GUMBO_TAG_OPTGROUP = 113;
    /** <i>native declaration : line 142</i> */
    public static final int GUMBO_TAG_OPTION = 114;
    /** <i>native declaration : line 143</i> */
    public static final int GUMBO_TAG_TEXTAREA = 115;
    /** <i>native declaration : line 144</i> */
    public static final int GUMBO_TAG_KEYGEN = 116;
    /** <i>native declaration : line 145</i> */
    public static final int GUMBO_TAG_OUTPUT = 117;
    /** <i>native declaration : line 146</i> */
    public static final int GUMBO_TAG_PROGRESS = 118;
    /** <i>native declaration : line 147</i> */
    public static final int GUMBO_TAG_METER = 119;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/interactive-elements.html#interactive-elements<br>
     * <i>native declaration : line 149</i>
     */
    public static final int GUMBO_TAG_DETAILS = 120;
    /** <i>native declaration : line 150</i> */
    public static final int GUMBO_TAG_SUMMARY = 121;
    /** <i>native declaration : line 151</i> */
    public static final int GUMBO_TAG_MENU = 122;
    /** <i>native declaration : line 152</i> */
    public static final int GUMBO_TAG_MENUITEM = 123;
    /**
     * http://www.whatwg.org/specs/web-apps/current-work/multipage/obsolete.html#non-conforming-features<br>
     * <i>native declaration : line 155</i>
     */
    public static final int GUMBO_TAG_APPLET = 124;
    /** <i>native declaration : line 156</i> */
    public static final int GUMBO_TAG_ACRONYM = 125;
    /** <i>native declaration : line 157</i> */
    public static final int GUMBO_TAG_BGSOUND = 126;
    /** <i>native declaration : line 158</i> */
    public static final int GUMBO_TAG_DIR = 127;
    /** <i>native declaration : line 159</i> */
    public static final int GUMBO_TAG_FRAME = 128;
    /** <i>native declaration : line 160</i> */
    public static final int GUMBO_TAG_FRAMESET = 129;
    /** <i>native declaration : line 161</i> */
    public static final int GUMBO_TAG_NOFRAMES = 130;
    /** <i>native declaration : line 162</i> */
    public static final int GUMBO_TAG_ISINDEX = 131;
    /** <i>native declaration : line 163</i> */
    public static final int GUMBO_TAG_LISTING = 132;
    /** <i>native declaration : line 164</i> */
    public static final int GUMBO_TAG_XMP = 133;
    /** <i>native declaration : line 165</i> */
    public static final int GUMBO_TAG_NEXTID = 134;
    /** <i>native declaration : line 166</i> */
    public static final int GUMBO_TAG_NOEMBED = 135;
    /** <i>native declaration : line 167</i> */
    public static final int GUMBO_TAG_PLAINTEXT = 136;
    /** <i>native declaration : line 168</i> */
    public static final int GUMBO_TAG_RB = 137;
    /** <i>native declaration : line 169</i> */
    public static final int GUMBO_TAG_STRIKE = 138;
    /** <i>native declaration : line 170</i> */
    public static final int GUMBO_TAG_BASEFONT = 139;
    /** <i>native declaration : line 171</i> */
    public static final int GUMBO_TAG_BIG = 140;
    /** <i>native declaration : line 172</i> */
    public static final int GUMBO_TAG_BLINK = 141;
    /** <i>native declaration : line 173</i> */
    public static final int GUMBO_TAG_CENTER = 142;
    /** <i>native declaration : line 174</i> */
    public static final int GUMBO_TAG_FONT = 143;
    /** <i>native declaration : line 175</i> */
    public static final int GUMBO_TAG_MARQUEE = 144;
    /** <i>native declaration : line 176</i> */
    public static final int GUMBO_TAG_MULTICOL = 145;
    /** <i>native declaration : line 177</i> */
    public static final int GUMBO_TAG_NOBR = 146;
    /** <i>native declaration : line 178</i> */
    public static final int GUMBO_TAG_SPACER = 147;
    /** <i>native declaration : line 179</i> */
    public static final int GUMBO_TAG_TT = 148;
    /**
     * Used for all tags that don't have special handling in HTML.<br>
     * <i>native declaration : line 181</i>
     */
    public static final int GUMBO_TAG_UNKNOWN = 149;
    /**
     * Also used as the terminator for varargs functions that take tags.<br>
     * <i>native declaration : line 184</i>
     */
    public static final int GUMBO_TAG_LAST = 150;
  };
  
  /** enum values */
  public static interface GumboNamespaceEnum {
    /** <i>native declaration : line 10</i> */
    public static final int GUMBO_NAMESPACE_HTML = 0;
    /** <i>native declaration : line 11</i> */
    public static final int GUMBO_NAMESPACE_SVG = 1;
    /** <i>native declaration : line 12</i> */
    public static final int GUMBO_NAMESPACE_MATHML = 2;
  };
  
  public static class GumboDocument extends Structure{
    /**
     * An array of GumboNodes, containing the children of this element.  This will<br>
     * normally consist of the <html> element and any comment nodes found.<br>
     * Pointers are owned.<br>
     * GumboNode*<br>
     * C type : GumboVector
     */
    public GumboVector children;
    /** True if there was an explicit doctype token as opposed to it being omitted. */
    public byte has_doctype;
    /**
     * Fields from the doctype token, copied verbatim.<br>
     * C type : const char*
     */
    public Pointer name;
    /** C type : const char* */
    public Pointer public_identifier;
    /** C type : const char* */
    public Pointer system_identifier;
    /**
     * Whether or not the document is in QuirksMode, as determined by the values<br>
     * in the GumboTokenDocType template.<br>
     * C type : GumboQuirksModeEnum
     */
    public int doc_type_quirks_mode;
    public GumboDocument() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("children", "has_doctype", "name", "public_identifier", "system_identifier", "doc_type_quirks_mode");
    }
    /**
     * @param children An array of GumboNodes, containing the children of this element.  This will<br>
     * normally consist of the <html> element and any comment nodes found.<br>
     * Pointers are owned.<br>
     * GumboNode*<br>
     * C type : GumboVector<br>
     * @param has_doctype True if there was an explicit doctype token as opposed to it being omitted.<br>
     * @param name Fields from the doctype token, copied verbatim.<br>
     * C type : const char*<br>
     * @param public_identifier C type : const char*<br>
     * @param system_identifier C type : const char*<br>
     * @param doc_type_quirks_mode Whether or not the document is in QuirksMode, as determined by the values<br>
     * in the GumboTokenDocType template.<br>
     * C type : GumboQuirksModeEnum
     */
    public GumboDocument(GumboVector children, byte has_doctype, Pointer name, Pointer public_identifier, Pointer system_identifier, int doc_type_quirks_mode) {
      super();
      this.children = children;
      this.has_doctype = has_doctype;
      this.name = name;
      this.public_identifier = public_identifier;
      this.system_identifier = system_identifier;
      this.doc_type_quirks_mode = doc_type_quirks_mode;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboDocument newInstance() { return new GumboDocument(); }
    public static class ByReference extends GumboDocument implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboDocument implements Structure.ByValue {
      
    };
  };
  
  /** enum values */
  public static interface GumboQuirksModeEnum {
    /** <i>native declaration : line 4</i> */
    public static final int GUMBO_DOCTYPE_NO_QUIRKS = 0;
    /** <i>native declaration : line 5</i> */
    public static final int GUMBO_DOCTYPE_QUIRKS = 1;
    /** <i>native declaration : line 6</i> */
    public static final int GUMBO_DOCTYPE_LIMITED_QUIRKS = 2;
  };
  
  /** enum values */
  public static interface GumboParseFlags {
    /**
     * A normal node - both start and end tags appear in the source, nothing has<br>
     * been reparented.<br>
     * <i>native declaration : line 15</i>
     */
    public static final int GUMBO_INSERTION_NORMAL = 0;
    /**
     * A node inserted by the parser to fulfill some implicit insertion rule.<br>
     * This is usually set in addition to some other flag giving a more specific<br>
     * insertion reason; it's a generic catch-all term meaning "The start tag for<br>
     * this node did not appear in the document source".<br>
     * <i>native declaration : line 23</i>
     */
    public static final int GUMBO_INSERTION_BY_PARSER = 1 << 0;
    /**
     * A flag indicating that the end tag for this node did not appear in the<br>
     * document source.  Note that in some cases, you can still have<br>
     * parser-inserted nodes with an explicit end tag: for example, "Text</html>"<br>
     * has GUMBO_INSERTED_BY_PARSER set on the <html> node, but<br>
     * GUMBO_INSERTED_END_TAG_IMPLICITLY is unset, as the </html> tag actually<br>
     * exists.  This flag will be set only if the end tag is completely missing;<br>
     * in some cases, the end tag may be misplaced (eg. a </body> tag with text<br>
     * afterwards), which will leave this flag unset and require clients to<br>
     * inspect the parse errors for that case.<br>
     * <i>native declaration : line 36</i>
     */
    public static final int GUMBO_INSERTION_IMPLICIT_END_TAG = 1 << 1;
    /**
     * A flag for nodes that are inserted because their presence is implied by<br>
     * other tags, eg. <html>, <head>, <body>, <tbody>, etc.<br>
     * <i>native declaration : line 44</i>
     */
    public static final int GUMBO_INSERTION_IMPLIED = 1 << 3;
    /**
     * A flag for nodes that are converted from their end tag equivalents.  For<br>
     * example, </p> when no paragraph is open implies that the parser should<br>
     * create a <p> tag and immediately close it, while </br> means the same thing<br>
     * as <br>.<br>
     * <i>native declaration : line 52</i>
     */
    public static final int GUMBO_INSERTION_CONVERTED_FROM_END_TAG = 1 << 4;
    /**
     * A flag for nodes that are converted from the parse of an <isindex> tag.<br>
     * <i>native declaration : line 55</i>
     */
    public static final int GUMBO_INSERTION_FROM_ISINDEX = 1 << 5;
    /**
     * A flag for <image> tags that are rewritten as <img>.<br>
     * <i>native declaration : line 58</i>
     */
    public static final int GUMBO_INSERTION_FROM_IMAGE = 1 << 6;
    /**
     * A flag for nodes that are cloned as a result of the reconstruction of<br>
     * active formatting elements.  This is set only on the clone; the initial<br>
     * portion of the formatting run is a NORMAL node with an IMPLICIT_END_TAG.<br>
     * <i>native declaration : line 65</i>
     */
    public static final int GUMBO_INSERTION_RECONSTRUCTED_FORMATTING_ELEMENT = 1 << 7;
    /**
     * A flag for nodes that are cloned by the adoption agency algorithm.<br>
     * <i>native declaration : line 68</i>
     */
    public static final int GUMBO_INSERTION_ADOPTION_AGENCY_CLONED = 1 << 8;
    /**
     * A flag for nodes that are moved by the adoption agency algorithm.<br>
     * <i>native declaration : line 71</i>
     */
    public static final int GUMBO_INSERTION_ADOPTION_AGENCY_MOVED = 1 << 9;
    /**
     * A flag for nodes that have been foster-parented out of a table (or<br>
     * should've been foster-parented, if verbatim mode is set).<br>
     * <i>native declaration : line 77</i>
     */
    public static final int GUMBO_INSERTION_FOSTER_PARENTED = 1 << 10;
  };
  
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
    public int type;
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
    public int parse_flags;
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
    public GumboNode(int type, GumboNode.ByReference parent, SizeT index_within_parent, int parse_flags, VUnion v) {
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
    /**
     * Pointer to the document node.  This is a GumboNode of type NODE_DOCUMENT<br>
     * that contains the entire document as its child.<br>
     * C type : GumboNode*
     */
    public GumboNode document;
    /**
     * Pointer to the root node.  This the <html> tag that forms the root of the<br>
     * document.<br>
     * C type : GumboNode*
     */
    public GumboNode root;
    /**
     * A list of errors that occurred during the parse.<br>
     * NOTE: In version 1.0 of this library, the API for errors hasn't been fully<br>
     * fleshed out and may change in the future.  For this reason, the GumboError<br>
     * header isn't part of the public API.  Contact us if you need errors<br>
     * reported so we can work out something appropriate for your use-case.<br>
     * GumboError<br>
     * C type : GumboVector
     */
    public GumboVector errors;
    public GumboOutput() {
      super();
    }
    protected List<? > getFieldOrder() {
      return Arrays.asList("document", "root", "errors");
    }
    /**
     * @param document Pointer to the document node.  This is a GumboNode of type NODE_DOCUMENT<br>
     * that contains the entire document as its child.<br>
     * C type : GumboNode*<br>
     * @param root Pointer to the root node.  This the <html> tag that forms the root of the<br>
     * document.<br>
     * C type : GumboNode*<br>
     * @param errors A list of errors that occurred during the parse.<br>
     * NOTE: In version 1.0 of this library, the API for errors hasn't been fully<br>
     * fleshed out and may change in the future.  For this reason, the GumboError<br>
     * header isn't part of the public API.  Contact us if you need errors<br>
     * reported so we can work out something appropriate for your use-case.<br>
     * GumboError<br>
     * C type : GumboVector
     */
    public GumboOutput(GumboNode document, GumboNode root, GumboVector errors) {
      super();
      this.document = document;
      this.root = root;
      this.errors = errors;
    }
    protected ByReference newByReference() { return new ByReference(); }
    protected ByValue newByValue() { return new ByValue(); }
    protected GumboOutput newInstance() { return new GumboOutput(); }
    public static class ByReference extends GumboOutput implements Structure.ByReference {
      
    };
    public static class ByValue extends GumboOutput implements Structure.ByValue {
      
    };
  };
  
//  public GumboOutput gumbo_parse_with_options(GumboOptions.ByReference options, String buffer, SizeT size);
  
  public GumboOutput gumbo_parse(String buffer);
  
  public class GumboOptions extends Structure{
    /**
     * A memory allocator function.  Default: malloc.<br>
     * C type : GumboAllocatorFunction
     */
    public GumboAllocatorFunction allocator;
    /**
     * A memory deallocator function. Default: free.<br>
     * C type : GumboDeallocatorFunction
     */
    public GumboDeallocatorFunction deallocator;
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
    public GumboOptions(GumboAllocatorFunction allocator, GumboDeallocatorFunction deallocator, Pointer userdata, int tab_stop, byte stop_on_first_error, int max_errors) {
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
      public ByReference() { } 
      public ByReference(Pointer p) { super(p); read(); } 
    };
    public static class ByValue extends GumboOptions implements Structure.ByValue {
      public ByValue() { } 
      public ByValue(Pointer p) { super(p); read(); } 
    };
    
    public static interface GumboAllocatorFunction extends StdCallCallback {
      Pointer invoke(Pointer userdata, SizeT size);
    };
    
    public static interface GumboDeallocatorFunction extends StdCallCallback {
      void invoke(Pointer userdata, Pointer ptr);
    };
  }
}
