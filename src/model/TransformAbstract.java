package model;

import java.util.Dictionary;


/**
 * This class represents all the common data and common functionality required for performing
 * various transformation operations on a given image.
 */
public abstract class TransformAbstract implements TransformationInterface {

  private final Dictionary<String, Image> images;
  private final String destImgName;
  private final int[][][] pixels;
  private final int height;
  private final int width;
  private final double[][] colorMatrix;

  /**
   * This constructor is used to declare and initialise this class objects with the appropriate
   * values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public TransformAbstract(Dictionary<String, Image> images, String imgName, String destImgName) {
    this.images = images;
    this.destImgName = destImgName;
    Image img = images.get(imgName);
    this.pixels = img.getPixels();
    this.height = img.getHeight();
    this.width = img.getWidth();
    this.colorMatrix = getColorMatrix();
  }

  private int clamp(int channel) {
    if (channel < 0) {
      return 0;
    } else if (channel > 255) {
      return 255;
    }
    return channel;
  }

  @Override
  public void transform() {


    int[][][] transform = new int[3][height][width];
    int[] newPixel;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        newPixel = transformHelper(i, j);

        for (int k = 0; k < 3; k++) {
          transform[k][i][j] = newPixel[k];
        }
      }
    }

    images.put(destImgName, new Image(transform, width, height, destImgName));


  }

  private int[] transformHelper(int x, int y) {

    int sum;
    int[] newRGB = new int[3];

    for (int i = 0; i < colorMatrix.length; i++) {
      sum = 0;
      for (int j = 0; j < colorMatrix[0].length; j++) {
        sum += colorMatrix[i][j] * pixels[j][x][y];
      }
      newRGB[i] = clamp(Math.round(sum));
    }

    return newRGB;
  }

  /**
   * This function retrieves the appropriate color matrix required for transformation.
   *
   * @return color matrix.
   */
  abstract double[][] getColorMatrix();
}
