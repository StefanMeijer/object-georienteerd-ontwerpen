package Slide;

import Slide.Item.SlideItem;

/**
 * A factory class for creating and manipulating Slide instances.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideFactory {

    /**
     * Creates a new Slide instance.
     *
     * @return A new Slide instance.
     */
    public static Slide createSlide() {
        return new Slide();
    }

    /**
     * Appends a SlideItem to a Slide.
     *
     * @param item  The SlideItem to append.
     * @param slide The Slide to which the SlideItem will be appended.
     */
    public static void appendSlideItemToSlide(SlideItem item, Slide slide) {
        slide.append(item);
    }
}
