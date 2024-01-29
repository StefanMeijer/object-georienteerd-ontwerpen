import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>This is the KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
    private Presentation presentation; //Commands are given to the presentation

    public KeyController(Presentation p) {
        presentation = p;
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                getPresentation().nextSlide();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                getPresentation().prevSlide();
                break;
            case 'q':
            case 'Q':
                System.exit(0);
                break; //Should not be reached
            default:
                break;
        }
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
