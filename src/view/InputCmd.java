package view;

import java.io.IOException;

/**
 * This represents the view functionality in the image manipulation class. This class is responsible
 * for printing anything to the user.
 */
public interface InputCmd {

  /**
   * This is used to obtain the required query from the user and
   * is sent back to the user.
   *
   * @return The user input in a string format.
   */
  String inputReceived() throws IOException;

  /**
   * Is used to display a suitable message after the model has been called.
   *
   * @param t True if the model has been successfully called and false otherwise.
   * @param s Represents the exact method that was called initially.
   */
  void outputDisplay(boolean t, String s) throws IOException;

  /**
   * This method is used to print an error when an invalid command is executed.
   */
  void invalidCmd() throws IOException;

}
