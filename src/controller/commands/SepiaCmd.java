package controller.commands;

import java.io.IOException;

import controller.ImageCommands;
import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the sepia
 * functionality in model.
 */
public class SepiaCmd implements ImageCommands {

  private String[] arrOfStr;

  private boolean t;

  /**
   * This constructor is used to declare and initialise SepiaCmd class objects with the given
   * values as parameters.
   *
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public SepiaCmd(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    } else {
      t = iInt.sepia(arrOfStr[1], arrOfStr[2]);
      iIpt.outputDisplay(t, "sepia");
    }
  }

}
