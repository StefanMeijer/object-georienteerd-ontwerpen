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
 * Graphical component that can display slides.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideViewerComponent extends JComponent {
    private Slide slide; // The current slide
    private Font labelFont; // The font for labels
    private Presentation presentation; // The presentation
    private JFrame frame;

    /**
     * Constructs a SlideViewerComponent with the specified presentation and frame.
     *
     * @param pres  The presentation to be displayed.
     * @param frame The JFrame associated with the component.
     */
    public SlideViewerComponent(Presentation pres, JFrame frame) {
        setBackground(BGCOLOR);

        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.presentation = pres;
        this.frame = frame;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    /**
     * Updates the component with the current presentation and slide data.
     *
     * @param presentation The current presentation.
     * @param data         The current slide data.
     */
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

    /**
     * Paints the component, drawing the current slide.
     *
     * @param g The Graphics context.
     */
    @Override
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
