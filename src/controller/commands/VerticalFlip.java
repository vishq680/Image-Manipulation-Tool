package controller.commands;

import java.io.IOException;

import controller.ImageCommands;
import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the vertical flip
 * functionality in model.
 */
public class VerticalFlip implements ImageCommands {


  private boolean t;
  private final String[] arrOfStr;

  /**
   * This constructor is used to declare and initialise VerticalFlip class objects with the given
   * values as parameters.
   *
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public VerticalFlip(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }

  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    } else {
      t = iInt.verticalFlip(arrOfStr[1], arrOfStr[2]);
      iIpt.outputDisplay(t, "vertical-flip");
    }


  }
}
