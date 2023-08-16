package controller.commands;

import java.io.IOException;

import controller.ImageCommands;
import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the horizontal
 * flip functionality in model.
 */
public class HorizontalFlip implements ImageCommands {


  private boolean t;
  private String[] arrOfStr;

  public HorizontalFlip(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    } else {
      t = iInt.horizontalFlip(arrOfStr[1], arrOfStr[2]);
      iIpt.outputDisplay(t, "horizontal-flip");
    }


  }
}
