package Menu;

import Accessor.*;
import Presentation.*;
import Menu.*;
import Utility.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serial;

import javax.swing.JOptionPane;

public class MenuController extends MenuBar {
    private static final String ABOUT = "About";
    private static final String FILE = "File";
    private static final String EXIT = "Exit";
    private static final String GOTO = "Go to";
    private static final String HELP = "Help";
    private static final String NEW = "New";
    private static final String NEXT = "Next";
    private static final String OPEN = "Open";
    private static final String PAGENR = "Page number?";
    private static final String PREV = "Prev";
    private static final String SAVE = "Save";
    private static final String VIEW = "View";
    private static final String TESTFILE = "assets/presentations/testPresentation.xml";
    private static final String SAVEFILE = "assets/presentations/savedPresentation.xml";
    private static final String IOEX = "IO Exception: ";
    private static final String LOADERR = "Load Error";
    private static final String SAVEERR = "Save Error";
    @Serial
    private static final long serialVersionUID = 227L;
    private Frame parent;
    private Presentation presentation;
    private final Menu fileMenu;
    private final Menu viewMenu;
    private final Menu helpMenu;

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
        fileMenu.add(MenuFactory.createMenuItem(OPEN, this::openFileAction, false));
        fileMenu.add(MenuFactory.createMenuItem(NEW, this::newFileAction, false));
        fileMenu.add(MenuFactory.createMenuItem(SAVE, this::saveFileAction, false));
        fileMenu.addSeparator();
        fileMenu.add(MenuFactory.createMenuItem(EXIT, actionEvent -> getPresentation().exit(0), false));
        add(fileMenu);
    }

    private void makeViewMenu() {
        viewMenu.add(MenuFactory.createMenuItem(NEXT, actionEvent -> getPresentation().nextSlide(), true));
        viewMenu.add(MenuFactory.createMenuItem(PREV, actionEvent -> getPresentation().prevSlide(), false));
        viewMenu.add(MenuFactory.createMenuItem(GOTO, this::gotoPageAction, false));
        add(viewMenu);
    }

    private void makeHelpMenu() {
        helpMenu.add(MenuFactory.createMenuItem(ABOUT, actionEvent -> AboutBox.show(getParent()), false));
        setHelpMenu(helpMenu);
    }

    //Actions
    private void openFileAction(ActionEvent actionEvent) {
        getPresentation().clear();

        XMLAccessor xmlAccessor = AccessorFactory.createXMLAccessor()
;        try {
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


    //Getters & Setters
    @Override
    public Frame getParent() {
        return parent;
    }

    public void setParent(Frame parent) {
        this.parent = parent;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
