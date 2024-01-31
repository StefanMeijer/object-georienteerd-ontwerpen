package Slide.Item;

import Slide.*;
import Style.*;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * A text item on a slide.
 * Text items have drawing capabilities.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class TextItem extends SlideItem {
    private String text;

    /**
     * Constructs a TextItem with a specified level and text content.
     *
     * @param level The level of the TextItem.
     * @param text  The content of the TextItem.
     */
    public TextItem(int level, String text) {
        super(level);
        this.text = text;
    }

    /**
     * Gets the text content of the TextItem.
     *
     * @return The text content.
     */
    public String getText() {
        return text == null ? "" : text;
    }

    /**
     * Gets the AttributedString for the TextItem with the specified style and scale.
     *
     * @param style The style of the TextItem.
     * @param scale The scale factor.
     * @return The AttributedString for the TextItem.
     */
    public AttributedString getAttributedString(Style style, float scale) {
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
        return attrStr;
    }

    /**
     * Gets the bounding box of the TextItem.
     *
     * @param g         The Graphics context.
     * @param observer  The ImageObserver.
     * @param scale     The scale factor.
     * @param myStyle   The style of the TextItem.
     * @return The bounding box as a Rectangle.
     */
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer,
                                    float scale, Style myStyle) {
        List<TextLayout> layouts = getLayouts(g, myStyle, scale);
        int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);
        Iterator<TextLayout> iterator = layouts.iterator();
        while (iterator.hasNext()) {
            TextLayout layout = iterator.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (myStyle.getIndent() * scale), 0, xsize, ysize);
    }

    /**
     * Draws the TextItem on the Graphics context.
     *
     * @param x      The x-coordinate.
     * @param y      The y-coordinate.
     * @param scale  The scale factor.
     * @param g      The Graphics context.
     * @param myStyle The style of the TextItem.
     * @param o      The ImageObserver.
     */
    public void draw(int x, int y, float scale, Graphics g,
                     Style myStyle, ImageObserver o) {
        if (text == null || text.length() == 0) {
            return;
        }
        List<TextLayout> layouts = getLayouts(g, myStyle, scale);
        Point pen = new Point(x + (int) (myStyle.getIndent() * scale),
                y + (int) (myStyle.getLeading() * scale));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(myStyle.getColor());
        Iterator<TextLayout> it = layouts.iterator();
        while (it.hasNext()) {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    private List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attrStr = getAttributedString(s, scale);
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - s.getIndent()) * scale;
        while (measurer.getPosition() < getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }
        return layouts;
    }

    /**
     * Returns a string representation of the TextItem.
     *
     * @return A string representation.
     */
    public String toString() {
        return "Slide.Item.TextItem[" + getLevel() + "," + getText() + "]";
    }
}
