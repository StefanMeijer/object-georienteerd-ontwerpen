package Utility;

import Presentation.Presentation;

import java.io.IOException;

/**
 * The SaveController interface defines a contract for classes responsible for saving a presentation to a file.
 * Implementing classes must provide the logic for saving a presentation.
 *
 * Author: [Your Name]
 */
public interface SaveController {

    /**
     * Saves the given Presentation instance to the specified file.
     *
     * @param p  The Presentation instance to be saved.
     * @param fn The file name or path to which the presentation should be saved.
     * @throws IOException If an I/O error occurs during the saving process.
     */
    void saveFile(Presentation p, String fn) throws IOException;
}
