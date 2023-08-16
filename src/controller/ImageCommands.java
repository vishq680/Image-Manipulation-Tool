package controller;

import java.io.IOException;


import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This interface represents the command function whose implementation will contain code to invoke
 * model functions according to the command entered.
 */
public interface ImageCommands {

  /**
   * This function invokes the appropriate function in model according to the command entered by the
   * user.
   *
   * @param iInt model.
   * @param iIpt view.
   * @throws IOException Exception thrown when there is invalid input/output operations
   */
  void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException;

}
