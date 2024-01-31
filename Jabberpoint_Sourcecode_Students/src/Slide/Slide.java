package Slide;

import Slide.Item.SlideItem;
import Slide.Item.SlideItemFactory;
import Style.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * A slide with drawing functionality.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class Slide {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String title; // The title is kept separately
    private Vector<SlideItem> items; // The SlideItems are kept in a vector

    // Constructor
    public Slide() {
        this.items = new Vector<>();
    }

    // Add a SlideItem
    public void append(SlideItem anItem) {
        getItems().addElement(anItem);
    }

    // Create a TextItem out of a String and add it to the Slide
    public void append(int level, String message) {
        append(SlideItemFactory.createTextItem(level, message));
    }

    // Draws the slide
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;

        // Draw the title separately
        SlideItem titleItem = SlideItemFactory.createTextItem(0, getTitle());
        Style titleStyle = StyleFactory.getStyle(titleItem.getLevel());
        titleItem.draw(area.x, y, scale, g, titleStyle, view);
        y += titleItem.getBoundingBox(g, view, scale, titleStyle).height;

        // Draw the other SlideItems
        for (int number = 0; number < getItems().size(); number++) {
            SlideItem slideItem = getSlideItems().elementAt(number);
            Style style = StyleFactory.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // Return all the SlideItems in a vector
    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    // Returns the scale to draw a slide
    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }

    // Return the title of a slide
    public String getTitle() {
        return this.title;
    }

    // Change the title of a slide
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    // Get the items of a slide
    public Vector<SlideItem> getItems() {
        return this.items;
    }
}
