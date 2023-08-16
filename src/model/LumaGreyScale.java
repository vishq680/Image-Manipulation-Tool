package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform greyscale on luma
 * component of the given image.
 */
public class LumaGreyScale extends GreyScaleAbstract {

  /**
   * This constructor is used to declare and initialise LumaGreyScale class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public LumaGreyScale(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }


  @Override
  double getComponentValue(int i, int j) {
    int[][][] pixels = images.get(imgName).getPixels();
    return Math.round(0.2126 * pixels[0][i][j] + 0.715 * pixels[1][i][j] + 0.0722
            * pixels[2][i][j]);
  }
}
