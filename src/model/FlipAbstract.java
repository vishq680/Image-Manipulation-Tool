package model;

import java.util.Dictionary;

/**
 * This class represents all the common data and common functionality required for performing
 * various flipping operations on a given image.
 */
public abstract class FlipAbstract implements FlipInterface {

  final Dictionary<String, Image> images;
  final Image img;
  final int height;
  final int width;
  final int[][][] pixels;
  final String imgName;
  final String destImgName;


  /**
   * This constructor is used to declare and initialise flip class objects with the appropriate
   * values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public FlipAbstract(Dictionary<String, Image> images, String imgName, String destImgName) {

    this.images = images;
    this.imgName = imgName;
    this.img = images.get(imgName);
    this.pixels = CopyOf.getCopyOf(img);  //copy of the original
    this.height = img.getHeight();
    this.width = img.getWidth();
    this.destImgName = destImgName;


  }

  @Override
  public void flip() {

    flipHelper();
    images.put(destImgName, new Image(pixels, img.getWidth(), img.getHeight(), destImgName));
  }

  /**
   * This function acts as a helper function that performs a logical part of the flipping
   * operation.
   */
  abstract void flipHelper();
}
