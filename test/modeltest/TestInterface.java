package modeltest;

import model.ImageInterfaceV2;

/**
 * This represents the interface for testing the model.
 */
public interface TestInterface extends ImageInterfaceV2 {

  /**
   * The test function is used to return the image pixels from the model.
   *
   * @param imgName Refers to the name of the image.
   * @return The integer array of pixels.
   */
  int[][][] testFunc(String imgName);


}
