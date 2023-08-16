package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform greyscale on blue
 * component of the given image.
 */
public class GreyscaleTransformation extends TransformAbstract {

  /**
   * This constructor is used to declare and initialise GreyscaleTransformation class objects with
   * the appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */

  public GreyscaleTransformation(Dictionary<String, Image> images, String imgName,
                                 String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double[][] getColorMatrix() {
    return new double[][]{
            {0.2126, 0.7152, .0722},
            {0.2126, 0.7152, .0722},
            {0.2126, 0.7152, .0722}
    };
  }
}
