package Utility;

import Presentation.Presentation;

import java.io.IOException;

public interface SaveController {
    void saveFile(Presentation p, String fn) throws IOException;
}
