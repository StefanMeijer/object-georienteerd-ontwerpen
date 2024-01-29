package Utility;

import Accessor.*;
import Presentation.*;
import Slide.*;
import Style.*;
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

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
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
    private Frame parent; //The frame, only used as parent for the Dialogs
    private Presentation presentation; //Commands are given to the presentation

    public MenuController(Frame frame, Presentation pres) {
        setParent(frame);
        setPresentation(pres);
        MenuItem menuItem;
        Menu fileMenu = new Menu(FILE);
        fileMenu.add(menuItem = mkMenuItem(OPEN));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                getPresentation().clear();
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.loadFile(getPresentation(), TESTFILE);
                    getPresentation().setCurrentSlideNumber(0);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(getParent(), IOEX + exc,
                            LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                getParent().repaint();
            }
        });
        fileMenu.add(menuItem = mkMenuItem(NEW));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                getPresentation().clear();
                getParent().repaint();
            }
        });
        fileMenu.add(menuItem = mkMenuItem(SAVE));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.saveFile(getPresentation(), SAVEFILE);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(getParent(), IOEX + exc,
                            SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fileMenu.addSeparator();
        fileMenu.add(menuItem = mkMenuItem(EXIT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                getPresentation().exit(0);
            }
        });
        add(fileMenu);
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(menuItem = mkMenuItem(NEXT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                getPresentation().nextSlide();
            }
        });
        viewMenu.add(menuItem = mkMenuItem(PREV));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                getPresentation().prevSlide();
            }
        });
        viewMenu.add(menuItem = mkMenuItem(GOTO));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
                int pageNumber = Integer.parseInt(pageNumberStr);
                getPresentation().setCurrentSlideNumber(pageNumber - 1);
            }
        });
        add(viewMenu);
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(menuItem = mkMenuItem(ABOUT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AboutBox.show(getParent());
            }
        });
        setHelpMenu(helpMenu);        //Needed for portability (Motif, etc.).
    }

    //Creating a menu-item
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

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
