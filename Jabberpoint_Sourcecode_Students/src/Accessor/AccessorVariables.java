package Accessor;

/**
 * AccessorVariables contains constant values representing XML tags and messages used in the Accessor package.
 */
public class AccessorVariables {
    // Names of XML tags and attributes
    protected static final String SHOWTITLE = "showtitle";  // XML tag for show title
    protected static final String SLIDETITLE = "title";    // XML tag for slide title
    protected static final String SLIDE = "slide";          // XML tag for slide
    protected static final String ITEM = "item";            // XML tag for item
    protected static final String LEVEL = "level";          // XML attribute for level
    protected static final String KIND = "kind";            // XML attribute for kind
    protected static final String TEXT = "text";            // Value for text kind
    protected static final String IMAGE = "image";          // Value for image kind

    // Text messages
    protected static final String PCE = "Parser Configuration Exception";  // Parser configuration exception message
    protected static final String UNKNOWNTYPE = "Unknown Element type";    // Unknown element type message
    protected static final String NFE = "Number Format Exception";          // Number format exception message
}
