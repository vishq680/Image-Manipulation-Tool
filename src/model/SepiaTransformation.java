package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform greyscale on blue
 * component of the given image.
 */
public class SepiaTransformation extends TransformAbstract {

  /**
   * This constructor is used to declare and initialise SepiaTransformation class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public SepiaTransformation(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double[][] getColorMatrix() {
    return new double[][]{
            {0.393, 0.769, 0.189},
            {0.349, 0.686, 0.168},
            {0.272, 0.534, 0.131}
    };
  }
}
