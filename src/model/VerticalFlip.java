package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform vertical flip of the
 * given image.
 */
public class VerticalFlip extends FlipAbstract {

  /**
   * This constructor is used to declare and initialise VerticalFlip class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public VerticalFlip(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  @Override
  void flipHelper() {
    for (int i = 0; i < height / 2; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          int t = pixels[k][i][j];
          pixels[k][i][j] = pixels[k][height - 1 - i][j];
          pixels[k][height - 1 - i][j] = t;
        }
      }
    }
  }
}
