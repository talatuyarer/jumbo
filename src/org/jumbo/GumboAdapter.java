package org.jumbo;

import org.apache.html.dom.HTMLDocumentImpl;
import org.jumbo.Gumbo.GumboNode;
import org.jumbo.Gumbo.GumboNodeType;
import org.jumbo.Gumbo.GumboOptions;
import org.jumbo.Gumbo.GumboOutput;
import org.w3c.dom.DocumentFragment;

import com.sun.jna.Callback;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public class GumboAdapter {

  GumboOutput output = null;
  
  /*
   def _add_element(soup, element):
  # TODO(jdtang): Expose next/previous in gumbo so they can be passed along to
  # BeautifulSoup.
  tag = BeautifulSoup.Tag(
      soup, _utf8(element.tag_name), _convert_attrs(element.attributes))
  for child in element.children:
    tag.append(_add_node(soup, child))
  _add_source_info(
      tag, element.original_tag, element.start_pos, element.end_pos)
  tag.original_end_tag = str(element.original_end_tag)
  return tag
  */
  public void addElement(HTMLDocumentImpl doc, DocumentFragment result, GumboNode node){
    DocumentFragment frag = doc.createDocumentFragment();
    frag.setNodeValue(Utils.Utf8(node.v.element.tagName()));
    
    
    /*
    
    doc.createAttribute()
    
    node.v.element.attributes
    */
  }
  
  
  public void addNode(HTMLDocumentImpl doc,DocumentFragment result, GumboNode node) {
    
    
    
    switch (node.type) {
    case GumboNodeType.GUMBO_NODE_DOCUMENT:
      ;
      break;
    case GumboNodeType.GUMBO_NODE_ELEMENT:
      addElement(doc,result,node);
      break;
    case GumboNodeType.GUMBO_NODE_TEXT:
      break;
    case GumboNodeType.GUMBO_NODE_WHITESPACE:
      break;
    case GumboNodeType.GUMBO_NODE_COMMENT:
      break;
    case GumboNodeType.GUMBO_NODE_CDATA:
      break;
    default:
      break;
    }

  }

  public GumboOutput parse(String text){
    Pointer p = NativeLibrary.getInstance("gumbo").getGlobalVariableAddress("kGumboDefaultOptions");
    GumboOptions options = new GumboOptions(p);
    SizeT size = new SizeT((long)text.length()); 
    output =  Gumbo.INSTANCE.gumbo_parse_with_options(options.getPointer(), text, size);
    //output.read();
 // convert Document to DocumentFragment
    HTMLDocumentImpl doc = new HTMLDocumentImpl();
    doc.setErrorChecking(false);
    DocumentFragment res = doc.createDocumentFragment();
//    DocumentFragment frag = doc.createDocumentFragment();
    
    addNode(doc,res,output.root);
    
    return output;
  }
  
  public static void main(String[] args) {
    GumboAdapter ga = new GumboAdapter();
    String buffer = "<html><body>Merhaba !!!</body></html>";
    GumboOutput output = ga.parse(buffer);
    
    
/*    
    Pointer p = NativeLibrary.getInstance("gumbo").getGlobalVariableAddress("kGumboDefaultOptions");
    GumboOptions options = new GumboOptions(p);
    
    SizeT size = new SizeT((long)buffer.length());
//    GumboOptions.ByReference options = new GumboOptions.ByReference(p);
//    System.out.println("Is callback assignable: " + 
//        Callback.class.isAssignableFrom(GumboOptions.GumboAllocatorFunction.class)); 
    
//    GumboOutput.ByReference ali =  Gumbo.INSTANCE.gumbo_parse_with_options(options.newByReference(), buffer, size);
    GumboOutput output =  Gumbo.INSTANCE.gumbo_parse_with_options(options.getPointer(), buffer, size);
 /*   
 // convert Document to DocumentFragment
    HTMLDocumentImpl doc = new HTMLDocumentImpl();
    doc.setErrorChecking(false);
    DocumentFragment res = doc.createDocumentFragment();
    DocumentFragment frag = doc.createDocumentFragment();
   
    
    
//  GumboOutput ali =  Gumbo.INSTANCE.gumbo_parse( buffer);
    Gumbo.INSTANCE.gumbo_destroy_output(p,output);
    */
  }
  
}
