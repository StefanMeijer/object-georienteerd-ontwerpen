package Presentation;

import Slide.*;
import Slide.Viewer.SlideViewerComponent;

import java.util.ArrayList;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
    private String showTitle; //The title of the presentation
    private ArrayList<Slide> showList; //An ArrayList with slides
    private int currentSlideNumber; //The number of the current slide
    private SlideViewerComponent slideViewComponent; //The view component of the slides

    public Presentation() {
        this.showList = null;
        this.currentSlideNumber = 0;
        this.slideViewComponent = null;

        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    //Remove the presentation
    public void clear() {
        showList = new ArrayList<Slide>();
        setCurrentSlideNumber(-1);
    }

    //Add a slide to the presentation
    public void append(Slide slide) {
        showList.add(slide);
    }

    //Exit the presentation
    public void exit(int n) {
        System.exit(n);
    }

    //Navigate to the previous slide unless we are at the first slide
    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setCurrentSlideNumber(currentSlideNumber - 1);
        }
    }

    //Navigate to the next slide unless we are at the last slide
    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setCurrentSlideNumber(currentSlideNumber + 1);
        }
    }

    //Return a slide with a specific number
    public Slide getSlide(int number) {
        if (number < 0 || number >= getShowList().size()) {
            return null;
        }

        return showList.get(number);
    }

    //Return the current slide
    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public ArrayList<Slide> getShowList() {
        return showList;
    }

    public void setShowList(ArrayList<Slide> showList) {
        this.showList = showList;
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    //Change the current slide number and report it the the window
    public void setCurrentSlideNumber(int currentSlideNumber) {
        this.currentSlideNumber = currentSlideNumber;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    public SlideViewerComponent getSlideViewComponent() {
        return slideViewComponent;
    }

    public void setSlideViewComponent(SlideViewerComponent slideViewComponent) {
        this.slideViewComponent = slideViewComponent;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }
}
