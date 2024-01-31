package Utility;

import Presentation.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * The KeyController class is a KeyListener responsible for handling keyboard events.
 * It interprets key presses and triggers corresponding actions on the associated Presentation.
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class KeyController extends KeyAdapter {
    private Presentation presentation; // Commands are given to the presentation

    /**
     * Constructs a KeyController with the given Presentation.
     *
     * @param p The Presentation to which commands will be directed.
     */
    public KeyController(Presentation p) {
        presentation = p;
    }

    /**
     * Handles key pressed events.
     *
     * @param keyEvent The KeyEvent representing the key press.
     */
    public void keyPressed(KeyEvent keyEvent) {
        // Interpret key presses and trigger corresponding actions
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, '+' -> getPresentation().nextSlide();
            case KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, '-' -> getPresentation().prevSlide();
            case 'q', 'Q' -> System.exit(0);
            // Should not be reached
            default -> {
            }
        }
    }

    /**
     * Gets the associated Presentation.
     *
     * @return The associated Presentation.
     */
    public Presentation getPresentation() {
        return presentation;
    }

    /**
     * Sets the associated Presentation.
     *
     * @param presentation The Presentation to be associated.
     */
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
