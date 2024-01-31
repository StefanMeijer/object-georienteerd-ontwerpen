package Accessor;

/**
 * AccessorFactory provides a factory method to create instances of Accessor classes.
 */
public class AccessorFactory {

    /**
     * Creates and returns an instance of XMLAccessor.
     *
     * @return An instance of XMLAccessor.
     */
    public static XMLAccessor createXMLAccessor() {
        return new XMLAccessor();
    }
}
