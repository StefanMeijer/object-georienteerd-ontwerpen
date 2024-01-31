package Menu;

import Presentation.Presentation;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * MenuFactory provides factory methods to create menu-related components.
 */
public class MenuFactory {

    /**
     * Creates and returns a MenuController for managing menus and actions.
     *
     * @param frame         The parent frame.
     * @param presentation  The presentation to be managed.
     * @return A MenuController instance.
     */
    public static MenuController createMenuController(Frame frame, Presentation presentation) {
        return new MenuController(frame, presentation);
    }

    /**
     * Creates and returns a MenuItem with the specified title, ActionListener, and shift modifier usage.
     *
     * @param title            The title of the menu item.
     * @param actionListener  The ActionListener for the menu item.
     * @param useShiftModifier Whether to use the shift modifier.
     * @return A MenuItem instance.
     */
    public static MenuItem createMenuItem(String title, ActionListener actionListener, boolean useShiftModifier) {
        MenuItem menuItem = new MenuItem(title, createMenuShortcut(title.charAt(0), useShiftModifier));
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    /**
     * Creates and returns a MenuShortcut with the specified key and shift modifier usage.
     *
     * @param key              The key for the menu shortcut.
     * @param useShiftModifier Whether to use the shift modifier.
     * @return A MenuShortcut instance.
     */
    public static MenuShortcut createMenuShortcut(int key, boolean useShiftModifier) {
        return new MenuShortcut(key, useShiftModifier);
    }
}
