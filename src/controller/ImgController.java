package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This interface represents the controller of image manipulation and enhancement operations.
 */
public interface ImgController {

  /**
   * This method is used to call the necessary method from the model
   * after reading the input given by the user.
   *
   * @throws FileNotFoundException If the file is not found, an appropriate exception is thrown.
   */
  void prog() throws IOException;
}
