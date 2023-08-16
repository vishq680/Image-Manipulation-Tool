package model;

import java.util.Dictionary;

/**
 * This class represents all the data and functions required to perform dithering operation on an
 * image.
 */
public class Dither implements DitherInterface {

  private final Dictionary<String, Image> images;
  private final String destImgName;
  private final int[][][] newPixels;
  private final int height;
  private final int width;

  /**
   * This constructor is used to declare and initialise dither class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   * @param t           controller object that invoked this class.
   */
  public Dither(Dictionary<String, Image> images, String imgName, String destImgName,
                ImageInterfaceV2 t) {

    this.images = images;
    this.destImgName = destImgName;
    t.greyscale(imgName, "ditherGreyscale");
    this.newPixels = CopyOf.getCopyOf(images.get("ditherGreyscale"));
    this.width = images.get("ditherGreyscale").getWidth();
    this.height = images.get("ditherGreyscale").getHeight();

  }

  @Override
  public void dither() {

    int oldColor;
    int newColor;
    int error;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        oldColor = newPixels[0][i][j];
        newColor = getCloserValue(oldColor);
        error = oldColor - newColor;

        for (int k = 0; k < 3; k++) {
          newPixels[k][i][j] = newColor;
        }

        if ((j + 1) < width && (i + 1) < height && (j - 1) >= 0) {
          addError(7.0 / 16, error, i, j + 1);
          addError(3.0 / 16, error, i + 1, j - 1);
          addError(5.0 / 16, error, i + 1, j);
          addError(1.0 / 16, error, i + 1, j + 1);
        }

      }
    }
    images.put(destImgName, new Image(newPixels, width, height, destImgName));


  }

  private void addError(double factor, int error, int x, int y) {

    for (int i = 0; i < 3; i++) {
      newPixels[i][x][y] += clamp((int) Math.round(factor * error));
    }
  }

  private int getCloserValue(int oldColor) {

    if (oldColor < 127.5) {
      return 0;
    }
    return 255;

  }

  private int clamp(int channel) {
    if (channel < 0) {
      return 0;
    } else if (channel > 255) {
      return 255;
    }
    return channel;
  }


}
