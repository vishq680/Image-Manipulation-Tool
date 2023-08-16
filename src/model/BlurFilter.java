package model;

import java.util.Dictionary;

/**
 * This class represents the data and functions required to blur a given image using the blur
 * kernel.
 */
public class BlurFilter extends FilterAbstract {

  /**
   * This constructor is used to initialise the BlurFilter class objects with the given values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public BlurFilter(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double[][] getKernel() {

    return new double[][]{
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}
    };
  }
}
