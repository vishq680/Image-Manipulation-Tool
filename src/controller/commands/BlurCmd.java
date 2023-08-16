package controller.commands;

import java.io.IOException;
import controller.ImageCommands;
import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the blur
 * functionality in model.
 */
public class BlurCmd implements ImageCommands {


  private final String[] arrOfStr;
  private boolean status;

  /**
   * This constructor is used to declare and initialise BlurCmd class objects with the given values
   * as parameters.
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public BlurCmd(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    }
    else {
      status = iInt.blur(arrOfStr[1], arrOfStr[2]);
      iIpt.outputDisplay(status,"blur");
    }
  }
}
