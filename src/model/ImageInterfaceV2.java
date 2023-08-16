package model;

/**
 * This interface contains all the new functionalities that were added in the second iteration of
 * the application.
 */
public interface ImageInterfaceV2 extends ImageInterface {

  /**
   * Creates a blurred version of the given imgName image and stores it in the images dictionary
   * as destImgName.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the blurred image of the given image.
   * @return true if the blurred image was successfully blurred, false otherwise.
   */
  boolean blur(String imgName, String destImgName);

  /**
   * Creates a sharpened version of the given imgName image and stores it in the images dictionary
   * as destImgName.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the sharpened image of the given image.
   * @return true if the image was successfully sharpened, false otherwise.
   */
  boolean sharpen(String imgName, String destImgName);

  /**
   * Creates a greyscale version of the given imgName image and stores it in the images dictionary
   * as destImgName.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the greyscale image of the given image.
   * @return true if the image was successfully greyscale, false otherwise.
   */
  boolean greyscale(String imgName, String destImgName);

  /**
   * Creates a sepia version of the given imgName image and stores it in the images dictionary
   * as destImgName.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the sepia image of the given image.
   * @return true if the image was successfully created, false otherwise.
   */
  boolean sepia(String imgName, String destImgName);

  /**
   * Creates a dithered version of the given imgName image and stores it in the images dictionary
   * as destImgName.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the dithered image of the given image.
   * @return true if the image was successfully dithered, false otherwise.
   */
  boolean dither(String imgName, String destImgName);

}
