import Accessor.*;
import Presentation.*;
import Slide.Viewer.SlideViewerFrame;
import Style.*;

import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * Author: Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * Version: 1.6 2014/05/16 Sylvia Stuurman
 */
public class JabberPoint {
    private static final String IOERR = "IO Error: ";
    private static final String JABERR = "Jabberpoint Error ";
    private static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    /**
     * The main program entry point.
     *
     * @param argv Command-line arguments.
     */
    public static void main(String[] argv) {
        // Create predefined styles for slides
        StyleFactory.createStyles();

        // Create a new presentation
        Presentation presentation = PresentationFactory.createPresentation();

        // Create the main SlideViewerFrame
        new SlideViewerFrame(JABVERSION, presentation);

        try {
            // Check if command-line arguments are provided
            if (argv.length == 0) { // No command-line arguments, create a demo presentation
                PresentationFactory.createDemoPresentation(presentation);
            } else {
                // Load presentation from the specified file using the XMLAccessor
                AccessorFactory.createXMLAccessor().loadFile(presentation, argv[0]);
            }

            // Set the current slide number to the beginning
            presentation.setCurrentSlideNumber(0);
        } catch (IOException ex) {
            // Display an error message if an IOException occurs during loading
            JOptionPane.showMessageDialog(null,
                    IOERR + ex, JABERR,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
