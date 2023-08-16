package model;

import java.util.Dictionary;

/**
 * This class represents all the common data and common functions required to perform greyscale
 * operation on the given image.
 */
public abstract class GreyScaleAbstract implements GreyScaleInterface {

  Dictionary<String, Image> images;
  String imgName;
  String destImgName;


  /**
   * This constructor is used to declare and initialise this class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public GreyScaleAbstract(Dictionary<String, Image> images, String imgName, String destImgName) {

    this.images = images;
    this.imgName = imgName;
    this.destImgName = destImgName;
  }

  /**
   * This function contains the algorithmic logic to generate a greyscale version of an image.
   */
  public void greyScale() {

    Image img = images.get(imgName);
    int[][][] greyScale = new int[3][img.getHeight()][img.getWidth()];

    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        double value = getComponentValue(i, j);
        for (int k = 0; k < 3; k++) {
          greyScale[k][i][j] = (int) value;
        }
      }
    }

    images.put(destImgName, new Image(greyScale, img.getWidth(), img.getHeight(), destImgName));

  }

  /**
   * This function is used to retrieve the greyscale value of a given pixel according to the class
   * implementing this function.
   *
   * @param i the row index of the given pixel.
   * @param j the column index of the given pixel.
   * @return the component value of the
   */
  abstract double getComponentValue(int i, int j);
}
