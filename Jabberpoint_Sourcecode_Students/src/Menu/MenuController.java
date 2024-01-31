package Menu;

import Accessor.*;
import Presentation.*;
import Utility.*;
import static Menu.MenuVariables.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * MenuController manages the menu actions for the presentation application.
 */
public class MenuController extends MenuBar {
    private Frame parent;
    private Presentation presentation;
    private final Menu fileMenu;
    private final Menu viewMenu;
    private final Menu helpMenu;

    /**
     * Constructs a MenuController with the specified frame and presentation.
     *
     * @param frame         The parent frame.
     * @param presentation  The presentation to be managed.
     */
    public MenuController(Frame frame, Presentation presentation) {
        this.parent = frame;
        this.presentation = presentation;

        this.fileMenu = new Menu(FILE);
        this.viewMenu = new Menu(VIEW);
        this.helpMenu = new Menu(HELP);

        this.makeFileMenu();
        this.makeViewMenu();
        this.makeHelpMenu();
    }

    private void makeFileMenu() {
        // Creating and adding items to the File menu
        fileMenu.add(MenuFactory.createMenuItem(OPEN, this::openFileAction, false));
        fileMenu.add(MenuFactory.createMenuItem(NEW, this::newFileAction, false));
        fileMenu.add(MenuFactory.createMenuItem(SAVE, this::saveFileAction, false));
        fileMenu.addSeparator();
        fileMenu.add(MenuFactory.createMenuItem(EXIT, actionEvent -> getPresentation().exit(0), false));
        add(fileMenu);
    }

    private void makeViewMenu() {
        // Creating and adding items to the View menu
        viewMenu.add(MenuFactory.createMenuItem(NEXT, actionEvent -> getPresentation().nextSlide(), true));
        viewMenu.add(MenuFactory.createMenuItem(PREV, actionEvent -> getPresentation().prevSlide(), false));
        viewMenu.add(MenuFactory.createMenuItem(GOTO, this::gotoPageAction, false));
        add(viewMenu);
    }

    private void makeHelpMenu() {
        // Creating and adding items to the Help menu
        helpMenu.add(MenuFactory.createMenuItem(ABOUT, actionEvent -> AboutBox.show(getParent()), false));
        setHelpMenu(helpMenu);
    }

    // Action methods for menu items

    private void openFileAction(ActionEvent actionEvent) {
        getPresentation().clear();

        XMLAccessor xmlAccessor = AccessorFactory.createXMLAccessor();
        try {
            xmlAccessor.loadFile(getPresentation(), TESTFILE);
            getPresentation().setCurrentSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(getParent(), IOEX + exc,
                    LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        getParent().repaint();
    }

    private void newFileAction(ActionEvent actionEvent) {
        getPresentation().clear();
        getParent().repaint();
    }

    private void saveFileAction(ActionEvent e) {
        XMLAccessor xmlAccessor = AccessorFactory.createXMLAccessor();
        try {
            xmlAccessor.saveFile(getPresentation(), SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(getParent(), IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gotoPageAction(ActionEvent actionEvent) {
        String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);

            if (pageNumber >= 0 && pageNumber <= this.getPresentation().getShowList().size()) {
                getPresentation().setCurrentSlideNumber(pageNumber - 1);
            }
        } catch (Exception ignored) {
            JOptionPane.showMessageDialog(parent,
                    "Only numbers are allowed.",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    @Override
    public Frame getParent() {
        return parent;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
