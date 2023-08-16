import java.io.IOException;
import java.io.InputStreamReader;

import controller.ImgController;
import controller.ImgControllerImpl;
import model.ImageInterfaceV3;
import model.ImageManipulationAndEnhanceV3;
import view.InputCmd;
import view.InputCmdImpl;


/**
 * This class contains utility meth ods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {


  //demo main

  /**
   * Main function which acts as the driver code and the program execution starts from this
   * function.
   *
   * @param args command line arguments
   * @throws IOException exception thrown when there is invalid input/ output operation.
   */
  public static void main(String[] args) throws IOException {

    ImageInterfaceV3 t = new ImageManipulationAndEnhanceV3();


    InputCmd input = new InputCmdImpl(new InputStreamReader(System.in), System.out);
    ImgController c = new ImgControllerImpl(t, input, args);

    c.prog();




  }

}

