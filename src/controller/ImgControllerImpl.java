package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import controller.commands.BlurCmd;
import controller.commands.Brighten;
import controller.commands.DitherCmd;
import controller.commands.Greyscale;
import controller.commands.HorizontalFlip;
import controller.commands.Load;
import controller.commands.RGBCombine;
import controller.commands.RGBSplit;
import controller.commands.Save;
import controller.commands.SepiaCmd;
import controller.commands.SharpenCmd;
import controller.commands.VerticalFlip;
import model.ImageInterfaceV3;
import view.IView;
import view.InputCmd;
import view.SwingView;


/**
 * This class represents the controller and implements the ImgController interface.
 * It delegated all the functionalities to model and view.
 */

public class ImgControllerImpl implements ImgController {


  private final ImageInterfaceV3 modelObj;
  private final InputCmd viewObj;
  private final String[] args;
  private IView view;
  private final Map<String, Function<String[], ImageCommands>> knownCommands = new HashMap<>();


  /**
   * This represents a constructor which get an object of the ImageInterface and InputCmd
   * as it's parameter and is assigned to the local private variables.
   *
   * @param img    Represents the model object.
   * @param input1 Represents the view object.
   */
  public ImgControllerImpl(ImageInterfaceV3 img, InputCmd input1, String[] args) {
    this.modelObj = img;
    this.viewObj = input1;
    this.args = args;
  }


  /**
   * This is a helper method which accepts one command as an array of string and
   * calls the appropriate method from the model.x
   *
   * @param arrOfStr Represents one command split space-wise as an array of string.
   */
  private void modCall(String[] arrOfStr, InputCmd v1) throws IOException {

    if (arrOfStr.length == 0) {
      return;
    }
    String s1 = arrOfStr[0];


    knownCommands.put("load", s -> new Load(arrOfStr));
    knownCommands.put("brighten", s -> new Brighten(arrOfStr));
    knownCommands.put("vertical-flip", s -> new VerticalFlip(arrOfStr));
    knownCommands.put("horizontal-flip", s -> new HorizontalFlip(arrOfStr));
    knownCommands.put("greyscale", s -> new Greyscale(arrOfStr));
    knownCommands.put("save", s -> new Save(arrOfStr));
    knownCommands.put("rgb-split", s -> new RGBSplit(arrOfStr));
    knownCommands.put("rgb-combine", s -> new RGBCombine(arrOfStr));
    knownCommands.put("dither", s -> new DitherCmd(arrOfStr));
    knownCommands.put("sepia", s -> new SepiaCmd(arrOfStr));
    knownCommands.put("sharpen", s -> new SharpenCmd(arrOfStr));
    knownCommands.put("blur", s -> new BlurCmd(arrOfStr));


    ImageCommands c;
    Function<String[], ImageCommands> cmd = knownCommands.getOrDefault(s1, null);

    if (cmd == null) {
      v1.invalidCmd();
    } else {
      c = cmd.apply(arrOfStr);
      c.cmdFunction(modelObj, v1);
    }


  }

  @Override
  public void prog() throws IllegalArgumentException, IOException {
    String fileName;


    if (args.length > 0) {

      if (args[0].equals("-file")) {
        fileName = args[1];
        try {
          File file = new File(fileName);
          BufferedReader br = new BufferedReader(new FileReader(file));
          String st;
          while ((st = br.readLine()) != null) {
            String[] arrOfStr1 = st.split(" ");
            modCall(arrOfStr1, viewObj);

          }
          return;
        } catch (FileNotFoundException e) {
          return;
        }
      } else if (args[0].equals("-text")) {

        while (true) {

          String str = viewObj.inputReceived();

          String[] arrOfStr = str.split(" ");

          String s1 = arrOfStr[0];

          if (s1.equals("quit")) {
            break;
          } else if (s1.equals("run")) {

            try {
              File file = new File(arrOfStr[1]);
              BufferedReader br = new BufferedReader(new FileReader(file));
              String st;
              while ((st = br.readLine()) != null) {
                arrOfStr = st.split(" ");
                modCall(arrOfStr, viewObj);
              }
            } catch (FileNotFoundException e) {
              viewObj.invalidCmd();
            }
          } else {
            modCall(arrOfStr, viewObj);
          }

        }

        return;

      }
    }


    view = new SwingView();
    configureButtonListener();


  }


  private void buttonClickHelper1(String t) {
    try {
      modCall(t.split("\\s+"), view);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void buttonClickHelper2(String t) {
    buttonClickHelper1(t);
    if (modelObj.getGUIImage() == null) {
      try {
        view.invalidCmd();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return;
    }
    view.setImage(modelObj.getGUIImage(), modelObj.getHistogram());
  }

  private void configureButtonListener() {
    Map<String, Runnable> buttonClickedMap = new HashMap<>();
    ButtonListener buttonListener = new ButtonListener();

    buttonClickedMap.put("Open file", () ->
            buttonClickHelper2("load " + view.getLoadPath() + " guiImg"));

    buttonClickedMap.put("blrImg", () ->
            buttonClickHelper2("blur " + "guiImg " + "guiImg"));

    buttonClickedMap.put("brtImg", () ->
            buttonClickHelper2("brighten " + view.getBrightenValue() + " guiImg " + "guiImg"));

    buttonClickedMap.put("hozImg", () ->
            buttonClickHelper2("horizontal-flip " + "guiImg " + "guiImg"));

    buttonClickedMap.put("vertImg", () ->
            buttonClickHelper2("vertical-flip " + "guiImg " + "guiImg"));

    buttonClickedMap.put("greyImg", () ->
            buttonClickHelper2("greyscale " + view.getGreyscaleComponent() + " guiImg " +
                    "guiImg"));
    buttonClickedMap.put("sharpImg", () ->
            buttonClickHelper2("sharpen" + " guiImg " + "guiImg"));

    buttonClickedMap.put("ditherImg", () ->
            buttonClickHelper2("dither" + " guiImg " + "guiImg"));

    buttonClickedMap.put("sepiaImg", () ->
            buttonClickHelper2("sepia" + " guiImg " + "guiImg"));

    buttonClickedMap.put("saveImg", () ->
            buttonClickHelper2("save " + view.getSavePath() + " guiImg"));

    buttonClickedMap.put("rgbSplitImg", () -> {

      String[] rgbLoc = view.showSplit();


      buttonClickHelper1("rgb-split guiImg red green blue");
      buttonClickHelper1("save " + rgbLoc[0] + " red");
      buttonClickHelper1("save " + rgbLoc[1] + " green");
      buttonClickHelper1("save " + rgbLoc[2] + " blue");

      view.setImage(modelObj.getGUIImage(), modelObj.getHistogram());
    });

    buttonClickedMap.put("rgbCombImg", () -> {

      String[] rgbLoc = view.rgbCombine();

      buttonClickHelper1("load " + rgbLoc[0] + " red");
      buttonClickHelper1("load " + rgbLoc[1] + " green");
      buttonClickHelper1("load " + rgbLoc[2] + " blue");
      buttonClickHelper1("rgb-combine guiImg red blue green");

      view.setImage(modelObj.getGUIImage(), modelObj.getHistogram());
    });

    buttonClickedMap.put("EXIT", () -> System.exit(0));

    buttonListener.setButtonClickedActionMap(buttonClickedMap);
    this.view.addActionListener(buttonListener);
  }


}
