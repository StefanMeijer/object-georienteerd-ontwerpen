package Utility;

import Presentation.Presentation;

import java.io.IOException;

public interface LoadController {
    abstract public void loadFile(Presentation p, String fn) throws IOException;
}
