package Utility;

import Presentation.Presentation;

import java.io.IOException;

public interface LoadController {
    void loadFile(Presentation p, String fn) throws IOException;
}
