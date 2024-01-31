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
 * <p>The class for a Bitmap item</p>
 * <p>Bitmap items are responsible for drawing themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class BitmapItem extends SlideItem {
    private static final String FILE = "File ";
    private static final String NOTFOUND = " not found";
    private BufferedImage bufferedImage;
    private String imageName;

    //level indicates the item-level; name indicates the name of the file with the image
    public BitmapItem(int level, String name) {
        super(level);
        setImageName(name);
        try {
            this.setBufferedImage(ImageIO.read(new File(getImageName())));
        } catch (IOException e) {
            System.err.println(FILE + getImageName() + NOTFOUND);
        }
    }

    //Returns the bounding box of the image
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (this.getBufferedImage().getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale)) +
                        (int) (this.getBufferedImage().getHeight(observer) * scale));
    }

    //Draws the image
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);
        g.drawImage(this.getBufferedImage(), width, height, (int) (this.getBufferedImage().getWidth(observer) * scale),
                (int) (this.getBufferedImage().getHeight(observer) * scale), observer);
    }

    public String toString() {
        return "Slide.Item.BitmapItem[" + getLevel() + "," + getImageName() + "]";
    }

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
