package model;

import java.util.Dictionary;


/**
 * This class represents the data and the functionalities required to perform greyscale on intensity
 * component of the given image.
 */
public class IntensityGreyScale extends GreyScaleAbstract {

  /**
   * This constructor is used to declare and initialise IntensityGreyScale class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public IntensityGreyScale(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double getComponentValue(int i, int j) {
    int[][][] pixels = images.get(imgName).getPixels();
    return (int) Math.round((pixels[0][i][j] + pixels[1][i][j] + pixels[2][i][j]) / 3.0);
  }
}
