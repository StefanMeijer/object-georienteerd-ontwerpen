package Presentation;

import Slide.*;
import Slide.Viewer.*;

import java.util.ArrayList;

/**
 * Presentation keeps track of the slides in a presentation.
 * Only one instance of this class is available.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class Presentation {
    private String showTitle;  // The title of the presentation
    private ArrayList<Slide> showList;  // An ArrayList with slides
    private int currentSlideNumber;  // The number of the current slide
    private SlideViewerComponent slideViewComponent;  // The view component of the slides

    /**
     * Constructs a Presentation instance with default values.
     */
    public Presentation() {
        this.showList = null;
        this.currentSlideNumber = 0;
        this.slideViewComponent = null;

        clear();
    }

    /**
     * Constructs a Presentation instance with a specified SlideViewerComponent.
     *
     * @param slideViewerComponent The SlideViewerComponent to associate with the presentation.
     */
    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    /**
     * Clears the presentation by initializing the showList and setting the current slide number to -1.
     */
    public void clear() {
        showList = new ArrayList<Slide>();
        setCurrentSlideNumber(-1);
    }

    /**
     * Adds a slide to the presentation.
     *
     * @param slide The slide to be added.
     */
    public void append(Slide slide) {
        showList.add(slide);
    }

    /**
     * Exits the presentation by terminating the application with the specified exit code.
     *
     * @param n The exit code.
     */
    public void exit(int n) {
        System.exit(n);
    }

    /**
     * Navigates to the previous slide unless the current slide is the first one.
     */
    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setCurrentSlideNumber(currentSlideNumber - 1);
        }
    }

    /**
     * Navigates to the next slide unless the current slide is the last one.
     */
    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setCurrentSlideNumber(currentSlideNumber + 1);
        }
    }

    /**
     * Returns a slide with a specific number.
     *
     * @param number The slide number.
     * @return The slide with the specified number or null if not found.
     */
    public Slide getSlide(int number) {
        if (number < 0 || number >= getShowList().size()) {
            return null;
        }

        return showList.get(number);
    }

    /**
     * Returns the current slide.
     *
     * @return The current slide.
     */
    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    // Getter and Setter methods

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public ArrayList<Slide> getShowList() {
        return showList;
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    /**
     * Changes the current slide number and updates the slide view component.
     *
     * @param currentSlideNumber The new current slide number.
     */
    public void setCurrentSlideNumber(int currentSlideNumber) {
        this.currentSlideNumber = currentSlideNumber;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    /**
     * Sets the SlideViewerComponent for the presentation.
     *
     * @param slideViewerComponent The SlideViewerComponent to be set.
     */
    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }
}
