package Style;

import java.awt.Color;
import java.awt.Font;

/**
 * Represents the style for items, including indent, color, font, and leading.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class Style {
    private static final String FONTNAME = "Helvetica";
    private int indent;      // The indentation level for the item
    private Color color;     // The color of the text
    private Font font;       // The font for the text
    private int fontSize;    // The font size of the text
    private int leading;     // The leading (line spacing) for the text

    /**
     * Constructs a Style object with specified attributes.
     *
     * @param indent  The indentation level for the item.
     * @param color   The color of the text.
     * @param points  The font size in points.
     * @param leading The leading (line spacing) for the text.
     */
    public Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        font = new Font(FONTNAME, Font.BOLD, fontSize = points);
        this.leading = leading;
    }

    /**
     * Returns a string representation of the Style object.
     *
     * @return A string containing the indent, color, font size, and leading.
     */
    public String toString() {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    /**
     * Gets the indentation level.
     *
     * @return The indentation level.
     */
    public int getIndent() {
        return indent;
    }

    /**
     * Gets the color of the text.
     *
     * @return The color of the text.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the font with the specified scale factor.
     *
     * @param scale The scale factor for the font size.
     * @return The scaled font.
     */
    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    /**
     * Gets the leading (line spacing) for the text.
     *
     * @return The leading (line spacing) for the text.
     */
    public int getLeading() {
        return leading;
    }
}
