package Utility;

import Presentation.Presentation;

import java.io.IOException;

public interface SaveController {
    abstract public void saveFile(Presentation p, String fn) throws IOException;
}
