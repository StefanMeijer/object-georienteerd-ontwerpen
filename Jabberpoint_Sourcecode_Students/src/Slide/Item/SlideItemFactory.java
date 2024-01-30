package Slide.Item;

public class SlideItemFactory {
    public static TextItem createTextItem(int level, String string) {
        return new TextItem(level, string);
    }

    public static BitmapItem createBitmapItem(int level, String name) {
        return new BitmapItem(level, name);
    }
}
