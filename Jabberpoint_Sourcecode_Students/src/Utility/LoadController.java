package Utility;

import Presentation.Presentation;

import java.io.IOException;

/**
 * The LoadController interface defines a contract for classes responsible for loading a presentation from a file.
 * Implementing classes must provide the logic for loading a presentation.
 *
 * Author: [Your Name]
 */
public interface LoadController {

    /**
     * Loads a presentation from the specified file and associates it with the given Presentation instance.
     *
     * @param p  The Presentation instance to associate the loaded presentation with.
     * @param fn The file name or path from which to load the presentation.
     * @throws IOException If an I/O error occurs during the loading process.
     */
    void loadFile(Presentation p, String fn) throws IOException;
}
