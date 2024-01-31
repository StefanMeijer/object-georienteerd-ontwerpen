package Accessor;

import Slide.Item.TextItem;

public class AccessorFactory {
    public static XMLAccessor createXMLAccessor() {
        return new XMLAccessor();
    }
}
