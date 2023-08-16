package model;

import java.util.Dictionary;


/**
 * This class represents the data and functions required to sharpen a given image using the sharpen
 * kernel.
 */
public class SharpenFilter extends FilterAbstract {

  /**
   * This constructor is used to initialise the SharpenFilter class objects with the given values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public SharpenFilter(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }


  @Override
  double[][] getKernel() {

    return new double[][]{
            {-0.125, -0.125, -0.125, -0.125, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1, 0.25, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}
    };


  }
}
