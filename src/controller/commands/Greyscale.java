package controller.commands;

import java.io.IOException;

import controller.ImageCommands;

import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the greyscale
 * functionality in model.
 */
public class Greyscale implements ImageCommands {

  private boolean t;
  private String[] arrOfStr;


  public Greyscale(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {


    if (arrOfStr.length == 3) {
      t = iInt.greyscale(arrOfStr[1], arrOfStr[2]);
      iIpt.outputDisplay(t, "greyscale");
    } else if (arrOfStr.length != 4) {
      iIpt.invalidCmd();
    } else {
      if (arrOfStr[1].equals("red-component")) {
        t = iInt.greyScaleRed(arrOfStr[2], arrOfStr[3]);
      } else if (arrOfStr[1].equals("blue-component")) {
        t = iInt.greyScaleBlue(arrOfStr[2], arrOfStr[3]);
      } else if (arrOfStr[1].equals("green-component")) {
        t = iInt.greyScaleGreen(arrOfStr[2], arrOfStr[3]);
      } else if (arrOfStr[1].equals("value-component")) {
        t = iInt.greyScaleValue(arrOfStr[2], arrOfStr[3]);
      } else if (arrOfStr[1].equals("luma-component")) {
        t = iInt.greyScaleLuma(arrOfStr[2], arrOfStr[3]);
      } else if (arrOfStr[1].equals("intensity-component")) {
        t = iInt.greyScaleIntensity(arrOfStr[2], arrOfStr[3]);
      } else {
        iIpt.invalidCmd();
      }

      iIpt.outputDisplay(t, "greyscale");
    }


  }
}
