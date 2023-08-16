package controller.commands;

import java.io.IOException;

import controller.ImageCommands;

import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the RGBSplit
 * functionality in model.
 */
public class RGBSplit implements ImageCommands {


  private boolean t;
  private final String[] arrOfStr;

  /**
   * This constructor is used to declare and initialise RGBSplit class objects with the given
   * values as parameters.
   *
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public RGBSplit(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }

  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {


    if (arrOfStr.length != 5) {
      iIpt.invalidCmd();
    } else {
      t = iInt.rgbSplit(arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4]);
      iIpt.outputDisplay(t, "rgb-split");
    }


  }
}
