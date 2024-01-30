package Accessor;

import Presentation.*;
import Slide.*;
import Slide.Item.BitmapItem;
import Slide.Item.SlideItem;
import Slide.Item.SlideItemFactory;
import Slide.Item.TextItem;

/**
 * A built-in demo presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
class DemoPresentation extends Accessor {

    public void loadFile(Presentation presentation, String unusedFilename) {
        presentation.setShowTitle("Demo Presentation.Presentation");

        Slide slide = SlideFactory.createSlide();
        slide.setTitle("JabberPoint");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "The Java prestentation tool"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "Copyright (c) 1996-2000: Ian Darwin"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "Copyright (c) 2000-now:"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "Gert Florijn and Sylvia Stuurman"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(4, "Calling Jabberpoint without a filename"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(4, "will show this presentation"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "Navigate:"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(3, "Next slide: PgDn or Enter"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(3, "Previous slide: PgUp or up-arrow"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(3, "Quit: q or Q"), slide);
        presentation.append(slide);

        slide = SlideFactory.createSlide();
        slide.setTitle("Demonstration of levels and styles");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "Level 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "Level 2"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "Again level 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "Level 1 has style number 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "Level 2 has style number 2"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(3, "This is how level 3 looks like"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(4, "And this is level 4"), slide);
        presentation.append(slide);

        slide = SlideFactory.createSlide();
        slide.setTitle("The third slide");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "To open a new presentation,"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(2, "use File->Open from the menu."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, " "), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createTextItem(1, "This is the end of the presentation."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createBitmapItem(1, "assets/images/JabberPoint.jpg"), slide);
        presentation.append(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename) {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
