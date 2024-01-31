package Menu;

import Presentation.Presentation;

import java.awt.*;
import java.awt.event.ActionListener;

public class MenuFactory {
    public static MenuController createMenuController(Frame frame, Presentation presentation) {
        return new MenuController(frame, presentation);
    }

    public static MenuItem createMenuItem(String title, ActionListener actionListener, boolean useShiftModifier) {
        MenuItem menuItem = new MenuItem(title, createMenuShortcut(title.charAt(0), useShiftModifier));
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    public static MenuShortcut createMenuShortcut(int key , boolean useShiftModifier) {
        return new MenuShortcut(key, useShiftModifier);
    }
}
