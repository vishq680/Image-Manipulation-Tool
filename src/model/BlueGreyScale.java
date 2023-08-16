package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform greyscale on blue
 * component of the given image.
 */
public class BlueGreyScale extends GreyScaleAbstract {

  /**
   * This constructor is used to declare and initialise BlueGreyScale class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public BlueGreyScale(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double getComponentValue(int i, int j) {
    return images.get(imgName).getPixels()[2][i][j];
  }
}
