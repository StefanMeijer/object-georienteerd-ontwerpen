package Slide.Item;

import Accessor.*;
import Presentation.*;
import Slide.*;
import Style.*;
import Utility.*;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * <p>The abstract class for items on a slide.<p>
 * <p>All SlideItems have drawing capabilities.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class SlideItem {
    private int level = 0; //The level of the Slide.Item.SlideItem

    public SlideItem(int Level) {
        this.level = Level;
    }

    //Returns the bounding box
    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    //Draws the item
    public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
