package Slide.Viewer;

import Menu.MenuController;
import Presentation.*;
import Utility.*;
import Menu.*;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * The application window for a SlideViewerComponent.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideViewerFrame extends JFrame {
    private static final long serialVersionUID = 3227L;
    private static final String JABTITLE = "Jabberpoint 1.6 - OU";
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;

    /**
     * Constructs a SlideViewerFrame with the specified title and presentation.
     *
     * @param title        The title of the frame.
     * @param presentation The presentation to be displayed.
     */
    public SlideViewerFrame(String title, Presentation presentation) {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
        presentation.setShowView(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    /**
     * Set up the GUI for the SlideViewerFrame.
     *
     * @param slideViewerComponent The SlideViewerComponent to be displayed.
     * @param presentation        The presentation associated with the frame.
     */
    public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
        setTitle(JABTITLE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation)); // Add a controller

        // Set up menu bar with menu controller
        setMenuBar(MenuFactory.createMenuController(this, presentation));

        setSize(new Dimension(WIDTH, HEIGHT)); // Set the frame size to match a slide
        setVisible(true);
    }
}
