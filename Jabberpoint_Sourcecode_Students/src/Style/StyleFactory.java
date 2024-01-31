package Style;

import java.awt.Color;

/**
 * A factory class for creating Style objects and managing a set of predefined styles.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class StyleFactory {
    private static Style[] styles;

    /**
     * Factory method for creating a Style object.
     *
     * @param indent  The indentation level for the style.
     * @param color   The color for the style.
     * @param points  The font size in points for the style.
     * @param leading The leading (line spacing) for the style.
     * @return The created Style object.
     */
    public static Style createStyle(int indent, Color color, int points, int leading) {
        return new Style(indent, color, points, leading);
    }

    /**
     * Factory method for creating an array of predefined Style objects.
     */
    public static void createStyles() {
        styles = new Style[5];
        styles[0] = createStyle(0, Color.red, 48, 20);
        styles[1] = createStyle(20, Color.blue, 40, 10);
        styles[2] = createStyle(50, Color.black, 36, 10);
        styles[3] = createStyle(70, Color.black, 30, 10);
        styles[4] = createStyle(90, Color.black, 24, 10);
    }

    /**
     * Retrieves a Style object based on the specified level.
     * If the level exceeds the available styles, the last style is returned.
     *
     * @param level The level for which to retrieve the style.
     * @return The Style object for the specified level.
     */
    public static Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }
}
