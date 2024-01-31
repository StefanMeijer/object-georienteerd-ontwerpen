package Slide.Item;

import Style.*;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * SlideItem is an abstract class for items on a slide.
 * All SlideItems have drawing capabilities.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public abstract class SlideItem {
    private int level; // The level of the SlideItem

    /**
     * Constructs a SlideItem with a specified level.
     *
     * @param level The level of the SlideItem.
     */
    public SlideItem(int level) {
        this.level = level;
    }

    /**
     * Returns the bounding box of the item.
     *
     * @param g        The Graphics context.
     * @param observer The ImageObserver.
     * @param scale    The scale factor.
     * @param style    The style of the item.
     * @return The bounding box of the item as a Rectangle.
     */
    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    /**
     * Draws the item on the graphics context.
     *
     * @param x        The x-coordinate.
     * @param y        The y-coordinate.
     * @param scale    The scale factor.
     * @param g        The Graphics context.
     * @param style    The style of the item.
     * @param observer The ImageObserver.
     */
    public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);

    /**
     * Sets the level of the SlideItem.
     *
     * @param level The new level to be set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the level of the SlideItem.
     *
     * @return The level of the SlideItem.
     */
    public int getLevel() {
        return level;
    }
}
