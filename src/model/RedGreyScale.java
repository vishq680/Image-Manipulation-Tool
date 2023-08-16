package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform greyscale on red
 * component of the given image.
 */
public class RedGreyScale extends GreyScaleAbstract {

  /**
   * This constructor is used to declare and initialise RedGreyScale class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public RedGreyScale(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  double getComponentValue(int i, int j) {
    return images.get(imgName).getPixels()[0][i][j];
  }
}
