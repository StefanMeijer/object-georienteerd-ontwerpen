package Slide.Viewer;

import Presentation.*;
import Slide.*;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

import static Slide.Viewer.SlideViewerVariables.*;


/**
 * <p>Slide.Viewer.SlideViewerComponent is a graphical component that ca display Slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent {
    private Slide slide; //The current slide
    private Font labelFont; //The font for labels
    private Presentation presentation; //The presentation
    private JFrame frame;

    public SlideViewerComponent(Presentation pres, JFrame frame) {
        setBackground(BGCOLOR);

        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.presentation = pres;
        this.frame = frame;
    }

    public Dimension getPreferredSize() {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    public void update(Presentation presentation, Slide data) {
        if (data == null) {
            repaint();
            return;
        }
        this.presentation = presentation;
        this.slide = data;
        repaint();
        frame.setTitle(presentation.getShowTitle());
    }

    //Draw the slide
    public void paintComponent(Graphics g) {
        g.setColor(BGCOLOR);
        g.fillRect(0, 0, getSize().width, getSize().height);
        if (presentation.getCurrentSlideNumber() < 0 || slide == null) {
            return;
        }
        g.setFont(labelFont);
        g.setColor(COLOR);
        g.drawString("Slide " + (1 + presentation.getCurrentSlideNumber()) + " of " +
                presentation.getShowList().size(), XPOS, YPOS);
        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        slide.draw(g, area, this);
    }
}
