package model;

import java.util.Dictionary;

/**
 * This class represents the data and the functionalities required to perform horizontal flip of the
 * given image.
 */
public class HorizontalFlip extends FlipAbstract {

  /**
   * This constructor is used to declare and initialise HorizontalFlip class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param img         name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public HorizontalFlip(Dictionary<String, Image> images, String img, String destImgName) {
    super(images, img, destImgName);
  }

  @Override
  void flipHelper() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width / 2; j++) {
        for (int k = 0; k < 3; k++) {
          int t = pixels[k][i][j];
          pixels[k][i][j] = pixels[k][i][width - 1 - j];
          pixels[k][i][width - 1 - j] = t;
        }
      }
    }
  }
}
