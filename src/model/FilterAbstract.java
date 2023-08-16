package model;

import java.util.Dictionary;


/**
 * This class represents all the common data and common functionality required for performing
 * various filter operations on a given image.
 */
public abstract class FilterAbstract implements FilterInterface {
  final double[][] kernel;
  final int kernelSize;
  final Dictionary<String, Image> images;
  final Image img;
  final int[][][] pixels;
  final int height;
  final int width;
  final String imgName;
  final String destImgName;

  /**
   * This constructor is used to declare and initialise filter class objects with the appropriate
   * values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public FilterAbstract(Dictionary<String, Image> images, String imgName, String destImgName) {
    this.images = images;
    this.img = images.get(imgName);
    this.pixels = img.getPixels();
    this.height = img.getHeight();
    this.width = img.getWidth();
    this.imgName = imgName;
    this.destImgName = destImgName;
    this.kernel = getKernel();
    this.kernelSize = kernel.length;
  }

  @Override
  public void filter() {

    int[][][] filter = new int[3][height][width];
    int[] rgb = new int[3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        filterHelper(rgb, i, j);

        for (int k = 0; k < 3; k++) {
          filter[k][i][j] = rgb[k];
        }
      }
    }

    images.put(destImgName, new Image(filter, width, height, destImgName));
  }

  private int clamp(int channel) {
    if (channel < 0) {
      return 0;
    } else if (channel > 255) {
      return 255;
    }
    return channel;
  }


  private void filterHelper(int[] rgb, int i, int j) {

    int top;
    int bottom;
    int left;
    int right;
    int padding = kernelSize / 2;


    if (i - padding < 0) {
      top = i;
    } else {
      top = padding;
    }

    if (i + padding < height) {
      bottom = padding;
    } else {
      if (i == height - 1) {
        bottom = 0;
      } else {
        bottom = height - i - 1;
      }
    }

    if (j - padding < 0) {
      left = j;
    } else {
      left = padding;
    }

    if (j + padding < width) {
      right = padding;
    } else {
      if (j == width - 1) {
        right = 0;
      } else {
        right = width - j - 1;
      }

    }

    int startPtX = padding - top;
    int startPtY = padding - left;
    int windowHeight = 1 + bottom + top;
    int windowWidth = 1 + right + left;
    int a;
    int b;
    int m;
    int n;
    int sum;
    for (int k = 0; k < 3; k++) {
      sum = 0;
      for (a = startPtX, m = i - top; a < windowHeight; a++, m++) {
        for (b = startPtY, n = j - left; b < windowWidth; b++, n++) {

          sum += kernel[a][b] * pixels[k][m][n];
        }
      }
      rgb[k] = clamp(Math.round(sum));
    }

  }

  /**
   * This function is used to retrieve kernel matrices of respective filter classes.
   *
   * @return the kernel matrix.
   */
  abstract double[][] getKernel();

}
