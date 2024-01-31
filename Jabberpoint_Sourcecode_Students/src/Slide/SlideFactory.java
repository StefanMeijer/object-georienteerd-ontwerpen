package Slide;

import Accessor.*;
import Presentation.*;
import Slide.*;
import Slide.Item.*;
import Style.*;
import Utility.*;
import Menu.*;

public class SlideFactory {
    public static Slide createSlide() {
        return new Slide();
    }

    public static void appendSlideItemToSlide(SlideItem item, Slide slide) {
        slide.append(item);
    }
}