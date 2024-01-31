package Slide.Item;

import Style.*;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;

/**
 * BitmapItem represents a bitmap item in a slide.
 * Bitmap items are responsible for drawing themselves.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class BitmapItem extends SlideItem {
    private static final String FILE = "File ";
    private static final String NOTFOUND = " not found";
    private BufferedImage bufferedImage;
    private String imageName;

    /**
     * Constructs a BitmapItem with a specified level and image name.
     *
     * @param level The item-level.
     * @param name  The name of the file with the image.
     */
    public BitmapItem(int level, String name) {
        super(level);
        setImageName(name);
        try {
            this.setBufferedImage(ImageIO.read(new File(getImageName())));
        } catch (IOException e) {
            System.err.println(FILE + getImageName() + NOTFOUND);
        }
    }

    /**
     * Returns the bounding box of the image.
     *
     * @param g        The Graphics context.
     * @param observer The ImageObserver.
     * @param scale    The scale factor.
     * @param myStyle  The style of the item.
     * @return The bounding box of the image as a Rectangle.
     */
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (this.getBufferedImage().getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale)) +
                        (int) (this.getBufferedImage().getHeight(observer) * scale));
    }

    /**
     * Draws the image on the graphics context.
     *
     * @param x        The x-coordinate.
     * @param y        The y-coordinate.
     * @param scale    The scale factor.
     * @param g        The Graphics context.
     * @param myStyle  The style of the item.
     * @param observer The ImageObserver.
     */
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);
        g.drawImage(this.getBufferedImage(), width, height, (int) (this.getBufferedImage().getWidth(observer) * scale),
                (int) (this.getBufferedImage().getHeight(observer) * scale), observer);
    }

    /**
     * Returns a string representation of the BitmapItem.
     *
     * @return A string representation.
     */
    public String toString() {
        return "Slide.Item.BitmapItem[" + getLevel() + "," + getImageName() + "]";
    }

    // Getter and Setter methods

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
