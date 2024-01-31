package Slide.Item;

/**
 * SlideItemFactory is a factory class for creating different types of slide items.
 * It provides methods to create TextItem and BitmapItem instances.
 */
public class SlideItemFactory {

    /**
     * Creates a TextItem with the specified level and string content.
     *
     * @param level  The level of the TextItem.
     * @param string The content of the TextItem.
     * @return A new TextItem instance.
     */
    public static TextItem createTextItem(int level, String string) {
        return new TextItem(level, string);
    }

    /**
     * Creates a BitmapItem with the specified level and image name.
     *
     * @param level The level of the BitmapItem.
     * @param name  The name of the image file for the BitmapItem.
     * @return A new BitmapItem instance.
     */
    public static BitmapItem createBitmapItem(int level, String name) {
        return new BitmapItem(level, name);
    }
}
