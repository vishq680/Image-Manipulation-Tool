package model;

import java.io.IOException;

/**
 * It represents all the enhancement and manipulation functionalities that can be performed on
 * images.
 */
public interface ImageInterface {

  /**
   * This function loads a file from the given file path in the specified variable name.
   *
   * @param imgName name of the variable used to refer the image.
   * @return true if the image was successfully loaded, false otherwise.
   */
  boolean loadImage(int[][][] pixels, int width, int height, String imgName);


  /**
   * It saves the file with the specified image name in the given location.
   *
   * @param imgName name of the image to be saved.
   * @return 3D integer array that represents pixel matrix of an image.
   */
  int[][][] saveImage(String imgName) throws IOException;

  /**
   * Creates a greyscale image with the red-component of the image with the given name, and refer
   * to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the red component greyscale image of the given image.
   * @return true if the red greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleRed(String imgName, String destImgName) throws IOException;


  /**
   * Creates a greyscale image with the green-component of the image with the given name, and refer
   * to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the green component greyscale image of the given image.
   * @return true if the Green greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleGreen(String imgName, String destImgName) throws IOException;

  /**
   * Creates a greyscale image with the blue-component of the image with the given name, and refer
   * to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the blue component greyscale image of the given image.
   * @return true if the blue greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleBlue(String imgName, String destImgName) throws IOException;

  /**
   * Creates a greyscale image with the value-component of the image with the given name, and refer
   * to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the value component greyscale image of the given image.
   * @return true if the value greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleValue(String imgName, String destImgName) throws IOException;

  /**
   * Creates a greyscale image with the luma-component of the image with the given name, and refer
   * to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the luma component greyscale image of the given image.
   * @return true if the Luma greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleLuma(String imgName, String destImgName) throws IOException;

  /**
   * Creates a greyscale image with the intensity-component of the image with the given name, and
   * refer to it henceforth in the program by the given destination name.
   *
   * @param imgName     name of the given image.
   * @param destImgName name of the intensity component greyscale image of the given image.
   * @return true if the intensity greyscale image were successfully created, false otherwise.
   */
  boolean greyScaleIntensity(String imgName, String destImgName) throws IOException;

  /**
   * It flips the given image along the y-axis.
   *
   * @param imgName     name of the image to be flipped.
   * @param destImgName name of the flipped image.
   * @return true if the image were successfully flipped horizontally, false otherwise.
   */
  boolean horizontalFlip(String imgName, String destImgName) throws IOException;

  /**
   * It flips the given image along the x-axis.
   *
   * @param imgName     name of the image to be flipped.
   * @param destImgName name of the flipped image.
   * @return true if the image were successfully flipped vertically, false otherwise.
   */
  boolean verticalFlip(String imgName, String destImgName) throws IOException;

  /**
   * It brightens or darkens the given image  by the increment amount according to the sign of the
   * increment value.
   *
   * @param increment   the value by which the image is brightened or darkened.
   * @param imgName     name of the image to be brightened or darkened.
   * @param destImgName name of the brightened/darkened image.
   * @return true if the image were successfully brightened, false otherwise.
   */
  boolean brightenImage(int increment, String imgName, String destImgName) throws IOException;

  /**
   * Splits the given image into three greyscale images containing its red, green and blue
   * components respectively.
   *
   * @param imgName          the name of the image to be split into its individual components.
   * @param redDestImgName   the name of the red component image.
   * @param greenDestImgName the name of the green component image.
   * @param blueDestImgName  the name of the blue component image.
   * @return true if the components were successfully split, false otherwise.
   */
  boolean rgbSplit(String imgName, String redDestImgName, String greenDestImgName,
                   String blueDestImgName) throws IOException;

  /**
   * combines the three greyscale images into a single image.
   *
   * @param imgName      the name of the resultant image after combining its component images.
   * @param redImgName   the name of the red component image.
   * @param greenImgName the name of the green component image.
   * @param blueImgName  the name of the blue component image.
   * @return true if the components were successfully combined, false otherwise.
   */
  boolean rgbCombine(String imgName, String redImgName, String greenImgName,
                     String blueImgName) throws IOException;


}

