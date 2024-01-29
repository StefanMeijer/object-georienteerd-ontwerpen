package Style;

import Accessor.*;
import Presentation.*;
import Slide.*;
import Style.*;
import Utility.*;

import java.awt.Color;

public class StyleFactory {
    private static Style[] styles;

    // Private constructor to prevent instantiation
    private StyleFactory() {
        // Do nothing, prevent instantiation
    }

    // Factory method for creating Style.Style objects
    public static Style createStyle(int indent, Color color, int points, int leading) {
        return new Style(indent, color, points, leading);
    }

    // Factory method for creating an array of Style.Style objects
    public static void createStyles() {
        styles = new Style[5];
        styles[0] = createStyle(0, Color.red, 48, 20);
        styles[1] = createStyle(20, Color.blue, 40, 10);
        styles[2] = createStyle(50, Color.black, 36, 10);
        styles[3] = createStyle(70, Color.black, 30, 10);
        styles[4] = createStyle(90, Color.black, 24, 10);
    }

    // Getter for the styles array
    public static Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }

    // Setter for the styles array
    public static void setStyles(Style[] newStyles) {
        styles = newStyles;
    }
}
