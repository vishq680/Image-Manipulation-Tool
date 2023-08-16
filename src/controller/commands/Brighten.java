package controller.commands;

import java.io.IOException;

import controller.ImageCommands;

import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the brighten
 * functionality in model.
 */
public class Brighten implements ImageCommands {

  private boolean t;
  private final String[] arrOfStr;
  /**
   * This constructor is used to declare and initialise Brighten class objects with the given values
   * as parameters.
   * @param arrOfStr input parameters given to be given when calling model function.
   */

  public Brighten(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 4) {
      iIpt.invalidCmd();
    }
    else {
      int i = Integer.parseInt(arrOfStr[1]);
      t = iInt.brightenImage(i, arrOfStr[2], arrOfStr[3]);
      iIpt.outputDisplay(t,"brighten");
    }

  }
}f
