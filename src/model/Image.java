package model;

/**
 * This class represents an image and its associated attributes and all the functions that
 * operate on the image data.
 */
public class Image {

  private final String name;
  private final int[][][] pixels;
  private final int width;
  private final int height;

  /**
   * This constructor is used to declare and initialise an image object with the given values.
   *
   * @param pixels pixel matrix of the image.
   * @param width  width of the image.
   * @param height height of the image.
   * @param name   name of the image.
   */
  public Image(int[][][] pixels, int width, int height, String name) {
    this.name = name;
    this.pixels = pixels;
    this.width = width;
    this.height = height;

  }

  /**
   * getter method to retrieve the pixel matrix of an image.
   *
   * @return pixel matrix.
   */
  public int[][][] getPixels() {
    return pixels;
  }

  /**
   * getter method to retrieve the width of an image.
   *
   * @return width of the image.
   */
  public int getWidth() {
    return width;
  }

  /**
   * getter method to retrieve the height of an image.
   *
   * @return height of an image.
   */
  public int getHeight() {
    return height;
  }

  /**
   * getter method to retrieve the name of an image.
   *
   * @return name of an image.
   */
  public String getName() {
    return name;
  }
}
