package Slide;

import Slide.Item.SlideItem;
import Slide.Item.SlideItemFactory;
import Slide.Item.TextItem;
import Style.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String title; //The title is kept separately
    private Vector<SlideItem> items; //The SlideItems are kept in a vector

    public Slide() {
        this.items = new Vector<>();
    }

    //Add a Slide.Item.SlideItem
    public void append(SlideItem anItem) {
        getItems().addElement(anItem);
    }

    //Create a Slide.Item.TextItem out of a String and add the Slide.Item.TextItem
    public void append(int level, String message) {
        append(SlideItemFactory.createTextItem(level, message));
    }

    //Draws the slide
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        //The title is treated separately
        SlideItem slideItem = SlideItemFactory.createTextItem(0, getTitle());
        Style style = StyleFactory.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number = 0; number < getItems().size(); number++) {
            slideItem = getSlideItems().elementAt(number);
            style = StyleFactory.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    //Return all the SlideItems in a vector
    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    //Returns the scale to draw a slide
    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }

    //Return the title of a slide
    public String getTitle() {
        return this.title;
    }

    //Change the title of a slide
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public Vector<SlideItem> getItems() {
        return this.items;
    }

    public void setItems(Vector<SlideItem> items) {
        this.items = items;
    }
}
