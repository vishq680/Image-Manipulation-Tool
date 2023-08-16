package modeltest;

import model.ImageManipulationAndEnhanceV2;

/**
 * This is a helper class for testing the model.
 */
public class TestModel extends ImageManipulationAndEnhanceV2 implements TestInterface {

  @Override
  public int[][][] testFunc(String imgName) {

    return images.get(imgName).getPixels();

  }
}
