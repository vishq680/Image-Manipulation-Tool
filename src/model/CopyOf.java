package model;

/**
 * This class acts as a function object where it is primarily used to generate a copy of the image
 * pixel matrix.
 */
public class CopyOf {

  /**
   * This function creates a copy of the given image object in terms of its pixel matrix.
   *
   * @param source the image for which copy is created.
   * @return copy of the pixel matrix of the source image.
   */
  public static int[][][] getCopyOf(Image source) {

    try {

      int[][][] pixels = source.getPixels();
      int[][][] t = new int[3][source.getHeight()][source.getWidth()];
      for (int i = 0; i < source.getHeight(); i++) {
        for (int j = 0; j < source.getWidth(); j++) {
          for (int k = 0; k < 3; k++) {
            t[k][i][j] = pixels[k][i][j];
          }
        }
      }
      return t;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
